package com.xiaomi.chen.springboottest.dao

import com.xiaomi.chen.springboottest.domain.Contact
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.data.repository.PagingAndSortingRepository

import java.util.Date

/**
 * Created by Wei Chen on 10:34 2018/12/18.
 */
interface ContactDao : PagingAndSortingRepository<Contact, Long>, JpaSpecificationExecutor<Contact> {

    fun getAllByCreateTimeBefore(createTime: Date, pageable : Pageable): Page<Contact>
}
