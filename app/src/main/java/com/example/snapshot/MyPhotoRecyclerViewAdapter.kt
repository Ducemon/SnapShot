package com.example.snapshot.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.snapshot.Image
import com.example.snapshot.databinding.FragmentPhotoBinding

/**
 * [RecyclerView.Adapter] that can display a [PictureItem] and makes a call to the
 * specified [OnListFragmentInteractionListener].
 * TODO: Replace the implementation with code for your data type.
 */
class MyPhotoRecyclerViewAdapter(
    private var values: List<Image>,
) : RecyclerView.Adapter<MyPhotoRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            FragmentPhotoBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        val item = values[position]
        holder.imageView.setImageURI(values[position].uri)
        holder.dateView.setText(values[position].title)

    }

    override fun getItemCount(): Int = values.size


    inner class ViewHolder(binding: FragmentPhotoBinding) : RecyclerView.ViewHolder(binding.root){
        val imageView: ImageView = binding.galleryImage
        val dateView: TextView = binding.imageName
    }
}