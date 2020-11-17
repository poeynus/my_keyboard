package com.myhome.rpgkeyboard.keyboardview

import android.content.Context
import android.os.*
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.inputmethod.InputConnection
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.view.children
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.myhome.rpgkeyboard.*

class KeyboardMacro{
    companion object{
        lateinit var emojiLayout: LinearLayout
        lateinit var inputConnection: InputConnection
        lateinit var keyboardInterationListener: KeyboardInterationListener
        lateinit var context:Context
        lateinit var vibrator: Vibrator

        lateinit var emojiRecyclerViewAdapter: EmojiRecyclerViewAdapter
        lateinit var macroRecyclerViewAdapter: MacroRecyclerViewAdapter
        val fourthLineText = listOf<String>("!#1","금융", "비밀번호", "이메일", "주소","기타", getEmojiByUnicode(0x1F682),"DEL")
        var vibrate = 0
        var sound = 0

        val bank =  listOf<String>("신한 123456789", "농협 352123456", "국민 123456789")
        val password = listOf<String>("1q2w3e4r!", "12345678", "52468981")
        val e_mail = listOf<String>("poeynus@naver.com", "poeynus@google.com", "tjsduq8789@cu.ac.kr")
        val remnants = listOf<String>("010-5246-8981", "010-1234-5678", "010-9876-5432")
        val address = listOf<String>("영주시 장수로 장수면 219번길 26", "경상북도 경산시 하양읍 하양로 13-13", "경기 성남시 분당구 불정로 6")

        fun newInstance(context:Context, layoutInflater: LayoutInflater, inputConnection: InputConnection, keyboardInterationListener: KeyboardInterationListener): LinearLayout {
            Companion.context = context
            emojiLayout = layoutInflater.inflate(R.layout.keyboard_macro, null) as LinearLayout
            Companion.inputConnection = inputConnection
            Companion.keyboardInterationListener = keyboardInterationListener
            vibrator = context.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
            val sharedPreferences = context.getSharedPreferences("setting", Context.MODE_PRIVATE)
            vibrate = sharedPreferences.getInt("vibrate", -1)
            sound = sharedPreferences.getInt("sound", -1)

            val fourthLine = emojiLayout.findViewById<LinearLayout>(
                R.id.fourth_line
            )
            val children = fourthLine.children.toList()
            for(item in children.indices){
                val actionButton = children[item].findViewById<Button>(R.id.key_button)
                val spacialKey = children[item].findViewById<ImageView>(R.id.spacial_key)
                if(fourthLineText[item].equals("DEL")){
                    actionButton.setBackgroundResource(R.drawable.del)
                    val myOnClickListener = getDeleteAction()
                    actionButton.setOnClickListener(myOnClickListener)
                }
                else{
                    actionButton.text = fourthLineText[item]
                    actionButton.setOnClickListener(View.OnClickListener {
                        when((it as Button).text){
                            "!#1" -> {
                                keyboardInterationListener.modechange(2)
                            }
                            "금융" -> {
                                setLayoutComponents(bank, 2)
                            }
                            "비밀번호" -> {
                                setLayoutComponents(password, 2)
                            }
                            "이메일" -> {
                                setLayoutComponents(e_mail, 2)
                            }
                            "주소" -> {
                                setLayoutComponents(address, 2)
                            }
                            "기타" -> {
                                setLayoutComponents(remnants, 2)
                            }
                            getEmojiByUnicode(0x1F682) -> {

                            }
                        }
                    })
                }
            }

            setLayoutComponents(bank, 2)
            return emojiLayout
        }

        private fun playVibrate(){
            if(vibrate > 0){
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    vibrator.vibrate(VibrationEffect.createOneShot(70, vibrate))
                }
                else{
                    vibrator.vibrate(70)
                }
            }
        }

        private fun setLayoutComponents(unicode: List<String>, count:Int) {
            var recyclerView = emojiLayout.findViewById<RecyclerView>(R.id.emoji_recyclerview)
            val emojiList = ArrayList<String>()
            val config = context.getResources().configuration
            val sharedPreferences = context.getSharedPreferences("setting", Context.MODE_PRIVATE)
            val height = sharedPreferences.getInt("keyboardHeight", 150)

//            unicode = 0x1F600
//            val unicode = 0x1F48B
            for(i in 0..count){
                emojiList.add(unicode[i])
//                emojiList.add(i.toString())
            }
            if(emojiList == address) {
                macroRecyclerViewAdapter =
                    MacroRecyclerViewAdapter(context, emojiList, inputConnection)
                recyclerView.adapter = macroRecyclerViewAdapter

                val gm = GridLayoutManager(context, 1)
                gm.isItemPrefetchEnabled = true
                recyclerView.layoutManager = gm
                recyclerView.layoutParams =
                    LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, height * 5)
            }
            else{
                emojiRecyclerViewAdapter =
                    EmojiRecyclerViewAdapter(context, emojiList, inputConnection)
                recyclerView.adapter = emojiRecyclerViewAdapter

                val gm = GridLayoutManager(context, 1)
                gm.isItemPrefetchEnabled = true
                recyclerView.layoutManager = gm
                recyclerView.layoutParams =
                    LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, height * 5)
            }
        }

        fun getEmojiByUnicode(unicode: Int): String {
            return String(Character.toChars(unicode))
        }

        fun getDeleteAction():View.OnClickListener{
            return View.OnClickListener{
                playVibrate()
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    inputConnection.deleteSurroundingTextInCodePoints(1, 0)
                }else{
                    inputConnection.deleteSurroundingText(1,0)
                }
            }
        }
    }
}