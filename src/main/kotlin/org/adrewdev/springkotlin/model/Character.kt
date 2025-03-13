package org.adrewdev.springkotlin.model

import dev.langchain4j.model.output.structured.Description

data class Character(
    @Description("Nombre del personaje.")
    val name: String,

    @Description("Rol dentro de la historia (ej. Protagonista, antagonista).")
    val role: String,

    @Description("Breve descripción del personaje.")
    val description: String,

    @Description("Edad del personaje (puede ser nulo si es desconocida).")
    val age: Int?,

    @Description("Lista de características o rasgos del personaje.")
    val traits: List<String>,
)