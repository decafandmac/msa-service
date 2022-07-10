package com.decafandmac.userservice.entity

import javax.persistence.*

@Entity
@Table(name = "users")
data class UserEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0L,

    @Column(length = 50, unique = true)
    var email: String,

    @Column(length = 50)
    var name: String,

    @Column(unique = true)
    var userId: String,

    @Column(unique = true)
    var encryptedPwd: String
)
