package com.peiandsky.uilibtest

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.peiandsky.uilibtest.popup.ToastyActivity
import kotlinx.android.synthetic.main.activity_index.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_index)

        btn_toasty.setOnClickListener {
            startActivity(Intent(this, ToastyActivity::class.java))
        }
    }
}
