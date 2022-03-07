package network.impl

import main.staff.masters.PlanesRepository
import main.staff.masters.addMaster.CreatePlaneRequest
import main.staff.masters.data.Plane
import network.BaseRepository

class PlanesRepositoryImpl : BaseRepository("planes"), PlanesRepository {

    override suspend fun getPlanes() =
        get<List<Plane>>()

    override suspend fun addPlane(request: CreatePlaneRequest) =
        post<Plane>(body = request)

    override suspend fun deletePlane(id: Int) =
        delete<Unit>("/$id")
}