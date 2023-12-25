import objects.Student;
import tables.StudentTable;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        StudentTable studentTable = new StudentTable();
        ArrayList  <Student> student = studentTable.selectAll();
//        int studentCount = studentTable.selectCountStudent();
        if(studentTable.isEmpty()) {
        studentTable.insert(new Student( "Петров Пётр Федорович", "man",1));
        studentTable.insert(new Student( "Федоткин Викто Сергеевич", "man",2));
        studentTable.insert(new Student("Владимиров Георгий Тимофеевич", "man",3));
        studentTable.insert(new Student( "Кошкина Алёна Геннадьевна", "woman",4));
        studentTable.insert(new Student( "Алёнкина Алёнка Сергеевна", "woman",1));
        studentTable.insert(new Student("Буратинкин Тимойей Герогиевич", "man",2));
        studentTable.insert(new Student("Морозова Ирина Констанитовна", "woman",3));
        studentTable.insert(new Student("Шапкин Александр Павлович", "man",4));
        studentTable.insert(new Student("Подколодная Валентина Яковлевна", "woman",1));
        studentTable.insert(new Student("Слуцкий Леонид Эдуардович", "man",2));
        studentTable.insert(new Student( "Гатаулин Рашид Маратович", "man",3));
        studentTable.insert(new Student("Балашова Надежда Петровна ", "woman",4));
        studentTable.insert(new Student( "Васильев Николай Иванович", "man",1));
        studentTable.insert(new Student("Светлова Светлана Петровна", "woman",3));
        studentTable.insert(new Student( "Петров Федор Петрович", "man",2));
        }
        for (Student tmp : student) {
            System.out.println(tmp.toString());
        }
        System.out.println();

        student.get(3).setGroupID(2);
        studentTable.update(student.get(3));

        student = studentTable.selectAll();
        for (Student tmp: student) {
            System.out.println(tmp.toString());
        }
        studentTable.delete(5);

        }

    }

