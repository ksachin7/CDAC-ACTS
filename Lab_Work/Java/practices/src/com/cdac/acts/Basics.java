package com.cdac.acts;

public class Basics{
	// Max byte value: 127
	// Max short value: 32767
	// Max int value: 2147483647
	// Max long value: 9223372036854775807
	// Max float value: 3.4028235E38
	// Max double value: 1.7976931348623157E308
	// Max char value: 65535
	// Max boolean value (true): true
	// Min boolean value (false): false

	public static void main(String[] args){
		byte b=127;
		// byte b1= 128;	// compile-time error: outside the valid range
		// byte b2=-129;	// // compile-time error: outside the valid range
        byte b1 = (byte) 128; // casting 128 to byte results in overflow
        byte b2 = (byte) -129; // casting -129 to byte results in underflow

		short s= 32767;
		int i= 1073741824;
		long l= 9223372036854775807L;
		float f= 1073741824.00f;
		double d= 9223372036854775807.00;
		char c= 'Z';
		boolean bool= true;
		// boolean bool1= 1;	// compile-time error

		System.out.println(b);
		// System.out.println(b1);
		// System.out.println(b2);
        System.out.println("Byte b1 (cast 128): " + b1); 	// Output: -128 (overflow)
        System.out.println("Byte b2 (cast -129): " + b2); 	// Output: 127 (underflow)

		System.out.println(s);
		System.out.println(i);
		// System.out.println(l);
		System.out.println(f);
		System.out.println(d);
		System.out.println(c);
		System.out.println(bool);
		// System.out.println(bool1);
		System.out.println();

		// Printing the maximum values of each data type
        System.out.println("Max byte value: " + Byte.MAX_VALUE);

        System.out.println("Max short value: " + Short.MAX_VALUE);

        System.out.println("Max int value: " + Integer.MAX_VALUE);

        System.out.println("Max long value: " + Long.MAX_VALUE);

        System.out.println("Max float value: " + Float.MAX_VALUE);

        System.out.println("Max double value: " + Double.MAX_VALUE);

        // Maximum value for char (since 'char' represents Unicode characters)
        System.out.println("Max char value: " + (int) Character.MAX_VALUE);

        // Maximum value for boolean (boolean has only two values: true or false)
        System.out.println("Max boolean value (true): " + Boolean.TRUE);

        System.out.println("Min boolean value (false): " + Boolean.FALSE);
        
        // Casting
        {
        	System.out.println("\n--- Upcasting Examples ---");
	        /*
	        * Upcasting with Primitive Data Types (Widening Conversion)
			* Definition: Upcasting (or widening conversion) happens when a smaller type is automatically converted into a larger type. This is done implicitly by the compiler.
			*
			* Upcasting:
			* byte → short → int → long → float → double
			*
			* Java automatically promotes a smaller type to a larger type to avoid loss of data.
	        */

	        byte b0 = 10;
	        short s0 = b;  // Implicit upcasting from byte to short
	        int i0 = s;    // Implicit upcasting from short to int
	        long l0 = i;   // Implicit upcasting from int to long
	        float f0 = l;  // Implicit upcasting from long to float
	        double d0 = f; // Implicit upcasting from float to double

	        System.out.println("byte to short: " + s0);
	        System.out.println("short to int: " + i0);
	        System.out.println("int to long: " + l0);
	        System.out.println("long to float: " + f0);
	        System.out.println("float to double: " + d0);
        }

        {

        	System.out.println("\n--- Downcasting Examples ---");
			/* Downcasting with Primitive Data Types (Narrowing Conversion)
			* Definition: Downcasting (or narrowing conversion) happens when a larger type is explicitly converted to a smaller type. This may result in data loss if the value cannot be represented in the target type.
			*
			* Examples of Downcasting:
			*
			* double → float → long → int → short → byte
			*
			* In this case, you need to explicitly cast the value. If the value is too large or too small to fit in the target type, it may lead to data loss or overflow.
			*/

			double d9 = 100.99;
	        float f9 = (float) d;  // Explicit downcasting from double to float
	        long l9 = (long) f;    // Explicit downcasting from float to long
	        int i9 = (int) l;      // Explicit downcasting from long to int
	        short s9 = (short) i;  // Explicit downcasting from int to short
	        byte b9 = (byte) s;    // Explicit downcasting from short to byte
	        
	        System.out.println("double to float: " + f9);
	        System.out.println("float to long: " + l9);
	        System.out.println("long to int: " + i9);
	        System.out.println("int to short: " + s9);
	        System.out.println("short to byte: " + b9);

	        // When you add 4 to b (which is a byte), 
	        // Java will implicitly promote the byte to an int before performing the addition. 
	        // This happens because arithmetic operations in Java on primitive types (like byte, short, etc.) automatically promote the operands to int.
	        b += 4;  //b = (byte) (b + 4); LHS is byte and RHS is int  hence casting
	        b = ++b; //b = ( byte) (b + b); LHS is byte and RHS is int hence casting
	        // b = 154; // Error: incompatible types: possible lossy conversion from int to byte
	        b =  (byte) 154; // LHS is byte and RHS is int hence casting
	        b =  (byte) i;  // LHS is byte and RHS is int hence casting 
	        b =  ( byte) (b + 4); // LHS is byte and RHS is int hence casting
	        b = ( byte) (b + b);  // LHS is byte and RHS is int hence casting
	        
	        //Special error cases
	        //b =  ( byte) b + 4; //Error LHS is byte and RHS is int
	        b =  (byte) (b + (byte)4); //LHS and RHS both are byte
	        //b = b + b; // Error LHS is byte and RHS is int    
	        //s = s + 4; //Error LHS is byte and RHS is int
	        //s = s + s; //Error LHS is byte and RHS is int 
	        System.out.println("Byte value = " + b);
		}
        
    }
}
