package com.example.mvi_notesapp_testing_ex.core.domain.repository

import com.example.mvi_notesapp_testing_ex.core.domain.model.Images

interface ImagesRepository {

    suspend fun searchImages(query: String): Images?
}