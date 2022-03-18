package com.example.mini_sounds

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mini_sounds.data.RemoteConfig
import com.example.mini_sounds.data.RmsConfig
import com.example.mini_sounds.data.StatusConfig

class MainActivityViewModel: ViewModel() {
    val status = MutableLiveData<StatusConfig>()
    val rmsConfig = MutableLiveData<RmsConfig>()
}