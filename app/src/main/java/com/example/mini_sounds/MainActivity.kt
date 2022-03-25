package com.example.mini_sounds

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.example.mini_sounds.data.RemoteConfig
import com.example.mini_sounds.data.RemoteConfigRepository
import com.example.mini_sounds.data.StatusConfig
import com.example.mini_sounds.databinding.ActivityMainBinding
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        goToHome()

        binding.bottomNavigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home_link -> goToHome()

//                R.id.live_link -> goToLive()
//
//                R.id.killed_link -> goToKilled()

                else -> false
            }
        }
    }

    private fun goToHome(): Boolean {
        supportFragmentManager.commit {
            replace<HomeFragment>(R.id.container, null, null)
        }

        return true
    }

//    private fun goToLive(): Boolean {
//        supportFragmentManager.commit {
//            replace<LiveConfigFragment>(R.id.container, null, null)
//        }
//
//        return true
//    }
//
//    private fun goToKilled(): Boolean {
//        supportFragmentManager.commit {
//            replace<KilledConfigFragment>(R.id.container, null, null)
//        }
//
//        return true
//    }
}
