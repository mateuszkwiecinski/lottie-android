package com.airbnb.lottie.issues

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.lottie.issues.databinding.ActivityMainBinding
import com.airbnb.lottie.issues.databinding.IssueReproActivityBinding
import leakcanary.LeakCanary

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnNext.setOnClickListener {
            startActivity(Intent(this, IssueReproActivity::class.java))
        }

        binding.btnDump.setOnClickListener {
            LeakCanary.dumpHeap()
        }
    }
}

class IssueReproActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = IssueReproActivityBinding.inflate(layoutInflater)
        binding.root.tag = this
        setContentView(binding.root)
        // Reproduce any issues here.

        binding.animationView.setFailureListener { }
        binding.animationView.setAnimationFromUrl("https://fastupload.io/download002/N2p3DJQZdGMa5/r8HaDIRvlULrvB7/34462-html-url.json")
    }
}
