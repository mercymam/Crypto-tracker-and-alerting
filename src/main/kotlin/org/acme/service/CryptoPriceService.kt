package org.acme.service

import jakarta.enterprise.context.ApplicationScoped
import org.acme.controller.CryptoClient
import org.eclipse.microprofile.rest.client.inject.RestClient

@ApplicationScoped
class CryptoPriceService(@RestClient private val client: CryptoClient) {

    suspend fun getBitcoinPriceForUs(): Double? {
        val response = client.getCryptoData("bitcoin", "usd")
        return response["bitcoin"]?.get("usd")
    }
}