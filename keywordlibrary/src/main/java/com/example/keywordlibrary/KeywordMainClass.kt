package com.example.keywordlibrary

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.util.AttributeSet
import android.util.Log
import android.widget.AutoCompleteTextView
import android.widget.ImageView
import androidx.annotation.Nullable
import androidx.annotation.RequiresApi
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView

class KeywordMainClass : ConstraintLayout {

    private val TAG = KeywordMainClass::class.java.simpleName

    lateinit var keywordsRV: RecyclerView
    lateinit var keywordACTV: AutoCompleteTextView
    lateinit var keywordCheck: ImageView
    private lateinit var parentConstraintLayout: ConstraintLayout


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


            parentConstraintLayout = ConstraintLayout(context)
            parentConstraintLayout.id = R.id.container_keyword_container

            keywordACTV = AutoCompleteTextView(context)
            keywordCheck = ImageView(context)
            keywordsRV = RecyclerView(context)

            keywordsRV.id = R.id.rv_layout_keywords
            keywordCheck.id = R.id.iv_check
            keywordACTV.id = R.id.actv_keyword

            //Wrap up with height and width
            val constraintParams = ConstraintLayout.LayoutParams(
                ConstraintLayout.LayoutParams.MATCH_PARENT,
                ConstraintLayout.LayoutParams.MATCH_PARENT
            )

            Log.e(TAG, "In Keyword main class with constraintParams as $constraintParams")
            addView(parentConstraintLayout, constraintParams)


            val recyclerParams = ConstraintLayout.LayoutParams(
                ConstraintLayout.LayoutParams.MATCH_PARENT,
                ConstraintLayout.LayoutParams.WRAP_CONTENT
            )
            recyclerParams.topToTop = constraintParams.topToTop
            addView(keywordsRV, recyclerParams)


            val actvParams = ConstraintLayout.LayoutParams(
                ConstraintLayout.LayoutParams.MATCH_PARENT,
                ConstraintLayout.LayoutParams.WRAP_CONTENT
            )

            val checkParams = ConstraintLayout.LayoutParams(
                ConstraintLayout.LayoutParams.WRAP_CONTENT,
                ConstraintLayout.LayoutParams.WRAP_CONTENT
            )


            actvParams.topToBottom = recyclerParams.topToBottom

            checkParams.topToBottom = actvParams.bottomMargin
            checkParams.endToEnd = constraintParams.endToEnd
            checkParams.startToStart = constraintParams.startToStart


            addView(keywordACTV, actvParams)
            addView(keywordCheck, checkParams)


        } catch (e: Exception) {
            Log.e(TAG, "In init exception with ${e.cause} and ${e.message}")
        }
    }


}