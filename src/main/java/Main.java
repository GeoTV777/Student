import objects.Curator;
import objects.GroupStudent;
import objects.Student;
import tables.AbsTable;
import tables.CuratorTable;
import tables.GroupTable;
import tables.StudentTable;

import java.util.ArrayList;
import java.util.Objects;

public class Main {
    public static void main(String[] args){
        StudentTable studentTable = new StudentTable();
        ArrayList <Student> student = studentTable.selectAll();

        if(student.size() <15) {
        studentTable.insert(new Student( "Петров Пётр Федорович", "man",1));
        studentTable.insert(new Student( "Федоткин Викто Сергеевич", "man",2));
        studentTable.insert(new Student("Владимиров Георгий Тимофеевич", "man",3));
        studentTable.insert(new Student( "Кошкина Алёна Геннадьевна", "woman",1));
        studentTable.insert(new Student( "Алёнкина Алёнка Сергеевна", "woman",2));
        studentTable.insert(new Student("Буратинкин Тимойей Герогиевич", "man",3));
        studentTable.insert(new Student("Морозова Ирина Констанитовна", "woman",1));
        studentTable.insert(new Student("Шапкин Александр Павлович", "man",2));
        studentTable.insert(new Student("Подколодная Валентина Яковлевна", "woman",3));
        studentTable.insert(new Student("Слуцкий Леонид Эдуардович", "man",1));
        studentTable.insert(new Student( "Гатаулин Рашид Маратович", "man",2));
        studentTable.insert(new Student("Балашова Надежда Петровна ", "woman",3));
        studentTable.insert(new Student( "Васильев Николай Иванович", "man",1));
        studentTable.insert(new Student("Светлова Светлана Петровна", "woman",2));
        studentTable.insert(new Student( "Петров Федор Петрович", "man",3));
        student = studentTable.selectAll();
        }
        for (Student tmp : student) {
            System.out.println(tmp.toString());
        }
        System.out.println();
//  ошибок не вызывает, но и не работает
        student.get(3).setGroupID(1);
        studentTable.update(student.get(3));
// почему-то в консоли все id = 0
        student = studentTable.selectAll();
        for (Student tmp: student) {
            System.out.println(tmp.toString());
        }
//        studentTable.delete();

        }


    private AbsTable groupStudent;
        ArrayList<Student> groupStudents = groupStudent.selectAll();
        if(groupStudents.size() <3) {
        groupStudents.set(new GroupStudent("1","Первая","1");
        groupStudents.set(new GroupStudent("2","Вторая","2");
        groupStudents.set(new GroupStudent("3","Третья","3");
        groupStudents = groupStudents.selectAll();
        }
        CuratorTable curatorTable = new CuratorTable();
         ArrayList<Objects> curators = curatorTable.selectAll();
        if(curators.size() < 4) {
        curatorTable.insert(new CuratorTable("1", "Петров Петр Петрович"));
        curatorTable.insert(new CuratorTable("2", "Иванов Иван Иванович"));
        curatorTable.insert(new CuratorTable("3", "Георгиев Георгий Георгиевич"));
        curatorTable.insert(new CuratorTable("4", "Федоров Федор Федорович"));
        curatorTable = curatorTable.selectAll();
        
    }

    }

