package example.myapp

fun buildAquarium() {
    val aquarium= Aquarium(length = 25, width = 25, height = 40)
    aquarium.printSize()
    aquarium.volume = 70
    println("Printed Volume: ${aquarium.width * aquarium.length * aquarium.height / 1000} l")
    val myTower = TowerTank(diameter = 25, height = 40)
    myTower.printSize()
}
fun makeFish() {
    val shark = Shark()
    val pleco = Plecostomus()
    println("Shark: ${shark.color} \nPlecostomus: ${pleco.color}")
}

fun main() {
    // buildAquarium()
    makeFish()
}