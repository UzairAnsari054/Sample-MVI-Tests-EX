package com.example.mvi_notesapp_testing_ex.core.data.mapper

import com.example.mvi_notesapp_testing_ex.core.data.remote.dto.ImageListDto
import com.example.mvi_notesapp_testing_ex.core.domain.model.Images

fun ImageListDto.toImages(): Images {
    return Images(
        images = hits?.map { it.previewURL ?: "" } ?: emptyList()
    )
}