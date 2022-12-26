package com.example.app_imddb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.app_imddb.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding =  ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCari.setOnClickListener{
            showFragment()
        }

    }
    private fun showFragment(){
        val mFragmetManager = supportFragmentManager
        val mFragmentTransaksi = mFragmetManager.beginTransaction()
        val mFragment = DataFragment()

        val textCari = binding.etCari.text
        val mBundle = Bundle()
        mBundle.putString("carimovie", textCari.toString())
        mFragment.arguments = mBundle
        mFragmentTransaksi.replace(R.id.fl_data,mFragment).commit()
    }
}