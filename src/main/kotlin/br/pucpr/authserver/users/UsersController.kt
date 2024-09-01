package br.pucpr.authserver.users

import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
open class UsersController (val userService: UserService) {


    @GetMapping
    fun listUsers() = userService.findAll().map {
        it.toResponse()
    }

    @PostMapping
    fun createUser(@RequestBody user: User) : ResponseEntity<UserResponse> {
        val user = userService.save(user).toResponse()
        return ResponseEntity.status(HttpStatus.CREATED).body(user)
    }

    @GetMapping("/{id}")
    fun getUser(@PathVariable("id") id: Long) : ResponseEntity<UserResponse> {
        val user = userService.getById(id)
        return if (user == null)
            ResponseEntity.notFound().build()
        else
            ResponseEntity.ok(user.toResponse())
    }

    private fun User.toResponse() = UserResponse(
        id = id!!,
        email = email,
        name = name
    )

}