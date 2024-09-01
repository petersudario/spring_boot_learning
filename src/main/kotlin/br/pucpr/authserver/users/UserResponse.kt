package br.pucpr.authserver.users

data class UserResponse (
    var id: Long,
    val email: String,
    val name: String

)