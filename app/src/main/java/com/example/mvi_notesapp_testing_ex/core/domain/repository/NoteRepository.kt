package com.example.mvi_notesapp_testing_ex.core.domain.repository

import com.example.mvi_notesapp_testing_ex.core.domain.model.NoteItem

interface NoteRepository {

    suspend fun upsertNote(noteItem: NoteItem)
    suspend fun deleteNote(noteItem: NoteItem)
    suspend fun getAllNotes(): List<NoteItem>
}