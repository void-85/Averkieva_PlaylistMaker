package com.example.playlistmaker.ui.player.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.playlistmaker.creator.Creator
import com.example.playlistmaker.domain.player.PlayerInteractor
import com.example.playlistmaker.domain.player.PlayerState
import com.example.playlistmaker.domain.player.PlayerStateChangeListener

class ViewModelAudioPlayer(private val playerInteractor: PlayerInteractor):ViewModel() {

    val playerStateLiveData = MutableLiveData<PlayerState>()

    init{
        val listener = object: PlayerStateChangeListener{
            override fun onChange(state: PlayerState) {
                playerStateLiveData.postValue(state)
            }
        }
        playerInteractor.setListener(listener)
    }

    fun createPlayer(url: String, completion: ()->Unit) {
        playerInteractor.createPlayer(url, completion)
    }

    fun play(){
        playerInteractor.play()
    }

    fun pause(){
        playerInteractor.pause()
    }

    fun destroy(){
        playerInteractor.destroy()
    }

    fun time():String{
        return playerInteractor.time()
    }

    companion object{
        fun getViewModelFactory(): ViewModelProvider.Factory = object: ViewModelProvider.Factory{
            @Suppress("UNCHECKED_CAST")
            override fun <T: ViewModel> create (modelClass: Class<T>):T{
                return ViewModelAudioPlayer(
                    Creator.providePlayerInteractor()
                ) as T
            }
        }
    }
}