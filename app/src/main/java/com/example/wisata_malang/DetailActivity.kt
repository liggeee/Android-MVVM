package com.example.wisata_malang

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.wisata_malang.databinding.ActivityDetailBinding
import com.example.wisata_malang.model.Vacation
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityDetailBinding = DataBindingUtil.setContentView(this,R.layout.activity_detail)

        toolbar.setTitle("Test Magang Android")
        toolbar.setNavigationIcon(R.drawable.ic_keyboard_backspace_white_24dp)
        toolbar.setNavigationOnClickListener { onBackPressed() }
        toolbar.setTitleTextColor(Color.WHITE)
        binding.vacation = intent.getParcelableExtra(BuildConfig.VACATION_DETAIL) as Vacation
    }

}