package auth

import auth.signIn.SignInRequest
import network.ResponseState.NetworkResponse
import network.TokenResponse

interface AuthRepository {

//    suspend fun resetPassword(resetPasswordRequest: ResetPasswordRequest): NetworkResponse<TokenResponse>
//
//    suspend fun requestSms(requestSmsRequest: RequestSmsRequest): NetworkResponse<Unit>
//
//    suspend fun validateCode(validateRequest: ValidateRequest): NetworkResponse<Unit>

    suspend fun signIn(signInRequest: SignInRequest): NetworkResponse<TokenResponse>

//    suspend fun signInBySms(signInRequestRequest: SignInBySmsRequest): NetworkResponse<TokenResponse>
//
//    suspend fun signUp(signUpRequest: SignUpRequest): NetworkResponse<TokenResponse>
}