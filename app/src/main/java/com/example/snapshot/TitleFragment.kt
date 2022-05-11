package com.example.snapshot

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.snapshot.databinding.FragmentTitleBinding


class TitleFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = DataBindingUtil.inflate<FragmentTitleBinding>(inflater,
            R.layout.fragment_title,container, false)
        val shareText = binding.shareText
        binding.playButton.setOnClickListener{
            var shareIntent = Intent().apply {
                this.action = Intent.ACTION_SEND
                this.putExtra(Intent.EXTRA_TEXT, shareText.text.toString())
                this.type = "text/plain"
            }
            startActivity(shareIntent)
        }
//        binding.galleryButton.setOnClickListener{view : View ->
//            view.findNavController().navigate(R.id.action_titleFragment_to_scrollingFragment)}

        return binding.root


    }
}