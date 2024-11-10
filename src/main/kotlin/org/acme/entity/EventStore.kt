package org.acme.entity

import io.quarkus.hibernate.orm.panache.kotlin.PanacheCompanion
import io.quarkus.hibernate.orm.panache.kotlin.PanacheEntity
import jakarta.persistence.Entity
import jakarta.persistence.Table
import java.time.Instant

 @Entity
 @Table(name = "CRYPTO_EVENT")
class EventStore: PanacheEntity() {
    lateinit var bitcoin: String;
    lateinit var country: String;
    var date: Instant = Instant.now()


    companion object : PanacheCompanion<EventStore>{
        fun getByCountry(country: String) = find("country", country).firstResult()
    }
}