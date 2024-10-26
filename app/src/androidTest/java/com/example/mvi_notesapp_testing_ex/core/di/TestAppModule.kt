package com.example.mvi_notesapp_testing_ex.core.di

import android.app.Application
import androidx.room.Room
import com.example.mvi_notesapp_testing_ex.add_note.domain.use_case.SearchImages
import com.example.mvi_notesapp_testing_ex.add_note.domain.use_case.UpsertNote
import com.example.mvi_notesapp_testing_ex.core.data.local.NoteDatabase
import com.example.mvi_notesapp_testing_ex.core.data.repository.FakeAndroidNoteRepository
import com.example.mvi_notesapp_testing_ex.core.domain.repository.NoteRepository
import com.example.mvi_notesapp_testing_ex.core.data.remote.api.ImagesApi
import com.example.mvi_notesapp_testing_ex.core.data.repository.FakeAndroidImagesRepository
import com.example.mvi_notesapp_testing_ex.core.domain.repository.ImagesRepository
import com.example.mvi_notesapp_testing_ex.note_list.domain.use_case.DeleteNote
import com.example.mvi_notesapp_testing_ex.note_list.domain.use_case.GetAllNote
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object TestAppModule {

    @Singleton
    @Provides
    fun provideNoteDatabase(application: Application) = Room.inMemoryDatabaseBuilder(
        application,
        NoteDatabase::class.java,
    ).build()

    @Singleton
    @Provides
    fun provideNoteRepository(): NoteRepository {
        return FakeAndroidNoteRepository()
    }

    @Singleton
    @Provides
    fun provideGetAllNote(noteRepository: NoteRepository): GetAllNote {
        return GetAllNote(noteRepository)
    }

    @Singleton
    @Provides
    fun provideDeleteAllNote(noteRepository: NoteRepository): DeleteNote {
        return DeleteNote(noteRepository)
    }


    @Singleton
    @Provides
    fun provideImagesApi(): ImagesApi {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(ImagesApi.BASE_URL)
            .build()
            .create(ImagesApi::class.java)
    }

    @Singleton
    @Provides
    fun provideImagesRepository(): ImagesRepository {
        return FakeAndroidImagesRepository()
    }

    @Singleton
    @Provides
    fun provideUpsertNote(noteRepository: NoteRepository): UpsertNote {
        return UpsertNote(noteRepository)
    }

    @Singleton
    @Provides
    fun provideSearchImages(imagesRepository: ImagesRepository): SearchImages {
        return SearchImages(imagesRepository)
    }

}