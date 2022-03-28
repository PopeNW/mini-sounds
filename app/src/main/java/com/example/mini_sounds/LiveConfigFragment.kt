package com.example.mini_sounds

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.mini_sounds.databinding.ActivityMainBinding
import com.example.mini_sounds.databinding.FragmentKilledConfigBinding
import com.example.mini_sounds.databinding.FragmentLiveConfigBinding

class LiveConfigFragment : Fragment() {

    private var _binding: FragmentLiveConfigBinding? = null
    private val binding get() = _binding!!
    private val viewModel: SharedViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentLiveConfigBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val rms = viewModel.rms.value
        if (rms != null) {
            binding.textView2.text = rms.modules[0].title
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}