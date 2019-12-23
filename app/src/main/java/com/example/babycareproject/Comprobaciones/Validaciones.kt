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

    public fun validarLogintudTexto(editText: EditText,longitud:Int=8,texto: String=""):Boolean{
        if(editText.textSize<longitud){
            editText.setError(texto)
            return false
        }else{
            return true
        }
    }

    public fun validarCorreo(editText: EditText,texto: String=""):Boolean{
        val emailRegex = "^[A-Za-z](.*)([@]{1})(.{1,})(\\.)(.{1,})";
        if(validarRegex(emailRegex,editText.text.toString())){
            return true
        }else{
            editText.setError(texto)
            return false
        }
    }

    public fun validarTelefono(editText: EditText,texto: String=""):Boolean{
        val phoneRegex ="^(\\+91[\\-\\s]?)?[0]?(91)?[789]\\d{9}\$"
        if(validarRegex(phoneRegex,editText.text.toString())){
            return true
        }else{
            editText.setError(texto)
            return false
        }

    }

    public fun validarRegex(regex:String, texto:String):Boolean{
        return regex.toRegex().matches(texto)
    }
}