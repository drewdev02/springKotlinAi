package org.adrewdev.springkotlin

import io.github.oshai.kotlinlogging.KotlinLogging
import org.adrewdev.springkotlin.service.Assistant
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication


@SpringBootApplication
class SpringKotlinApplication(
    private val assistant: Assistant,
) : CommandLineRunner {
    val log = KotlinLogging.logger(this::class.java.name)

    override fun run(vararg args: String?) {
        log.info { "App is running" }
        runCatching {
            assistant.weatherForecast(
                """
    Morning: The day dawns bright and clear in Osaka, with crisp
    autumn air and sunny skies. Expect temperatures to hover
    around 18°C (64°F) as you head out for your morning stroll
    through Namba.
    Afternoon: The sun continues to shine as the city buzzes with
    activity. Temperatures climb to a comfortable 22°C (72°F).
    Enjoy a leisurely lunch at one of Osaka's many outdoor cafes,
    or take a boat ride on the Okawa River to soak in the beautiful
    scenery.
    Evening: As the day fades, expect clear skies and a slight chill
    in the air. Temperatures drop to 15°C (59°F). A cozy dinner at a
    traditional Izakaya will be the perfect way to end your day in
    Osaka.
    Overall: A beautiful autumn day in Osaka awaits, perfect for
    exploring the city's vibrant streets, enjoying the local cuisine,
    and soaking in the sights.
    Don't forget: Pack a light jacket for the evening and wear
    comfortable shoes for all the walking you'll be doing.
    """
            )
        }.onSuccess {
            log.info { "Weather forecast: $it" }
        }.onFailure {
            log.error(it) { "Error getting weather forecast" }
        }
        runCatching {
            assistant.weatherForecast(
                """
  Mañana: El día amanece cálido y soleado en La Habana, con una brisa suave que refresca mientras recorres el Malecón. Las temperaturas rondarán los 26 °C (79 °F), perfectas para disfrutar de un paseo matutino por las coloridas calles de La Habana Vieja, admirando su arquitectura colonial.

Tarde: El sol sigue brillando intensamente y la ciudad se llena de vida. Las temperaturas alcanzarán los 31 °C (88 °F), por lo que es un buen momento para hacer una pausa y disfrutar de un mojito o un jugo natural en alguna terraza con vista al mar. También puedes visitar la Plaza de la Catedral o dar un paseo en auto clásico por el centro.

Noche: Al caer la tarde, el calor disminuye y la brisa del mar refresca el ambiente. Las temperaturas bajan hasta los 24 °C (75 °F). Es el momento ideal para cenar en un paladar (restaurante familiar) y disfrutar de la música cubana en vivo, ya sea en un bar local o en una plaza al aire libre.

Resumen: Te espera un día tropical y vibrante en La Habana, ideal para explorar su cultura, música y gastronomía. El clima cálido y la hospitalidad cubana harán de tu visita una experiencia inolvidable.

No olvides: Lleva ropa fresca y ligera, protector solar, y agua para mantenerte hidratado durante el día. Por la noche, algo cómodo para salir a disfrutar la música y la brisa habanera.
    """
            )
        }.onSuccess {
            log.info { "Weather forecast: $it" }
        }.onFailure {
            log.error(it) { "Error getting weather forecast" }
        }

        runCatching {
            assistant.story(
                """
  Título: "El susurro de La Habana"

La Habana despertaba lentamente, como una vieja dama que se sacude los restos de un sueño profundo. Las calles, aún húmedas por la brisa marina de la madrugada, reflejaban los primeros rayos del sol que se colaban tímidamente entre los balcones coloniales.

En una esquina de La Habana Vieja, Ernesto, un joven escritor frustrado, observaba desde la ventana de su desvencijado apartamento. Había llegado a la ciudad en busca de inspiración, pero la rutina y la falta de oportunidades habían apagado su entusiasmo.

Esa mañana, algo era diferente. Mientras bebía su café, escuchó un susurro que parecía venir desde el callejón:
—"Ven al Malecón al anochecer" —decía una voz suave, casi imperceptible.

Pensando que era producto de su imaginación, Ernesto intentó ignorarlo, pero la curiosidad pudo más. Al llegar la noche, se dirigió al Malecón. El mar estaba inquieto, y las olas golpeaban con fuerza los muros que protegían la ciudad. Allí, bajo la tenue luz de una farola, encontró a una mujer de mirada profunda y vestida con ropas antiguas.

—"He esperado mucho por ti" —dijo ella—. "En estas aguas duerme una historia que aún no ha sido contada".

Intrigado, Ernesto se sentó junto a ella, y mientras las olas rompían a sus pies, comenzó a escuchar un relato olvidado de piratas, tesoros escondidos y amores imposibles que se remontaban a los días en que corsarios navegaban por el Caribe.

Aquella noche, Ernesto entendió que La Habana no era solo una ciudad, sino un cofre repleto de historias que susurran a quienes están dispuestos a escuchar. Y, por primera vez en mucho tiempo, sintió que las palabras volvían a fluir, como las olas que nunca dejan de besar las piedras del Malecón.

 """
            )
        }.onSuccess {
            log.info { "Story: $it" }
        }.onFailure {
            log.error(it) { "Error getting Story" }
        }
    }

}

fun main(args: Array<String>) {
    runApplication<SpringKotlinApplication>(*args)
}
