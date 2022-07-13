package com.decafandmac.userservice.entity

import javax.persistence.*

@Entity
@Table(name = "users")
data class UserEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long,

    @Column(length = 50, unique = true)
    var email: String,

    @Column(length = 50)
    var name: String,

    @Column(unique = true)
    var userId: String,

    @Column
    var encryptedPwd: String
)
