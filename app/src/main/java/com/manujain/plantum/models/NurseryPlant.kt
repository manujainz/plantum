package com.manujain.plantum.models

import java.net.URL
import java.util.Date

data class NurseryPlant(
    val id: Int,
    val name: String,
    val datePlanted: Date = Date(),
    val waterRequired: Boolean = true,
    val waterDaysFrequency: Int = 3,
    val imageLink: URL? = null
    )
