package org.acme.controller

import jakarta.ws.rs.GET
import jakarta.ws.rs.Path
import jakarta.ws.rs.Produces
import jakarta.ws.rs.QueryParam
import jakarta.ws.rs.core.MediaType
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient

@RegisterRestClient(baseUri = "crypto-api")
interface CryptoClient {

    @GET
    @Path("/simple/price?ids=bitcoin&vs_currencies=usd")
    @Produces(MediaType.APPLICATION_JSON)
    suspend fun getCryptoData(
        @QueryParam("ids") ids: String,
        @QueryParam("vs_cuurencies") vsCurrencies: String
    ): Map<String, Map<String, Double>>
}
