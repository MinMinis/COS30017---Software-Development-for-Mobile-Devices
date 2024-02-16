package example.myapp

abstract class AquariumFish : FishAction {
    abstract val color: String
    var fishSize: Int = 0
    override fun eat() = println("yum")
    fun printFish() {
        println("The fish is $color and the size is $fishSize")
    }
}
class Shark : AquariumFish(), FishAction {
    override val color = "gray"
    override fun eat() {
        println("hunt and eat fish")
    }
}
class Plecostomus : AquariumFish(), FishAction {
    override val color = "gold"
    override fun eat() {
        println("munch on algae")
    }
}
interface FishAction {
    fun eat()
}