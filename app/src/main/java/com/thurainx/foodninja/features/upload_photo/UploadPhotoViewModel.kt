package com.thurainx.foodninja.features.upload_photo

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

class UploadPhotoViewModel : ViewModel() {
    var permissionQueue  = mutableStateListOf<String>()

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