package Home5;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static int getInt(){
        try {
            return Integer.parseInt(scanner.next());
        } catch (NumberFormatException ex) {
            return -1;
        }
    }
    public static String getLine(){
        return scanner.next();
    }



    public static void main(String[] args) {
        Group group = new Group("JAVA CORE",10);
        int option = 1;
        do {
            System.out.println("1 ДОБАВИТЬ СТУДЕНТА 2 ПРИНТ 3 УДАЛИТЬ 4 ПОИСК 5 поставить оценку 6 поставить посещение 7 сортироваить 0 ВЫХОД");
            switch (option = getInt()){
                case 1:
                    System.out.println("Введите фамилию");
                    String addName = getLine();
                    int countLessons = group.getCount();
                    int id = group.getId();
                    Student newStudent = new Student(id,addName,countLessons );
                    group.addStudent(newStudent,group.getStudentsList());
                    break;
                case 2:
                    group.print();
                    break;
                case 3:
                    System.out.println("Введите фамилию");
                    String deleteName = getLine();
                    group.deleteStudent(deleteName);
                    break;
                case 0:
                    option = 0;
                    break;
                case 4:
                    System.out.println("Введите фамилию");
                    String findName = getLine();
                    group.findStudent(findName);
                    break;
                case 5:
                    System.out.println("Введите фамилию");
                    String setMarkName = getLine();
                    group.setMark(setMarkName);
                    break;
                case 6:
                    System.out.println("Введите фамилию");
                    String setVisitName = getLine();
                    group.setVisit(setVisitName);
                    break;
                case 7:
                    group.sort();
                    break;
                }


            }while (option != 0);
        }


}
