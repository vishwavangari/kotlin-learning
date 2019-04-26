package io.kotlin.learning

import io.kotlin.learning.dto.Person
import io.kotlin.learning.repository.PersonRepository
import io.kotlintest.specs.FeatureSpec
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.test.annotation.DirtiesContext
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.TestContextManager

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles
@DirtiesContext
class PersonEndpointTest : FeatureSpec() {
    @Autowired
    val restTemplate: TestRestTemplate? = null

    @Autowired
    private val repository: PersonRepository? = null

    override fun beforeAll() {
        TestContextManager(this.javaClass).prepareTestInstance(this)
    }

    init {
        feature("People endpoint") {
            scenario("Asserting getting a person is working") {
                repository?.save(Person(firstName = "Vishwa", lastName = "Vangari", age = 10))
                val entity = restTemplate?.getForEntity("/person/1", Person::class.java)
                entity?.statusCodeValue shouldBe 200
            }
        }
    }
}