package com.hadi.superherolexicon.utils

fun Int?.getStat(): Float {
    return try {
        this?.toFloat() ?: 0f
    } catch (e: Exception) {
        0f
    }
}
