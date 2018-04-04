object ScalaExercises {
println("Welcome to the Scala worksheet")         //> Welcome to the Scala worksheet
  // VALUES are immutable constants. You can't change them once defined.
  val hello: String = "Herro!"                    //> hello  : String = Herro!
  println(hello)                                  //> Herro!
  
  // VARIABLES are mutable
  var helloThere: String = hello                  //> helloThere  : String = Herro!
  helloThere = hello + "There"
  println(helloThere)                             //> Herro!There
  
  // Some other types
  val numberOne : Int = 1                         //> numberOne  : Int = 1
  val truth : Boolean = true                      //> truth  : Boolean = true
  val letterA : Char = 'a'                        //> letterA  : Char = a
  val pi : Float = 3.14159265f                    //> pi  : Float = 3.1415927
  val bigNumber : Long = 1234567890l              //> bigNumber  : Long = 1234567890
  val smallNumber : Byte = 127                    //> smallNumber  : Byte = 127
 
  // printf style:
  println(f"Pi is about $pi%.3f")                 //> Pi is about 3.142
  println(f"Zero padding on the left: $numberOne%05d")
                                                  //> Zero padding on the left: 00001
  
  // Dealing with booleans
  val isGreater = 1 > 2                           //> isGreater  : Boolean = false
  val isLesser = 1 < 2                            //> isLesser  : Boolean = true
  val impossible = isGreater & isLesser           //> impossible  : Boolean = false
  val anotherWay = isGreater && isLesser          //> anotherWay  : Boolean = false
  
  val picard: String = "Picard"                   //> picard  : String = Picard
  val bestCaptain: String = "Picard"              //> bestCaptain  : String = Picard
  val isBest: Boolean = picard == bestCaptain     //> isBest  : Boolean = true
  
  
  // EXERCISE
  // Write some code that takes the value of pi, TRIPLES it, and then prints it within a string with
  // FOUR decimal places of precision to the right.
  // Just write your code below here; any time you save the file it will automatically display the results!
  
  val piTripled = pi*3                            //> piTripled  : Float = 9.424778
  println(f"PiTripled is about $piTripled%.4f")   //> PiTripled is about 9.4248
  
  
  // Flow control
  
  // If / else syntax
  if (1 > 3) println("Impossible!") else println("This is not true man.")
                                                  //> This is not true man.
  
  if (1 > 3) {println("Impossible!")} else {	println("This is also false.")}
                                                  //> This is also false.
  
  // Matching - like switch in other languages:
  val number = 6                                  //> number  : Int = 6
  number match {
  	case 1 => println("One")
  	case 2 => println("Two")
  	case 3 => println("Three")
  	case _ => println("Something else")
 	}                                         //> Something else
 	
 	// For loops
 	for (x <- 1 to 4) {
 		val squared = x * x
 		println(squared)
 		}                                 //> 1
                                                  //| 4
                                                  //| 9
                                                  //| 16
                                                  
  // While loops
  var x = 10                                      //> x  : Int = 10
  while (x >= 0) {
  	println(x)
  	x -= 1
  }                                               //> 10
                                                  //| 9
                                                  //| 8
                                                  //| 7
                                                  //| 6
                                                  //| 5
                                                  //| 4
                                                  //| 3
                                                  //| 2
                                                  //| 1
                                                  //| 0
                                                  
  x = 0
  do { println(x); x+=1 } while (x <= 10)         //> 0
                                                  //| 1
                                                  //| 2
                                                  //| 3
                                                  //| 4
                                                  //| 5
                                                  //| 6
                                                  //| 7
                                                  //| 8
                                                  //| 9
                                                  //| 10
                                                  
   // Expressions
   // "Returns" the final value in a block automatically
   
   {val x = 10; x + 20}                           //> res0: Int = 30
                                                
	 println({val x = 10; x + 20})            //> 30
	 
  // EXERCISE
	 // Write some code that prints out the first 10 values of the Fibonacci sequence.
	 // This is the sequence where every number is the sum of the two numbers before it.
	 // So, the result should be 0, 1, 1, 2, 3, 5, 8, 13, 21, 34
 
var a = 0                                         //> a  : Int = 0
var b = 1                                         //> b  : Int = 1
println(a)                                        //> 0
for (i <- 2 to 10) {
	val c = a+b;
	println(c);
	b = a;
	a = c;
}                                                 //> 1
                                                  //| 1
                                                  //| 2
                                                  //| 3
                                                  //| 5
                                                  //| 8
                                                  //| 13
                                                  //| 21
                                                  //| 34
  
  // Functions
  
  // Format is def <function name>(parameter name: type...) : return type = { expression }
  // Don't forget the = before the expression!
  def squareIt(x: Int) : Int = {
  	x * x
  }                                               //> squareIt: (x: Int)Int
  
  def cubeIt(x: Int): Int = {x * x * x}           //> cubeIt: (x: Int)Int
  
  println(squareIt(2))                            //> 4
  
  println(cubeIt(2))                              //> 8
  
  // Functions can take other functions as parameters
  
  def transformInt(x: Int, f: Int => Int) : Int = {
  	f(x)
  }                                               //> transformInt: (x: Int, f: Int => Int)Int
  
  val result = transformInt(2, cubeIt)            //> result  : Int = 8
  println (result)                                //> 8
  
  // "Lambda functions", "anonymous functions", "function literals"
  // You can declare functions inline without even giving them a name
  // This happens a lot in Spark.
  transformInt(3, x => x * x * x)                 //> res1: Int = 27
  
  transformInt(10, x => x / 2)                    //> res2: Int = 5
  
  transformInt(2, x => {val y = x * 2; y * y})    //> res3: Int = 16
  
  // EXERCISE
  // Strings have a built-in .toUpperCase method. For example, "foo".toUpperCase gives you back FOO.
  // Write a function that converts a string to upper-case, and use that function of a few test strings.
  // Then, do the same thing using a function literal instead of a separate, named function.
  
  def Upper(s: String): String={ s.toUpperCase()} //> Upper: (s: String)String
  println(Upper("this needs to change to upper case"))
                                                  //> THIS NEEDS TO CHANGE TO UPPER CASE
  
  def Upper2(s: String, f: String => String) : String = {f(s)}
                                                  //> Upper2: (s: String, f: String => String)String
  println(Upper2("this too needs to be upper case", s=> s.toUpperCase()))
                                                  //> THIS TOO NEEDS TO BE UPPER CASE
  
  // Data structures
  
  // Tuples
  // Immutable lists
  // Often thought of as database fields, or columns.
  // Useful for passing around entire rows of data.
  
  val captainStuff = ("Korean", "Harvey", "Brother")
                                                  //> captainStuff  : (String, String, String) = (Korean,Harvey,Brother)
  println(captainStuff)                           //> (Korean,Harvey,Brother)
  
  // Refer to individual fields with their ONE-BASED index:
  println(captainStuff._1)                        //> Korean
  println(captainStuff._2)                        //> Harvey
  println(captainStuff._3)                        //> Brother
 
 // Create a key/value pair with ->
 val picardsShip = "Picard" -> "Enterprise-D"     //> picardsShip  : (String, String) = (Picard,Enterprise-D)
 println(picardsShip._2)                          //> Enterprise-D
 
 // Mix different types in a tuple
 val aBunchOfStuff = ("Kirk", 1964, true)         //> aBunchOfStuff  : (String, Int, Boolean) = (Kirk,1964,true)
 
 // Lists
 // Like a tuple, but it's an actual Collection object that has more functionality.
 // Cannot hold items of different types.
 // It's a singly-linked list under the hood.
 
 val shipList = List("Korean", "Defiant", "Voyager")
                                                  //> shipList  : List[String] = List(Korean, Defiant, Voyager)
 
 // Access individual members using () with ZERO-BASED index...
 println(shipList(1))                             //> Defiant
 
 // head : first item, tail: the remaining ones.
 println(shipList.head)                           //> Korean
 println(shipList.tail)                           //> List(Defiant, Voyager)
 
 
 // Iterating though a list
 for (ship <- shipList) {println(ship)}           //> Korean
                                                  //| Defiant
                                                  //| Voyager
 
 // Apply a function literal to a list. map() can apply any function to every item in a collection.
val backwardShips = shipList.map( (ship: String) => {ship.reverse})
                                                  //> backwardShips  : List[String] = List(naeroK, tnaifeD, regayoV)
 for (ship <- backwardShips) {println(ship)}      //> naeroK
                                                  //| tnaifeD
                                                  //| regayoV
                                                  
// reduce() can combine all the items in a collection using some function.
val numberList = List(1, 2, 3, 4, 5)              //> numberList  : List[Int] = List(1, 2, 3, 4, 5)
val sum = numberList.reduce( (x: Int, y: Int) => x + y)
                                                  //> sum  : Int = 15
println(sum)                                      //> 15

// filter() removes stuff you don't want.
val noFives = numberList.filter( (x: Int) => x != 5)
                                                  //> noFives  : List[Int] = List(1, 2, 3, 4)
val noThrees = numberList.filter(_ != 3)          //> noThrees  : List[Int] = List(1, 2, 4, 5)

// Concatenating lists
val moreNumbers = List(6, 7, 8)                   //> moreNumbers  : List[Int] = List(6, 7, 8)
val lotsOfNumbers = numberList ++ moreNumbers     //> lotsOfNumbers  : List[Int] = List(1, 2, 3, 4, 5, 6, 7, 8)

// More list fun
val reversed = numberList.reverse                 //> reversed  : List[Int] = List(5, 4, 3, 2, 1)
val sorted = reversed.sorted                      //> sorted  : List[Int] = List(1, 2, 3, 4, 5)
val lotsOfDuplicates = numberList ++ numberList   //> lotsOfDuplicates  : List[Int] = List(1, 2, 3, 4, 5, 1, 2, 3, 4, 5)
val distinctValues = lotsOfDuplicates.distinct    //> distinctValues  : List[Int] = List(1, 2, 3, 4, 5)
val maxValue = numberList.max                     //> maxValue  : Int = 5
val total = numberList.sum                        //> total  : Int = 15
val hasThree = noThrees.contains(3)               //> hasThree  : Boolean = false

// Maps
// Useful for key/value lookups on distinct keys
// Like dictionaries in other languages

val shipMap = Map("Kirk" -> "Enterprise", "Picard" -> "Enterprise-D", "Sisko" -> "Deep Space Nine", "Janeway" -> "Voyager")
                                                  //> shipMap  : scala.collection.immutable.Map[String,String] = Map(Kirk -> Ente
                                                  //| rprise, Picard -> Enterprise-D, Sisko -> Deep Space Nine, Janeway -> Voyage
                                                  //| r)
println(shipMap("Janeway"))                       //> Voyager

// Dealing with missing keys
println(shipMap.contains("Archer"))               //> false

val archersShip = util.Try(shipMap("Archer")) getOrElse "Unknown"
                                                  //> archersShip  : String = Unknown
println(archersShip)                              //> Unknown

// EXERCISE
// Create a list of the numbers 1-20; your job is to print out numbers that are evenly divisible by three. (Scala's
// modula operator, like other languages, is %, which gives you the remainder after division. For example, 9 % 3 = 0
// because 9 is evenly divisible by 3.) Do this first by iterating through all the items in the list and testing each
// one as you go. Then, do it again by using a filter function on the list instead.
  
for(numb<-1 to 20){
if((numb%3)==0)
println(numb)                                     //> 3
                                                  //| 6
                                                  //| 9
                                                  //| 12
                                                  //| 15
                                                  //| 18
}
val numbers = List.range(1,21)
val numbersFiltered = numbers.filter(_ %3 ==0)
}