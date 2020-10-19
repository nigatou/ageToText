import kotlin.math.roundToInt

fun main() {
    agoToText("Andrei Nikiforov", 31.0)
    agoToText("Andrei Nikiforov", 34.0)
    agoToText("Andrei Nikiforov", 306.0)
    agoToText("Andrei Nikiforov", 350.0)
    agoToText("Andrei Nikiforov", 3040.0)
    agoToText("Andrei Nikiforov", 3500.0)
    agoToText("Andrei Nikiforov", 30000.0)
    agoToText("Andrei Nikiforov", 30670.0)
    agoToText("Andrei Nikiforov", 304500.0)
    agoToText("Andrei Nikiforov", 300089.0)
    agoToText("Andrei Nikiforov", 3000077.0)
    agoToText("Andrei Nikiforov", 3456000.0)
    agoToText("Andrei Nikiforov", 30007340.0)
    agoToText("Andrei Nikiforov", 30035500.0)
}

fun agoToText(name: String, seconds: Double) {
    println("$name " + when (seconds) {
        in 0.0..59.0 -> {
            rightNow()
        }
        in 60.0..(60.0 * 60) -> {
            minutes(seconds)
        }
        in (60.0 * 60 + 1.0)..(24.0 * 60 * 60) -> {
            hours(seconds)
        }
        in (24.0 * 60 * 60 + 1)..(2.0 * 24 * 60 * 60) -> {
            today()
        }
        in (2.0 * 24 * 60 * 60 + 1)..(3.0 * 24 * 60 * 60) -> {
            yesterday()
        }
        else -> {
            longTimeAgo()
        }
    })
}

fun rightNow(): String {
    return "был(а) только что"
}

fun minutes(seconds: Double): String {
    val minutes = (seconds / 60).roundToInt()
    val phrase = if (minutes == 1 || (minutes > 20 && (minutes - 1) % 10 == 0)) {
        "минуту"
    } else if (minutes in 2..4 || (minutes > 20 && ((minutes - 2) % 10 == 0 || (minutes - 3) % 10 == 0 || (minutes - 4) % 10 == 0))) {
        "минуты"
    } else {
        "минут"
    }
    return "был(а) $minutes $phrase назад"
}

fun hours(seconds: Double): String {
    val hours = (seconds / (60 * 60)).roundToInt()
    val phrase = if (hours == 1 || (hours > 20 && (hours - 1) % 10 == 0)) {
        "час"
    } else if (hours in 2..4 || (hours > 20 && ((hours - 2) % 10 == 0 || (hours - 3) % 10 == 0 || (hours - 4) % 10 == 0))) {
        "часа"
    } else {
        "часов"
    }
    return "был(а) $hours $phrase назад"
}

fun today(): String {
    return "был(а) сегодня"
}

fun yesterday(): String {
    return "был(а) вчера"
}

fun longTimeAgo(): String {
    return "был(а) давно"
}
