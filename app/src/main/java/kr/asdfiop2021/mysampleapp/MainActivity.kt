package kr.asdfiop2021.mysampleapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {

        // Initialize Firebase Auth
        auth = Firebase.auth

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btnJoinClicked = findViewById<Button>(R.id.btnJoin)
        btnJoinClicked.setOnClickListener {
            auth.createUserWithEmailAndPassword("abc@abc.com", "12341234")
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this, "ok", Toast.LENGTH_SHORT).show()

                    } else {
                        Toast.makeText(this, "ok", Toast.LENGTH_SHORT).show()
                    }
                }
        }


    }
}