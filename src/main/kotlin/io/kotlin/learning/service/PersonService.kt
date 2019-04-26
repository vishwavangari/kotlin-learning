package io.kotlin.learning.service

import io.kotlin.learning.dto.Person
import io.kotlin.learning.repository.PersonRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PersonService {

    @Autowired
    lateinit var repository: PersonRepository

    fun findOne(id: Long): Person? = repository.findOne(id)

    fun findAll(): List<Person> = repository.findAll() as List<Person>

    fun save(person: Person): Person = repository.save(person)

    fun delete(id: Long): Unit = repository.delete(id)

}