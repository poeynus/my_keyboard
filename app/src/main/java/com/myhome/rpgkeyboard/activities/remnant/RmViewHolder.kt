package com.myhome.rpgkeyboard.activities.remnant

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_contacts.view.*

class RmViewHolder(v: View) : RecyclerView.ViewHolder(v){
    var view : View = v

    fun bind(item: RmEn) {
        view.mName.text = item.name
    }
}