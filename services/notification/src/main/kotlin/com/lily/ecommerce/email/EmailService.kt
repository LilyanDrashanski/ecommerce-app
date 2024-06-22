package com.lily.ecommerce.email

import com.lily.ecommerce.email.EmailTemplates.*
import com.lily.ecommerce.kafka.order.Products
import jakarta.mail.MessagingException
import org.apache.kafka.common.requests.DeleteAclsResponse.log
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.mail.javamail.MimeMessageHelper
import org.springframework.mail.javamail.MimeMessageHelper.MULTIPART_MODE_MIXED
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Service
import org.thymeleaf.context.Context
import org.thymeleaf.spring6.SpringTemplateEngine
import java.nio.charset.StandardCharsets.UTF_8

@Service
class EmailService(
    private val mailSender: JavaMailSender,
    private val templateEngine: SpringTemplateEngine,

    ) {
    @Async
    fun sendPaymentSuccessEmail(
        destinationEmail: String,
        customerName: String,
        amount: Int,
        orderReference: String
    ) {

        val mimeMessage = mailSender.createMimeMessage()
        val messageHelper = MimeMessageHelper(mimeMessage, MULTIPART_MODE_MIXED, UTF_8.name())
        messageHelper.setFrom("lilyandrashanski@gmail.com")

        val templateName = PAYMENT_CONFIRMATION.templateName

        val variables = mapOf("customerName" to customerName, "amount" to amount, "orderReference" to orderReference)


        val context = Context()
        context.setVariables(variables)

        messageHelper.setSubject(PAYMENT_CONFIRMATION.subject)

        try {
            val htmlTemplate = templateEngine.process(templateName, context)
            messageHelper.setText(htmlTemplate, true)

            messageHelper.setTo(destinationEmail)
            mailSender.send(mimeMessage)
            log.info(String.format("Sending email successfully %s with template %s", destinationEmail), templateName)
        } catch (e: MessagingException) {
            log.warn("WARNING - Cannot send email to {}", destinationEmail)
        }
    }

    @Async
    fun sentOrderConfirmationEmail(
        destinationEmail: String?,
        customerName: String,
        amount: Int,
        orderReference: String,
        products: List<Products>
    ) {

        val mimeMessage = mailSender.createMimeMessage()
        val messageHelper = MimeMessageHelper(mimeMessage, MULTIPART_MODE_MIXED, UTF_8.name())
        messageHelper.setFrom("lilyandrashanski@gmail.com")

        val templateName = ORDER_CONFIRMATION.templateName

        val variables = mapOf("customerName" to customerName, "totalAmount" to amount, "orderReference" to orderReference,"products" to products)


        val context = Context()
        context.setVariables(variables)

        messageHelper.setSubject(ORDER_CONFIRMATION.subject)

        try {
            val htmlTemplate = templateEngine.process(templateName, context)
            messageHelper.setText(htmlTemplate, true)

            messageHelper.setTo(destinationEmail!!)
            mailSender.send(mimeMessage)
            log.info(String.format("Sending email successfully %s with template %s", destinationEmail), templateName)
        } catch (e: MessagingException) {
            log.warn("WARNING - Cannot send email to {}", destinationEmail)
        }
    }
}