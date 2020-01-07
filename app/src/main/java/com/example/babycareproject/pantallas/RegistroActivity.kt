package com.example.babycareproject.pantallas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.example.babycareproject.comprobaciones.Conexion
import com.example.babycareproject.comprobaciones.Validaciones
import com.example.babycareproject.R
import kotlinx.android.synthetic.main.activity_registro.*

class RegistroActivity : AppCompatActivity() {

    var textInputArray = ArrayList<EditText>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        textInputArray.add(editText)
        textInputArray.add(editText2)
        buttonRegistrar.setOnClickListener { registrarAction() }
    }

    private fun registrarAction() {
        //TODO aun hay que trabajar en el comportamiento de esta clase, quiza se deba implementar algunos DTOs
        if (Validaciones().validarNoVacio(textInputArray) &&
            Validaciones().validarCorreo(editText) &&
            Validaciones().validarLogintudTexto(editText2)
        ) {
            Conexion().createNewUser(editText.text.toString(), editText2.text.toString())
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(
                            this,
                            "Usuario almacenado correctamente, por favor ingrese al sistema",
                            Toast.LENGTH_LONG
                        )
                            .show()
                        //TODO hay que extraer "Usuario almacenado correctamente, por favor ingrese al sistema" desde string xml
                        startActivity(
                            Intent(this, LoginActivity::class.java)
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
}
