package com.example.keywordlibrary

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.Log
import android.view.LayoutInflater
import android.widget.AutoCompleteTextView
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class KeywordFunctionClass private constructor(builder: Builder) : OnKeywordClickListener {

    private val TAG = KeywordFunctionClass::class.java.simpleName

    /**
     * Parameters
     */
    private val mLayoutInflater: LayoutInflater
    private val context: Context

    private val parentView: LinearLayout?
    private val recyclerView: RecyclerView?
    private val autoCompleteTextView: AutoCompleteTextView?
    private val imageView: ImageView?

    //Parameters for the ACTV
    private val actvBgColor: Int?
    private val hintText: String?
    private val hintColor: Int?

    //Parameters for the check drawable
    private val checkDrawable: Drawable?

    //private val checkOffTint: Int?
    private val checkOnTint: Int?

    //Parameters for the recycler view
    private val layout: RecyclerView.LayoutManager?
    private val keywordList: MutableList<String>?
    var childCount = 0

    fun clearKeywordList() {
        keywordList?.clear()
    }

    fun addKeywords(mList: MutableList<String>, mFeatures: Features) {

        Log.e(TAG, "In add keywords for list $mList")
        initiateFeature()

        try {


            //Instantiate the adapter
            val mAdapter = KeywordAdapter(mFeatures, this)
            mAdapter.keywordList = mList
            recyclerView!!.adapter = mAdapter
            mAdapter.notifyDataSetChanged()

        } catch (e: Exception) {
            Log.e(TAG, "In exception for add keyword ${e.message} and ${e.cause}")
        }

    }

    override fun onKeywordClick(_tag: String) {
        Log.e(TAG, "In on click keyword for the word $_tag")

    }

    private fun initiateFeature() {

        Log.e(TAG, "In initiate feature")

        //For actv
        if (autoCompleteTextView != null) {

            if (actvBgColor != null) {
                autoCompleteTextView.setBackgroundColor(actvBgColor)
            }

            autoCompleteTextView.hint = hintText

            if (hintColor != null) {
                autoCompleteTextView.setHintTextColor(hintColor)
            }

        }


        //For ivCheck
        if (imageView != null) {
            imageView.setImageDrawable(checkDrawable)
            if (checkOnTint != null) {
                imageView.setColorFilter(checkOnTint, android.graphics.PorterDuff.Mode.SRC_IN)
            }

        }

        //For the RV
        if (recyclerView != null) {
            recyclerView.layoutManager = layout
        }


    }

    /**
     * Return the list of the current keywords
     */
    fun getListOfKeywords(): MutableList<String>? {
        Log.e(TAG, "In get returned list of words")
        return keywordList
    }

    /**
     * Builder class
     */
    class Builder(
        val context: Context,
        featureView: KeywordMainClass
    ) {
        val parentView: LinearLayout
        val recyclerView: RecyclerView
        val imageView: ImageView
        val autoCompleteTextView: AutoCompleteTextView

        //Parameters for the container auto comlete
        var actvBgColor: Int? = R.color.white
        var hintText: String? = context.resources.getString(R.string.hint)
        var hintColor: Int? = R.color.black

        //Parameters for the check drawable
        var checkDrawable: Drawable? = context.getDrawable(R.drawable.ic_check_black_24dp)

        //var checkOffTint: Int? = R.color.grey
        var checkOnTint: Int? = R.color.blue

        //Parameters for the recycler view
        var layout: RecyclerView.LayoutManager? = LinearLayoutManager(context)
        var keywordList: MutableList<String>? = null

        fun setACTVBackgroundColor(actvBgColor: Int): Builder {
            this.actvBgColor = actvBgColor
            return this
        }


        fun setACTVHintText(hintText: String): Builder {
            this.hintText = hintText
            return this
        }

        fun setACTVHintColor(hintColor: Int): Builder {
            this.hintColor = hintColor
            return this
        }


        fun setCheckDrawable(checkDrawable: Drawable): Builder {
            this.checkDrawable = checkDrawable
            return this
        }

//        fun setCheckOffTint(offTint: Int): Builder {
//            this.checkOffTint = offTint
//            return this
//        }

        fun setCheckOnTint(onTint: Int): Builder {
            this.checkOnTint = onTint
            return this
        }


        fun setKeywordsList(keywordList: MutableList<String>): Builder {
            this.keywordList = keywordList
            return this
        }

        fun setLayoutManager(layout: RecyclerView.LayoutManager): Builder {
            this.layout = layout
            return this
        }


        //Default
        fun build(): KeywordFunctionClass {
            return KeywordFunctionClass(this)
        }

        init {
            parentView = featureView
            recyclerView = featureView.keywordsRV
            imageView = featureView.keywordCheck
            autoCompleteTextView = featureView.keywordACTV


        }
    }

    /**
     * Keyword Function Class Init
     */
    init {

        context = builder.context
        parentView = builder.parentView
        recyclerView = builder.recyclerView
        imageView = builder.imageView
        autoCompleteTextView = builder.autoCompleteTextView

        mLayoutInflater =
            context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        actvBgColor = builder.actvBgColor
        hintText = builder.hintText
        hintColor = builder.hintColor

        //Parameters for the check drawable
        checkDrawable = builder.checkDrawable
        //checkOffTint = builder.checkOffTint
        checkOnTint = builder.checkOnTint

        //Parameters for the recycler view
        layout = builder.layout
        keywordList = builder.keywordList

    }


}