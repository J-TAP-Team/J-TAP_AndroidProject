package com.example.justtakeanypicture.widget.recyclerview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.justtakeanypicture.databinding.CustomDialogBinding
import com.example.justtakeanypicture.databinding.MainBinding
import com.example.justtakeanypicture.model.domain.ListGalleryResponse
import com.example.justtakeanypicture.viewModel.MainViewModel

class GalleryListAdapter(private val galleryList: List<ListGalleryResponse>) : RecyclerView.Adapter<GalleryListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder {
        val binding: CustomDialogBinding = CustomDialogBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }


    override fun getItemCount(): Int = galleryList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(galleryList[position])
    }

    inner class ViewHolder(binding: CustomDialogBinding) : RecyclerView.ViewHolder(binding.root) {
        val binding = binding

        fun bindItems(galleryResponse: ListGalleryResponse) {
            binding.galleryName.text = galleryResponse.name
            binding.galleryDescription.text = galleryResponse.description
            binding.galleryCreated.text = galleryResponse.created_at.toString()

        }
    }
}