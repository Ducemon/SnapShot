package com.example.snapshot

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.snapshot.ImageContent.loadSavedImages
import com.example.snapshot.databinding.FragmentScrollingBinding
import java.io.File


class ScrollingFragment : Fragment() {

    private lateinit var viewBinding: FragmentScrollingBinding
    private val dir = File("/storage/emulated/0/Pictures/SnapShot")



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        viewBinding = FragmentScrollingBinding.inflate(inflater, container, false)

        val editText = viewBinding.edittext

        return viewBinding.root

    }


    override fun onResume() {
        super.onResume()
        loadSavedImages(dir)
    }
}