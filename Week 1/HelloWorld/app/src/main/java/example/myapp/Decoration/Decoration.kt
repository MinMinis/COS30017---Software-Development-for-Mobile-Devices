package example.myapp.Decoration
import java.util.*
data class Decoration (val rocks: String, val wood: String, val diver: String) {
}
fun makeDecorations() {
    val d5 = Decoration("crystal", "wood", "diver")
    println(d5)
    //println("---")
    //println(d5.diver)
    //println("---")
    val (rock, wood, diver) = d5
    println(rock)
    println(wood)
    println(diver)
    //get type of diver
    println(diver::class.simpleName)
}
