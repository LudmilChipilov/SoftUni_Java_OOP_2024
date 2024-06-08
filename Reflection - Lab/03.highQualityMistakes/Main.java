package highQualityMistakes;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;

public class Main
{
    public static void main(String[] args)
    {
        // Get all fields
        Field[] fields = Reflection.class.getDeclaredFields();
        Arrays.sort(fields, Comparator.comparing(Field::getName));  // sort fields alphabetically by name
        // Get all methods
        Method[] methods = Reflection.class.getDeclaredMethods();
        Arrays.sort(methods, Comparator.comparing(Method::getName));  // sort methods alphabetically by name
        // Check field access modifiers
        for(Field field : fields)
        {
            int modifiers = field.getModifiers();

            String fieldName = field.getName();
            if(!Modifier.isPrivate(modifiers))
            {
                System.out.printf("%s must be private!%n", fieldName);
            }
        }
        // Check method access modifiers
        for (Method method : methods) {
            int modifiers = method.getModifiers();
            String methodName = method.getName();
            if (methodName.startsWith("get") && !Modifier.isPublic(modifiers)) {
                System.out.println(methodName + " have to be public!");
            } else if (methodName.startsWith("set") && !Modifier.isPrivate(modifiers)) {
                System.out.println(methodName + " have to be private!");
            }
        }
    }
}
