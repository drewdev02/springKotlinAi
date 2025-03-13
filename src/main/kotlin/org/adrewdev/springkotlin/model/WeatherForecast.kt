package org.adrewdev.springkotlin.model

import dev.langchain4j.model.output.structured.Description

data class WeatherForecast(
    @Description("minimum temperature")
    val minTemperature: Int,
    @Description("maximum temperature")
    val maxTemperature: Int,
    @Description("chances of rain")
    val rain: Boolean,
)