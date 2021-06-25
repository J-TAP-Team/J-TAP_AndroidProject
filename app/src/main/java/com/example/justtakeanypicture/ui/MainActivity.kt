package com.example.justtakeanypicture.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.core.content.FileProvider
import androidx.core.view.GravityCompat
import androidx.lifecycle.Observer
import com.example.justtakeanypicture.R
import com.example.justtakeanypicture.base.BaseActivity
import com.example.justtakeanypicture.databinding.MainBinding
import com.example.justtakeanypicture.ui.register.login.LoginActivity
import com.example.justtakeanypicture.viewModel.MainViewModel
import com.example.justtakeanypicture.widget.recyclerview.adapter.GalleryListAdapter
import com.google.android.material.navigation.NavigationView
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.TedPermission
import org.koin.androidx.viewmodel.ext.android.getViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.io.File

@Suppress("UNREACHABLE_CODE")
class MainActivity : BaseActivity<MainBinding,MainViewModel>(
    R.layout.main
) , NavigationView.OnNavigationItemSelectedListener {

    override val viewModel: MainViewModel by viewModel()

    override fun observerViewModel() {
        binding.navigationView.setNavigationItemSelectedListener(this)

        init()

        viewModel.galleryList.observe(this, Observer {
            binding.include.mainRecyclerGallery.adapter?.notifyDataSetChanged()
            binding.include.mainRecyclerGallery.adapter = GalleryListAdapter(it)
        })

        viewModel.bestGalleryNumber.observe(this, Observer {
            binding.include.mainBestGalleryText.text = "다른 사람의 현재 갤러리 ${it}개"
        })

        viewModel.name.observe(this, Observer {
            binding.include.mainMyName.text = it
        })

        viewModel.galleryNumber.observe(this, Observer {
            binding.include.mainGalleryNumberText.text = "나의 작품은 현재 ${it}개 입니다."
        })
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_actionbar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.main_camera -> {
                startActivity(Intent(this,AddPhotoActivity::class.java))
                return true
            }
            R.id.main_notifications -> {

            }
            R.id.main_person -> {
            }
            R.id.main_menu_menu -> { // 메뉴 버튼
                binding.mainDrawerLayout.openDrawer(GravityCompat.END)    // 네비게이션 드로어 열기
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.main_premium -> {
                Toast.makeText(this, "프리미엄", Toast.LENGTH_SHORT).show()
            }
            R.id.main_info_change -> {
                Toast.makeText(this, "정보변경", Toast.LENGTH_SHORT).show()
            }
            R.id.main_help -> {
                Toast.makeText(this, "도움말", Toast.LENGTH_SHORT).show()
            }
            R.id.main_logout -> {
                Toast.makeText(this, "로그아웃", Toast.LENGTH_SHORT).show()
            }
        }
        return false
    }

    override fun onBackPressed() { //뒤로가기 처리
        if (binding.mainDrawerLayout.isDrawerOpen(GravityCompat.END)) {
            binding.mainDrawerLayout.closeDrawers()
            // 테스트를 위해 뒤로가기 버튼시 Toast 메시지
            Toast.makeText(this, "back btn clicked", Toast.LENGTH_SHORT).show()
        } else {
            super.onBackPressed()
        }
    }
    private fun init() {
        viewModel.getGalleryList()
        viewModel.getMyUser()
        viewModel.listPicture()
    }
}