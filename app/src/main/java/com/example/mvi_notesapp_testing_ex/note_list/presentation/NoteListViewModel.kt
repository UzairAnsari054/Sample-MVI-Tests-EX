package com.example.mvi_notesapp_testing_ex.note_list.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvi_notesapp_testing_ex.core.domain.model.NoteItem
import com.example.mvi_notesapp_testing_ex.note_list.domain.use_case.DeleteNote
import com.example.mvi_notesapp_testing_ex.note_list.domain.use_case.GetAllNote
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteListViewModel @Inject constructor(
    private val getAllNote: GetAllNote,
    private val deleteNote: DeleteNote
) : ViewModel() {

    private val _noteListState = MutableStateFlow<List<NoteItem>>(emptyList())
    val noteListState: StateFlow<List<NoteItem>> = _noteListState.asStateFlow()

    private val _orderByTitleState = MutableStateFlow(false)
    val orderByTitleState: StateFlow<Boolean> = _orderByTitleState.asStateFlow()

    fun loadNotes() {
        viewModelScope.launch {
            _noteListState.update {
                getAllNote.invoke(isOrderByTitle = orderByTitleState.value)
            }
        }
    }

    fun deleteNote(noteItem: NoteItem) {
        viewModelScope.launch {
            deleteNote.invoke(note = noteItem)
            loadNotes()
        }
    }

    fun changeOrder() {
        viewModelScope.launch {
            _orderByTitleState.update { !it }
            loadNotes()
        }
    }
}