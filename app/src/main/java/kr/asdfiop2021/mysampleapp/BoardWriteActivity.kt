package kr.asdfiop2021.mysampleapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class BoardWriteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_board_write)


        ///var btnWrite : Button = findViewById<Button>(R.id.btnWriteUpload)
        var btnWrite : Button = findViewById(R.id.btnWriteUpload)
        btnWrite.setOnClickListener {

            var textAreaWrite : EditText = findViewById(R.id.textAreaWrite)

            // Write a message to the database
            val database = Firebase.database
            val myRef = database.getReference("board")

            ///myRef.push().setValue(textAreaWrite.text.toString())
            myRef.push().setValue(
                Model(textAreaWrite.text.toString())
            )

        }

    }
}