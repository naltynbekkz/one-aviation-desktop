package main

import kotlinx.coroutines.flow.StateFlow

interface MainSettings {

    val nightMode: StateFlow<Boolean>
    fun setNightMode(value: Boolean)

    val startupScreen: StateFlow<MainTab>
    fun setStartupScreen(value: MainTab)

}