package org.adrewdev.springkotlin.service

import dev.langchain4j.service.SystemMessage
import dev.langchain4j.service.spring.AiService
import org.adrewdev.springkotlin.model.Story
import org.adrewdev.springkotlin.model.WeatherForecast


@AiService
interface Assistant {
    @SystemMessage("You are a polite assistant of the weather")
    fun weatherForecast(userMessage: String): WeatherForecast?

    @SystemMessage("You are a polite assistant of the story")
    fun story(message: String): Story?
}


