package com.netsensia.rivalchess.utils

import com.google.gson.Gson
import com.netsensia.rivalchess.utils.interfaces.JmsServiceInterface
import org.apache.activemq.ActiveMQConnectionFactory
import javax.jms.*

class JmsService: JmsServiceInterface {

    private val url = System.getenv("ACTIVE_MQ_URL")
    private val user = System.getenv("ACTIVE_MQ_USER")
    private val pass = System.getenv("ACTIVE_MQ_PASSWORD")

    private var connection: Connection? = null

    @Throws(JMSException::class)
    override fun send(subject: String, message: Any) {
        val session = getSession()

        val destination: Destination = session.createQueue(subject)

        val producer = session.createProducer(destination)

        val gson = Gson()
        val sessionMessage = session.createTextMessage(gson.toJson(message))

        producer.send(sessionMessage)
        println("Event sent $subject, JCG printing@@ '" + sessionMessage.text + "'")
        connection!!.close()
    }

    @Throws(JMSException::class)
    override fun receive(subject: String): String {
        val session = getSession()

        val destination: Destination = session.createQueue(subject)

        val consumer = session.createConsumer(destination)

        println("Waiting for $subject message")
        val message = consumer.receive()

        connection!!.close()
        println("Event received $subject, $message")

        if (message is TextMessage) {
            return message.text
        }
        return "ERROR"
    }

    private fun getSession(): Session {
        val connectionFactory = ActiveMQConnectionFactory(url)
        connectionFactory.userName = user
        connectionFactory.password = pass
        connection = connectionFactory.createConnection()
        connection!!.start()
        return connection!!.createSession(false, Session.AUTO_ACKNOWLEDGE)
    }

}