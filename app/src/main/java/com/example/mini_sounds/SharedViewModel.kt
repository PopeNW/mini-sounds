package com.example.mini_sounds

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mini_sounds.data.RemoteConfig

class SharedViewModel : ViewModel() {
    private val _remoteConfig = MutableLiveData<RemoteConfig>()
    val remoteConfig: LiveData<RemoteConfig> = _remoteConfig

    fun setRemoteConfig(config: RemoteConfig) {
        _remoteConfig.value = config
    }
}
