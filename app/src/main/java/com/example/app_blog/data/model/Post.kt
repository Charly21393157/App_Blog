package com.example.appblog.data.model

import com.google.firebase.firestore.ServerTimestamp
import java.sql.Timestamp
import java.util.*

data class Post(val profile_picture: String = "",
                val profile_name: String = "",
                @ServerTimestamp
                var created_at: Timestamp? = null,
                val post_image: String = "",
                val post_description: String = "",
                val uid: String = "")
