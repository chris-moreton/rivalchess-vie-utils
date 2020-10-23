package com.netsensia.rivalchess.utils

fun pgnHeader(pgn: String, key: String): String {
    val match = Regex("\\[$key \"(.*?)\"]").find(pgn)
    if (match != null) {
        val (value) = match.destructured
        return value
    }
    return "HeaderNotFound"
}