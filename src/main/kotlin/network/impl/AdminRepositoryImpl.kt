package network.impl

import main.staff.admins.AdminRepository
import main.staff.admins.User
import main.staff.admins.addAdmin.RegistrationRequest
import network.BaseRepository

class AdminRepositoryImpl : BaseRepository("users/admins"), AdminRepository {

    override suspend fun getAdmins() =
        get<List<User>>()

    override suspend fun addAdmin(request: RegistrationRequest) =
        post<User>(body = request)

    override suspend fun getAdmin(id: Long) =
        get<User>("/$id")

    override suspend fun deleteAdmin(id: Long) =
        delete<Unit>("/$id")

    override suspend fun editAdmin(id: Long, request: RegistrationRequest) =
        put<User>("/$id", request)
}