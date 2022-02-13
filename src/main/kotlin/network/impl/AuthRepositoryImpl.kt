package network.impl

import auth.AuthRepository
import auth.signIn.SignInRequest
import network.BaseRepository
import network.TokenResponse

class AuthRepositoryImpl : BaseRepository("auth-app/auth/v1"), AuthRepository {

    override suspend fun signIn(signInRequest: SignInRequest) =
        post<TokenResponse>("/sign-in", signInRequest)

}