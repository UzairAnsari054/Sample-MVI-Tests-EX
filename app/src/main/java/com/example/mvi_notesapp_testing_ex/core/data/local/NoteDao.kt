package com.example.mvi_notesapp_testing_ex.core.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert

@Dao
interface NoteDao {

    @Upsert
    suspend fun upsertNoteEntity(noteEntity: NoteEntity)

    @Delete
    suspend fun deleteNoteEntity(noteEntity: NoteEntity)

    @Query("SELECT * FROM noteTable")
    suspend fun getAllNotesEntities(): List<NoteEntity>
}