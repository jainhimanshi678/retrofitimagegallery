package com.sk.retrofitimagegallery.ui.gallery

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.sk.retrofitimagegallery.R
import dagger.hilt.android.AndroidEntryPoint
import androidx.fragment.app.viewModels
import com.sk.retrofitimagegallery.databinding.FragmentGalleryBinding

@AndroidEntryPoint
class Galleryfragment:Fragment(R.layout.fragment_gallery) {

    private val viewModel by viewModels<GalleryViewModel>()
    private var _binding:FragmentGalleryBinding?=null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding= FragmentGalleryBinding.bind(view)
        val adapter=Adapterclass()
        binding.apply { recyclerView.adapter=adapter }
        viewModel.photos.observe(viewLifecycleOwner){
            adapter.submitData(viewLifecycleOwner.lifecycle,it)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }
}