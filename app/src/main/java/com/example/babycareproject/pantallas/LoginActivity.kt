package com.example.babycareproject.pantallas

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.babycareproject.R
import com.example.babycareproject.comprobaciones.Conexion
import com.example.babycareproject.comprobaciones.Validaciones
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

            val progressDialog = ProgressDialog(this)
            progressDialog.setTitle("Login en Proceso")
            progressDialog.setMessage("Cargando")
            progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER)
            progressDialog.show()
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
            progressDialog.dismiss()
        }
    }

    private fun goToRegistroActivity() {
        startActivity(
            Intent(this, RegistroActivity::class.java)
        )
        //this.finish()
    }
}
