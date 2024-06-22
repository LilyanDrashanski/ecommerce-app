package com.lily.ecommerce.email

enum class EmailTemplates(val templateName: String, val subject: String) {

    PAYMENT_CONFIRMATION("payment-confirmation.html", "Payment successfully processed"),

    ORDER_CONFIRMATION("order-confirmation.html", "Order successfully processed"),

}