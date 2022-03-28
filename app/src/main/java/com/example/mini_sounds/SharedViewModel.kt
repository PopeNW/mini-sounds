package com.example.mini_sounds

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mini_sounds.data.RMS
import com.example.mini_sounds.data.RemoteConfig

class SharedViewModel : ViewModel() {
    private val _remoteConfig = MutableLiveData<RemoteConfig>()
    val remoteConfig: LiveData<RemoteConfig> = _remoteConfig

    fun setRemoteConfig(data: RemoteConfig) {
        _remoteConfig.value = data
    }

    private val _rms = MutableLiveData<RMS>()
    val rms: LiveData<RMS> = _rms

    fun setRms(data: RMS) {
        _rms.value = data
    }
}
