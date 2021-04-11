package com.example.keywordlibrary

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.util.AttributeSet
import android.util.Log
import android.view.ViewGroup
import android.widget.AutoCompleteTextView
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import androidx.annotation.Nullable
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView

class KeywordMainClass : LinearLayout {

    private val TAG = KeywordMainClass::class.java.simpleName

    lateinit var keywordsRV: RecyclerView
    lateinit var keywordACTV: AutoCompleteTextView
    lateinit var keywordCheck: ImageView
    private lateinit var parentConstraintLayout: LinearLayout


    constructor(context: Context?) : super(context!!) {
        init(null)
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(
        context!!,
        attrs
    ) {
        init(attrs)
    }

    constructor(
        context: Context?,
        attrs: AttributeSet?,
        defStyleAttr: Int
    ) : super(context!!, attrs, defStyleAttr) {
        init(attrs)
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    constructor(
        context: Context?,
        attrs: AttributeSet?,
        defStyleAttr: Int,
        defStyleRes: Int
    ) : super(context!!, attrs, defStyleAttr, defStyleRes) {
        init(attrs)
    }


    @SuppressLint("Recycle")
    private fun init(@Nullable attrs: AttributeSet?) {

        try {


            parentConstraintLayout = LinearLayout(context)
            parentConstraintLayout.id = R.id.container_keyword_container

            keywordACTV = AutoCompleteTextView(context)
            keywordCheck = ImageView(context)
            keywordsRV = RecyclerView(context)

            keywordsRV.id = R.id.rv_layout_keywords
            keywordCheck.id = R.id.iv_check
            keywordACTV.id = R.id.actv_keyword


            val featureRV = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT
            )


            val featureACTV = RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT
            )
            featureACTV.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
            featureACTV.addRule(RelativeLayout.ALIGN_PARENT_START);


            val featureCheck = RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT
            )

            featureCheck.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
            featureCheck.addRule(RelativeLayout.ALIGN_PARENT_END);


            print("In init of class")
            Log.e(TAG, featureRV.toString())

            //Add view to parent
            addView(keywordsRV, featureRV)
            addView(keywordACTV, featureACTV)
            addView(keywordCheck, featureCheck)


        } catch (e: Exception) {
            Log.e(TAG, "In init exception with ${e.cause} and ${e.message}")
        }
    }


}