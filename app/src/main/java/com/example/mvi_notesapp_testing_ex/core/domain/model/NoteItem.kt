package com.example.mvi_notesapp_testing_ex.core.domain.model

data class NoteItem(
    val title: String,
    val description: String,
    val imageUrl: String,
    val dateAdded: Long,
    val id: Int? = null
)
