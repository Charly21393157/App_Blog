package com.example.app_blog.domain.auth

import android.graphics.Bitmap
import com.example.appblog.data.remote.auth.AuthDataSource
import com.google.firebase.auth.FirebaseUser

class AuthRepoImpl(private val dataSource: AuthDataSource) : AuthRepo {
    override suspend fun signIn(email: String, password: String): FirebaseUser? =
        dataSource.signIn(email, password)

    override suspend fun signUp(email: String, password: String, username: String): FirebaseUser? =
        dataSource.signUp(email, password, username)


    override suspend fun updateProfile(imageBitmap: Bitmap, username: String): Boolean {
        return try {
            dataSource.updateUserProfile(imageBitmap, username)
            true  // Si no hay excepción, indicamos que la actualización fue exitosa
        } catch (e: Exception) {
            false // Si ocurre un error, indicamos que la actualización falló
        }
    }
}
