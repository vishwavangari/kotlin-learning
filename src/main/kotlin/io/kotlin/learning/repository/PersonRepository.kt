package io.kotlin.learning.repository

import io.kotlin.learning.dto.Person
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface PersonRepository : CrudRepository<Person, Long>