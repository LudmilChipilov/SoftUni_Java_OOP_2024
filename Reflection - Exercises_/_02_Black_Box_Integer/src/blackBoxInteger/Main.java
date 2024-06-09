package blackBoxInteger;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Scanner;

// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main
{
    public static void main(String[] args) throws IOException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException
    {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        //Returns a Constructor object that reflects the specified constructor of the class represented by this Class object
        Constructor<BlackBoxInt> constructor = BlackBoxInt.class.getDeclaredConstructor();
        //Set the accessible flag for this reflected object to the indicated boolean value.
        // A value of true indicates that the reflected object should suppress checks for Java language access control when it is used
        constructor.setAccessible(true);
        //Uses the constructor represented by this Constructor object to create and initialize a new instance
        // of the constructor's declaring class, with the specified initialization parameters.
        // Individual parameters are automatically unwrapped to match primitive formal parameters,
        // and both primitive and reference parameters are subject to method invocation conversions as necessary.
        BlackBoxInt blackBoxInt = constructor.newInstance();
       //Returns an array containing Method objects reflecting all the declared methods of the class or interface
        // represented by this Class object, including public, protected, default (package) access, and private methods,
        // but excluding inherited methods
        Method[] methods = blackBoxInt.getClass().getDeclaredMethods();
        //Returns: the Field object for the specified field in this class
        Field innerValue = blackBoxInt.getClass().getDeclaredField("innerValue");
        //A value of true indicates that the reflected object should suppress checks for Java language access control when it is used
        innerValue.setAccessible(true);

        while (!input.equalsIgnoreCase("end")) {
            String[] tokens = input.split("_");
            String command = tokens[0];
            int value = Integer.parseInt(tokens[1]);
            //A Method provides information about, and access to, a single method on a class or interface.
            // The reflected method may be a class method or an instance method (including an abstract method)
            Method method = Arrays.stream(methods)
                    .filter(m -> m.getName().equalsIgnoreCase(command))
                    .findFirst().orElse(null);
           //A value of true indicates that the reflected object should suppress checks for Java language access control when it is used
            method.setAccessible(true);
            //Invokes the underlying method represented by this Method object, on the specified object with the specified parameters.
            method.invoke(blackBoxInt, value);

            System.out.println(innerValue.get(blackBoxInt));

            input = scanner.nextLine();
        }
    }
}