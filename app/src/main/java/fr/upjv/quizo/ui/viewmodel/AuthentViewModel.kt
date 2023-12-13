package fr.upjv.quizo.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth

class AuthentViewModel : ViewModel() {

    private lateinit var authent: FirebaseAuth

    init {
        authent = FirebaseAuth.getInstance()
    }


    fun Connexion(username:String,password: String){
        val Lowerusername = username.toLowerCase()
        authent.signInWithEmailAndPassword(Lowerusername,password).addOnCompleteListener {
            if(!it.isSuccessful){
                Log.e("Error Sign In", it.exception.toString())
            }
            else
            {
                Log.d("Sign In successful", "Connexion reussi a firebase")
            }
        }
    }

    fun getCurrentUserId(): String?{
        var CurrentUserId: String? = authent.currentUser?.uid

        return  CurrentUserId
    }

    fun Inscription(username:String,password:String){
        authent.createUserWithEmailAndPassword(username,password).addOnCompleteListener{
            if(!it.isSuccessful){
                Log.e("Error Sign Up", it.exception.toString())
            }
        }
    }

    fun Checkfields(username:String, password:String):Boolean{

        var isNotEmpty = false

        if(username != null && password != null){
            isNotEmpty = true
        }

        return isNotEmpty
    }
}