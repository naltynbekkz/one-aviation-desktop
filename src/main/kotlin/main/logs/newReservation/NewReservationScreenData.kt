package main.logs.newReservation

import main.logs.reservation.Passenger
import main.staff.masters.data.Plane

data class NewReservationScreenData(
    val planes: List<Plane>,
    val passengers: List<Passenger>,
)
