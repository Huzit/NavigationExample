package com.recycler.navigationexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.widget.Toast
import androidx.databinding.BindingAdapter
import androidx.lifecycle.withCreated
import androidx.navigation.NavController
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
    lateinit var _navHostFragment: NavHostFragment
    val navHostFragment
        get() = _navHostFragment
    //바텀 네비게이션에 들어갈 네비게이션 컨트롤러 정의
    lateinit var _navController: NavController
    val navController
        get() = _navController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initBind()
        setBottomNav()
        showBackStack()
    }
    //바인딩
    private fun initBind(){
        binding = ActivityMainBinding.inflate(layoutInflater)
        _navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainer) as NavHostFragment
        _navController = navHostFragment.findNavController()
        setContentView(binding.root)
    }

    //바텀 네비 설정
    private fun setBottomNav(){
        binding.bottomNav.setupWithNavController(navController)
    }

    fun showBackStack(){
        //FragmentContainerView를 NavHostFragment로 가져옴
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainer) as NavHostFragment

        navHostFragment.childFragmentManager.addOnBackStackChangedListener {
            if(navHostFragment.childFragmentManager.backStackEntryCount == 0) {
                Toast.makeText(this, "백 스택 수 : ${navHostFragment.childFragmentManager.backStackEntryCount}", Toast.LENGTH_SHORT).show()
                Log.d(
                    "백 스택 없음",
                    navHostFragment.childFragmentManager.backStackEntryCount.toString()
                )
                navHostFragment.childFragmentManager.popBackStack()
            }
            else {
                Toast.makeText(this, "백 스택 수 : ${navHostFragment.childFragmentManager.backStackEntryCount}", Toast.LENGTH_SHORT).show()
                Log.d(
                    "백 스택 있음",
                    navHostFragment.childFragmentManager.backStackEntryCount.toString()
                )
            }
        }
    }

    var waitTime = 0L
    override fun onBackPressed() {
        if(!navController.popBackStack()){
            if(System.currentTimeMillis() - waitTime >= 1500){
                waitTime = System.currentTimeMillis()
                Toast.makeText(this, "뒤로가기 한 번 더 하면 앱 종료", Toast.LENGTH_SHORT).show()
            } else{
                finish()
            }
        }
    }
}