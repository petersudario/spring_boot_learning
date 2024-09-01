package br.pucpr.authserver.users

class User (
    var id: Long,
    val email: String,
    val password: String,
    val name: String
)