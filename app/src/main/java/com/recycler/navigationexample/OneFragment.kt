package com.recycler.navigationexample

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import androidx.appcompat.R
import com.recycler.navigationexample.databinding.FragmentOneBinding

class OneFragment : Fragment() {
    lateinit var _binding: FragmentOneBinding
    val binding :FragmentOneBinding
            get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentOneBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.toSubBt.setOnClickListener {
            val action = OneFragmentDirections.actionOneFragmentToSubFragment()
            it.findNavController().navigate(action, navOptions {
                restoreState = true
                popUpTo(findNavController().graph.startDestinationId){
                    saveState = true
                    inclusive = false
                }

            })
        }
    }
}