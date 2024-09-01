package br.pucpr.authserver.users

import org.springframework.stereotype.Service

@Service
class UserService(val usersRepository: UsersRepository) {

    fun save(user: User) = usersRepository.save(user)

    fun getById(id: Long) = usersRepository.getById(id)

    fun findAll() = usersRepository.findAll()
}