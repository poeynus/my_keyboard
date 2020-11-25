package com.myhome.rpgkeyboard.activities.password

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_contacts.view.*

class PwViewHolder(v: View) : RecyclerView.ViewHolder(v){
    var view : View = v

    fun bind(item: PwEn) {
        view.mName.text = item.name
    }
}