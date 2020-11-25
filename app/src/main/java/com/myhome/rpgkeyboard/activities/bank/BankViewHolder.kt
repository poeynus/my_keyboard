package com.myhome.rpgkeyboard.activities.bank

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_contacts.view.*

class BankViewHolder(v: View) : RecyclerView.ViewHolder(v){
    var view : View = v

    fun bind(item: BankEn) {
        view.mName.text = item.name
    }
}