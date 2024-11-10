package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.acme.entity.EventStore;

@ApplicationScoped
class EventService {

    @Transactional
    fun findByCountry(country: String): EventStore? {
        return EventStore.getByCountry(country);
    }

}
