package com.myhome.rpgkeyboard.activities.remnant

import android.app.Activity
import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import com.myhome.rpgkeyboard.AppDatabase
import com.myhome.rpgkeyboard.R
import kotlinx.android.synthetic.main.activity_layout.*
import java.util.*

class Remnant : Activity() {

    var db : AppDatabase? = null
    var contactsList = ArrayList<RmEn>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_layout)

        //초기화
        db = AppDatabase.getInstance(this)

        //이전에 저장한 내용 모두 불러와서 추가하기
        val savedContacts = db!!.rmDao().getAll()
        if(savedContacts.isNotEmpty()){
            contactsList.addAll(savedContacts)
        }

        //어댑터, 아이템 클릭 : 아이템 삭제
        val adapter = RmListAdapter(contactsList)
        adapter.setItemClickListener(object : RmListAdapter.OnItemClickListener{
            override fun onClick(v: View, position: Int) {

                val contacts = contactsList[position]

                db?.rmDao()?.delete(contacts = contacts) //DB에서 삭제
                contactsList.removeAt(position) //리스트에서 삭제
                adapter.notifyDataSetChanged() //리스트뷰 갱신

            }
        })
        mRecyclerView.adapter = adapter


        //플러스 버튼 클릭 : 데이터 추가
        mPlusButton.setOnClickListener {

            val builder = AlertDialog.Builder(this)
            val dialogView = layoutInflater.inflate(R.layout.dialog, null)
            val dialogText = dialogView.findViewById<EditText>(R.id.dialog_name_id)

            builder.setView(dialogView)
                .setPositiveButton("확인") { dialogInterface, i ->
                    val contact = RmEn(0, dialogText.text.toString()) //Contacts 생성
                    db?.rmDao()?.insertAll(contact) //DB에 추가
                    contactsList.add(contact) //리스트 추가
                }
                .setNegativeButton("취소") { dialogInterface, i ->
                }
                .show()

            adapter.notifyDataSetChanged() //리스트뷰 갱신
        }

    }

}