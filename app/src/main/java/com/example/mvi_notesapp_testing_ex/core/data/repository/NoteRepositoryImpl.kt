package com.example.mvi_notesapp_testing_ex.core.data.repository

import com.example.mvi_notesapp_testing_ex.core.data.local.NoteDatabase
import com.example.mvi_notesapp_testing_ex.core.data.mapper.toNoteEntityForDelete
import com.example.mvi_notesapp_testing_ex.core.data.mapper.toNoteEntityForInsert
import com.example.mvi_notesapp_testing_ex.core.data.mapper.toNoteItem
import com.example.mvi_notesapp_testing_ex.core.domain.model.NoteItem
import com.example.mvi_notesapp_testing_ex.core.domain.repository.NoteRepository
import javax.inject.Inject

class NoteRepositoryImpl @Inject constructor(
    noteDatabase: NoteDatabase
) : NoteRepository {
    private val noteDao = noteDatabase.getNoteDao()

    override suspend fun upsertNote(noteItem: NoteItem) {
        return noteDao.upsertNoteEntity(noteItem.toNoteEntityForInsert())
    }

    override suspend fun deleteNote(noteItem: NoteItem) {
        return noteDao.deleteNoteEntity(noteItem.toNoteEntityForDelete())
    }

    override suspend fun getAllNotes(): List<NoteItem> {
        return noteDao.getAllNotesEntities().map { it.toNoteItem() }
    }

}