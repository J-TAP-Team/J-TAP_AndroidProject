package com.example.justtakeanypicture.viewModel

import com.example.justtakeanypicture.base.BaseViewModel
import com.example.justtakeanypicture.model.domain.ListPictureResponse
import com.example.justtakeanypicture.widget.SingleLiveEvent
import com.example.justtakeanypicture.widget.recyclerview.adapter.MyPageRecyclerAdapter

class MyPageFragmentViewModel : BaseViewModel() {
    val onRecentEvent = SingleLiveEvent<Unit>()
    val myLaundryList = ArrayList<ListPictureResponse>()/*
    val myLaundryAdapter = MyPageRecyclerAdapter()

    fun setList() {
        myLaundryAdapter.setList(myLaundryList)
        myLaundryAdapter.notifyDataSetChanged()
        onRecentEvent.call()
    }
*/
    fun getImage() {

    }
}