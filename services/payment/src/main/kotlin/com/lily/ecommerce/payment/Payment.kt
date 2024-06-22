package com.lily.ecommerce.payment

import jakarta.persistence.*
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime


@Entity
@EntityListeners(AuditingEntityListener::class)
class Payment(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int?,
    var amount: Int?,
    @Enumerated(EnumType.STRING)
    var paymentMethod: PaymentMethod,
    var orderReference: String?,
    var orderId: String?,
    @CreatedDate @Column(updatable = false, nullable = false)
    var createdAt: LocalDateTime = LocalDateTime.now(),
    @LastModifiedDate @Column(insertable = false)
    var updatedAt: LocalDateTime = LocalDateTime.now()
)