package com.jcs.creditApp.exception

data class BusinessException(override val message: String?) : RuntimeException(message)