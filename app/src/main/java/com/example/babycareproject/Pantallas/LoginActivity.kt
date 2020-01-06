package com.example.babycareproject.Pantallas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.example.babycareproject.Comprobaciones.Validaciones
import com.example.babycareproject.Comprobaciones.Conexion
import com.example.babycareproject.R
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    var editTextList = ArrayList<EditText>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        editTextList.add(editTextEmail)
        editTextList.add(editTextContrasena)

        buttonIngresar.setOnClickListener { goToAppActivity() }
        textRegistro.setOnClickListener { goToRegistroActivity() }

    }

    private fun goToAppActivity() {
        if (Validaciones().validarNoVacio(editTextList) && Validaciones().validarCorreo(
                editTextEmail
            )
        ) {
            Conexion().logginNewUser(
                editTextEmail.text.toString(),
                editTextContrasena.text.toString()
            ).addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    startActivity(
                        Intent(this, AppActivity::class.java)
                    )
                    this.finish()
                } else {
                    Toast.makeText(this, "Usuario o contrasena incorrecto", Toast.LENGTH_LONG)
                        .show()
                    //TODO hay que extraer "Usuario o contrasena incorrecto" desde string xml
                }
            }
        }
    }

    private fun goToRegistroActivity() {
        startActivity(
            Intent(this, RegistroActivity::class.java)
        )
        //this.finish()
    }
}
