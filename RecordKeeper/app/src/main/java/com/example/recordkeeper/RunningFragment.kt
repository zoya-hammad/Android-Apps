package com.example.recordkeeper

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.content.Intent
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.recordkeeper.databinding.ActivityMainBinding
import com.example.recordkeeper.databinding.FragmentRunningBinding

class RunningFragment : Fragment() {

    private lateinit var binding: FragmentRunningBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRunningBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupClickListeners()

    }

    private fun setupClickListeners() {
        binding.container5km.setOnClickListener { launchRunningEditScreen("5km") }
        binding.container10km.setOnClickListener { launchRunningEditScreen("10km") }
        binding.containerHalfMarathon.setOnClickListener { launchRunningEditScreen("Half Marathon") }
        binding.containerMarathon.setOnClickListener { launchRunningEditScreen("Marathon") }
    }

    private fun launchRunningEditScreen(dist : String) {
        val intent = Intent(context, EditRunningRecordActivity::class.java)
        intent.putExtra("Distance",dist)
        startActivity(intent)
//         use 'context' instead of 'this' in fragments
    }
}