package com.chikara.jetpackcomposeseries.ui.auth.viewModel

import androidx.compose.ui.res.stringResource
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.chikara.jetpackcomposeseries.R
import com.google.firebase.auth.FirebaseAuth

/**
 * Created by CHIKARA on 24/10/25.
 */
class AuthViewModel : ViewModel() {
    private val auth: FirebaseAuth = FirebaseAuth.getInstance();
    private val _authState = MutableLiveData<AuthState>();
    var authState = _authState;


    init {
        checkForAuth()
    }

    /// Function to check for Auth.
    fun checkForAuth() {
        if (auth.currentUser == null) {
            _authState.value = AuthState.UnAuthenticated;
        } else {
            _authState.value = AuthState.Authenticated;
        }
    }

    /// Function to check for Login.
    fun login(email: String, password: String) {
        _authState.value = AuthState.Loading;
        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                _authState.value = AuthState.Authenticated;
            } else {
                var errorMsg = task.exception?.message;
                if (errorMsg == null) {
                    errorMsg = "Something went wrong";
                }

                _authState.value = AuthState.onError(error = errorMsg);
            }
        }
    }

    /// Function to check for Signup.
    fun createSignup(email: String, password: String) {
        _authState.value = AuthState.Loading;
        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                _authState.value = AuthState.Authenticated;
            } else {
                var errorMsg = task.exception?.message;
                if (errorMsg == null) {
                    errorMsg = "Something went wrong";
                }

                _authState.value = AuthState.onError(error = errorMsg);
            }
        }
    }

    /// Function to SignOut.
    fun signOut() {
        _authState.value = AuthState.Loading;
        auth.signOut();
        _authState.value = AuthState.UnAuthenticated;
    }

}

sealed class AuthState {
    object Authenticated : AuthState()
    object UnAuthenticated : AuthState()
    object Loading : AuthState()
    data class onError(val error: String) : AuthState()
}