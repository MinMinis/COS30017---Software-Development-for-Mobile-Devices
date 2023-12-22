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
    - [Function](#function)
    - [Summary Week 1](#summary-week-1)

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

### Function

"fun" keyword designates a function, followed by the name. As with other programming languages, the parentheses are for function arguments, if any, and the curly braces frame the code for the function. There is no return type because the function doesn't return anything. Also note that there are no semicolons at the ends of lines

```kotlin
fun printHello() {
    println("Hello World")
}
printHello()
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
