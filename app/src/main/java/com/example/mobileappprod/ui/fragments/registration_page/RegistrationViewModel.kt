package com.example.mobileappprod.ui.fragments.registration_page

import androidx.lifecycle.ViewModel
import com.example.mobileappprod.ui.FirebaseRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RegistrationViewModel : ViewModel() {
    private val repo = FirebaseRepository()

    fun registerNewUserByEmail(email: String,password: String, name: String ){
        CoroutineScope(Dispatchers.IO).launch {
            repo.registerNewUserByEmail(email, password, name)
        }
    }
}