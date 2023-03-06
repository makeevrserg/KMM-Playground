package com.makeevrserg.kmmplayground

interface SongPlayer {
    /**
     * Pause player
     */
    fun pause()

    /**
     * Stops player
     */
    fun stop()

    /**
     * Resume paused song
     */
    fun resume()

    /**
     * Play song from url
     */
    fun play(url: String)
}