package com.thurainx.foodninja.features.upload_photo

import androidx.lifecycle.ViewModel

class UploadPhotoViewModel : ViewModel() {
    var permissionQueue : ArrayList<String> = arrayListOf()

    fun dismissedDialog(){
        permissionQueue.removeFirst()
    }

    fun onPermissionResult(
        permission: String,
        isGranted: Boolean,
    ){
        if(!isGranted && !permissionQueue.contains(permission)){
            permissionQueue.add(permission)
        }
    }




}