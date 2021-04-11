package com.example.keywordlibrary

import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

//Adapter class

class KeywordAdapter(val features: Features, val onClickKeyword : OnKeywordClickListener) :
    RecyclerView.Adapter<KeywordAdapter.MyViewHolder>(){

    //List of the keywords to be added
    var keywordList: MutableList<String> = mutableListOf()

    /**
    ViewHolder class
     */

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        //These are the UI elements of the item
        private val word = itemView.findViewById<TextView>(R.id.keywordText)
        val cross = itemView.findViewById<ImageView>(R.id.keywordCross)
        private val card = itemView.findViewById<CardView>(R.id.container_keyword)

        fun bindPost(_mKeyword: String, features: Features, onClickKeyword: OnKeywordClickListener) {

            with(_mKeyword) {

                //Format the recycler view
                formatRecyclerView(features)


                word.text = _mKeyword


            }
        }

        private fun formatRecyclerView(features: Features) {

            //Card background color
            card.setCardBackgroundColor(features.backgroundCardColor)

            //Keyword color,size and typeface
            word.setTextColor(features.colorKeyword)
            word.textSize = features.sizeKeyword

            if(features.typefaceKeyword != null){
                word.setTypeface(null, features.typefaceKeyword);
            } else{
                word.setTypeface(null, Typeface.NORMAL);
            }



            //For the drawable
            if(features.hasClosingFeature){
                cross.visibility= View.VISIBLE
                if(features.closingDrawable != null){
                    cross.setImageDrawable(features.closingDrawable)
                } else{
                    cross.setImageDrawable(itemView.context.resources.getDrawable(R.drawable.ic_cancel,null))
                }
            }

            else{
                //Does not have a closing feature
                //Hide the cross
                cross.visibility = View.GONE
            }

        }


    }

    fun updateList(_tag: String, position: Int) {
        keywordList.add(_tag)
        notifyItemInserted(position)        //Not needed
        notifyDataSetChanged()
    }

    fun removeAt(position: Int) {
        keywordList.removeAt(position)
        notifyItemRemoved(position)
        notifyItemRangeChanged(position, keywordList.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_keyword, parent, false)
        return KeywordAdapter.MyViewHolder(view)

    }

    override fun getItemCount(): Int {
        return keywordList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {


        //Remove the item
        holder.cross.setOnClickListener {
            removeAt(position)
        }

        holder.bindPost(keywordList[position], features = features, onClickKeyword = onClickKeyword)

    }

}
interface OnKeywordClickListener{
    fun onKeywordClick(_tag: String)
}


