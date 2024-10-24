package com.example.mvi_notesapp_testing_ex.note_list.domain.use_case

import com.example.mvi_notesapp_testing_ex.core.domain.model.NoteItem
import com.example.mvi_notesapp_testing_ex.core.domain.repository.NoteRepository

class GetAllNote(
    private val noteRepository: NoteRepository
) {
    suspend operator fun invoke(isOrderByTitle: Boolean): List<NoteItem> {
        return if (isOrderByTitle) {
            noteRepository.getAllNotes().sortedBy { it.title.lowercase() }
        } else {
            noteRepository.getAllNotes().sortedBy { it.dateAdded }
        }
    }
}