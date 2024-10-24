package com.example.mvi_notesapp_testing_ex.core.data.mapper

import com.example.mvi_notesapp_testing_ex.core.data.local.NoteEntity
import com.example.mvi_notesapp_testing_ex.core.domain.model.NoteItem

fun NoteItem.toNoteEntityForInsert(): NoteEntity {
    return NoteEntity(
        title = title,
        description = description,
        imageUrl = imageUrl,
        dateAdded = dateAdded,
    )
}

fun NoteItem.toNoteEntityForDelete(): NoteEntity {
    return NoteEntity(
        title = title,
        description = description,
        imageUrl = imageUrl,
        dateAdded = dateAdded,
        id = id
    )
}

fun NoteEntity.toNoteItem(): NoteItem {
    return NoteItem(
        title = title,
        description = description,
        imageUrl = imageUrl,
        dateAdded = dateAdded,
        id = id
    )
}