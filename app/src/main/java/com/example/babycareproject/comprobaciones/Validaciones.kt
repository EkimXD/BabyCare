package com.example.babycareproject.comprobaciones

import android.content.res.Resources
import android.widget.EditText
import com.example.babycareproject.R

class Validaciones{

    val msgError: String="Es necesario rellenar este campo" // ya me dio coraje XD
        //Resources.getSystem().getString(R.string.txt_err_msg)

    constructor(){}

    public fun validarNoVacio(editText:EditText,texto:String?= msgError):Boolean{
        if(editText.text.isEmpty()){
            editText.setError(texto)
            return false
        }else{
            return true
        }
    }

    public fun validarNoVacio(editText:ArrayList<EditText>, texto:String?=msgError):Boolean{
        var bandera:Boolean=true
        editText.forEach{elemento->
            if(!validarNoVacio(elemento, texto)){
                bandera=false
            }
        }
        return bandera
    }

    public fun validarLogintudTexto(editText: EditText,longitud:Int=8,texto: String=msgError):Boolean{
        if(editText.textSize<longitud){
            editText.setError(texto)
            return false
        }else{
            return true
        }
    }

    public fun validarCorreo(editText: EditText,texto: String=msgError):Boolean{
        val emailRegex = "^[A-Za-z](.*)([@]{1})(.{1,})(\\.)(.{1,})"
        if(validarRegex(emailRegex,editText.text.toString())){
            return true
        }else{
            editText.setError(texto)
            return false
        }
    }

    public fun validarTelefono(editText: EditText,texto: String=msgError):Boolean{
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