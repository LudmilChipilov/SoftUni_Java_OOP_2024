package harvestingFields;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Scanner;

// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        Field[] fields = RichSoilLand.class.getDeclaredFields();   // Get all fields
        String command = scanner.nextLine();
        while(!command.equals("HARVEST"))
        {
            printAllFieldsWithCorrectAccessModifiers(command, fields);
            command = scanner.nextLine();
        }
    }
    public static void printAllFieldsWithCorrectAccessModifiers(String command,  Field[] fields)
    {
        for(Field field : fields)
        {
            int modifiers = field.getModifiers();
            if(command.equals("private") && Modifier.isPrivate(modifiers))
            {
                System.out.printf("%s %s %s%n", command, field.getType().getSimpleName(), field.getName());
            }
            else if(command.equals("protected") && Modifier.isProtected(modifiers))
            {
                System.out.printf("%s %s %s%n", command, field.getType().getSimpleName(), field.getName());
            }
            else if(command.equals("public") && Modifier.isPublic(modifiers))
            {
                System.out.printf("%s %s %s%n", command, field.getType().getSimpleName(), field.getName());
            }
            else if(command.equals("all"))
            {
                System.out.printf("%s %s %s%n", Modifier.toString(modifiers), field.getType().getSimpleName(), field.getName());
            }
        }
    }
}