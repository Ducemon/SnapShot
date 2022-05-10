package com.example.snapshot

import android.net.Uri
import android.util.Log
import java.io.File

object ImageContent {
        val ITEMS: MutableList<Image> = ArrayList()

        fun loadImage(file: File?) {
            val newItem = Image(Uri.fromFile(file), getNameFromUri(Uri.fromFile(file)))
            addItem(newItem)
        }

        private fun addItem(item: Image) {
            ITEMS.add(0,item)
        }

        fun loadSavedImages(dir: File) {
            ITEMS.clear()
            if (dir.exists()) {
                val files = dir.listFiles()
                for (file in files) {
                    val absolutePath = file.absolutePath
                    val extension = absolutePath.substring(absolutePath.lastIndexOf("."))
                    if (extension == ".jpg") {
                        loadImage(file)
                    }
                }
            }
        }

    private fun getNameFromUri(uri: Uri): String {
        val split = uri.path!!.split("/").toTypedArray()
        val fileName = split[split.size - 1]
        return fileName.split("\\.").toTypedArray()[0]
    }

}