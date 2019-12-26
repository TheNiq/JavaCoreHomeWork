package Home4;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static String[] surnames = new String[0];
    public static int[][] marks = new int[0][0];
    public static boolean[][] visits = new boolean[0][0];
    public static Scanner scanner = new Scanner(System.in);



    public static void print(String[] arr){
        for (int i = 0;i < arr.length; i++){
            System.out.print(arr[i]+ " ");
        }
        System.out.println();
    }
    public static void print(int[][] arr){
        for(int i = 0;i < arr.length; i++){
            for(int j = 0;j < arr[i].length;j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();

        }

    }
    public static void print(boolean[][] arr){
        for(int i = 0;i < arr.length; i++){
            for(int j = 0;j < arr[i].length;j++){
                System.out.print(arr[i][j]);
            }
            System.out.println();

        }

    }
    //test
    public static void printMarks(){
        for(int i =0;i < surnames.length;i++) {
            System.out.print(surnames[i] + "\t");
            for (int mark : marks[i]) {
                System.out.print(mark + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void printVisits(){
        for(int i =0;i < surnames.length;i++) {
            System.out.print(surnames[i] + "\t");
            for (boolean visit : visits[i]) {
                System.out.print(visit + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

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
    public static void createMarks(){
        int[][] buffer = new int[marks.length+1][10];
        for(int i =0;i <marks.length;i++){
            buffer[i] = marks[i];
        }
        buffer[surnames.length-1] = new int[10];
        marks = buffer;

    }
    public static void createVisit(){
        boolean [][] buffer = new boolean[visits.length+1][10];
        for(int i = 0;i < visits.length;i++){
            buffer[i] = visits[i];
        }
        buffer[surnames.length -1] = new boolean[10];
        visits = buffer;
    }
    public static void addStudent (){
        System.out.println("Введите фамилию");
        String newStudent = getLine();
        String[] buffer = new String[surnames.length +1];
        for (int i = 0;i < surnames.length;i++ ){
            buffer[i] = surnames[i];

        }
        buffer[buffer.length -1] = newStudent;
        surnames = buffer;
        createMarks();
        createVisit();
    }
    public static void addMarks(){
        System.out.println("Введите фамилию");
        String name = getLine();
        int id = find(name);
        if(id != -1){
            System.out.println("Введите номер урока ");
            int lessonId = getInt();
            int mark;
            if(lessonId < marks[0].length && lessonId >= 1){
                if (marks[id][lessonId-1] == 0){
                    System.out.println("Введите оценку");
                    mark = getInt();
                    marks[id][lessonId-1] = mark;
                    visits[id][lessonId-1] = true;

                }
                else{
                    System.out.println("Оценка стоит");
                }
            }
            else {
                System.out.println("некорректные данные");
            }

        }
    }
    public static void addVisit(){
        System.out.println("Введите фамилию");
        String name = getLine();
        int id = find(name);
        if(id != -1){
            System.out.println("Введите номер урока ");
            int lessonId = getInt();
            boolean visit;
            int num;
            if(lessonId < marks[0].length && lessonId >= 1){
                System.out.println("Посещяемость 1 -> YES 2 -> NO");
                num = getInt();
                if(num == 1){
                    visits[id][lessonId-1] = true;
                }
                else if(num == 2){
                    visits[id][lessonId-1] = false;
                }
                else {
                    System.out.println("Ошибка");
                }
            }
            else {
                System.out.println("некорректные данные");
            }

        }
    }


    public static int find(String name){
        int id = -1;
        for (int i = 0;i < surnames.length;i++){
            if(surnames[i].equals(name)){
                id = i;
                break;
            }

        }
        return id;
    }
    public static void deleteStudent(){
        System.out.println("Введите фамилию");
        String name = getLine();
        int id = find(name);
        if(id >-1 ){
            int counter = 0;
            String[] bufferSurname = new String[surnames.length-1];
            int[][] bufferMarks = new int[marks.length-1][10];
            boolean[][] bufferVisit = new boolean[visits.length-1][10];
            for (int i =0;i < surnames.length;i++){
                if(i != id){
                    bufferSurname[counter] = surnames[i];
                    bufferMarks[counter] = marks[i];
                    bufferVisit[counter] = visits[i];
                    counter++;

                }

            }
            surnames = bufferSurname;
            marks = bufferMarks;
            visits = bufferVisit;
        }
        else {
            System.out.println("Такого студента нету ");
        }

    }
    public static void clear(){
        System.out.println("Введите фамилию");
        String name = getLine();
        int id = find(name);
        if(id != -1){
            System.out.println("Вы уверены что хотите удалить все данные у " + name + "YES -> 1 OR NO -> 2");
            int option = getInt();
            if(option == 1){
                marks[id] = new int[10];
                visits[id] = new boolean[10];
            }
            else {
                return;
            }
        }else {
            System.out.println("Cтудент не найден ");

        }
    }
    public static void sort(){
        String[] bufferName = surnames.clone();
        int [] [] bufferMarks = marks.clone();
        boolean[][] bufferVisit = visits.clone();
        Arrays.sort(bufferName);
        for (int i = 0;i < bufferName.length;i++){
            for (int j =0;j < surnames.length;j++){
                if(bufferName[i] == surnames[j]){
                    bufferMarks[i] = marks[j];
                    bufferVisit[i] = visits[j];

                }
            }
        }
        surnames = bufferName;
        marks = bufferMarks;
        visits = bufferVisit;
    }
    //method complete

    public static void main(String[] args) {
        int action;
       do{
           System.out.println("1-> Добавить студеннта | 2-> Удалить студента |3->  Оценку поставитть | 4 -> Добавить посещяемость |5 -> удалить данные студента | 6 -> сортировать | 7-> печатать оценки | 8 -> печатать посещение  0-> Выход");
           switch (action = getInt()){
               case 1:
                   addStudent();
                   break;
               case 2:
                   deleteStudent();
                   break;
               case 3:
                   addMarks();
                   break;
               case 4:
                   addVisit();
                   break;
               case 5:
                   clear();
                   break;
               case 6:
                   sort();
                   break;
               case 7:
                   printMarks();
                   break;
               case 8:
                   printVisits();
                   break;
               case 0:
                   action = 0;
                   break;
           }


       }while (action != 0);

    }



}