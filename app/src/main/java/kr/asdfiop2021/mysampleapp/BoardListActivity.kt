package kr.asdfiop2021.mysampleapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class BoardListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_board_list)

        val btnWrite = findViewById<Button>(R.id.btnWrite)
        btnWrite.setOnClickListener{
            var intent = Intent(this, BoardWriteActivity::class.java)
            startActivity(intent)
        }
    }
}