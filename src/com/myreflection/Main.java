/**
 *  Java program to demonstrate reflection to access annotations of the class.
 */

package com.myreflection;


import java.lang.annotation.*;
import java.lang.reflect.Method;

/**
 *  Main class.
 */
public class Main {

    // JVM entry point.
    public static void main(String[] args) {

        try {
            // Creating an instance of the class DemoClass.
            DemoClass dm = new DemoClass();

            // Getting annotations of class DemoClass.
            Annotation[] annotations = dm.getClass().getAnnotations();

            // Iterating through all annotations of class.
            for (Annotation el : annotations) {

                // Printing annotations to console.
                System.out.println("The annotation is: " + el.toString());
            }

        } catch (Exception ex) {

            ex.printStackTrace();

        }

    }
}

/**
 * DemoClass class.
 */
@MyAnnotationClass(name = "JavaClass", value = "DemoClass")
class DemoClass {

    @MyAnnotation(name = "JavaUser", value = "alpha") @Deprecated
    // Method testMe().
    public void testMe() {
        System.out.println("TestMe method.");
    }

    // Method testMeToo().
    public void testMeToo() {
        System.out.println("TestMeToo method.");
    }

}

// Annotation for methods.
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface MyAnnotation {
    String name();
    String value();
}

// Annotation for classes.
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotationClass {
    String name();
    String value();
}