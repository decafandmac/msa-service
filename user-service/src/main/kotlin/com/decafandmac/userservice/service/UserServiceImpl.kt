package com.decafandmac.userservice.service

import com.decafandmac.userservice.dto.UserDto
import com.decafandmac.userservice.entity.UserEntity
import com.decafandmac.userservice.repository.UserRepository
import org.modelmapper.ModelMapper
import org.modelmapper.convention.MatchingStrategies
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(val userRepository: UserRepository): UserService {

    override fun createUser(userDto: UserDto): UserDto {
        val modelMapper: ModelMapper = ModelMapper()
        modelMapper.configuration.matchingStrategy = MatchingStrategies.STRICT

        val userEntity: UserEntity = modelMapper.map(userDto, UserEntity::class.java)
        userEntity.encryptedPwd = "encrypted_password"
        userRepository.save(userEntity)

        return modelMapper.map(userEntity, UserDto::class.java)
    }
}