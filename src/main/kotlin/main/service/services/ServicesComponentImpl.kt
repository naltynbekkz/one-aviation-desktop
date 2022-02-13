package main.service.services

import com.arkivanov.decompose.ComponentContext

class ServicesComponentImpl(
    componentContext: ComponentContext,
) : ServicesComponent, ComponentContext by componentContext