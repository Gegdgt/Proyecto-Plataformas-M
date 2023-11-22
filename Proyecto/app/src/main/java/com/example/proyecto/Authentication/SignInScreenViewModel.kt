package com.example.proyecto.Authentication

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.launch

class SignInScreenViewModel: ViewModel() {
    private val auth: FirebaseAuth = Firebase.auth
    private val _loading = MutableLiveData(false)
    sealed class AuthResult {
        object Success : AuthResult()
        data class Error(val message: String) : AuthResult()
    }

    val authResult = MutableLiveData<AuthResult>()

    fun signInWithEmailAndPassword(email: String, password:String, MainFeedScreen:()-> Unit)
            = viewModelScope.launch {
        try {
            auth.signInWithEmailAndPassword(email,password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful){
                        //Log.d("BREAK","signInWithEmailAndPassword logeado!!")
                        authResult.value = AuthResult.Success
                        MainFeedScreen()
                    }
                    else {
                        //Log.d("BREAK", "signInWithEmailAndPassword: ${task.result.toString()}")
                        authResult.value = AuthResult.Error("Error al iniciar sesión. Verifica tus credenciales.")
                    }
                }
        }
        catch (ex:Exception){
            authResult.value = AuthResult.Error("Error al iniciar sesión. Inténtalo de nuevo más tarde.")
        }
    }
    fun clearError() {
        authResult.value = null // Clear the error state
    }


    fun createUserWithEmailAndPassword(email:String,
                                       password: String,
                                       MainFeedScreen: () -> Unit){
        if(_loading.value == false){
            _loading.value = true
            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful){
                        val displayName =
                            task.result.user?.email?.split("@")?.get(0)
                        createUser(displayName)
                        MainFeedScreen()
                    }
                    else {
                        //Log.d("BREAK", "createUserWithEmailAndPassword: ${task.result.toString()}")
                        authResult.value = AuthResult.Error("Error al crear cuenta. El correo electrónico ya está en uso.")
                    }
                    _loading.value = false
                }
        }

    }

    private fun createUser(displayName: String?) {
        val userId = auth.currentUser?.uid
        val user = mutableMapOf<String, Any>()

        user["user_id"] = userId.toString()
        user["display_name"] = displayName.toString()

        FirebaseFirestore.getInstance().collection("users")
            .add(user)
            .addOnSuccessListener {
                Log.d("BREAK","Creado ${it.id}")
            }.addOnFailureListener {
                Log.d("BREAK","Ocurrio un error ${it}")
            }
    }

}