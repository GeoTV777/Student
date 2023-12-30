import db.MySQLConnector;
import objects.Curator;
import objects.GroupStudent;
import objects.Student;
import tables.CuratorTable;
import tables.GroupTable;
import tables.StudentTable;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        StudentTable studentTable = new StudentTable();
        GroupTable groupTable = new GroupTable();
        CuratorTable curatorTable = new CuratorTable();

        try {
            ArrayList<Student> students = studentTable.selectAll();
            if (students.size() <= 15) {
                studentTable.insert(new Student("Петров Пётр Федорович", "man", 1));
                studentTable.insert(new Student("Федоткин Викто Сергеевич", "man", 2));
                studentTable.insert(new Student("Владимиров Георгий Тимофеевич", "man", 3));
                studentTable.insert(new Student("Кошкина Алёна Геннадьевна", "woman", 1));
                studentTable.insert(new Student("Алёнкина Алёнка Сергеевна", "woman", 2));
                studentTable.insert(new Student("Буратинкин Тимойей Герогиевич", "man", 3));
                studentTable.insert(new Student("Морозова Ирина Констанитовна", "woman", 1));
                studentTable.insert(new Student("Шапкин Александр Павлович", "man", 2));
                studentTable.insert(new Student("Подколодная Валентина Яковлевна", "woman", 3));
                studentTable.insert(new Student("Слуцкий Леонид Эдуардович", "man", 1));
                studentTable.insert(new Student("Гатаулин Рашид Маратович", "man", 2));
                studentTable.insert(new Student("Балашова Надежда Петровна ", "woman", 3));
                studentTable.insert(new Student("Васильев Николай Иванович", "man", 1));
                studentTable.insert(new Student("Светлова Светлана Петровна", "woman", 2));
                studentTable.insert(new Student("Петров Федор Петрович", "man", 3));
                students = studentTable.selectAll();
            }
            for (Student tmp : students) {
                System.out.println(tmp.toString());
            }
            System.out.println();

//            students.get(3).setGroupID(2);
//            studentTable.update(students.get(3));
//
//            students = studentTable.selectAll();
//            for (Student tmp : students) {
//                System.out.println(tmp.toString());
//            }
//        studentTable.delete(5);
//        System.out.println();

//            students = studentTable.selectAll();
//            for (Student tmp : students) {
//                System.out.println(tmp.toString());
//            }

//        } finally {
//            MySQLConnector.close();
//        }
//
//        try {

            ArrayList<GroupStudent> groupStudents = groupTable.selectAllGroup();
            if (groupStudents.size() <= 3) {
                groupTable.insertGroup(new GroupStudent(1, "A", 3));
                groupTable.insertGroup(new GroupStudent(2, "B", 2));
                groupTable.insertGroup(new GroupStudent(3, "C", 1));
                groupStudents = groupTable.selectAllGroup();
            }
            for (GroupStudent tmp : groupStudents){
                System.out.println(tmp.toString());
            }
            System.out.println();
//        } finally {
//            MySQLConnector.close();
//        }
//
//        try {
            ArrayList<Curator> curators = curatorTable.selectAll();
            if (curators.size() <= 4) {
                curatorTable.insertCurator(new Curator(1, "Владимиров Владимир Владимирович"));
                curatorTable.insertCurator(new Curator(2, "Петров Пётр Петрович"));
                curatorTable.insertCurator(new Curator(3, "Сергеев Сергей Сергеевич"));
                curatorTable.insertCurator(new Curator(4, "Федоров Фёдор Федорович"));
                curators = curatorTable.selectAll();
            }
            for (Curator tmp : curators) {
                System.out.println(tmp.toString());
            }

        } finally {
            MySQLConnector.close();
        }
    }

}

