package com.example.mini_sounds

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.mini_sounds.data.RemoteConfigRepository
import com.example.mini_sounds.databinding.ActivityMainBinding
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.goodConfigButton.setOnClickListener {
            getConfigData("2.3.0")
        }

        binding.badConfigButton.setOnClickListener {
            getConfigData("2.1.0")
        }
    }

    private fun getConfigData(appVersion: String) {
        val mainActivityJob = Job()

        val errorHandler = CoroutineExceptionHandler { _, exception ->
            AlertDialog.Builder(this).setTitle("Error")
                .setMessage(exception.message)
                .setPositiveButton(android.R.string.ok) { _, _ -> }
                .setIcon(android.R.drawable.ic_dialog_alert).show()
        }

        val coroutineScope = CoroutineScope(mainActivityJob + Dispatchers.Main)
        coroutineScope.launch(errorHandler) {
            val result = RemoteConfigRepository().getConfig(appVersion)
            binding.configTitle.text = result.status.title
            binding.configMessage.text = result.status.message
            binding.configLinkTitle.text = result.status.linkTitle
            binding.googleAppStoreLink.text = result.status.googleAppStoreUrl
            binding.amazonAppStoreUrl.text = result.status.amazonAppStoreUrl
            binding.versionStatus.text = if (result.status.on) "Supported version" else "Unsupported version"

        }

    }
}
