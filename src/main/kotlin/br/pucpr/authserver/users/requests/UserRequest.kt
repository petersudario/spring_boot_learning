package br.pucpr.authserver.users.requests

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

class UserRequest (

    @field:NotBlank
    val name: String,

    @field:Email
    val email: String,

    @field:Size(min = 6, max = 16)
    val password: String

)