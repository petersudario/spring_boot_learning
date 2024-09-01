package br.pucpr.authserver.users

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
    fun createUser(@RequestBody user: User) = userService.save(user).toResponse()

    @GetMapping("/{id}")
    fun getUser(@PathVariable("id") id: Long) = userService.getById(id)?.toResponse()

    private fun User.toResponse() = UserResponse(
        id = id!!,
        email = email,
        name = name
    )

}