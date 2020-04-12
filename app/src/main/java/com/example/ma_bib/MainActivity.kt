package com.example.ma_bib

import android.content.Context
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Surface
import android.view.WindowManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




            if ( c2 != null ){
                val fragment = list.newInstance(true)
                val fragment2 = detail()
                val transaction = supportFragmentManager.beginTransaction()
                transaction.replace(R.id.contaner, fragment)
                transaction.replace(R.id.c2, fragment2)
                transaction.commit()
            }else{
                val fragment = list.newInstance(false)
                val transaction = supportFragmentManager.beginTransaction()
                transaction.replace(R.id.contaner, fragment)
                transaction.commit()
            }
        }


}