package com.example.babycareproject.Pantallas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import com.example.babycareproject.Comprobaciones.Validaciones
import com.example.babycareproject.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    var editTextList= ArrayList<EditText>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        editTextList.add(editTextEmail)
        editTextList.add(editTextContrasena)

        buttonIngresar.setOnClickListener({goToAppActivity()})
        textRegistro.setOnClickListener({goToRegistroActivity()})
    }

    fun goToAppActivity() {
        if (Validaciones().validarNoVacio(editTextList) && Validaciones().validarCorreo(
                editTextEmail
            )
        ) {
            startActivity(
                Intent(this, AppActivity::class.java)
                //TODO algo se le ha de enviar --_O-O_--
            )
            this.finish()
        }
    }

    fun goToRegistroActivity() {
        startActivity(
            Intent(this, RegistroActivity::class.java)
        )
    }
}
