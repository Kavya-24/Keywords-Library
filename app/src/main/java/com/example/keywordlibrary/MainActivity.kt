package com.example.keywordlibrary

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var feature: KeywordMainClass
    private lateinit var keywordFunction : KeywordFunctionClass

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val context = this
        //Locate
        feature = findViewById(R.id.activityMainkeywordFeature)
        //Initialize


        keywordFunction = KeywordFunctionClass.Builder(context,feature).build()



    }
}
