
package com.example.mobileappprod.data.repository

import com.example.mobileappprod.data.models.IncidentModel
import com.example.mobileappprod.data.models.UserModel
import com.example.mobileappprod.ui.fragments.incidents_page.IncidentsViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await

class FirebaseRepository {
    private val auth = FirebaseAuth.getInstance()
    private val db = FirebaseFirestore.getInstance()



    fun getCurrentUser() = auth.currentUser

    suspend fun loginUser(email: String,password: String):FirebaseUser?{
        return auth.signInWithEmailAndPassword(email,password)
            .await()
            .user
    }

    suspend fun registerNewUserByEmail(email: String,password: String, name: String): FirebaseUser? {

        val firebaseUser = auth
            .createUserWithEmailAndPassword(email, password)
            .await()
            .user

        addNewUserToDatabase(firebaseUser, name)

        return firebaseUser
    }

    private suspend fun addNewUserToDatabase(firebaseUser: FirebaseUser?, name: String) {

        firebaseUser ?: throw Exception("User can not be null")
        val user = UserModel(
            id =  firebaseUser.uid,
            name = name,
            email = firebaseUser.email ?:""
        )

        db.collection("users")
            .add(user)
            .await()

    }


    suspend fun getAllIncidents(): List<IncidentModel> {
        return db.collection("incidents")
            .get()
            .await()
            .toObjects(IncidentModel::class.java)
            .toList()
    }

    suspend fun getUserIncidents(userId: String?): List<IncidentModel> {
        userId ?: return emptyList()

        return db.collection("incidents")
            .whereEqualTo("userId", userId)
            .get()
            .await()
            .toObjects(IncidentModel::class.java)
            .toList()
    }

}
