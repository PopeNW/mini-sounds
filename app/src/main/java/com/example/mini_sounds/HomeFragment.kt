package com.example.mini_sounds

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.*
import androidx.lifecycle.Observer
import com.example.mini_sounds.data.RemoteConfig
import com.example.mini_sounds.data.RemoteConfigRepository
import com.example.mini_sounds.data.RmsConfig
import com.example.mini_sounds.data.StatusConfig
import com.example.mini_sounds.databinding.FragmentHomeBinding
import kotlinx.coroutines.*

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val viewModel: SharedViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.welcome.text = "Hello there"

        binding.liveConfigButton.setOnClickListener {
            getConfigData("2.3.0")
        }

        binding.killedConfigButton.setOnClickListener {
            getConfigData("1.15.0")
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun getConfigData(appVersion: String) {
        val mainActivityJob = Job()

        val errorHandler = CoroutineExceptionHandler { _, exception ->
            AlertDialog.Builder(this.requireContext()).setTitle("Error")
                .setMessage(exception.message)
                .setPositiveButton(R.string.ok) { _, _ -> }
                .setIcon(R.drawable.ic_dialog_alert).show()
        }

        val coroutineScope = CoroutineScope(mainActivityJob + Dispatchers.Main)
        coroutineScope.launch(errorHandler) {
            val result = RemoteConfigRepository().getConfig(appVersion)
            viewModel.setRemoteConfig(result)
            renderFragmentWithConfigData()
        }
    }

    private fun renderFragmentWithConfigData() {
        val isActiveConfig = viewModel.remoteConfig.value?.status?.on
        if (isActiveConfig == true)
            goToLiveConfigFragment()
        else
            goToKilledConfigFragment()
    }

    private fun goToLiveConfigFragment(): Boolean {
        parentFragmentManager.commit {
            replace<LiveConfigFragment>(com.example.mini_sounds.R.id.container, null, null)
        }

        return true
    }

    private fun goToKilledConfigFragment(): Boolean {
        parentFragmentManager.commit {
            replace<KilledConfigFragment>(com.example.mini_sounds.R.id.container, null, null)
        }

        return true
    }
}