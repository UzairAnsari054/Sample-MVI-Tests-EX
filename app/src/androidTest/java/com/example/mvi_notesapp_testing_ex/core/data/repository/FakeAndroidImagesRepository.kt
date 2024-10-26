package com.example.mvi_notesapp_testing_ex.core.data.repository

import com.example.mvi_notesapp_testing_ex.core.domain.model.Images
import com.example.mvi_notesapp_testing_ex.core.domain.repository.ImagesRepository

class FakeAndroidImagesReository : ImagesRepository {

    private var shouldReturnError = false
    fun setShouldReturnError(value: Boolean) {
        shouldReturnError = value
    }

    override suspend fun searchImages(query: String): Images? {
        return if (shouldReturnError) {
            null
        } else {
            Images(listOf("Image1", "Image2", "Image3", "Image4", "Image5", "Image6"))
        }
    }

}