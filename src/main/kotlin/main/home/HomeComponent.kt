package main.home

import core.Component
import kotlinx.coroutines.flow.StateFlow

interface HomeComponent : Component {

    val nightMode: StateFlow<Boolean>

    fun setNightMode(value: Boolean)

}