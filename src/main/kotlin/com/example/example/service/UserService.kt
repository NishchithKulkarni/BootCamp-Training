package com.example.example.service

import com.example.example.model.User
import com.example.example.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService(@Autowired val userRepository: UserRepository) {

    fun getUserList(): List<User?>? {
        return userRepository.findAll()
    }

}