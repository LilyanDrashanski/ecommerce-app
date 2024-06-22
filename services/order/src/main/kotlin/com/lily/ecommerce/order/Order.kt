package com.lily.ecommerce.order
import jakarta.persistence.*
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime

@Entity
@EntityListeners(AuditingEntityListener::class)
@Table(name = "customer-order")
class Order(
    @Id @GeneratedValue
    var id: Int,
    var reference: String?,
    var totalAmount: Int?,
    @Enumerated(EnumType.STRING)
    var paymentMethod: PaymentMethod?,
    var customerId: String?,
    @OneToMany(mappedBy = "order")
    var orderLines: List<OrderLine> = mutableListOf(),
    @CreatedDate @Column(updatable = false, nullable = false)
    var createdAt: LocalDateTime = LocalDateTime.now(),
    @LastModifiedDate @Column(insertable = false)
    var updatedAt: LocalDateTime = LocalDateTime.now()
)
