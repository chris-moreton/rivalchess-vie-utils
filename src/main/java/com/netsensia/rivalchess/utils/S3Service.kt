package com.netsensia.rivalchess.utils

import com.amazonaws.auth.BasicAWSCredentials
import com.amazonaws.services.s3.AmazonS3Client
import com.amazonaws.services.s3.S3ClientOptions
import com.amazonaws.services.s3.model.GetObjectRequest
import java.io.File
import java.io.InputStream

val accessKey = System.getenv("AWS_ACCESS_KEY_ID")
val secretKey = System.getenv("AWS_SECRET_ACCESS_KEY")
val endpoint = System.getenv("S3_ENDPOINT")

fun getS3Client(): AmazonS3Client {
    val credentials = BasicAWSCredentials(accessKey, secretKey)

    return AmazonS3Client(credentials).apply {
        setEndpoint(endpoint).apply {
            println("S3 endpoint is $endpoint")
        }
        setS3ClientOptions(S3ClientOptions.builder().setPathStyleAccess(true).build())
    }
}

fun getFile(
        bucket: String,
        fileName: String,
        destPath: String
) {
    val s3Client = getS3Client()

    if (File(destPath).exists()) {
        println("$destPath already exists")
    } else {
        println("Getting $fileName from S3")
        val o = s3Client.getObject(GetObjectRequest(bucket, fileName))
        val objectData: InputStream = o.objectContent
        File(destPath).writeBytes(objectData.readBytes())
        objectData.close()
    }
}


