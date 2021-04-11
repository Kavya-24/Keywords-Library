package com.example.keywordlibrary

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.AutoCompleteTextView
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var feature: KeywordMainClass
    private lateinit var keywordFunction: KeywordFunctionClass
    private var mList = mutableListOf<String>()

    private lateinit var keywordTextView: AutoCompleteTextView
    private lateinit var keywordButton: ImageView

    private val TAG = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val context = this
        //Locate
        feature = findViewById(R.id.activityMainkeywordFeature)
        //Initialize

        Log.e(TAG, "In main activity with feature as $feature")

        keywordFunction = KeywordFunctionClass.Builder(context, feature)
            .setACTVHintText(resources.getString(R.string.smile))
            .build()

        keywordTextView = feature.keywordACTV
        keywordButton = feature.keywordCheck

        //Features defined for keyword item
        val mFeatures = Features(
            R.color.teal,
            R.color.colorPrimary,
            16f,
            null,
            true,
            null
        )

        keywordTextView.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                //Method for getting suggestions
            }

            override fun afterTextChanged(s: Editable?) {
                if (!s.isNullOrEmpty()) {
                    //We can enable the imageview wrt requirements if needed
                    keywordButton.setColorFilter(
                        resources.getColor(R.color.blue, null),
                        android.graphics.PorterDuff.Mode.SRC_IN
                    )
                } else {
                    keywordButton.setColorFilter(
                        resources.getColor(R.color.grey, null),
                        android.graphics.PorterDuff.Mode.SRC_IN
                    )
                }

            }
        })


        keywordButton.setOnClickListener {
            if (!keywordTextView.text.isNullOrEmpty()) {
                //Add this in the list
                mList.add(keywordTextView.text.toString())
                Log.e(TAG, "\nIn main activity with query with mList as $mList")

                keywordFunction.addKeywords(mList, mFeatures)
                keywordTextView.text = null

            }
        }


    }
}
