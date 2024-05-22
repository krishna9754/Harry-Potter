package com.example.harrypotter.data.apiservice

import com.example.harrypotter.data.api.CharacterItem
import com.example.harrypotter.data.model.AppConstant
import retrofit2.http.GET


interface CharacterAPI {

    @GET(AppConstant.END_POINT)
    suspend fun getCharacter(): List<CharacterItem>
}