package com.hadi.superherolexicon.utils

import kotlinx.serialization.json.Json

object Utils {
    val format = Json {
        ignoreUnknownKeys = true
        prettyPrint = true
        isLenient = true
    }
}