package br.pucpr.authserver.users

import br.pucpr.authserver.users.requests.UserRequest
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/users")
open class UsersController (val userService: UserService) {


    @GetMapping
    fun listUsers() = userService.findAll().map {
        it.toResponse()
    }

    @PostMapping
    fun createUser(@RequestBody @Validated request: UserRequest) = userService.save(
        User(email = request.email!!, password = request.password!!, name = request.name!!)).toResponse().let { ResponseEntity.ok(it) }

    @GetMapping("/{id}")
    fun getUser(@PathVariable("id") id: Long) = userService.getById(id)?.let { ResponseEntity.ok(it.toResponse()) } ?: ResponseEntity.notFound().build()

    private fun User.toResponse() = UserResponse(
        id = id!!,
        email = email,
        name = name
    )

}