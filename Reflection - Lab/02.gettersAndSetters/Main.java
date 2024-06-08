package gettersAndSetters;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main
{
    public static void main(String[] args)
    {
        // Get all (Declared) methods of the Reflection class
        Method[] methods = Reflection.class.getDeclaredMethods();

        List<Method> getters = new ArrayList<>();
        List<Method> setters = new ArrayList<>();

// Identify getters and setters
        for (Method method : methods) {
            String methodName = method.getName();
            if (methodName.startsWith("get") || methodName.startsWith("is")) {
                getters.add(method);
            } else if (methodName.startsWith("set")) {
                setters.add(method);
            }
        }

// Sort getter and setter methods alphabetically
        getters.sort(Comparator.comparing(Method::getName));
        setters.sort(Comparator.comparing(Method::getName));

// Print getters
        for (Method getter : getters)
        {
            System.out.printf("%s will return class %s%n", getter.getName(), getter.getReturnType().getName());
        }

// Print setters
        for (Method setter : setters)
        {
            Class<?>[] parameterTypes = setter.getParameterTypes();
            System.out.printf("%s and will set field of class %s%n", setter.getName(), parameterTypes[0].getName());
        }
    }
}