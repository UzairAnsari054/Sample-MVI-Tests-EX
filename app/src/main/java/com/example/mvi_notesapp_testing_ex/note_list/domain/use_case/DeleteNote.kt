package com.example.mvi_notesapp_testing_ex.note_list.domain.use_case

import com.example.mvi_notesapp_testing_ex.core.domain.model.NoteItem
import com.example.mvi_notesapp_testing_ex.core.domain.repository.NoteRepository

class DeleteNote(
    private val noteRepository: NoteRepository
) {
    suspend operator fun invoke(note: NoteItem){
        noteRepository.deleteNote(note)
    }
}