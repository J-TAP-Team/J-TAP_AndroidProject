package com.example.justtakeanypicture.widget.recyclerview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.justtakeanypicture.R
import com.example.justtakeanypicture.databinding.CustomDialogBinding
import com.example.justtakeanypicture.databinding.FragmentMypageBinding
import com.example.justtakeanypicture.databinding.MypageItemBinding
import com.example.justtakeanypicture.model.domain.ListGalleryResponse
import com.example.justtakeanypicture.model.domain.ListPictureResponse
import com.example.justtakeanypicture.widget.SingleLiveEvent

class MyPageRecyclerAdapter(private var mypageList: ArrayList<ListPictureResponse>) : RecyclerView.Adapter<MyPageRecyclerAdapter.ViewHolder>() {

    val onItemClickEvent = SingleLiveEvent<ListPictureResponse>()

    fun setList(mypageList: ArrayList<ListPictureResponse>) {
        this.mypageList = mypageList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.mypage_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bindItems(mypageList[position])
        holder.binding.myPageImage.setOnClickListener {
            onItemClickEvent.value = mypageList[position]
        }
    }

    override fun getItemCount(): Int = mypageList.size

    class ViewHolder(val binding: MypageItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bindItems(myPageResponse: ListPictureResponse) {
            Glide.with(binding.root).load(myPageResponse.image).into(binding.myPageImage)
        }
    }
}

