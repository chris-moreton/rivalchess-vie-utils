package com.netsensia.rivalchess.utils.`interface`

interface JmsSenderInterface {
    fun send(subject: String, message: Any)
}