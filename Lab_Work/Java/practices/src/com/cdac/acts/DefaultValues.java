package com.cdac.acts;

public class DefaultValues {
    // int → 0
    // boolean → false
    // char → '\u0000' (null character)
    // Reference types (like String, arrays, objects) → null


    // Instance variables (non-static)
    int instanceInt;
    long instanceLong;
    float instanceFloat;
    double instanceDouble;
    boolean instanceBoolean;
    char instanceChar;
    String instanceString;

    // Static variables (class variables)
    static int staticInt;
    static boolean staticBoolean;
    static char staticChar;
    static String staticString;

    public static void main(String[] args) {
        // Creating an object to access instance variables
        DefaultValues obj = new DefaultValues();

        // Printing default values for instance variables
        System.out.println("Instance Variable Default Values:");
        System.out.println("int: " + obj.instanceInt);
        System.out.println("long: " + obj.instanceLong);
        System.out.println("float: " + obj.instanceFloat);
        System.out.println("double: " + obj.instanceDouble);
        System.out.println("boolean: " + obj.instanceBoolean);
        System.out.println("char: " + obj.instanceChar);
        System.out.println("char: '" + obj.instanceChar + "'");
        System.out.println("String: " + obj.instanceString);

        // Printing default values for static variables
        System.out.println("\nStatic Variable Default Values:");
        System.out.println("int: " + staticInt);
        System.out.println("boolean: " + staticBoolean);
        System.out.println("char: '" + staticChar + "'");
        System.out.println("String: " + staticString);

        // Printing default values for local variables (compiler will not allow use without initialization)
        // Local variables must be explicitly initialized before use, so we won't print them here.
        // Java doesn't have global variables in the same sense as some other languages. Static variables in classes can serve as class-level "global" variables, but they are still scoped to their class.

        int localVar;
        // The following line will cause a compile-time error
        // System.out.println(localVar); // Error: variable localVar might not have been initialized
    }
}
