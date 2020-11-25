package com.myhome.rpgkeyboard.activities.email

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_contacts.view.*

class EmailViewHolder(v: View) : RecyclerView.ViewHolder(v){
    var view : View = v

    fun bind(item: EmailEn) {
        view.mName.text = item.name
    }
}