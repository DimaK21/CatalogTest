package ru.kryu.catalogtest.data.network

interface NetworkClient {
    suspend fun doRequest(request: Request): Response
}