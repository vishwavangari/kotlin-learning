package io.kotlin.learning.dto

import com.fasterxml.jackson.annotation.JsonInclude
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "person")
data class Person(@Id @GeneratedValue val id: Long? = null, val firstName: String? = null, val lastName: String? = null, val age:Int? = null)