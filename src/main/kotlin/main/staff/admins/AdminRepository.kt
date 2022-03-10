package main.staff.admins

import main.staff.admins.addAdmin.RegistrationRequest
import network.ResponseState.NetworkResponse

interface AdminRepository {

    suspend fun addAdmin(request: RegistrationRequest): NetworkResponse<User>
    suspend fun getAdmins(): NetworkResponse<List<User>>
    suspend fun getAdmin(id: Long): NetworkResponse<User>
    suspend fun deleteAdmin(id: Long): NetworkResponse<Unit>

}