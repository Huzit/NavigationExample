package com.recycler.navigationexample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.recycler.navigationexample.databinding.FragmentAnotherBinding

class AnotherFragment : Fragment() {

    var _binding: FragmentAnotherBinding? = null
    val binding: FragmentAnotherBinding
        get() = _binding!!
    //전달된 변수를 받기위한 매개변수
    val args: AnotherFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAnotherBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Toast.makeText(requireContext(), args.test, Toast.LENGTH_SHORT).show()
        setButton()
    }

    fun setButton(){
        binding.anotherButton.setOnClickListener {v ->
            when(args.beforeFrag){
                "MainFragment" -> {
                    val action = AnotherFragmentDirections.actionAnotherFragmentToMainFragment()
                    v.findNavController().navigate(action)
                }
                "SubFragment" -> {
                    val action = AnotherFragmentDirections.actionAnotherFragmentToSubFragment()
                    v.findNavController().navigate(action)
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}