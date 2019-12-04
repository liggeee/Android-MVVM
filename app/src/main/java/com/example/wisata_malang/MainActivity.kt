package com.example.wisata_malang

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.wisata_malang.adapter.VacationAdapter
import com.example.wisata_malang.model.Vacation
import com.example.wisata_malang.viewmodel.VacationViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var adapter: VacationAdapter
    private lateinit var viewModel: VacationViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showLoading(true)
        loadData()

        viewModel = ViewModelProviders.of(this).get(VacationViewModel::class.java)

        viewModel.setData().observe(this, Observer { listData ->
            if (listData != null) {
                showLoading(false)
                adapter.setData(listData)
            }
        })

        viewModel.getData()
    }

    private fun loadData(){
        adapter = VacationAdapter()
        adapter.notifyDataSetChanged()

        rvMain.layoutManager = StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL)
        rvMain.adapter = adapter

        adapter.setOnItemClickCallback(object : VacationAdapter.OnItemClickCallback{
            override fun onItemClicked(data: Vacation) {
                val parcelable = Vacation(data.caption,data.thumbnail,data.image)
                val intent = Intent(this@MainActivity,DetailActivity::class.java)
                intent.putExtra(BuildConfig.VACATION_DETAIL,parcelable)
                startActivity(intent)
            }

        })
    }

    private fun showLoading(state: Boolean) {
        if (state) {
            progressbar.visibility = View.INVISIBLE
        } else {
            progressbar.visibility = View.GONE
        }
    }
}

