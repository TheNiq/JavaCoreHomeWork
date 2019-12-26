package Home5;
public class Group {
    private String groupName;
    private int count;
    private Student [] studentsList = new Student[0];
    private int id;

    public Group(String groupName, int count) {
        this.groupName = groupName;
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getId() {
        return ++id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Student[] getStudentsList() {
        return studentsList;
    }
    public int counterStudents(){
        return this.studentsList.length;
    }

    public void print(){
        for (int i =0;i < studentsList.length;i ++){
            System.out.println(studentsList[i]);

        }
    }

    public Student[] addStudent(Student student,Student[] arr){
        Student[] buffer = new Student[arr.length + 1];
        if(arr.length > 0){
            for(int i =0;i < arr.length; i ++){
                buffer[i] = arr[i];
            }
            buffer[buffer.length-1] = student;
            studentsList = buffer;
        }else {
            buffer[buffer.length-1] = student;
            studentsList = buffer;
        }
        return buffer;



    }
    public Student[] findStudent(String name){
        int counter =0;
        Student[] foundStudent = new Student[0];
        if (counterStudents() > 0){
            for(int i =0;i < studentsList.length;i++){
                if(studentsList[i].getSurName().equals(name)){
                    counter++;
                    Student[] buffer = new Student[counter];
                    if (foundStudent.length > 0){
                        for(int j = 0;j < foundStudent.length;j++){
                            buffer[j] = foundStudent[j];
                        }

                    }
                    buffer[counter-1] = studentsList[i];
                    foundStudent = buffer;
                }

            }
        }
        return foundStudent;
    }
    public void deleteStudent(String name){
        Student[] founderStudent = findStudent(name);
        int id = -1;
        if(founderStudent.length == 0){
            System.out.println("Cтудент не найден");
            return;
        }
        else if(founderStudent.length == 1){
            id = founderStudent[0].getId();
        }
        else if(founderStudent.length > 1){
            String[] option = new String[founderStudent.length];
            for(int i = 0;i < founderStudent.length;i++){
                option[i] = founderStudent[i].getSurName() + "id" + founderStudent[i].getId();
            }
            System.out.println("кого удалить ? ");
            int select = Main.getInt();
            id = founderStudent[select-1].getId();

        }
        Student [] buffer = new Student[0];
        for(int i = 0;i <studentsList.length;i ++){
            if(studentsList[i].getId() != id){
                buffer = addStudent(studentsList[i],buffer);

            }
        }
        studentsList = buffer;
    }
    public void setMark(String name){
        Student[] foundStudent = findStudent(name);
        int id = -1;
        if(foundStudent.length == 0){
            System.out.println("Cтудент не найден");
            return;
        }
        else if(foundStudent.length == 1){
            id = foundStudent[0].getId();
        }
        else if (foundStudent.length > 1){
            String[] option = new String[foundStudent.length];
            for(int i = 0;i <foundStudent.length;i++){
                option[i] = foundStudent[i].getSurName() + "id " + foundStudent[i].getId();
            }
            System.out.println("кому поставить оценку ? ");
            int select = Main.getInt();
            id = foundStudent[select-1].getId();
        }
        Student studentToSettMark = null;
        for(int i = 0;i < studentsList.length;i++){
            if(studentsList[i].getId() == id){
                studentToSettMark = studentsList[i];
            }
        }
        int lessonToSetMark = -1;
        System.out.println("какой урок?");
        lessonToSetMark = Main.getInt();
        int markToSet = -1;
        if(lessonToSetMark >= 1 && lessonToSetMark <= getCount()){
            if(studentToSettMark.getMark(lessonToSetMark) > 0){
                System.out.println("У студента уже стоит");

            }else {
                System.out.println("Оценка");
                markToSet = Main.getInt();
                studentToSettMark.setMark(lessonToSetMark,markToSet);
            }

        }else {
            System.out.println("ТАКОГО УРОКА НЕТУ ");
        }



    }
    public void setVisit(String name){
        Student[] foundStudent = findStudent(name);
        int id = -1;
        if(foundStudent.length == 0){
            System.out.println("Cтудент не найден");
            return;
        }
        else if(foundStudent.length == 1){
            id = foundStudent[0].getId();
        }
        else if (foundStudent.length > 1){
            String[] option = new String[foundStudent.length];
            for(int i = 0;i <foundStudent.length;i++){
                option[i] = foundStudent[i].getSurName() + "id " + foundStudent[i].getId();
            }
            System.out.println("кому поставить посещение ? ");
            int select = Main.getInt();
            id = foundStudent[select-1].getId();
        }
        Student studentToSettVisit = null;
        for(int i = 0;i < studentsList.length;i++){
            if(studentsList[i].getId() == id){
                studentToSettVisit = studentsList[i];
            }
        }
        int numberLesson = -1;
        System.out.println("какой урок?");
        numberLesson = Main.getInt();
        int setToVisit = -1;
        if(numberLesson >= 1 && numberLesson <= getCount()){
            if(studentToSettVisit.getVisit(numberLesson) == true){
                System.out.println("У студента уже стоит");

            }else {
                System.out.println("1-> Был | 2-> Не был");
                setToVisit = Main.getInt();
                if (setToVisit == 1){
                    studentToSettVisit.setVisit(numberLesson,true);
                }
                else if(setToVisit == 2){
                    studentToSettVisit.setVisit(numberLesson, false);
                }
                else {
                    System.out.println("Ошибка");
                }
            }

        }else {
            System.out.println("ТАКОГО УРОКА НЕТУ ");
        }



    }
    public void sort(){
        Student buff;
        for (int i = 0; i < studentsList.length; i++) {
            for (int j = i + 1; j < studentsList.length; j++) {
                if (studentsList[i].getSurName().compareTo(studentsList[j].getSurName()) > 0) {
                    buff = studentsList[i];
                    studentsList[i] = studentsList[j];
                    studentsList[j] = buff;
                }
            }
        }


    }



}
