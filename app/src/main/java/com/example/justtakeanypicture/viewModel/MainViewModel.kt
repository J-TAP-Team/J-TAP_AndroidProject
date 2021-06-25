package com.example.justtakeanypicture.viewModel

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.justtakeanypicture.base.BaseViewModel
import com.example.justtakeanypicture.model.domain.ListGalleryResponse
import com.example.justtakeanypicture.model.repository.PictureApiRepository
import com.example.justtakeanypicture.model.repository.UserApiRepository
import com.example.justtakeanypicture.model.repository.galleryApiRepository
import com.example.justtakeanypicture.widget.SingleLiveEvent
import com.example.justtakeanypicture.widget.`object`.SharedPreferencesManager
import org.koin.core.get

class MainViewModel(private val sharedPreferencesManager: SharedPreferencesManager, private val userApiRepository: UserApiRepository, private val galleryApiRepository: galleryApiRepository, private val pictureApiRepository: PictureApiRepository) : BaseViewModel() {

    private val _name = MutableLiveData<String>()
    val name : LiveData<String>
        get() = _name

    private val _galleryNumber = MutableLiveData<String>()
    val galleryNumber : LiveData<String>
        get() = _galleryNumber

    private val _bestGalleryNumber = MutableLiveData<String>()
    val bestGalleryNumber : LiveData<String>
        get() = _bestGalleryNumber

    private val _galleryList = MutableLiveData<List<ListGalleryResponse>>()
    val galleryList : LiveData<List<ListGalleryResponse>>
        get() = _galleryList


    fun getGalleryList() {
        addDisposable(
            galleryApiRepository.listGallery(sharedPreferencesManager.getUserUid().toString())
                .subscribe({
                    _galleryList.postValue(it)
                    _bestGalleryNumber.postValue(it[it.size - 1].gallery_id.toString())
                }, {
                    Log.e("error", it.message.toString())
                })
        )
    }

    fun getMyUser() {
        addDisposable(
            userApiRepository.getUser(sharedPreferencesManager.getUserUid().toString())
                .subscribe({
                    _name.postValue(it.name)
                }, {
                    Log.e("error", it.message.toString())
                })
        )
    }

    fun listPicture() {
        addDisposable(
            pictureApiRepository.listPicture(sharedPreferencesManager.getUserUid().toString())
                .subscribe({
                    _galleryNumber.postValue(it[it.size -1].picture_id.toString())
                }, {
                    Log.e("error", it.message.toString())
                })
        )
    }

    /*@BindingAdapter("imageUrl")
    fun loadImage(View: ImageView, imageUrl: String) {
        Glide.with(View.getContext())
            .load(imageUrl)
            .placeholder(R.color.black) .into(View);
    }*/

    /*fun dateFormat(str: String): String {

        val formatterCal = SimpleDateFormat("E, dd MMM yyyy HH:mm:ss Z", Locale.US)
        val date: Date = formatterCal.parse(str) // all done

        val formatterStr = SimpleDateFormat("yyyy년 MM월 dd일 (E) / HH:mm:ss", Locale.KOREAN)
        val strDate = formatterStr.format(date)
        return strDate
    }*/

}