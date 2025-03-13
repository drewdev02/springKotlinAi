package org.adrewdev.springkotlin.model

import dev.langchain4j.model.output.structured.Description

data class Chapter(
    @Description("Número del capítulo.")
    val number: Int,

    @Description("Título del capítulo.")
    val title: String,

    @Description("Breve descripción de lo que sucede en el capítulo.")
    val summary: String,

    @Description("Lista de escenas dentro del capítulo.")
    val scenes: List<Scene>,
)