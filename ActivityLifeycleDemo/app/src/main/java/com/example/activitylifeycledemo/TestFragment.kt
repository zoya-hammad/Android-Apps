package com.example.activitylifeycledemo

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.activitylifeycledemo.databinding.FragmentTestBinding

class TestFragment: Fragment() {

    private lateinit var binding: FragmentTestBinding
    private lateinit var fragmentListener: TestFragmentListener

    override fun onAttach(context: Context) {
        super.onAttach(context)
        fragmentListener = context as TestFragmentListener
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTestBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.fragmentText.text = "Here in the fragment now! on view created code :)))"

        binding.btnClearScreen.setOnClickListener{ fragmentListener.clearActivityScreen() }
    }

    override fun onDetach() {
        super.onDetach()
    }

    interface TestFragmentListener{
        fun clearActivityScreen()
    }




}