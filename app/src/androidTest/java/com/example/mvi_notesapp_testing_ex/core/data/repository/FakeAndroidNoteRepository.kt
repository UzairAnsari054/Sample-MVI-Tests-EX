package com.example.mvi_notesapp_testing_ex.core.data.repository

import com.example.mvi_notesapp_testing_ex.core.domain.model.NoteItem
import com.example.mvi_notesapp_testing_ex.core.domain.repository.NoteRepository

class FakeAndroidNoteRepository : NoteRepository {

    private var noteItems = mutableListOf<NoteItem>()

    fun shouldHaveFilledList(shouldHaveFilledList: Boolean) {
        noteItems = if (shouldHaveFilledList) {
            mutableListOf(
                NoteItem("title1", "description1", "imageUrl1", 1),
                NoteItem("title2", "description2", "imageUrl2", 2),
                NoteItem("title3", "description3", "imageUrl3", 3),
                NoteItem("title4", "description4", "imageUrl4", 4)
            )
        } else {
            mutableListOf()
        }

    }

    override suspend fun upsertNote(noteItem: NoteItem) {
        noteItems.add(noteItem)
    }

    override suspend fun deleteNote(noteItem: NoteItem) {
        noteItems.remove(noteItem)
    }

    override suspend fun getAllNotes(): List<NoteItem> {
        return noteItems
    }

}