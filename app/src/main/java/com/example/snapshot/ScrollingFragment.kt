package com.example.snapshot

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.snapshot.ImageContent.filter
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
        editText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable) {
                filter(s.toString(),dir)
            }
        })

        viewBinding.gallButton.setOnClickListener{view : View ->
            view.findNavController().navigate(R.id.action_scrollingFragment_to_photoFragment)}

        loadSavedImages(dir)

        return viewBinding.root

    }


    override fun onResume() {
        super.onResume()
        loadSavedImages(dir)
    }
}