package com.myhome.rpgkeyboard.activities.address

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_contacts.view.*

class AddressViewHolder(v: View) : RecyclerView.ViewHolder(v){
    var view : View = v

    fun bind(item: AddressEn) {
        view.mName.text = item.name
    }
}
