package com.lily.ecommerce.notification

import org.springframework.data.mongodb.repository.MongoRepository

interface NotificationRepository: MongoRepository<Notification, String> {
}