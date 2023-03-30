package com.recycler.navigationexample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.recycler.navigationexample.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    //프래그먼트 뷰 바인딩
    var _binding: FragmentMainBinding? = null
    val binding: FragmentMainBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //화면을 바인딩에 올려 줌
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setButton()
    }

    fun setButton(){
        binding.mainNextButton.setOnClickListener {v ->
            //navigation에 추가한 argument 타입에 따라 데이터 전달 가능
            val amount = "From Main Fragment"
            val t = "MainFragment"
            val action = MainFragmentDirections.actionMainFragmentToAnotherFragment(amount, t)
            //화면 전환 액션
            v.findNavController().navigate(action)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        //메모리 누수 방지를 위해 null 할당
        _binding = null
    }
}