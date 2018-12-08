
/**
    Mutable variable
 */

var myVar : String = "Foo"

/* 
    Immutable value
*/

val myVal : String = "Foo"

/*
    If you do not assign an initial value to a variable
    then the following syntax is valid
*/

var unInitVar :Int;
val unInitVal :String;

/*
    Types are inferred
 */

 var infString = "Hello World!"
 val infInt = 10


 /*
    Multiple assignments. Scala supports multiple assignments
    if a code block or method returns a Tuple, the Tuple can
    be assigned to a val variable
 */

 val (myVar1: Int, myVar2: String) = Pair(40, "Foo");

 val (inferredInt, inferredString) = Pair(40, "Foo");

 /*
    Scope:
        Variables have 3 different scopes

    Fields
        Variables that belong to an object. The fields
        are accessible from inside every method in the 
        object(global to the object) and can be accessed
        from outside depending on their access modifiers
        Fields can be val or var (immutable/mutable).

    Method Params
        Method params are accessible only within a method
        but if the param is an object it may be accessible
        from outside the method. Can only be val (always immutable)
    
    Local Variables
        Variables declared inside of a method. These variables may
        escape upon a return from the method they were created
        in. Can be val/var
 */
