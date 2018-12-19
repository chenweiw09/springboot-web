package com.xiaomi.chen.springboottest.domain

import org.hibernate.validator.constraints.Length
import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank

/**
 * Created by Wei Chen on 10:21 2018/12/18.
 */
@Entity
class Contact {

    @Id
    @GeneratedValue
    @Column(name = "id")
    var id = 0

    @NotBlank(message = "{user name mot blank}")
    var name = ""

    @Email
    @NotBlank(message = "email not blank")
    var email = ""

    @Length(min=0, max = 1024)
    var message = ""

    var dealStatus = 0

    var phone = ""

    var createTime: Date? = null
}
