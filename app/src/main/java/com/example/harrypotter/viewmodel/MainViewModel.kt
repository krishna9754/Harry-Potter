package com.example.harrypotter.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.harrypotter.data.api.CharacterItem
import com.example.harrypotter.repository.CharacterRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(private val characterRepo: CharacterRepo
) : ViewModel() {
    private val _state = MutableStateFlow(emptyList<CharacterItem>())
    val state:StateFlow<List<CharacterItem>>
        get() = _state

    init {
        viewModelScope.launch {
            val charactersData = characterRepo.getCharacters()
            _state.value = charactersData
        }
    }
}