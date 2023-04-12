package com.recycler.navigationexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.BindingAdapter
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.recycler.navigationexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    //FragmentContainerView를 NavHostFragment로 가져옴
    val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainer) as NavHostFragment
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initBind()
        setBottomNav()
    }
    //바인딩
    private fun initBind(){
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
    //바텀 네비 설정
    private fun setBottomNav(){
        //바텀 네비게이션에 들어갈 네비게이션 컨트롤러 정의
        val navController = navHostFragment.findNavController()
        binding.bottomNav.setupWithNavController(navController)
    }
    
    override fun onBackPressed() {
//        navHostFragment.findNavController().popBackStack()
    }
}