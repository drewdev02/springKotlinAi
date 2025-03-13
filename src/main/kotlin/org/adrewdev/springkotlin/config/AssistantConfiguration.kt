package org.adrewdev.springkotlin.config

import dev.langchain4j.memory.ChatMemory
import dev.langchain4j.memory.chat.MessageWindowChatMemory
import dev.langchain4j.model.chat.ChatLanguageModel
import dev.langchain4j.model.chat.request.ResponseFormat
import dev.langchain4j.model.googleai.GoogleAiGeminiChatModel
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.time.Duration


@Configuration
class AssistantConfiguration {

    @Bean
    fun model(
        @Value("\${GEMINI_AI_KEY}")
        key: String,
    ): ChatLanguageModel {
        return GoogleAiGeminiChatModel.builder()
            .apiKey(key)
            .modelName("gemini-2.0-flash")
            .temperature(1.0)
            .topP(0.95)
            .topK(64)
            .maxOutputTokens(8192)
            .timeout(Duration.ofSeconds(60))
            .responseFormat(ResponseFormat.TEXT)
            .logRequestsAndResponses(false)
            .build()
    }

    @Bean
    fun chatMemory(): ChatMemory {
        return MessageWindowChatMemory.withMaxMessages(10)
    }
}