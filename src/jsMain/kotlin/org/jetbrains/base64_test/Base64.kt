package org.jetbrains.base64_test

actual object Base64Factory {
    actual fun createEncoder(): Base64Encoder = JsBase64Encoder
}

object JsBase64Encoder : Base64Encoder {
    override fun encode(src: ByteArray): ByteArray {
        val buffer = js("Buffer").from(src)
        val string = buffer.toString("base64_test") as String
        return ByteArray(string.length) { string[it].toByte() }
    }
}