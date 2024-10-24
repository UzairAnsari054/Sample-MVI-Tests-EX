package com.example.mvi_notesapp_testing_ex.core.data.repository

import com.example.mvi_notesapp_testing_ex.core.data.mapper.toImages
import com.example.mvi_notesapp_testing_ex.core.data.remote.api.ImagesApi
import com.example.mvi_notesapp_testing_ex.core.domain.model.Images
import com.example.mvi_notesapp_testing_ex.core.domain.repository.ImagesRepository
import javax.inject.Inject

class ImagesRepositoryImpl @Inject constructor(
    private val imagesApi: ImagesApi
) : ImagesRepository {

    override suspend fun searchImages(query: String): Images? {
        return imagesApi.searchImages(query)?.toImages()
    }
}