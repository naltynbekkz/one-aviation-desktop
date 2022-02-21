package network.impl

import main.profile.ProfileRepository
import network.BaseRepository

class ProfileRepositoryImpl : BaseRepository("profile"), ProfileRepository {

    override suspend fun signOut() =
        delete<Unit>("/logout")
}