import java.util.Random

fun main(args: Array<String>) {
    // hello()
    // feedTheFish()
    filter()
    lambda()
}

fun lambda() {
    val dirtyLevel = 20
    val waterFilter = { dirty: Int -> dirty / 2 }
    println(waterFilter(dirtyLevel))
    val waterFilter2: (Int) -> Int = { dirty -> dirty / 2 }
    fun updateDirty(dirty: Int, operation: (Int) -> Int): Int {
        return operation(dirty)
    }
    println(updateDirty(30, waterFilter2))
}

fun filter() {
    val decorations = listOf("rock", "pagoda", "plastic plant", "alligator", "flowerpot")
    val eager = decorations.filter { it[0] == 'p' }
    println("eager: $eager")
    val filtered = decorations.asSequence().filter { it[0] == 'p' }
    println("filtered: $filtered")
    val lazyMap = decorations.asSequence().map {
        println("access: $it")
        it
    }
    println(lazyMap)
    println("---")
    println("first: ${lazyMap.first()}")
    println("---")
    println("---")
    println("last: ${lazyMap.last()}")
    println("---")
    println("all: ${lazyMap.toList()}")

}

fun hello() {
    val isUnit = println("This is an expression")
    println(isUnit)
    val temperature = 10
    val isHot = if (temperature > 50) true else false
    println(isHot)
    val message = "The water temperature is ${if (temperature > 50) "too warm" else "OK"}."
    println(message)
}

fun feedTheFish() {
    val day = randomDay()
    val food = fishFood(day)
    println("Today is $day and the fish eat $food")
}

fun randomDay(): String {
    val week = listOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
    return week[Random().nextInt(week.size)]
}

fun fishFood(day: String): String {
    val food: String
    return when (day) {
        "Monday" -> "flakes"
        "Tuesday" -> "pellets"
        "Wednesday" -> "red worms"
        "Thursday" -> "granules"
        "Friday" -> "mosquitoes"
        "Saturday" -> "lettuce"
        "Sunday" -> "plankton"
        else -> "nothing"
    }
}