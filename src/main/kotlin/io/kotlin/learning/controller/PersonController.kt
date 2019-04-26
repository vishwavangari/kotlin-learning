package io.kotlin.learning.controller

import io.kotlin.learning.dto.Person
import io.kotlin.learning.service.PersonService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/person")
class PersonController {

    @Autowired
    lateinit var service: PersonService

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): Person? = service.findOne(id)

    @GetMapping
    fun findAll(): List<Person> = service.findAll()

    @PostMapping
    fun add(@RequestBody person: Person): Person = service.save(person)

    @PutMapping
    fun update(@RequestBody person: Person): Person {
        return service.save(person)
//        if(service.findOne(personId) != null) {
//            return service.save(person)
//        }
    }

    @DeleteMapping("/{id}")
    fun remove(@PathVariable id: Long): Unit = service.delete(id)
}