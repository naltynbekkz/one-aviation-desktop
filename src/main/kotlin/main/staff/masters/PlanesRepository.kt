package main.staff.masters

import main.staff.masters.addMaster.CreatePlaneRequest
import main.staff.masters.data.Plane
import main.staff.masters.master.EditPlaneRequest
import network.ResponseState.NetworkResponse

interface PlanesRepository {

    suspend fun getPlanes(): NetworkResponse<List<Plane>>
    suspend fun addPlane(request: CreatePlaneRequest): NetworkResponse<Plane>
    suspend fun deletePlane(id: Int): NetworkResponse<Unit>
    suspend fun getPlane(id: Long): NetworkResponse<Plane>
    suspend fun editPlane(id: Long, request: EditPlaneRequest): NetworkResponse<Plane>

}