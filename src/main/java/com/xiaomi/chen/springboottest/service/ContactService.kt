package com.xiaomi.chen.springboottest.service

import com.xiaomi.chen.springboottest.dao.ContactDao
import com.xiaomi.chen.springboottest.domain.Contact
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.*

/**
 * Created by Wei Chen on 10:30 2018/12/18.
 */

@Service
class ContactService(@Autowired private val contactDao: ContactDao){

    fun saveContact(contact: Contact): Contact{
       return contactDao.save(contact)
    }

    fun getAllByCreateTimeBefore(createTime : Date, pageable : Pageable) : Page<Contact> {
        return contactDao.getAllByCreateTimeBefore(createTime, pageable)
    }

}