package main.storage.turnover.data

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class PlaneViewModel {

    var planes by mutableStateOf(PlaneProvider.planeList)

    fun addPlane(plane: Plane) {
        planes = planes + listOf(plane)
    }

    fun removePlane(plane: Plane) {
        planes = planes.toMutableList().also {
            it.remove(plane)
        }
    }
}