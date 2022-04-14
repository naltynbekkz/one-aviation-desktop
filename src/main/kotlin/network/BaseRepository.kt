package network

import core.CoreSettings
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.network.sockets.*
import io.ktor.client.plugins.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.delay
import network.ResponseState.NetworkResponse

abstract class BaseRepository(val basePath: String = "") {

    lateinit var client: HttpClient
    lateinit var coreSettings: CoreSettings

    suspend inline fun <reified T> request(call: () -> HttpResponse): NetworkResponse<T> {
        val response: NetworkResponse<T> = try {
//            delay(1500L)
            val response = call()
            val body = response.body<T>()
            return NetworkResponse.Success(body)
        } catch (e: CancellationException) {
            NetworkResponse.Error.CancelledError()
        } catch (e: ClientRequestException) {
            when (e.response.status) {
                HttpStatusCode.Unauthorized -> {
                    coreSettings.setRefreshToken(null)
                    NetworkResponse.Error.UnauthenticatedError()
                }
                HttpStatusCode.NotFound -> {
                    NetworkResponse.Error.UnknownError(e)
                }
                else -> {
                    val message = e.response.body<MessageResponse>()
                    NetworkResponse.Error.UnknownError(Exception(message.message))
                }
            }
        } catch (e: ServerResponseException) {
            NetworkResponse.Error.ServerError()
        } catch (e: SocketTimeoutException) {
            NetworkResponse.Error.UnknownError(e)
        } catch (e: Exception) {
            NetworkResponse.Error.UnknownError(e)
        }
        return response
    }

    suspend inline fun <reified T> get(path: String = "", queryParams: List<Pair<String, Any?>>? = null) = request<T> {
        client.get {
            url.set {
                path("$basePath$path")
            }
            contentType(ContentType.Application.Json)
            queryParams?.forEach {
                val value = it.second
                if (value is List<*>) {
                    value.forEach { parameter ->
                        parameter(it.first, parameter)
                    }
                } else {
                    parameter(it.first, it.second)
                }
            }
        }
    }

    suspend inline fun <reified T> post(path: String = "", body: Any) = request<T> {
        client.post {
            url {
                path("$basePath$path")
            }
            setBody(body)
            contentType(ContentType.Application.Json)
        }
    }

    suspend inline fun <reified T> postFullUrl(url: String, body: Any) = request<T> {
        client.post {
            url {
                path(url)
            }
            setBody(body)
            contentType(ContentType.Application.Json)
        }
    }

    suspend inline fun <reified T> put(path: String, body: Any?) = request<T> {
        client.put {
            url {
                path("$basePath$path")
            }
            setBody(body)
            contentType(ContentType.Application.Json)
        }
    }

    suspend inline fun <reified T> delete(path: String) = request<T> {
        client.delete {
            url {
                path("$basePath$path")
            }
            contentType(ContentType.Application.Json)
        }
    }

}