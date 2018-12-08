/**
 * Methods 
 */

// def add(x: Int, y: Int): Int = x + y
// def addThenMultiply(x: Int, y: Int)(multiplier: Int) = (x + y) * multiplier
// def name: String = System.getProperty("user.name")
// def getSquareString(input: Double): String = {
//   val square = input * input
//   square.toString
// }


/**
 * Case Classes:
 *  Immutable, and compared by value defined with case class keyword, may be instantiated
 *  without the new keyword
 */ 
  // case class Point(x: Int, y: Int)
  
  // val point = Point(1, 2)
  // val anotherPoint = Point(1, 2)
  // val yetAnotherPoint = Point(2, 2)
  
  // if (point == anotherPoint) {
  //   println(point + " and " + anotherPoint + " are the same.")
  // } else {
  //   println(point + " and " + anotherPoint + " are different.")
  // } // Point(1,2) and Point(1,2) are the same.
  
  // if (point == yetAnotherPoint) {
  //   println(point + " and " + yetAnotherPoint + " are the same.")
  // } else {
  //   println(point + " and " + yetAnotherPoint + " are different.")
  // } 
  
  /**
   * Objects:
   *  Objects are single instances of their own definitions, ie singletons of their own classes
   */
  
    object IdFactory {
      /**
       * Acts like static variable
       */
      private var counter = 0
      def create(): Int = {
        counter += 1
        counter
      }
    }
    
    /**
     * Traits:
     *  Types that contain fields and methods (can combine multiple traits)
     */
    
    // trait Greeter {
    //   def greet(name: String): Unit =
    //     /**
    //     * Default implementation of greet
    //     */
    //     println("Hello, " + name + "!")
    // }
 
 /**
  * You can extend traits with the extends keyword 
  */
  // class DefaultGreeter extends Greeter
  
  // class CustomGreeter(prefix: String, postfix: String) extends Greeter {
  //   override def greet(name: String): Unit = {
  //     println(prefix + name + postfix)
  //   }
  // }
  
  // val greeter = new DefaultGreeter()
  // greeter.greet("David")
  
  // val customGreeter = new CustomGreeter("How are you, ", "?")
  // customGreeter.greet("Benny")
  
/**
 * Main:
 *  The pain method is the entrypoint of a program
 */
// object Main {
//   def main (args: Array[String]): Unit =
//     println("Hello friend, from main.")
// }
 
 /**
  * Type Hierarchy:
  * 
  *  Any: Supertype of all types, defines universal methods: equals, hashCode, toString.
  *   > Subclasses: AnyVal, AnyRef.
  *  
  * AnyVal: represents value type
  *   > Subtypes: Double, Float, Long, Int, Short, Byte, Char, Unit, Boolean
  *     - Unit carries no meaningful information, has exactly one instance, declared with ().
  *       Since all functions must return something, so it is a useful return type.
  * 
  *  AnyRef: represents reference types
  *   > Subtypes: All non value types, user defined types
  * 
  *  Nothing: there is no value that has type Nothing. Common use for nothing return types
  *           are thrown exceptions, program exit, or an infinite loop
  *  Null: a subtype of all reference types. Has a single value identified by the keyword literal @null.
  *        It is only provided for interoperability with JVM languages and should almost never be used in
  *        scala
  */
  
  // val list: List[Any] = List(
  //   "a string",
  //   732,
  //   'c',
  //   true,
  //   () => "function"
  //   )
    
  //   list.foreach(element => println(element))
    
    /**
     * Typecasting:
     *  Value types can be cast in the following way.
     *  [Byte]=>[Short]=>[Int]=>[Long]=>[Float]=>[Double]
     *                     ^
     *                     |
     *                   [Char]
     * ILLEGAL:
     *  @val x: Long = 987654321
     *  @val y: Float = x // OK
     *  @val z: Long = y // does not compile
     * 
     * LEGAL:
     *      
     *  @val x: Long = 987654321
     *  @val y: Float = x // 9.8765434E8 (loses precision)
     *  @val face: Char = '☺ '
     *  @val number: Int = face // 9786
     */

     
     /**
      * Classes
      */
     
     /***
      * Mininmal
      */ 
    //   class User
    //   val user1 = new User
      
    
    
    // val location1 = new Location
    
    // location1.x = 99;
    // location1.y = 101;
    // location1.z = 24;

/**
 * Tuples: holds elements of different types, immutable, useful for multiple return
 *         values in functions.
 */
 
 val ingredient = ("Sugar", 25):Tuple2[String, Int]
 
 
 /**
  * Destructuring
  */
 
 val (name, quantity) = ingredient
 
 println(name)
 println(quantity)
 
 /**
  * Destructuring using pattern matching
  */
  
  val planetDistanceFromSun = 
    List(
      ("Mercury", 57.9), 
      ("Venus", 108.2),
      ("Earth", 149.6),
      ("Mars", 227.9),
      ("Jupiter", 778.3)
      )
  
  planetDistanceFromSun.foreach{ tuple => {
    
    tuple match {
      case ("Mercury", distance) => println(s"Mercury is $distance million km away from the Sun")
      case p if(p._1 == "Venus") => println(s"Venus is ${p._2} million km away from the Sun")
      case p if(p._1 == "Earth") => println(s"${p._1} is ${p._2} million km away from Sun")
      case _ => println("Too Far...")
    }   
  }}
 
 /**
  * Destructuring in 'for' comprehenshion
  */
 
 val numPairs = List((2, 5), (3, -7), (20, 56))
 
 for ((a, b) <- numPairs) {
   println(a * b)
 }
 
 /**
  * Rules for tuples vs case classes:
  *   Use case classes for when elements carry more meaning
  */
  
  /**
   * Mixin class composition
   *  Mixins are @trait's that are used to compose a class
   */
   
  abstract class A {
    val message: String
  }
  class B extends A {
    val message = "I'm an instance of class B"
  }
  trait C extends A {
    def loudMessage = message.toUpperCase()
  }
  /**
    * Class D has superclass B, and a mixin C. Classes may have only one supertype, but
    * many mixins. The mixins and superclass may have the same supertype.
    */
  class D extends B with C
  
  val d = new D
  println(d.message)
  println(d.loudMessage)
 
 

 class App {
   
 }
 
 /**
  * This trait implements foreach by continually calling the provided function
  * f: T => Unit as long as there is a next element. Since it is a trait it doesnt
  * need to implement abstract members
  */

 
 /**
  * This class takes a string and can be used to iterate over the string
  * ie to see if a String contains a certain character
  */


 

object StringIteratorTest extends App {
  class RichStringIter extends StringIterator("Scala") with RichIterator
  val richStringIter = new RichStringIter
  def main() {
    richStringIter foreach println
  }
}

 StringIteratorTest.main()

 /**
 * Higher-Order Functions: Intake functions as parameters or return a function as a result
 *  Since functions are first-class values in Scala,
 */

val salaries = Seq(20000, 70000, 40000)
val newSalaries = salaries.map(_ * 2)

println(newSalaries)


/**
 * Methods may define multiple parameter lists. whne a method is called with a fewer
 * number of parameter lists then this will yield a function taking the missing parameter
 * lists as its arguments
 * 
 * Currying:
 *  A technique taking functions that have multiple parameters, and transforming them into
 *  a sequence of functions, each with a single parameter. 
 *  Original: f(x, y): z => z
 *  Curried: f: z = (x) => (y) => z
 * 
 */
 
/**
 * Scala.Traversable
 *  def foldLeft[B](z: B)(op: (B, A) => B): B
 *  Folding is similiar to reducing in this case in that we are recursively passing an
 *  accumulator and adding the value each time.
 *  
 * @val res = numbers.foldLeft(0)((m, n) => m + n)
 */

val numbers = List(1,2,3,4,5,6,7,8,9,10)

val res = numbers.foldLeft(0)(_ + _)
/**
 * This statement allows us to fix the parameter z and pass around a partial function
 * and reuse it as shown below
 */

val numberFn = numbers.foldLeft(List[Int]())_

val squares = numberFn((xs, x) => xs:+ x*x)
println(squares.toString())

val cubes = numberFn((xs, x) => xs:+ x*x*x)
println(cubes.toString())


println(res)

//foldLeft
println((0 /: numbers)(_ + _))

/**
 * Case classes are similiar to regular classes with a few key differences. They are good
 * for modeling immutable data.
 * 
 * A minimal case class requires the keyword case class, an identifier, and a parameter list
 * which may be empty
 */
 
 case class Book(isbn: String)
 
 val frankenstein = Book("978-0486282114")
 
 case class Message(sender: String, recipient: String, body: String)
 
 var message1 = Message("jasonjobs@snagajob.com", "jamesworker@mrworker.com", "Sup?")
 
 println(message1.sender)
 //message1.sender = "travis@washington.us" // case class instance is immutable
 
 /**
  * Comparison:
  *   Case classes are compared structurally vs by reference
  */
  val message2 = Message("jorge@catalonia.es", "guillaume@quebec.ca", "Com va?")
  val message3 = Message("jorge@catalonia.es", "guillaume@quebec.ca", "Com va?")
  
  val messagesEqual = message2 == message3
  println(messagesEqual)
  
  /**
   * Copying
   */
   val message4 = message3.copy(sender = message2.recipient, recipient = message3.sender)
   println(message4)
   
abstract class Notification

case class Email(sender: String, title: String, body: String) extends Notification

case class SMS(caller: String, message: String) extends Notification

case class VoiceRecording(contactName: String, link: String) extends Notification

def showNotification(notification: Notification): String = {
  notification match {
    case Email(email, title, _) =>
      s"You got an email from $email with title: $title"
    case SMS(number, message) =>
      s"You got an SMS from $number! Message: $message"
    case VoiceRecording(name, link) => 
      s"You received a Voice Recording from $name! Click the link to hear it: $link"
  }
}

val someSms = SMS("12345", "Are you there?")
val someVoiceRecording = VoiceRecording("Tom", "voicerecording.org/id/123")

println(showNotification(someSms))  // prints You got an SMS from 12345! Message: Are you there?

println(showNotification(someVoiceRecording))  // you received a Voice Recording from Tom! Click the link to hear it: voicerecording.org/id/123
package libscala {
    
    package iterator {
        abstract class AbsIterator {
          type T
          def hasNext: Boolean
          def next(): T
        }

        trait Iterator[A] {
          def hasNext: Boolean
          def next(): A
        }

        trait RichIterator extends AbsIterator {
          def foreach(f: T => Unit): Unit = while (hasNext) f(next())
        }

        class StringIterator(s: String) extends AbsIterator {
          type T = Char
          private var i = 0
          def hasNext = i < s.length
          def next() = {
            val ch = s charAt i
            i += 1
            ch
          }
        }

        class IntIterator(to: Int) extends Iterator[Int] {
          private var current = 0
          override def hasNext: Boolean = current < to
          override def next(): Int = {
            if (hasNext) {
              val t = current
              current += 1
              t
            } else 0
          }
        }
    }

    package math {
        
        def factorial(x: Int): Int = {
          def fact(x: Int, acc: Int): Int = {
            if (x <= 1) acc
            else fact(x - 1, x * acc)
          }
          fact(x, 1)
        }

    }

    package graphics {

        class Point(var x: Int = 0, var y: Int = 0) {
          def move(dx: Int, dy: Int): Unit = {
            x = x + dx
            y = y + dy
          }
          override def toString: String =
            s"$x, $y"
        }
    
        class Location {
          private var _x = 0
          private var _y = 0
          private var _z = 0
          private val bound = 100

          /**
          * Getter/Setter methods
          */
          def x = _x
          def x_= (newVal: Int): Unit = {
            if (newVal < bound) _x = newVal else printWarning
          }

          def y = _y
          def y_= (newVal: Int): Unit = {
            if (newVal < bound) _y = newVal else printWarning
          }

          def z = _z
          def z_= (newVal: Int): Unit = {
            if (newVal < bound && newVal > 0) _z = newVal else printWarning
          }

          private def printWarning = println("WARNING: Out of bounds")
        }
    }
    package http {

       /**
        *  Usage:
        *    val domainName = "www.example.com"
        *    def getURL = urlBuilder(ssl=true, domainName)
        *    val endpoint = "users"
        *    val query = "id=1"
        *    val url = getURL(endpoint, query)
        */
        def urlBuilder(ssl: Boolean, domainName: String): (String, String) => String = {
          val schema = if (ssl) "https://" else "http://"
          (endpoint: String, query: String) => s"$schema$domainName/$endpoint"
        }

    }
}

/*
JavaMirror with scala.tools.nsc.interpreter.IMain$TranslatingClassLoader@2c7d121c of type 
class scala.tools.nsc.interpreter.IMain$TranslatingClassLoader with classpath [(memory)] and 
parent being scala.reflect.internal.util.ScalaClassLoader$URLClassLoader@24e2355c of type class 
scala.reflect.internal.util.ScalaClassLoader$URLClassLoader with 
classpath [
    
    file:/Library/Java/JavaVirtualMachines/jdk1.8.0_112.jdk/Contents/Home/jre/lib/resources.jar,
    file:/Library/Java/JavaVirtualMachines/jdk1.8.0_112.jdk/Contents/Home/jre/lib/rt.jar,
    file:/Library/Java/JavaVirtualMachines/jdk1.8.0_112.jdk/Contents/Home/jre/lib/jsse.jar,
    file:/Library/Java/JavaVirtualMachines/jdk1.8.0_112.jdk/Contents/Home/jre/lib/jce.jar,

]  
]
*/