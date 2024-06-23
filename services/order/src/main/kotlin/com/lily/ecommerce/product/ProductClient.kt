package com.lily.ecommerce.product

import com.lily.ecommerce.exception.BusinessException
import org.springframework.beans.factory.annotation.Value
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpHeaders.*
import org.springframework.http.HttpMethod.*
import org.springframework.http.MediaType.*
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class ProductClient(
    @Value("\${application.config.product-url}")
    val productUrl: String,
    val restTemplate: RestTemplate,
) {
    fun purchaseProducts(request: List<PurchaseRequest>?): List<PurchaseResponse>? {
        val headers = HttpHeaders()
        headers.set(CONTENT_TYPE, APPLICATION_JSON_VALUE)

        val requestEntity = HttpEntity(request, headers)

        val responseType = object : ParameterizedTypeReference<List<PurchaseResponse>>() {}

        println("Sending request to $productUrl/purchase with headers: $headers and body: $request")

        val responseEntity = restTemplate.exchange("$productUrl/purchase", POST, requestEntity, responseType)

        if (responseEntity.statusCode.isError) {
            throw BusinessException("An error occured while processing the products purchase " + responseEntity.statusCode)
        }
        return responseEntity.body

    }

}
