package main.staff.masters

import main.staff.masters.addMaster.CreatePlaneRequest
import main.staff.masters.data.Plane
import network.ResponseState.NetworkResponse

interface PlanesRepository {

    suspend fun getPlanes(): NetworkResponse<List<Plane>>
    suspend fun addPlane(request: CreatePlaneRequest): NetworkResponse<Plane>
    suspend fun deletePlane(id: Int): NetworkResponse<Unit>

}