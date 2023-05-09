package com.example.projectshandura.presentation.secondFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.jetpacknav.databinding.FragmentSecondBinding

class SecondFragment() : Fragment() {

    private var _binding : FragmentSecondBinding? = null
    private val binding get() = _binding!!

    lateinit var secondViewModel : SecondViewModel

    companion object{
        const val nameOfFruit = "name"
        const val urlOfPhoto = "photo"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        secondViewModel = ViewModelProvider(this).get(SecondViewModel::class.java)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        secondViewModel.getData(arguments?.getString(nameOfFruit).toString())

        secondViewModel.nutritions.observe(viewLifecycleOwner){
            binding.tvNutritions.text = it
        }

        Glide.with(view).load(arguments?.getString(urlOfPhoto)).fitCenter().into(binding.photoOfFruit)
        binding.tvNameOfFruit.text = arguments?.getString(nameOfFruit)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}