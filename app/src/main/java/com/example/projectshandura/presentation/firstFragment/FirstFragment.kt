package com.example.projectshandura.presentation.firstFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jetpacknav.R
import com.example.projectshandura.presentation.secondFragment.SecondFragment
import com.example.jetpacknav.databinding.FragmentFirstBinding
import com.example.projectshandura.data.local.model.Fruit

class FirstFragment : Fragment(), FruitAdapter.Listener {

    private var _binding : FragmentFirstBinding? = null
    private val binding get() = _binding!!


    lateinit var adapter: FruitAdapter
    lateinit var firstViewModel : FirstViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        adapter = FruitAdapter( this)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        firstViewModel = ViewModelProvider(this).get(FirstViewModel :: class.java)
        firstViewModel.getFruits()
        firstViewModel.fruits.observe(viewLifecycleOwner){
            adapter.setList(it)
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val layoutManager = LinearLayoutManager(context)
        binding.rV.layoutManager = layoutManager
        binding.rV.adapter = adapter
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onClick(fruit: Fruit) {
        val bundle = bundleOf(
            SecondFragment.nameOfFruit to fruit.name,
            SecondFragment.urlOfPhoto to fruit.urlImage)
        findNavController().navigate(R.id.action_firstFragment_to_secondFragment, bundle)
    }


}

