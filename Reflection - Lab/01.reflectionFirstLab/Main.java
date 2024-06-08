package reflectionFirstLab;

import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException
    {
        System.out.println("class " + Reflection.class.getSimpleName());
        System.out.println(Reflection.class.getSuperclass());
        Class[] interfaces = Reflection.class.getInterfaces();

        for (int i = 0; i < interfaces.length; i++)
        {
            System.out.println(interfaces[i]);
        }

        Reflection reflection = (Reflection) Class.forName(Reflection.class.getName()).getConstructor().newInstance();

        System.out.println(reflection);
    }
}