package com.example.babycareproject.Comprobaciones

import android.widget.EditText

class Validaciones{

    constructor(){}

    public fun validarNoVacio(editText:EditText,texto:String?="@string/txt_err_msg"):Boolean{
        if(editText.text.isEmpty()){
            editText.setError(texto)
            return false
        }else{
            return true
        }
    }

    public fun validarNoVacio(editText:ArrayList<EditText>, texto:String?="@string/txt_err_msg"):Boolean{
        var bandera:Boolean=true
        editText.forEach{elemento->
            if(!validarNoVacio(elemento, texto)){
                bandera=false
            }
        }
        return bandera
    }

    public fun validarLogintudTexto(editText: EditText,longitud:Int=8):Boolean{
        return editText.textSize<longitud
    }

    public fun validarCorreo(editText: EditText){

    }
}