package main.logs.reservation

import core.Component
import core.Interactor
import main.logs.Flight

interface ReservationComponent : Component {
    val flight: Interactor<Flight>
}