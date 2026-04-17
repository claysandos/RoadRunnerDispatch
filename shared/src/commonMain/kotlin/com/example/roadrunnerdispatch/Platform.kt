package com.example.roadrunnerdispatch

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform