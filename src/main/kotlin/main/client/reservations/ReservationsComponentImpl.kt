package main.client.reservations

import com.arkivanov.decompose.ComponentContext

class ReservationsComponentImpl(
    componentContext: ComponentContext,
) : ReservationsComponent, ComponentContext by componentContext