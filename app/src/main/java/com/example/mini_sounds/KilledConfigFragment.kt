package com.example.mini_sounds

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.mini_sounds.data.StatusConfig
import com.example.mini_sounds.databinding.FragmentKilledConfigBinding

class KilledConfigFragment : Fragment() {

    private var _binding: FragmentKilledConfigBinding? = null
    private val binding get() = _binding!!
    private val viewModel: SharedViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentKilledConfigBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val status = viewModel.remoteConfig.value?.status
        setViewValues(status)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setViewValues(status: StatusConfig?) {
        binding.statusTitle.text = status?.title.toString()
        binding.statusMessage.text = status?.message.toString()
        binding.appStoreLinkTitle.text = status?.linkTitle.toString()
        binding.googleAppStoreLink.text = status?.googleAppStoreUrl.toString()
        binding.amazonAppStoreUrl.text = status?.amazonAppStoreUrl.toString()
    }
}