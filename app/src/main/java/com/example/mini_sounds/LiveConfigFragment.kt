package com.example.mini_sounds

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import coil.load
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
            with(binding) {
                val imageUrl =
                    getImageWithRecipe(rms.modules[0].playableItems[0].imageUrl)

                playableItemTitle.text = rms.modules[0].playableItems[0].titles.primary
                playableItemImage.load(imageUrl)
            }
        }
    }

    private fun getImageWithRecipe(imageUrl: String, imageSize: String = "320x320"): String {
        return imageUrl.replace("{recipe}", imageSize)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}