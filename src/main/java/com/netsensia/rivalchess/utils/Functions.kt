package com.netsensia.rivalchess.utils

fun pgnHeader(pgn: String, key: String): String {
    val match = Regex("\\[$key \"(.*?)\"]").find(pgn)!!
    val (value) = match.destructured
    return value
}