package com.example.flaguess

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.example.flaguess.databinding.ActivityResultActivtyBinding

class ResultActivty : AppCompatActivity() {
    private lateinit var design: ActivityResultActivtyBinding
    private val i = Intent()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        design = DataBindingUtil.setContentView(this, R.layout.activity_result_activty)
        var a = getIntent().extras?.getInt("re")
        Log.e("TAG2",a.toString())
        if (a!! >= 50 ){
            design.percenttv.setText("%${a.toString()} \nBaşarı\nHarika")
            design.resultiv.setImageResource(resources.getIdentifier("fireworks","drawable",packageName))
        }else{
            design.percenttv.setText("%${a.toString()} \nBaşarı\nVasat")
            design.resultiv.setImageResource(resources.getIdentifier("sad","drawable",packageName))
        }

    }
}