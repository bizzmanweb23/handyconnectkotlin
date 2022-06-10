package com.example.handyconnect.activities

import android.Manifest
import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.View
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import com.example.handyconnect.R
import com.example.handyconnect.adapters.ImagesUploadAdapter
import com.example.handyconnect.adapters.ItemsInfoAdapter
import com.example.handyconnect.network.responses.categoryServices.CategoryDetailData
import com.example.handyconnect.utils.isNetworkConnected
import com.example.handyconnect.utils.showToast
import com.example.handyconnect.viewModel.SimpleViewCategoryVM
import kotlinx.android.synthetic.main.activity_info.*
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.File

class InfoActivity : AppCompatActivity() {
    private var categoryDetailVM : SimpleViewCategoryVM ?= null
    var cateDetailList : ArrayList<CategoryDetailData> = ArrayList()

    private var adapter : ItemsInfoAdapter ?= null
    private var imagesAdapter : ImagesUploadAdapter?= null
    var isSelected = true
    var callFrom : String ?= null
    private val PERMISSION_REQUEST_CODE = 2
    val GALLERY_REQUESTCODE = 3
    val CAMERA_REQUESTCODE = 4

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)

        cateDetailList.clear()

        callFrom = intent?.extras?.get("callFrom") as String?
        categoryDetailVM = SimpleViewCategoryVM()

        // call service detail api
        if(isNetworkConnected()){
            categoryDetailVM?.simpleViewCategoryDetails(this,intent.extras?.get("CategoryID") as String)
        }
        else
        {
            showToast(this,"No Internet Connection")
        }

        setImagesAdapter()
        clicks()
        listeners()
    }

    private fun listeners() {
        categoryDetailVM?.simpleViewCategoryDetails?.observe(this, Observer { user ->
            if(user != null){
                if(user.SuccessCode == 200){
                    if(user.data != null){
                        Log.d("listSize",cateDetailList.size.toString())
                        cateDetailList.addAll(user.data)
                        setAdapter()
                    }
                }
                else{
                    showToast(this,"Error")
                }
            }
            else{
               showToast(this,"Something went wrong")
            }
        })
    }


    fun updateDataProfile(mImagePth: String) {

        Log.e("mImagePth", "--" + mImagePth)

        var mImageParts: MultipartBody.Part? = null

        if (mImagePth != null && !mImagePth.isEmpty()) {

            if (!mImagePth.toString().startsWith("http")) {
                val file = File(mImagePth)
                val requestFile =
                    RequestBody.create("multipart/form-data".toMediaTypeOrNull(), file)
                mImageParts =
                    MultipartBody.Part.createFormData("image", file.name, requestFile)
            }
            else {
                mImageParts = null
            }
        }
     //   categoryDetailVM?.uploadImageMethod(this,mImageParts!!,)

    }


    private fun openGallery() {
        val pickPhoto = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        pickPhoto.type = "image/*"
        pickPhoto.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(pickPhoto, GALLERY_REQUESTCODE)
    }

    private fun openCamera() {
        val takePicture = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(takePicture, CAMERA_REQUESTCODE)
    }
    private fun chooseImage(context: Context) {
        val optionsMenu = arrayOf<CharSequence>(
            "Take Photo",
            "Choose from Gallery",
            "Exit"
        ) // create a menuOption Array
        // create a dialog for showing the optionsMenu
        val builder = AlertDialog.Builder(context)
        // set the items in builder
        builder.setItems(
            optionsMenu
        ) { dialogInterface, i ->
            if (optionsMenu[i] == "Take Photo") {
                // Open the camera and get the photo
                openCamera()
            } else if (optionsMenu[i] == "Choose from Gallery") {
                // choose from  external storage
                openGallery()
            } else if (optionsMenu[i] == "Exit") {
                dialogInterface.dismiss()
            }
        }
        builder.show()
    }


    private fun requestPermission() {
        ActivityCompat.requestPermissions(
            this,
            arrayOf(
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.CAMERA,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
            ),
            PERMISSION_REQUEST_CODE )
    }


    private fun checkPermission(): Boolean {
        val result = ContextCompat.checkSelfPermission(applicationContext,
            Manifest.permission.ACCESS_FINE_LOCATION
        )
        val result1 = ContextCompat.checkSelfPermission(applicationContext,
            Manifest.permission.CAMERA
        )
        val result2 = ContextCompat.checkSelfPermission(applicationContext,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
        )
        return result == PackageManager.PERMISSION_GRANTED &&
                result1 == PackageManager.PERMISSION_GRANTED && result2 == PackageManager.PERMISSION_GRANTED
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>,
                                            grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            PERMISSION_REQUEST_CODE ->
                if (grantResults.size > 0) {
                    val locationAccepted = grantResults[0] == PackageManager.PERMISSION_GRANTED
                    val cameraAccepted = grantResults[1] == PackageManager.PERMISSION_GRANTED
                    val externalStorageAccepted = grantResults[2] == PackageManager.PERMISSION_GRANTED
                    if (locationAccepted){
                        showToast(this, "Permission Granted, Now you can access location")
                    }
                    else if(cameraAccepted){
                        chooseImage(this)
                    }
                    else if(externalStorageAccepted){
                        chooseImage(this)
                    }
                }
               else {
                    showToast(this, "Permission Denied, You cannot access location data and camera.")
                    requestPermission()
               }
        }
    }


    private fun clicks() {
        firstImage.setOnClickListener {
            if (checkPermission()) {
                chooseImage(this)
            }
            else {
                requestPermission()
            }
        }
        dropdown.setOnClickListener {
            if(isSelected) {
                rvItems.visibility = View.VISIBLE
                isSelected = false
            }
            else {
                rvItems.visibility = View.GONE
                isSelected = true
            }
        }

        butBack.setOnClickListener {
            onBackPressed()
        }

        butSubmit.setOnClickListener {
            startActivity(Intent(this, RequestReceivedActivity::class.java)
                .putExtra("call_From",callFrom))
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == RESULT_OK){
            when(requestCode){
                CAMERA_REQUESTCODE -> {
                    val selectedImage = data?.extras?.get("data") as Bitmap
                    uploadFirstImage.setImageBitmap(selectedImage)
//                    var image_Uri =  getImageUriFromBitmap(this,selectedImage)
//                    Glide.with(this).load(image_Uri).error(R.drawable.ic_user)
//                        .placeholder(R.drawable.ic_user).into(dp)
//                    profileImage =  getPath(this,image_Uri)
                }
                GALLERY_REQUESTCODE -> {
                    val selectedImage = data?.data as Uri
//                    Glide.with(this).load(selectedImage).error(R.drawable.ic_user)
//                        .placeholder(R.drawable.ic_user).into(uploadFirstImage)
                       uploadFirstImage.setImageURI(selectedImage)
                    //  profileImage = getPath(this,selectedImage)
                }
            }
        }
    }

    private fun setImagesAdapter() {
        imagesAdapter = ImagesUploadAdapter(this)
        rvUploadImage.adapter = imagesAdapter
    }

    private fun setAdapter() {
        adapter = ItemsInfoAdapter(this,cateDetailList)
        rvItems.adapter = adapter
    }
}