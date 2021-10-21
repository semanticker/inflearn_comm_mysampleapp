package kr.asdfiop2021.mysampleapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kr.asdfiop2021.mysampleapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        // Initialize Firebase Auth
        auth = Firebase.auth

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Toast.makeText(this, auth.currentUser?.uid.toString(), Toast.LENGTH_SHORT).show()

        //
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        var btnJoinClicked = findViewById<Button>(R.id.btnJoin)
        btnJoinClicked.setOnClickListener {

            // 첫번째
            // var email = findViewById<EditText>(R.id.txtEmail)
            // var pwd = findViewById<EditText>(R.id.txtPwd)

            // 두번째
            var email = binding.txtEmail;
            var pwd = binding.txtPwd;

            auth.createUserWithEmailAndPassword(
                email.text.toString(),
                pwd.text.toString()
            )
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this, "ok", Toast.LENGTH_SHORT).show()

                    } else {
                        var msg = task.exception?.message;
                        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
                    }
                }
        }

        binding.btnLogout.setOnClickListener{
            auth.signOut()
            Toast.makeText(this, auth.currentUser?.uid.toString(), Toast.LENGTH_SHORT).show()
        }

        binding.btnLogin.setOnClickListener{

            var email = binding.txtEmail;
            var pwd = binding.txtPwd;

            auth.signInWithEmailAndPassword(
                    email.text.toString(),
                    pwd.text.toString()
            )
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(this, "ok", Toast.LENGTH_SHORT).show()
                            Toast.makeText(this, auth.currentUser?.uid.toString(), Toast.LENGTH_SHORT).show()

                            var intent = Intent(this, BoardListActivity::class.java)
                            startActivity(intent)

                        } else {
                            var msg = task.exception?.message;
                            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
                        }
                    }
        }

    }
}