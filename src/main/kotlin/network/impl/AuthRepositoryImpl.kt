package network.impl

import auth.AuthRepository
import auth.signIn.SignInRequest
import network.BaseRepository
import network.TokenResponse

class AuthRepositoryImpl : BaseRepository("auth"), AuthRepository {

    override suspend fun signIn(signInRequest: SignInRequest) =
        post<TokenResponse>("/login", signInRequest)

}