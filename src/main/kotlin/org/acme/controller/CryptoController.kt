package org.acme.controller

 import jakarta.inject.Inject
 import jakarta.ws.rs.GET
 import jakarta.ws.rs.Path
 import jakarta.ws.rs.Produces
 import jakarta.ws.rs.core.MediaType
 import org.acme.service.CryptoPriceService

@Path("/crypto")
 class CryptoController @Inject constructor(private val cryptoPriceService: CryptoPriceService) {

    @GET
     @Produces(MediaType.APPLICATION_JSON)
     fun getCryptoData(): String {
         return "Crypto data"
     }

     @GET()
     @Path("/hello")
     @Produces(MediaType.TEXT_PLAIN)
     fun hello() = "Hello from Quarkus REST"

     @GET
     @Path("/price")
     @Produces(MediaType.APPLICATION_JSON)
     suspend fun getBitcoinPrice(): Map<String, Any>{
         val price = cryptoPriceService.getBitcoinPriceForUs()
         return if(price != null) {
             mapOf("currency" to "BTC", "price" to price)
         }
         else{
             mapOf("error" to "Unable to fetch price")
         }
     }
 }
