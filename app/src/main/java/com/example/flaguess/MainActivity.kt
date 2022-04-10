package com.example.flaguess

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.example.flaguess.databinding.ActivityMainBinding
import com.info.sqlitekullanimihazirveritabani.DatabaseCopyHelper
import java.io.IOException
import java.sql.SQLException

class MainActivity : AppCompatActivity() {
    private lateinit var design : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        design = DataBindingUtil.setContentView(this,R.layout.activity_main)
        design.viewModel = this
        databaseCopy()

    }

    fun intent(){
        startActivity(Intent(this,GameActivity::class.java))
    }

    fun databaseCopy(){
        val dbhelper = DatabaseCopyHelper(this)
        try {
            dbhelper.createDataBase()
        }catch (e:IOException){
            Log.e("TAG","unable to crate database")
        }
        try {
            dbhelper.openDataBase()
        }catch (e:SQLException){
            throw e
        }
    }
}