package com.netsensia.rivalchess.utils

import org.apache.activemq.ActiveMQConnectionFactory
import javax.jms.*

object JmsReceiver {
    private val url = System.getenv("ACTIVE_MQ_URL")
    private val user = System.getenv("ACTIVE_MQ_USER")
    private val pass = System.getenv("ACTIVE_MQ_PASSWORD")

    @Throws(JMSException::class)
    @JvmStatic
    fun receive(subject: String): String {
        val connectionFactory = ActiveMQConnectionFactory(url)
        connectionFactory.userName = user
        connectionFactory.password = pass
        val connection = connectionFactory.createConnection()

        connection.start()

        val session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE)

        val destination: Destination = session.createQueue(subject)

        val consumer = session.createConsumer(destination)

        println("Waiting for $subject message")
        val message = consumer.receive()

        connection.close()
        println("Event received $subject, $message")

        if (message is TextMessage) {
            return message.text
        }
        return "ERROR"
    }
}