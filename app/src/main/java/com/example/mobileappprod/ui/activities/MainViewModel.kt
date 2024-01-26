package com.example.mobileappprod.ui.activities

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mobileappprod.data.models.IncidentModel
import com.example.mobileappprod.data.repository.FirebaseRepository
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    private val repo = FirebaseRepository()

    private val _user = MutableStateFlow(getCurrentUser())
    val user = _user.asStateFlow()


    private val _allIncidents = MutableStateFlow<List<IncidentModel>>(emptyList())
    val allIncidents = _allIncidents.asStateFlow()
    private fun getCurrentUser(): FirebaseUser? = repo.getCurrentUser()





    fun registerNewUserByEmail(name: String, email:String, password: String){
        CoroutineScope(Dispatchers.IO).launch{
            val newUser = repo.registerNewUserByEmail(name, email, password)
        }
    }

    fun LoginUser(emial: String, password: String){
        CoroutineScope(Dispatchers.IO).launch {
            _user.emit(repo.loginUser(emial, password))
        }
    }

    fun loadAllIncidents(){
        viewModelScope.launch {
            _allIncidents.update {
                repo.getAllIncidents()
            }
        }
    }

    fun getUserIncidents(userId: String?): Flow<List<IncidentModel>>{
        return flow { emit(repo.getUserIncidents(userId))
        }
    }
}