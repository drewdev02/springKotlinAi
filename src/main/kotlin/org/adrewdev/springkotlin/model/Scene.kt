package org.adrewdev.springkotlin.model

import dev.langchain4j.model.output.structured.Description

data class Scene(
    @Description("Título o nombre de la escena.")
    val title: String,

    @Description("Descripción detallada de la escena.")
    val description: String,

    @Description("Lugar específico donde ocurre la escena.")
    val location: String,

    @Description("Nombres de los personajes involucrados en la escena.")
    val involvedCharacters: List<String>,
)