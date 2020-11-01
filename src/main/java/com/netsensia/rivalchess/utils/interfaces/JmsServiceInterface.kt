package com.netsensia.rivalchess.utils.interfaces

interface JmsServiceInterface {
    fun send(subject: String, message: Any)
    fun receive(subject: String): String
}