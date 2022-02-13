package main

import com.arkivanov.essenty.parcelable.Parcelable

abstract class MainTab(val title: String) : Parcelable

abstract class MainTabGroup(title: String) : MainTab(title) {
    abstract val destinations: List<MainTab>
}