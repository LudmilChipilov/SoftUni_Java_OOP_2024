import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        List<Student> studentList = new ArrayList<>();
        String command = scanner.nextLine();
        while(!command.equals("Exit"))
        {
            String[] comArgs = command.split(" ");
            String firstCommand = comArgs[0];
            if(firstCommand.equals("Create"))
            {
                String studentName = comArgs[1];
                int studentAge = Integer.parseInt(comArgs[2]);
                double studentGrade = Double.parseDouble(comArgs[3]);
                Student student = new Student(studentName, studentAge, studentGrade);
                addStudentToStudentListIfNotExist(student, studentList);
            }
            else if(firstCommand.equals("Show"))
            {
                String studentName = comArgs[1];
                Student student = studentList.stream().filter(n -> n.getStudentName().equals(studentName)).findFirst().orElse(null);
                if(student != null)
                {
                    printStudentInformation(student);
                }
            }
            command = scanner.nextLine();
        }
    }
    public static void addStudentToStudentListIfNotExist(Student student,  List<Student> studentList)
    {
        if(!studentList.contains(student))
        {
            studentList.add(student);
        }
    }
    public static String addCommentary(Student student)
    {
        String commentary = "";
        if(student.getStudentGrade() < 3.50)
        {
            commentary = "Very nice person";
        }
        else if(student.getStudentGrade() < 5.50)
        {
            commentary = "Average student";
        }
        else if(student.getStudentGrade() >= 5.50)
        {
            commentary = "Excellent student";
        }
        return commentary;
    }
    public static void printStudentInformation(Student student)
    {
        String commentary = addCommentary(student);
        System.out.printf("%s is %d years old. %s.%n",
                student.getStudentName(), student.getStudentAge(), commentary);
    }
}