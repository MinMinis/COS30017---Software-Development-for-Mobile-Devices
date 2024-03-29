# COS30017---Software-Development-for-Mobile-Devices

# Table of contents

- [COS30017---Software-Development-for-Mobile-Devices](#cos30017---software-development-for-mobile-devices)
- [Table of contents](#table-of-contents)
  - [Week 1](#week-1)
    - [Numeric Operations](#numeric-operations)
    - [Practice using types](#practice-using-types)
    - [String](#string)
    - [Compare Conditions and booleans](#compare-conditions-and-booleans)
    - [Nullability](#nullability)
    - [Lists](#lists)
    - [Arrays](#arrays)
    - [Loops](#loops)
    - [Summary Week 1](#summary-week-1)
  - [Week 2](#week-2)
    - [Function](#function)
    - [Filters](#filters)
    - [Lambda function](#lambda-function)
    - [OOP concepts](#oop-concepts)
      - [Class](#class)
        - [Inheritance and Subclass](#inheritance-and-subclass)
        - [Abstract and Interface](#abstract-and-interface)
          - [Interface Delegation](#interface-delegation)
      - [Data class](#data-class)
      - [Singleton](#singleton)
      - [Enum](#enum)
      - [Sealed Class](#sealed-class)
    - [Summary](#summary)

## Week 1

### Numeric Operations

As with other languages, Kotlin uses +, -, \* and / for plus, minus, times and division. Kotlin also supports different number types, such as Int, Long, Double, and Float.

```kotlin
1+1
⇒ res8: kotlin.Int = 2

53-3
⇒ res9: kotlin.Int = 50

50/10
⇒ res10: kotlin.Int = 5

1.0/2.0
⇒ res11: kotlin.Double = 0.5

2.0*3.5
⇒ res12: kotlin.Double = 7.0
```

Try some expressions with different combinations of integer and decimal numbers.

```kotlin
6*50
⇒ res13: kotlin.Int = 300

6.0*50.0
⇒ res14: kotlin.Double = 300.0

6.0*50
⇒ res15: kotlin.Double = 300.0
```

Kotlin keeps numbers as primitives, but it lets you call methods on numbers as if they were objects.

```kotlin
2.times(3)
⇒ res5: kotlin.Int = 6

3.5.plus(4)
⇒ res8: kotlin.Double = 7.5

2.4.div(2)
⇒ res9: kotlin.Double = 1.2
```

### Practice using types

To see some of the casts that are possible, define a variable of type Int in the REPL.

```kotlin
val i: Int = 6
```

Create a new variable, then enter the variable name shown above, followed by .to.

```kotlin
val b1 = i.to
```

To make long numeric constants more readable, Kotlin allows you to place underscores in the numbers, where it makes sense to you. Try entering different numeric constants.

```kotlin
val oneMillion = 1_000_000
val socialSecurityNumber = 999_99_9999L
val hexBytes = 0xFF_EC_DE_5E
val bytes = 0b11010010_01101001_10010100_10010010
```

Kotlin supports two types of variables: changeable and unchangeable. With val, you can assign a value once. If you try to assign something again, you get an error. With var, you can assign a value, then change the value later in the program.

Define variables using val and var and then assign new values to them.

```kotlin
var fish = 1
fish = 2
val aquarium = 1
aquarium = 2

⇒ error: val cannot be reassigned
```

Define some variables and specify the type explicitly.

```kotlin
var fish: Int = 12
var lakes: Double = 2.5
```

Once a type has been assigned by you or the compiler, you can't change the type, or you get an error.

### String

Strings in Kotlin work pretty much like strings in any other programming language using " for strings and ' for single characters, and you can concatenate strings with the + operator. You can create string templates by combining them with values; the $variable name is replaced with the text representing the value. This is called variable interpolation.

```kotlin
val numberOfFish = 5
val numberOfPlants = 12
"I have $numberOfFish fish" + " and $numberOfPlants plants"

⇒ res20: kotlin.String = I have 5 fish and 12 plants
```

Create a string template with an expression in it. As in other languages, the value can be the result of an expression. Use curly braces {} to define the expression.

```kotlin
"I have ${numberOfFish + numberOfPlants} fish and plants"

⇒ res21: kotlin.String = I have 17 fish and plants
```

### Compare Conditions and booleans

Like other languages, Kotlin has booleans and boolean operators such as less than, equal to, greater than, and so on (<, ==, >, !=, <=, >=).

Write an if/else statement.

```kotlin
val numberOfFish = 50
val numberOfPlants = 23
if (numberOfFish > numberOfPlants) {
    println("Good ratio!")
} else {
    println("Unhealthy ratio")
}

⇒ Good ratio!
```

Try a range in an if statement. In Kotlin, the condition you test can use ranges, too.

```kotlin
val fish = 50
if (fish in 1..100) {
    println(fish)
}

⇒ 50
```

Write an if with multiple cases. For more complicated conditions, use logical and && and logical or ||. As in other languages, you can have multiple cases by using else if.

```kotlin
if (numberOfFish == 0) {
    println("Empty tank")
} else if (numberOfFish < 40) {
    println("Got fish!")
} else {
    println("That's a lot of fish!")
}

⇒ That's a lot of fish!
```

Try out a when statement. There's a nicer way to write that series of if/else if/else statements in Kotlin, using the when statement, which is like the switch statement in other languages. Conditions in a when statement can use ranges, too.

```kotlin
when (numberOfFish) {
    0  -> println("Empty tank")
    in 1..39 -> println("Got fish!")
    else -> println("That's a lot of fish!")
}

⇒ That's a lot of fish!
```

### Nullability

Declare an Int and assign null to it.

```kotlin
var rocks: Int = null

⇒ error: null can not be a value of a non-null type Int
```

Use the question mark operator, ?, after the type to indicate that a variable can be null. Declare an Int? and assign null to it.

```kotlin
var marbles: Int? = null
```

**Note**:
When you have complex data types, such as a list:

- You can allow the elements of the list to be null.
- You can allow for the list to be null, but if it's not null its elements cannot be null.
- You can allow both the list or the elements to be null.

You can test for null with the ? operator, saving you the pain of writing many if/else statements.

```kotlin
var fishFoodTreats = 6
if (fishFoodTreats != null) {
    fishFoodTreats = fishFoodTreats.dec()
}
```

You can also chain null tests with the ?: operator. Look at this example:

```kotlin
fishFoodTreats = fishFoodTreats?.dec() ?: 0
```

It's shorthand for "if fishFoodTreats is not null, decrement and use it; otherwise use the value after the ?:, which is 0." If fishFoodTreats is null, evaluation is stopped, and the dec() method is not called.

A point about null pointers

If you really love NullPointerExceptions, Kotlin lets you keep them. The not-null assertion operator, !! (double-bang), converts any value to a non-null type and throws an exception if the value is null.

```kotlin
val len = s!!.length   // throws NullPointerException if s is null
```

### Lists

Lists are a fundamental type in Kotlin, and are similar to lists in other languages.

Declare a list using listOf and print it out. This list cannot be changed.

```kotlin
val school = listOf("mackerel", "trout", "halibut")
println(school)

⇒ [mackerel, trout, halibut]
```

Declare a list that can be changed using mutableListOf. Remove an item.

```kotlin
val myList = mutableListOf("tuna", "salmon", "shark")
myList.remove("shark")

⇒ res36: kotlin.Boolean = true
```

The remove() method returns true when it successfully removes the item passed.

**Note**: With a list defined with val, you can't change which list the variable refers to, but you can still change the contents of the list.

### Arrays

Like other languages, Kotlin has arrays. Unlike lists in Kotlin, which have mutable and immutable versions, there is no mutable version of an Array. Once you create an array, the size is fixed. You can't add or remove elements, except by copying to a new array.

The rules about using val and var are the same with arrays as with lists.

**Note**: With an array defined with val, you can't change which array the variable refers to, but you can still change the contents of the array.

Declare an array of strings using arrayOf. Use the java.util.Arrays.toString() array utility to print it out.

```kotlin
val school = arrayOf("shark", "salmon", "minnow")
println(java.util.Arrays.toString(school))

⇒ [shark, salmon, minnow]
```

An array declared with arrayOf doesn't have a type associated with the elements, so you can mix types, which is helpful. Declare an array with different types.

```kotlin
val mix = arrayOf("fish", 2)
```

You can also declare arrays with one type for all the elements. Declare an array of integers using intArrayOf(). There are corresponding builders, or instantiation functions, for arrays of other types.

```kotlin
val numbers = intArrayOf(1,2,3)
```

Note: Using an array of a primitive type such as Int or Byte avoids the overhead of boxing.

Combine two arrays with the + operator.

```kotlin
val numbers = intArrayOf(1,2,3)
val numbers3 = intArrayOf(4,5,6)
val foo2 = numbers3 + numbers
println(foo2[5])

=> 3
```

Try out different combinations of nested arrays and lists. As in other languages, you can nest arrays and lists. That is, when you put an array within an array, you have an array of arrays—not a flattened array of the contents of the two. The elements of an array can also be lists, and the elements of lists can be arrays.

```kotlin
val numbers = intArrayOf(1, 2, 3)
val oceans = listOf("Atlantic", "Pacific")
val oddList = listOf(numbers, oceans, "salmon")
println(oddList)

⇒ [I@89178b4, [Atlantic, Pacific], salmon]
```

The first element, numbers, is an Array. When you don't use the array utility to print it, Kotlin prints the address instead of the contents of the array.

One nice feature of Kotlin is that you can initialize arrays with code instead of initializing them to 0. Try this example:

```kotlin
val array = Array (5) { it * 2 }
println(java.util.Arrays.toString(array))

⇒ [0, 2, 4, 6, 8]
```

### Loops

Now that you have lists and arrays, looping through the elements works as you might expect.

Create an array. Use a for loop to iterate through the array and print the elements.

```kotlin
val school = arrayOf("shark", "salmon", "minnow")
for (element in school) {
    print(element + " ")
}

⇒ shark salmon minnow
```

In Kotlin, you can loop through the elements and the indexes at the same time. Try this example:

```kotlin
for ((index, element) in school.withIndex()) {
    println("Item at $index is $element\n")
}

⇒ Item at 0 is shark
Item at 1 is salmon
Item at 2 is minnow
```

Try different step sizes and ranges. You can specify ranges of numbers or of characters, alphabetically. And as in other languages, you don't have to step forward by 1. You can step backward using downTo.

```kotlin
for (i in 1..5) print(i)
⇒ 12345

for (i in 5 downTo 1) print(i)
⇒ 54321

for (i in 3..6 step 2) print(i)
⇒ 35

for (i in 'd'..'g') print (i)
⇒ defg
```

Try out some loops. Like other languages, Kotlin has while loops, do...while loops, and ++ and -- operators. Kotlin also has repeat loops.

```kotlin
var bubbles = 0
while (bubbles < 50) {
    bubbles++
}
println("$bubbles bubbles in the water\n")

do {
    bubbles--
} while (bubbles > 50)
println("$bubbles bubbles in the water\n")

repeat(2) {
    println("A fish is swimming")
}

⇒ 50 bubbles in the water
49 bubbles in the water
A fish is swimming
A fish is swimming
```

### Summary Week 1

The following features may be different in Kotlin than what you're used to in other languages:

- Kotlin types can't be implicitly converted—use casting.
- Variables declared with val can only be assigned once.
- Kotlin variables are not nullable by default. Use ? to make variables nullable.
- With Kotlin, you can loop through the index and elements of an array at the same time in a for loop.
  <break />
  The following Kotlin programming constructs are similar to those in other languages:

- Arrays and lists can have a single type or mixed types.
- Arrays and lists can be nested.
- You can create loops with for, while, do/while, and repeat.
- The when statement is Kotlin's version of the switch statement, but when is more flexible.

## Week 2

### Function

1.  "fun" keyword designates a function, followed by the name. As with other programming languages, the parentheses are for function arguments, if any, and the curly braces frame the code for the function. There is no return type because the function doesn't return anything. Also note that there are no semicolons at the ends of lines

```kotlin
fun printHello() {
    println("Hello World")
}
printHello()
```

write code in main() to assign a println() to a variable called isUnit and print it. (println() does not return a value, so it returns kotlin.Unit.)

```kotlin
// Will assign kotlin.Unit
val isUnit = println("This is an expression")
println(isUnit)
```

Run your program. The first println() prints the string "This is an expression". The second println() prints the value of the first println() statement, that is, kotlin.Unit.

```kotlin
⇒ This is an expression
kotlin.Unit
```

Declare a val called temperature and initialize it to 10.
Declare another val called isHot and assign the return value of an if/else statement to isHot, as shown in the following code. Because it is an expression, you can use the value of the if expression right away.

```kotlin
val temperature = 10
val isHot = if (temperature > 50) true else false
println(isHot)

⇒ false
```

Use the value of an expression in a string template. Add some code to check the temperature to determine whether a fish is safe or too warm, then run your program.

```kotlin
val temperature = 10
val message = "The water temperature is ${ if (temperature > 50) "too warm" else "OK" }."
println(message)

⇒ The water temperature is OK.
```

2.

Write a function called feedTheFish() that calls randomDay() to get a random day of the week. Use a string template to print a food for the fish to eat that day. For now, the fish eat the same food every day.

```kotlin
fun feedTheFish() {
    val day = randomDay()
    val food = "pellets"
    println ("Today is $day and the fish eat $food")
}

fun main(args: Array<String>) {
    feedTheFish()
}
```

Write the randomDay() function to pick a random day from an array and return it.
The nextInt() function takes an integer limit, which limits the number from Random() to 0 through 6 to match the week array.

```kotlin
fun randomDay() : String {
    val week = arrayOf ("Monday", "Tuesday", "Wednesday", "Thursday",
            "Friday", "Saturday", "Sunday")
    return week[Random().nextInt(week.size)]
}
```

The Random() and nextInt() functions are defined in java.util.\*. At the top of the file, add the needed import:

```kotlin
import java.util.\* // required import
```

Output:

```kotlin
⇒ Today is Tuesday and the fish eat pellets
```

add a function called fishFood() that takes a day as a String and returns the fish's food for the day as a String. Use when(), so that each day the fish gets a specific food. Run your program a few times to see different outputs.

```kotlin
fun fishFood (day : String) : String {
var food = ""
when (day) {
"Monday" -> food = "flakes"
"Tuesday" -> food = "pellets"
"Wednesday" -> food = "redworms"
"Thursday" -> food = "granules"
"Friday" -> food = "mosquitoes"
"Saturday" -> food = "lettuce"
"Sunday" -> food = "plankton"
}
return food
}

fun feedTheFish() {
val day = randomDay()
val food = fishFood(day)

    println ("Today is $day and the fish eat $food")

}
```

Output:

```kotlin
⇒ Today is Thursday and the fish eat granules
```

Add a default branch to the when expression using else. For testing, to make sure the default is taken sometimes in your program, remove the Tuesday and Saturday branches.
Having a default branch ensures that food gets a value before being returned, so it doesn't need to be initialized anymore. Because the code now assigns a string to food only once, you can declare food with val instead of var.

```kotlin
fun fishFood (day : String) : String {
    val food : String
    when (day) {
        "Monday" -> food = "flakes"
        "Wednesday" -> food = "redworms"
        "Thursday" -> food = "granules"
        "Friday" -> food = "mosquitoes"
        "Sunday" -> food = "plankton"
        else -> food = "nothing"
    }
    return food
}
```

Because every expression has a value, you can make this code a little more concise. Return the value of the when expression directly, and eliminate the food variable. The value of the when expression is the value of the last expression of the branch that satisfied the condition.

```kotlin
fun fishFood (day : String) : String {
    return when (day) {
        "Monday" -> "flakes"
        "Wednesday" -> "redworms"
        "Thursday" -> "granules"
        "Friday" -> "mosquitoes"
        "Sunday" -> "plankton"
        else -> "nothing"
    }
}
```

The final version of your program looks something like the code below.

import java.util.\* // required import

```kotlin
fun randomDay() : String {
val week = arrayOf ("Monday", "Tuesday", "Wednesday", "Thursday",
"Friday", "Saturday", "Sunday")
return week[Random().nextInt(week.size)]
}

fun fishFood (day : String) : String {
return when (day) {
"Monday" -> "flakes"
"Wednesday" -> "redworms"
"Thursday" -> "granules"
"Friday" -> "mosquitoes"
"Sunday" -> "plankton"
else -> "nothing"
}
}

fun feedTheFish() {
val day = randomDay()
val food = fishFood(day)
println ("Today is $day and the fish eat $food")
}

fun main(args: Array<String>) {
feedTheFish()
}
```

write a swim() function with a String parameter named speed that prints the fish's speed. The speed parameter has a default value of "fast".

```kotlin
fun swim(speed: String = "fast") {
   println("swimming $speed")
}
```

From the main() function, call the swim() function three ways. First call the function using the default. Then call the function and pass the speed parameter without a name, then call the function by naming the speed parameter.

```kotlin
swim()   // uses default speed
swim("slow")   // positional argument
swim(speed="turtle-like")   // named parameter

⇒ swimming fast
swimming slow
swimming turtle-like
```

write a shouldChangeWater() function that takes three parameters: day, temperature, and a dirty level. The function returns true if the water should be changed, which happens if it's Sunday, if the temperature is too high, or if the water is too dirty. The day of the week is required, but the default temperature is 22, and the default dirty level is 20.
Use a when expression without an argument, which in Kotlin acts as a series of if/else if checks.

```kotlin
fun shouldChangeWater (day: String, temperature: Int = 22, dirty: Int = 20): Boolean {
return when {
temperature > 30 -> true
dirty > 30 -> true
day == "Sunday" -> true
else -> false
}
}
```

Call shouldChangeWater() from feedTheFish() and supply the day. The day parameter doesn't have a default, so you must specify an argument. The other two parameters of shouldChangeWater() have default values, so you don't have to pass arguments for them.

```kotlin
fun feedTheFish() {
    val day = randomDay()
    val food = fishFood(day)
    println ("Today is $day and the fish eat $food")
    println("Change water: ${shouldChangeWater(day)}")
}

=> Today is Thursday and the fish eat granules
Change water: false
```

Compact functions, or single-expression functions, are a common pattern in Kotlin. When a function returns the results of a single expression, you can specify the body of the function after an = symbol, omit the curly braces {}, and omit the return.

in Hello.kt, add compact functions to test the conditions.

```kotlin
fun isTooHot(temperature: Int) = temperature > 30

fun isDirty(dirty: Int) = dirty > 30

fun isSunday(day: String) = day == "Sunday"
Change shouldChangeWater() to call the new functions.

fun shouldChangeWater (day: String, temperature: Int = 22, dirty: Int = 20): Boolean {
return when {
isTooHot(temperature) -> true
isDirty(dirty) -> true
isSunday(day) -> true
else -> false
}
}
```

he default value for a parameter doesn't have to be a value. It can be another function, as shown in the following partial sample:

```kotlin
fun shouldChangeWater (day: String, temperature: Int = 22, dirty: Int = getDirtySensorReading()): Boolean {
    ...
}
```

### Filters

define a list of aquarium decorations at the top level with listOf(). You can replace the contents of Hello.kt.

```kotlin
val decorations = listOf ("rock", "pagoda", "plastic plant", "alligator", "flowerpot")
```

Create a new main() function with a line to print only the decorations that start with the letter ‘p'. The code for the filter condition is in curly braces {}, and it refers to each item as the filter loops through. If the expression returns true, the item is included.

```kotlin
fun main() {
println( decorations.filter {it[0] == 'p'})
}

⇒ [pagoda, plastic plant]
```

If you're familiar with filters in other languages, you may wonder whether filters in Kotlin are eager or lazy. Is the result list created immediately, or when the list is accessed? In Kotlin, it happens whichever way you need it to. By default, filter is eager, and each time you use the filter, a list is created.

To make the filter lazy, you can use a Sequence, which is a collection that can only look at one item at a time, starting at the beginning, and going to the end. Conveniently, this is exactly the API that a lazy filter needs.

change your code to assign the filtered list to a variable called eager, then print it.

```kotlin
fun main() {
    val decorations = listOf ("rock", "pagoda", "plastic plant", "alligator", "flowerpot")

    // eager, creates a new list
    val eager = decorations.filter { it [0] == 'p' }
    println("eager: $eager")
}
```

Below that code, evaluate the filter using a Sequence with asSequence(). Assign the sequence to a variable called filtered, and print it.

```kotlin
   // lazy, will wait until asked to evaluate
    val filtered = decorations.asSequence().filter { it[0] == 'p' }
    println("filtered: $filtered")
```

When you return the filter results as a Sequence, the filtered variable won't hold a new list—it'll hold a Sequence of the list elements and knowledge of the filter to apply to those elements. Whenever you access elements of the Sequence, the filter is applied, and the result is returned to you.

Force evaluation of the sequence by converting it to a List with toList(). Print the result.

```kotlin
    // force evaluation of the lazy list
    val newList = filtered.toList()
    println("new list: $newList")

Output:

⇒ eager: [pagoda, plastic plant]
// filtered: kotlin.sequences.FilteringSequence@386cc1c4
new list: [pagoda, plastic plant]
```

With the same decorations list as above, make a transformation with map() that does nothing, and simply returns the element that was passed. Add a println() to show each time an element is accessed, and assign the sequence to a variable called lazyMap.

```kotlin
    val lazyMap = decorations.asSequence().map {
        println("access: $it")
        it
    }
```

Print lazyMap, print the first element of lazyMap using first(), and print lazyMap converted to a List.

```kotlin
    println("lazy: $lazyMap")
    println("-----")
    println("first: ${lazyMap.first()}")
    println("-----")
    println("all: ${lazyMap.toList()}")
```

Output:

```kotlin
⇒ lazy: kotlin.sequences.TransformingSequence@5ba23b66
-----
access: rock
first: rock
-----
access: rock
access: pagoda
access: plastic plant
access: alligator
access: flowerpot
all: [rock, pagoda, plastic plant, alligator, flowerpot]

```

Create a new Sequence using the original filter before applying map. Print that result.

```kotlin
    val lazyMap2 = decorations.asSequence().filter {it[0] == 'p'}.map {
        println("access: $it")
        it
    }
    println("-----")
    println("filtered: ${lazyMap2.toList()}")
```

Run your program and observe the additional output. As with getting the first element, the inner println() is only called for the elements that are accessed.

```kotlin
⇒
-----
access: pagoda
access: plastic plant
filtered: [pagoda, plastic plant]
```

### Lambda function

Like named functions, lambdas can have parameters. For lambdas, the parameters (and their types, if needed) go on the left of what is called a function arrow ->. The code to execute goes to the right of the function arrow. Once the lambda is assigned to a variable, you can call it just like a function.

```kotlin
var dirtyLevel = 20
val waterFilter = { dirty : Int -> dirty / 2}
println(waterFilter(dirtyLevel))

⇒ 10
```

In this example, the lambda takes an Int named dirty, and returns dirty / 2. (Because filtering removes dirt.)

Kotlin's syntax for function types is closely related to its syntax for lambdas. Use this syntax to cleanly declare a variable that holds a function:

```kotlin
val waterFilter: (Int) -> Int = { dirty -> dirty / 2 }
```

Here's what the code says:

- Make a variable called waterFilter.
- waterFilter can be any function that takes an Int and returns an Int.
- Assign a lambda to waterFilter.
- The lambda returns the value of the argument dirty divided by 2.

Write a higher-order function. Here's a basic example, a function that takes two arguments. The first argument is an integer. The second argument is a function that takes an integer and returns an integer. Try it out in the REPL.

```kotlin
fun updateDirty(dirty: Int, operation: (Int) -> Int): Int {
   return operation(dirty)
}
```

The body of the code calls the function that was passed as the second argument, and passes the first argument along to it.

To call this function, pass it an integer and a function.

```kotlin
val waterFilter: (Int) -> Int = { dirty -> dirty / 2 }
println(updateDirty(30, waterFilter))

⇒ 15
```

The function you pass doesn't have to be a lambda; it can be a regular named function instead. To specify the argument as a regular function, use the :: operator. This way Kotlin knows that you are passing the function reference as an argument, not trying to call the function.

Try passing a regular named function to updateDirty().

```kotlin
fun increaseDirty( start: Int ) = start + 1

println(updateDirty(15, ::increaseDirty))

⇒ 16
```

### OOP concepts

The following programming terms should already be familiar to you:

- Classes are blueprints for objects. For example, an Aquarium class is the blueprint for making an aquarium object.
- Objects are instances of classes; an aquarium object is one actual Aquarium.
- Properties are characteristics of classes, such as the length, width, and height of an Aquarium.
- Methods, also called member functions, are the functionality of the class. Methods are what you can "do" with the object. For example, you can fillWithWater() an Aquarium object.
- An interface is a specification that a class can implement. For example, cleaning is common to objects other than aquariums, and cleaning generally happens in similar ways for different objects. So you could have an interface called Clean that defines a clean() method. The Aquarium class could implement the Clean interface to clean the aquarium with a soft sponge.
- Packages are a way to group related code to keep it organized, or to make a library of code. Once a package is created, you can import the package's contents into another file and reuse the code and classes in it.

#### Class

Classes are defined with the keyword class, and class names by convention start with a capital letter.

Inside the Aquarium class, define and initialize var properties for the width, height, and length (in centimeters). Initialize the properties with default values.

```kotlin
package example.myapp

class Aquarium {
    var width: Int = 20
    var height: Int = 40
    var length: Int = 100
}
```

**Note**: If you declared these properties with val instead of var, the properties would be immutable. You could only set them once, and all the instances of Aquarium would have the same dimensions.

Define a buildAquarium() function and inside create an instance of Aquarium. To create an instance, reference the class as if it were a function, Aquarium(). This calls the constructor of the class and creates an instance of the Aquarium class, similar to using new in other languages.
Define a main() function and call buildAquarium().

```kotlin
package example.myapp

fun buildAquarium() {
    val myAquarium = Aquarium()
}

fun main() {
    buildAquarium()
}
```

In the Aquarium class, add a method to print the aquarium's dimension properties.

```kotlin
    fun printSize() {
        println("Width: $width cm " +
                "Length: $length cm " +
                "Height: $height cm ")
    }
```

In main.kt, in buildAquarium(), call the printSize() method on myAquarium.

```kotlin
fun buildAquarium() {
    val myAquarium = Aquarium()
    myAquarium.printSize()
}

```

Output:

```kotlin
⇒ Width: 20 cm Length: 100 cm Height: 40 cm
```

In buildAquarium(), add code to set the height to 60 and print the changed dimension properties.

```kotlin
fun buildAquarium() {
val myAquarium = Aquarium()
myAquarium.printSize()
myAquarium.height = 60
myAquarium.printSize()
}
```

Output:

```kotlin
⇒ Width: 20 cm Length: 100 cm Height: 40 cm
Width: 20 cm Length: 100 cm Height: 60 cm
```

In this step, you add a constructor to the Aquarium class you created in the first task. In the earlier example, every instance of Aquarium is created with the same dimensions. You can change the dimensions once it is created by setting the properties, but it would be simpler to create it the correct size to begin with.

In some programming languages, the constructor is defined by creating a method within the class that has the same name as the class. In Kotlin, you define the constructor directly in the class declaration itself, specifying the parameters inside parentheses as if the class was a method. As with functions in Kotlin, those parameters can include default values.

In the Aquarium class you created earlier, change the class definition to include three constructor parameters with default values for length, width and height, and assign them to the corresponding properties.

```kotlin
class Aquarium(length: Int = 100, width: Int = 20, height: Int = 40) {
   // Dimensions in cm
   var length: Int = length
   var width: Int = width
   var height: Int = height
...
}
```

When you create an Aquarium object with that constructor, you can specify no arguments and get the default values, or specify just some of them, or specify all of them and create a completely custom-sized Aquarium. In the buildAquarium() function, try out different ways of creating an Aquarium object using named parameters.

```kotlin
fun buildAquarium() {
    val aquarium1 = Aquarium()
    aquarium1.printSize()
    // default height and length
    val aquarium2 = Aquarium(width = 25)
    aquarium2.printSize()
    // default width
    val aquarium3 = Aquarium(height = 35, length = 110)
    aquarium3.printSize()
    // everything custom
    val aquarium4 = Aquarium(width = 25, height = 35, length = 110)
    aquarium4.printSize()
}
```

Run the program and observe the output.

```kotlin
⇒ Width: 20 cm Length: 100 cm Height: 40 cm
Width: 25 cm Length: 100 cm Height: 40 cm
Width: 20 cm Length: 110 cm Height: 35 cm
Width: 25 cm Length: 110 cm Height: 35 cm
```

The example constructors above just declare properties and assign the value of an expression to them. If your constructor needs more initialization code, it can be placed in one or more init blocks. In this step, you add some init blocks to Aquarium class.

In the Aquarium class, add an init block to print that the object is initializing, and a second block to print the volume in liters.

```kotlin
class Aquarium (var length: Int = 100, var width: Int = 20, var height: Int = 40) {
    init {
        println("aquarium initializing")
    }
    init {
        // 1 liter = 1000 cm^3
        println("Volume: ${width * length * height / 1000} l")
    }
}
```

Output:

```kotlin
aquarium initializing
Volume: 80 l
Width: 20 cm Length: 100 cm Height: 40 cm
aquarium initializing
Volume: 100 l
Width: 25 cm Length: 100 cm Height: 40 cm
aquarium initializing
Volume: 77 l
Width: 20 cm Length: 110 cm Height: 35 cm
aquarium initializing
Volume: 96 l
Width: 25 cm Length: 110 cm Height: 35 cm
```

Notice that the init blocks are executed in the order in which they appear in the class definition, and all of them are executed when the constructor is called.

**Note**: Parameters of the primary constructor can be used in the initializer blocks. Any properties used in initializer blocks must be declared previously.

In this step, you learn about secondary constructors and add one to your class. In addition to a primary constructor, which can have one or more init blocks, a Kotlin class can also have one or more secondary constructors to allow constructor overloading, that is, constructors with different arguments.

In the Aquarium class, add a secondary constructor that takes a number of fish as its argument, using the constructor keyword. Create a val tank property for the calculated volume of the aquarium in liters based on the number of fish. Assume 2 liters (2,000 cm^3) of water per fish, plus a little extra room so the water doesn't spill.

```kotlin
constructor(numberOfFish: Int) : this() {
    // 2,000 cm^3 per fish + extra room so water doesn't spill
    val tank = numberOfFish * 2000 * 1.1
}
```

Inside the secondary constructor, keep the length and width (which were set in the primary constructor) the same, and calculate the height needed to make the tank the given volume.

```kotlin
    // calculate the height needed
    height = (tank / (length * width)).toInt()
```

In the buildAquarium() function, add a call to create an Aquarium using your new secondary constructor. Print the size and volume.

```kotlin
fun buildAquarium() {
    val aquarium6 = Aquarium(numberOfFish = 29)
    aquarium6.printSize()
    println("Volume: ${aquarium6.width * aquarium6.length * aquarium6.height / 1000} l")
}
```

Run your program and observe the output.

```kotlin
⇒ aquarium initializing
Volume: 80 l
Width: 20 cm Length: 100 cm Height: 31 cm
Volume: 62 l
```

Notice that the volume is printed twice, once by the init block in the primary constructor before the secondary constructor is executed, and once by the code in buildAquarium().

You could have included the constructor keyword in the primary constructor, too, but it's not necessary in most cases.

In this step, you add an explicit property getter. Kotlin automatically defines getters and setters when you define properties, but sometimes the value for a property needs to be adjusted or calculated. For example, above, you printed the volume of the Aquarium. You can make the volume available as a property by defining a variable and a getter for it. Because volume needs to be calculated, the getter needs to return the calculated value, which you can do with a one-line function.

In the Aquarium class, define an Int property called volume, and define a get() method that calculates the volume in the next line.

```kotlin
val volume: Int
    get() = width * height * length / 1000  // 1000 cm^3 = 1 l
```

Remove the init block that prints the volume.
Remove the code in buildAquarium() that prints the volume.
In the printSize() method, add a line to print the volume.

```kotlin
fun printSize() {
    println("Width: $width cm " +
            "Length: $length cm " +
            "Height: $height cm "
    )
    // 1 l = 1000 cm^3
    println("Volume: $volume l")
}
```

Run your program and observe the output.

```kotlin
⇒ aquarium initializing
Width: 20 cm Length: 100 cm Height: 31 cm
Volume: 62 l
```

In this step, you create a new property setter for the volume.

In the Aquarium class, change volume to a var so it can be set more than once.
Add a setter for the volume property by adding a set() method below the getter, which recalculates the height based on the supplied amount of water. By convention, the name of the setter parameter is value, but you can change it if you prefer.

```kotlin
var volume: Int
get() = width _ height _ length / 1000
set(value) {
height = (value _ 1000) / (width _ length)
}
```

In buildAquarium(), add code to set the volume of the Aquarium to 70 liters. Print the new size.

```kotlin
fun buildAquarium() {
val aquarium6 = Aquarium(numberOfFish = 29)
aquarium6.printSize()
aquarium6.volume = 70
aquarium6.printSize()
}
```

Run your program again and observe the changed height and volume.

```kotlin
⇒ aquarium initialized
Width: 20 cm Length: 100 cm Height: 31 cm
Volume: 62 l
Width: 20 cm Length: 100 cm Height: 35 cm
Volume: 70 l
```

There have been no visibility modifiers, such as public or private, in the code so far. That's because by default, everything in Kotlin is public, which means that everything can be accessed everywhere, including classes, methods, properties, and member variables.

In Kotlin, classes, objects, interfaces, constructors, functions, properties, and their setters can have visibility modifiers:

- _public_ means visible outside the class. Everything is public by default, including variables and methods of the class.
- _internal_ means it will only be visible within that module. A module is a set of Kotlin files compiled together, for example, a library or application.
- _private_ means it will only be visible in that class (or source file if you are working with functions).
- _protected_ is the same as private, but it will also be visible to any subclasses.

Properties within a class, or member variables, are public by default. If you define them with var, they are mutable, that is, readable and writable. If you define them with val, they are read-only after initialization.

If you want a property that your code can read or write, but outside code can only read, you can leave the property and its getter as public and declare the setter private, as shown below.

```kotlin
var volume: Int
    get() = width * height * length / 1000
    private set(value) {
        height = (value * 1000) / (width * length)
    }
```

##### Inheritance and Subclass

In Kotlin, by default, classes cannot be subclassed. Similarly, properties and member variables cannot be overridden by subclasses (though they can be accessed).

You must mark a class as open to allow it to be subclassed. Similarly, you must mark properties and member variables as open, in order to override them in the subclass. The open keyword is required, to prevent accidentally leaking implementation details as part of the class's interface.

In this step, you make the Aquarium class open, so that you can override it in the next step.

Mark the Aquarium class and all its properties with the open keyword.

```kotlin
open class Aquarium (open var length: Int = 100, open var width: Int = 20, open var height: Int = 40) {
    open var volume: Int
        get() = width * height * length / 1000
        set(value) {
            height = (value * 1000) / (width * length)
        }
```

Add an open shape property with the value "rectangle".

```kotlin
   open val shape = "rectangle"
```

Add an open water property with a getter that returns 90% of the volume of the Aquarium.

```kotlin
    open var water: Double = 0.0
        get() = volume * 0.9
```

Add code to the printSize() method to print the shape, and the amount of water as a percentage of the volume.

```kotlin
fun printSize() {
println(shape)
println("Width: $width cm " +
            "Length: $length cm " +
            "Height: $height cm ")
    // 1 l = 1000 cm^3
    println("Volume: $volume l Water: $water l (${water/volume\*100.0}% full)")
}
```

In buildAquarium(), change the code to create an Aquarium with width = 25, length = 25, and height = 40.

```kotlin
fun buildAquarium() {
val aquarium6 = Aquarium(length = 25, width = 25, height = 40)
aquarium6.printSize()
}
```

Output:

```kotlin
⇒ aquarium initializing
rectangle
Width: 25 cm Length: 25 cm Height: 40 cm
Volume: 25 l Water: 22.5 l (90.0% full)
```

Create a subclass of Aquarium called TowerTank, which implements a rounded cylinder tank instead of a rectangular tank. You can add TowerTank below Aquarium, because you can add another class in the same file as the Aquarium class.
In TowerTank, override the height property, which is defined in the constructor. To override a property, use the override keyword in the subclass.
Note: Subclasses must declare their constructor parameters explicitly.

Make the constructor for TowerTank take a diameter. Use the diameter for both length and width when calling the constructor in the Aquarium superclass.

class TowerTank (override var height: Int, var diameter: Int): Aquarium(height = height, width = diameter, length = diameter) {
Override the volume property to calculate a cylinder. The formula for a cylinder is pi times the radius squared times the height. You need to import the constant PI from java.lang.Math.

```kotlin
    override var volume: Int
    // ellipse area = π * r1 * r2
    get() = (width/2 * length/2 * height / 1000 * PI).toInt()
    set(value) {
        height = ((value * 1000 / PI) / (width/2 * length/2)).toInt()
    }
```

In TowerTank, override the water property to be 80% of the volume.

```kotlin
override var water = volume * 0.8
Override the shape to be "cylinder".
```

override val shape = "cylinder"
Your final TowerTank class should look something like the code below.
Aquarium.kt:

```kotlin
package example.myapp

import java.lang.Math.PI

... // existing Aquarium class

class TowerTank (override var height: Int, var diameter: Int): Aquarium(height = height, width = diameter, length = diameter) {
    override var volume: Int
    // ellipse area = π * r1 * r2
    get() = (width/2 * length/2 * height / 1000 * PI).toInt()
    set(value) {
        height = ((value * 1000 / PI) / (width/2 * length/2)).toInt()
    }

    override var water = volume * 0.8
    override val shape = "cylinder"
}
```

In buildAquarium(), create a TowerTank with a diameter of 25 cm and a height of 45 cm. Print the size.
main.kt:

```kotlin
package example.myapp

fun buildAquarium() {
val myAquarium = Aquarium(width = 25, length = 25, height = 40)
myAquarium.printSize()
val myTower = TowerTank(diameter = 25, height = 40)
myTower.printSize()
}
```

Run your program and observe the output.

```kotlin
⇒ aquarium initializing
rectangle
Width: 25 cm Length: 25 cm Height: 40 cm
Volume: 25 l Water: 22.5 l (90.0% full)
aquarium initializing
cylinder
Width: 25 cm Length: 25 cm Height: 40 cm
Volume: 18 l Water: 14.4 l (80.0% full)
```

##### Abstract and Interface

Sometimes you want to define common behavior or properties to be shared among some related classes. Kotlin offers two ways to do that, interfaces and abstract classes. In this task, you create an abstract AquariumFish class for properties that are common to all fish. You create an interface called FishAction to define behavior common to all fish.

- Neither an abstract class nor an interface can be instantiated on its own, which means you cannot create objects of those types directly.
- Abstract classes have constructors.
- Interfaces can't have any constructor logic or store any state.

Under example.myapp, create a new file, AquariumFish.kt.
Create a class, also called AquariumFish, and mark it with abstract.
Add one String property, color, and mark it with abstract.

```kotlin
package example.myapp

abstract class AquariumFish {
    abstract val color: String
}
```

Create two subclasses of AquariumFish, Shark and Plecostomus.
Because color is abstract, the subclasses must implement it. Make Shark gray and Plecostomus gold.

```kotlin
class Shark: AquariumFish() {
    override val color = "gray"
}

class Plecostomus: AquariumFish() {
    override val color = "gold"
}
```

In main.kt, create a makeFish() function to test your classes. Instantiate a Shark and a Plecostomus, then print the color of each.
Delete your earlier test code in main() and add a call to makeFish(). Your code should look something like the code below.
main.kt:

```kotlin
package example.myapp

fun makeFish() {
val shark = Shark()
val pleco = Plecostomus()

    println("Shark: ${shark.color}")
    println("Plecostomus: ${pleco.color}")

}

fun main () {
makeFish()
}
```

Output:

```kotlin
⇒ Shark: gray
Plecostomus: gold
```

In AquariumFish.kt, create an interface called FishAction with a method eat().

```kotlin
interface FishAction  {
    fun eat()
}
```

Add FishAction to each of the subclasses, and implement eat() by having it print what the fish does.

```kotlin
class Shark: AquariumFish(), FishAction {
    override val color = "gray"
    override fun eat() {
        println("hunt and eat fish")
    }
}

class Plecostomus: AquariumFish(), FishAction {
    override val color = "gold"
    override fun eat() {
        println("eat algae")
    }
}
```

In the makeFish()function, have each fish you created eat something by calling eat().

```kotlin
fun makeFish() {
val shark = Shark()
val pleco = Plecostomus()
println("Shark: ${shark.color}")
shark.eat()
println("Plecostomus: ${pleco.color}")
pleco.eat()
}
```

Run your program and observe the output.

```kotlin
⇒ Shark: gray
hunt and eat fish
Plecostomus: gold
eat algae
```

Use an abstract class any time you can't complete a class. For example, going back to the AquariumFish class, you can make all AquariumFish implement FishAction, and provide a default implementation for eat while leaving color abstract, because there isn't really a default color for fish.

```kotlin
interface FishAction {
fun eat()
}

abstract class AquariumFish: FishAction {
abstract val color: String
override fun eat() = println("yum")
}
```

###### Interface Delegation

In AquariumFish.kt, remove the AquariumFish class. Instead of inheriting from the AquariumFish class, Plecostomus and Shark are going to implement interfaces for both the fish action and their color.
Create a new interface, FishColor, that defines the color as a string.

```kotlin
interface FishColor {
    val color: String
}
```

Change Plecostomus to implement two interfaces, FishAction, and a FishColor. You need to override the color from FishColor and eat() from FishAction.

```kotlin
class Plecostomus: FishAction, FishColor {
override val color = "gold"
override fun eat() {
println("eat algae")
}
}
```

Change your Shark class to also implement the two interfaces, FishAction and FishColor, instead of inheriting from AquariumFish.

```kotlin
class Shark: FishAction, FishColor {
override val color = "gray"
override fun eat() {
println("hunt and eat fish")
}
}
```

Your finished code should look something like this:

```kotlin
package example.myapp

interface FishAction {
fun eat()
}

interface FishColor {
val color: String
}

class Plecostomus: FishAction, FishColor {
override val color = "gold"
override fun eat() {
println("eat algae")
}
}

class Shark: FishAction, FishColor {
override val color = "gray"
override fun eat() {
println("hunt and eat fish")
}
}
```

Next, you implement the setup for the delegation part by creating a helper class that implements FishColor. You create a basic class called GoldColor that implements FishColor—all it does is say that its color is gold.

It doesn't make sense to make multiple instances of GoldColor, because they'd all do exactly the same thing. So Kotlin lets you declare a class where you can only create one instance of it by using the keyword object instead of class. Kotlin will create that one instance, and that instance is referenced by the class name. Then all other objects can just use this one instance—there is no way to make other instances of this class. If you're familiar with the singleton pattern, this is how you implement singletons in Kotlin.

In AquariumFish.kt, create an object for GoldColor. Override the color.

```kotlin
object GoldColor : FishColor {
   override val color = "gold"
}
```

Step 3: Add interface delegation for FishColor
Now you're ready to use interface delegation.

In AquariumFish.kt, remove the override of color from Plecostomus.
Change the Plecostomus class to get its color from GoldColor. You do this by adding by GoldColor to the class declaration, creating the delegation. What this says is that instead of implementing FishColor, use the implementation provided by GoldColor. So every time color is accessed, it is delegated to GoldColor.

```kotlin
class Plecostomus: FishAction, FishColor by GoldColor {
override fun eat() {
println("eat algae")
}
}
```

With the class as is, all Plecos will be golden, but these fish actually come in many colors. You can address this by adding a constructor parameter for the color with GoldColor as the default color for Plecostomus.

Change the Plecostomus class to take a passed in fishColor with its constructor, and set its default to GoldColor. Change the delegation from by GoldColor to by fishColor.

```kotlin
class Plecostomus(fishColor: FishColor = GoldColor): FishAction,
FishColor by fishColor {
override fun eat() {
println("eat algae")
}
}
```

Step 4: Add interface delegation for FishAction
In the same way, you can use interface delegation for the FishAction.

In AquariumFish.kt make a PrintingFishAction class that implements FishAction, which takes a String, food, then prints what the fish eats.

```kotlin
class PrintingFishAction(val food: String) : FishAction {
override fun eat() {
println(food)
}
}
```

In Plecostomus class, remove the override function eat(), because you will replace it with a delegation.
In the declaration of Plecostomus, delegate FishAction to PrintingFishAction, passing "eat algae".
With all that delegation, there's no code in the body of the Plecostomus class, so remove the {}, because all the overrides are handled by interface delegation

```kotlin
class Plecostomus (fishColor: FishColor = GoldColor):
FishAction by PrintingFishAction("eat algae"),
FishColor by fishColor
```

#### Data class

A data class is similar to a struct in some other languages—it exists mainly to hold some data—but a data class object is still an object. Kotlin data class objects have some extra benefits, such as utilities for printing and copying. In this task, you create a simple data class and learn about the support Kotlin provides for data classes.

Add a new package decor under the example.myapp package to hold the new code. Right-click on example.myapp in the Project pane and select File > New > Package.
In the package, create a new class called Decoration.

```kotlin
package example.myapp.decor

class Decoration {
}
```

To make Decoration a data class, prefix the class declaration with the keyword data.
Add a String property called rocks to give the class some data.

```kotlin
data class Decoration(val rocks: String) {
}
```

In the file, outside the class, add a makeDecorations() function to create and print an instance of a Decoration with "granite".

```kotlin
fun makeDecorations() {
val decoration1 = Decoration("granite")
println(decoration1)
}
```

Add a main() function to call makeDecorations(), and run your program. Notice the sensible output that is created because this is a data class.

```kotlin
⇒ Decoration(rocks=granite)
In makeDecorations(), instantiate two more Decoration objects that are both "slate" and print them.

fun makeDecorations() {
val decoration1 = Decoration("granite")
println(decoration1)

    val decoration2 = Decoration("slate")
    println(decoration2)

    val decoration3 = Decoration("slate")
    println(decoration3)

}
```

In makeDecorations(), add a print statement that prints the result of comparing decoration1 with decoration2, and a second one comparing decoration3 with decoration2. Use the equals() method that is provided by data classes.

```kotlin
    println (decoration1.equals(decoration2))
    println (decoration3.equals(decoration2))
```

Output:

```kotlin
⇒ Decoration(rocks=granite)
Decoration(rocks=slate)
Decoration(rocks=slate)
false
true
```

**Note**: You could have used == to check whether d1 == d2 and d3 == d2. In Kotlin, using == on data class objects is the same as using equals() (structural equality). If you need to check whether two variables refer to the same object (referential equality), use the === operator. Read more about equality in Kotlin in the language documentation.

**Note**: Although they are similar to structs in some languages, remember that data class objects are objects. Assigning a data class object to another variable copies the reference to that object, not the contents. To copy the contents to a new object, use the copy() method.

To get at the properties of a data object and assign them to variables, you could assign them one at a time, like this.

```kotlin
val rock = decoration.rock
val wood = decoration.wood
val diver = decoration.diver
```

Instead, you can make variables, one for each property, and assign the data object to the group of variables. Kotlin puts the property value in each variable.

```kotlin
val (rock, wood, diver) = decoration
```

This is called destructuring and is a useful shorthand. The number of variables should match the number of properties, and the variables are assigned in the order in which they are declared in the class. Here is a complete example you can try in Decoration.kt.

```kotlin
// Here is a data class with 3 properties.
data class Decoration2(val rocks: String, val wood: String, val diver: String){
}

fun makeDecorations() {
val d5 = Decoration2("crystal", "wood", "diver")
println(d5)

// Assign all properties to variables.
val (rock, wood, diver) = d5
println(rock)
println(wood)
println(diver)
}

⇒ Decoration2(rocks=crystal, wood=wood, diver=diver)
crystal
wood
diver
```

If you don't need one or more of the properties, you can skip them by using \_ instead of a variable name, as shown in the code below.

```kotlin
    val (rock, _, diver) = d5
```

#### Singleton

Recall the earlier example with the GoldColor class.

```kotlin
object GoldColor : FishColor {
   override val color = "gold"
}
```

Because every instance of GoldColor does the same thing, it is declared as an object instead of as a class to make it a singleton. There can be only one instance of it.

#### Enum

Kotlin also supports enums, which allow you to enumerate something and refer to it by name, much like in other languages. Declare an enum by prefixing the declaration with the keyword enum. A basic enum declaration only needs a list of names, but you can also define one or more fields associated with each name.

In Decoration.kt, try out an example of an enum.

```kotlin
enum class Color(val rgb: Int) {
   RED(0xFF0000), GREEN(0x00FF00), BLUE(0x0000FF);
}
```

Enums are a bit like singletons—there can be only one, and only one of each value in the enumeration. For example, there can only be one Color.RED, one Color.GREEN, and one Color.BLUE. In this example, the RGB values are assigned to the rgb property to represent the color components. You can also get the ordinal value of an enum using the ordinal property, and its name using the name property.

Try out another example of an enum.

```kotlin
enum class Direction(val degrees: Int) {
NORTH(0), SOUTH(180), EAST(90), WEST(270)
}

fun main() {
println(Direction.EAST.name)
println(Direction.EAST.ordinal)
println(Direction.EAST.degrees)
}

⇒ EAST
2
90
```

#### Sealed Class

A sealed class is a class that can be subclassed, but only inside the file in which it's declared. If you try to subclass the class in a different file, you get an error.

Because the classes and subclasses are in the same file, Kotlin will know all the subclasses statically. That is, at compile time, the compiler sees all the classes and subclasses and knows that this is all of them, so the compiler can do extra checks for you.

In AquariumFish.kt, try out an example of a sealed class, keeping with the aquatic theme.

```kotlin
sealed class Seal
class SeaLion : Seal()
class Walrus : Seal()

fun matchSeal(seal: Seal): String {
   return when(seal) {
       is Walrus -> "walrus"
       is SeaLion -> "sea lion"
   }
}
```

The Seal class can't be subclassed in another file. If you want to add more Seal types, you have to add them in the same file. This makes sealed classes a safe way to represent a fixed number of types. For example, sealed classes are great for returning success or error from a network API.

### Summary

**Classes and constructors**

- Define a class in Kotlin using class.
- Kotlin automatically creates setters and getters for properties.
- Define the primary constructor directly in the class definition. For example: class Aquarium(var length: Int = 100, var width: Int = 20, var height: Int = 40)
- If a primary constructor needs additional code, write it in one or more init blocks.
- A class can define one or more secondary constructors using constructor, but Kotlin style is to use a factory function instead.
  **Visibility modifiers and subclasses**
- All classes and functions in Kotlin are public by default, but you can use modifiers to change the visibility to internal, private, or protected.
- To make a subclass, the parent class must be marked open.
- To override methods and properties in a subclass, the methods and properties must be marked open in the parent class.
- A sealed class can be subclassed only in the same file where it is defined. Make a sealed class by prefixing the declaration with sealed.
  **Data classes, singletons, and enums**
- Make a data class by prefixing the declaration with data.
- Destructuring is a shorthand for assigning the properties of a data object to separate variables.
- Make a singleton class by using object instead of class.
- Define an enum using enum class.
  **Abstract classes, interfaces, and delegation**
- Abstract classes and interfaces are two ways to share common behavior between classes.
- An abstract class defines properties and behavior, but leaves the implementation to subclasses.
- An interface defines behavior, and may provide default implementations for some or all of the behavior.
- When you use interfaces to compose a class, the class's functionality is extended by way of the class instances that it contains.
- Interface delegation uses composition, but also delegates the implementation to the interface classes.
- Composition is a powerful way to add functionality to a class using interface delegation. In general composition is preferred, but inheritance from an abstract class is a better fit for some problems.
