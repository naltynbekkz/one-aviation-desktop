package network.impl

import main.staff.masters.PlanesRepository
import main.staff.masters.addMaster.CreatePlaneRequest
import main.staff.masters.data.Plane
import main.staff.masters.master.EditPlaneRequest
import network.BaseRepository

class PlanesRepositoryImpl : BaseRepository("planes"), PlanesRepository {

    override suspend fun getPlanes() =
        get<List<Plane>>()

    override suspend fun addPlane(request: CreatePlaneRequest) =
        post<Plane>(body = request)

    override suspend fun deletePlane(id: Int) =
        delete<Unit>("/$id")

    override suspend fun getPlane(id: Long) =
        get<Plane>("/$id")

    override suspend fun editPlane(id: Long, request: EditPlaneRequest) =
        put<Plane>("/$id", request)
}