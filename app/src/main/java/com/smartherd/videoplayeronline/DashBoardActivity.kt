package com.smartherd.videoplayeronline

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_dash_board.*

class DashBoardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dash_board)

        var lesson1 = "https://firebasestorage.googleapis.com/v0/b/videoplayeronline-11f2e.appspot.com/o/VID-20200129-WA0003.mp4?alt=media&token=3c59bcb0-fcd4-4b09-8572-2e6e7e04e426"
        var lesson2 = "https://firebasestorage.googleapis.com/v0/b/videoplayeronline-11f2e.appspot.com/o/VID-20200213-WA0000.mp4?alt=media&token=fb2d4a91-e900-4aa2-872e-0249c1883e5a"
        var lesson3 = "https://firebasestorage.googleapis.com/v0/b/videoplayeronline-11f2e.appspot.com/o/VID-20200216-WA0000.mp4?alt=media&token=412e6e32-6714-4b91-92f2-a223577613cf"
        var lesson4 = "https://firebasestorage.googleapis.com/v0/b/videoplayeronline-11f2e.appspot.com/o/VID-20200219-WA0000.mp4?alt=media&token=0abbf3ad-9d99-445b-a795-674732bebab0"


        val items = ArrayList<Lesson>()
        items.add(Lesson("Funny Videos","this will make you laugh", lesson1))
        items.add(Lesson("Funny Videos","this will make you laugh", lesson2))
        items.add(Lesson("Funny Videos","this will make you laugh", lesson3))
        items.add(Lesson("Funny Videos","this will make you laugh", lesson4))

        val adapter = Adapter(items, applicationContext)
        recycler.layoutManager = GridLayoutManager(applicationContext, 1)
        recycler.adapter = adapter
    }
}
