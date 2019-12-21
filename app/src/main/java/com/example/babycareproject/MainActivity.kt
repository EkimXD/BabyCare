package com.example.babycareproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import com.example.babycareproject.Comprobaciones.Validaciones
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Validaciones().validarLogintudTexto(editText)
        val iText=ArrayList<EditText>()
        iText.add(editText)
        iText.add(editText2)
        button.setOnClickListener({Validaciones().validarNoVacio(iText)})
    }
}
