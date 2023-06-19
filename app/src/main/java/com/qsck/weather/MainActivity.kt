package com.qsck.weather

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.qsck.weather.common.collectWithLifecycle
import com.qsck.weather.ui.WeatherAdapter
import com.qsck.weather.ui.WeatherItemDecoration

class MainActivity : ComponentActivity() {

    private val mainViewModel by viewModels<MainViewModel>()
    private val weatherAdapter = WeatherAdapter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()

        mainViewModel.weather.collectWithLifecycle(lifecycle) {
            Log.d("test!!!", "collectWithLifecycle weather: $it")

            weatherAdapter.add(it)
        }

        mainViewModel.getWeathers(this)
    }

    private fun initView() {
        val recyclerView = findViewById<RecyclerView>(R.id.rc)
        recyclerView.apply {
            adapter = weatherAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
            addItemDecoration(WeatherItemDecoration())
        }

    }
}