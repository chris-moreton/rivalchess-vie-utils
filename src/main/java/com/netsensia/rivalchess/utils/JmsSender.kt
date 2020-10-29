package com.netsensia.rivalchess.utils

import com.google.gson.Gson
import org.apache.activemq.ActiveMQConnectionFactory
import javax.jms.Destination
import javax.jms.JMSException
import javax.jms.Session

interface JmsSenderInterface {
    fun send(subject: String, message: Any)
}

object JmsSender : JmsSenderInterface {
    private val url = System.getenv("ACTIVE_MQ_URL")
    private val user = System.getenv("ACTIVE_MQ_USER")
    private val pass = System.getenv("ACTIVE_MQ_PASSWORD")

    @Throws(JMSException::class)
    override fun send(subject: String, message: Any) {
        val connectionFactory = ActiveMQConnectionFactory(url)
        connectionFactory.userName = user
        connectionFactory.password = pass
        val connection = connectionFactory.createConnection()
        connection.start()

        val session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE)

        val destination: Destination = session.createQueue(subject)

        val producer = session.createProducer(destination)

        val gson = Gson()
        val sessionMessage = session.createTextMessage(gson.toJson(message))

        producer.send(sessionMessage)
        println("Event sent $subject, JCG printing@@ '" + sessionMessage.text + "'")
        connection.close()
    }
}