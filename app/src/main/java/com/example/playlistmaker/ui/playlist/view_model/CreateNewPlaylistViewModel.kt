package com.example.playlistmaker.ui.playlist.view_model

import androidx.lifecycle.ViewModel
import com.example.playlistmaker.domain.playlist.interactor.PlaylistInteractor
import com.example.playlistmaker.domain.settings.interactors.SettingsInteractor

class CreateNewPlaylistViewModel(
    private val playlistInteractor: PlaylistInteractor,
    private val settingsInteractor: SettingsInteractor
) : ViewModel() {

    fun createPlaylist(playlistName: String, playlistDescription: String?, playlistUri: String) {
        playlistInteractor.createPlaylist(playlistName, playlistDescription, playlistUri)
    }

    fun isDark(): Boolean {
        return settingsInteractor.isDark()
    }
}