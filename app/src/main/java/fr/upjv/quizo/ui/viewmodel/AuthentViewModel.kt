package fr.upjv.quizo.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel

class AuthentViewModel : ViewModel() {


    fun Connexion(username:String){
        //TODO
        Log.d("User", username)
    }

    fun Deconnection(password:String){
        //TODO
        Log.d("Password", password)
    }
}