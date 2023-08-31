package com.example.booksappmvvm.di

import com.example.booksappmvvm.data.repository.BooksRepository
import com.example.booksappmvvm.data.source.BookService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideProductRepository(bookService: BookService): BooksRepository =
        BooksRepository(bookService)
}