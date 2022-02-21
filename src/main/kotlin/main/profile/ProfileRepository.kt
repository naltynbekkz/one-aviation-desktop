package main.profile

import network.ResponseState.NetworkResponse

interface ProfileRepository {

    suspend fun signOut(): NetworkResponse<Unit>

}