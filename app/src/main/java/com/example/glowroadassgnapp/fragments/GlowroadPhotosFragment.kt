package com.example.glowroadassgnapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.glowroadassgnapp.R
import com.example.glowroadassgnapp.adapters.GrPhotoAdpter
import com.example.glowroadassgnapp.databinding.FragmentGlowroadPhotosBinding
import com.example.glowroadassgnapp.networkrequests.GlowroadApi
import com.example.glowroadassgnapp.repositories.GlowroadPhotoRepository
import com.example.glowroadassgnapp.viewmodelfactories.GlowroadPhotosVMFactory
import com.example.glowroadassgnapp.viewmodels.GlowroadPhotosViewModel

class GlowroadPhotosFragment : Fragment() {

    companion object {
        fun newInstance() = GlowroadPhotosFragment()
    }

    private lateinit var viewModel: GlowroadPhotosViewModel
    private lateinit var factory: GlowroadPhotosVMFactory
    private lateinit var binding: FragmentGlowroadPhotosBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_glowroad_photos, container, false)
        val view = binding.root
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val api = GlowroadApi()
        val repository = GlowroadPhotoRepository(api)
        factory = GlowroadPhotosVMFactory(repository)
        viewModel = ViewModelProvider(this, factory).get(GlowroadPhotosViewModel::class.java)

        //Attach linear layout to the recyclerview
        val linearLayoutManager = LinearLayoutManager(requireContext())
        binding.rvPhotos.layoutManager = linearLayoutManager

        viewModel.getPhotos()
        viewModel.photos.observe(viewLifecycleOwner, Observer { photos ->
            binding.rvPhotos.adapter = GrPhotoAdpter(photos, requireContext())
        })
    }
}