package org.adrewdev.springkotlin.model

import dev.langchain4j.model.output.structured.Description


data class Story(
    @Description("Título de la historia.")
    val title: String,

    @Description("Autor de la historia.")
    val author: String,

    @Description("Sinopsis breve de la historia.")
    val summary: String,

    @Description("Época o período en que ocurre la historia.")
    val period: String,

    @Description("Lugar principal donde se desarrolla la historia.")
    val location: String,

    @Description("Temas o géneros de la historia.")
    val tags: List<String>,

    @Description("Lista de personajes con sus detalles.")
    val characters: List<Character>,

    @Description("Lista de capítulos que conforman la historia.")
    val chapters: List<Chapter>,
)
