package main.logs

data class Log(
    val name: String,
    val phone: String,
    val profession: List<String>,
    val services: Int,
    val online: Boolean,
    val account: Boolean,
    val rating: Int?,
)