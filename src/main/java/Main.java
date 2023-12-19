import objects.Student;
import tables.StudentTable;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        StudentTable studentTable = new StudentTable();
        studentTable.insert(new Student("1", "Петров Пётр Федорович", "man","1"));
        studentTable.insert(new Student("2", "Федоткин Викто Сергеевич", "man","2"));
        studentTable.insert(new Student("3", "Владимиров Георгий Тимофеевич", "man","3"));
        studentTable.insert(new Student("4", "Кошкина Алёна Геннадьевна", "woman","4"));
        studentTable.insert(new Student("5", "Алёнкина Алёнка Сергеевна", "woman","1"));
        studentTable.insert(new Student("6", "Буратинкин Тимойей Герогиевич", "man","2"));
        studentTable.insert(new Student("7", "Морозова Ирина Констанитовна", "woman","3"));
        studentTable.insert(new Student("8", "Шапкин Александр Павлович", "man","4"));
        studentTable.insert(new Student("9", "Подколодная Валентина Яковлевна", "woman","1"));
        studentTable.insert(new Student("10", "Слуцкий Леонид Эдуардович", "man","2"));
        studentTable.insert(new Student("11", "Гатаулин Рашид Маратович", "man","3"));
        studentTable.insert(new Student("12", "Балашова Надежда Петровна ", "woman","4"));
        studentTable.insert(new Student("13", "Васильев Николай Иванович", "man","1"));
        studentTable.insert(new Student("14", "Светлова Светлана Петровна", "woman","3"));
        studentTable.insert(new Student("15", "Петров Федор Петрович", "man","2"));

        ArrayList<Student> students = studentTable.selectCountStudent();
        for(Student tmp: students) {
            System.out.println(tmp.toString());
        }

    }
}
