package com.example.harrypotter.di

import com.example.harrypotter.data.apiservice.CharacterAPI
import com.example.harrypotter.data.model.AppConstant
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object CharacterApiModule {
    @Provides
    @Singleton
    fun provideCharacterApi(builder: Retrofit.Builder): CharacterAPI {
        return builder
            .build()
            .create(CharacterAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit.Builder {
        return Retrofit.Builder().baseUrl(AppConstant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
    }

}