package com.example.keywordlibrary

import android.graphics.Typeface
import android.graphics.drawable.Drawable

/**
    This will take the parameters for the
 */

data class Features(

    val backgroundCardColor: Int,                           //Default = @color/teal
    val colorKeyword: Int,                                  //Default = @color/black
    val sizeKeyword: Float,                                 //Default = 16sp
    val typefaceKeyword : Int?,                             //Default unless specified
    val hasClosingFeature: Boolean,                         //Default = true
    val closingDrawable: Drawable?                          //Default = cancel drawable
)