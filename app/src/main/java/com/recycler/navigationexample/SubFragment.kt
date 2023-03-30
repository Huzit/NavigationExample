package com.recycler.navigationexample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.recycler.navigationexample.databinding.FragmentSubBinding

class SubFragment : Fragment() {
    val binding: FragmentSubBinding
        get() = _binding!!
    var _binding: FragmentSubBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSubBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setButton()
    }

    fun setButton(){
        binding.subButton.setOnClickListener {v ->
            val amount = "From SubFragment"
            val t = "SubFragment"
            val action = SubFragmentDirections.actionSubFragmentToAnotherFragment(amount, t)
            v.findNavController().navigate(action)
        }
    }
}