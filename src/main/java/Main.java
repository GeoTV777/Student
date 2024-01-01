import db.MySQLConnector;
import objects.Curator;
import objects.GroupStudent;
import objects.Student;
import tables.CuratorTable;
import tables.GroupTable;
import tables.StudentTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.String.*;

public class Main {
    public static void main(String[] args) {

        StudentTable studentTable = new StudentTable();
        GroupTable groupTable = new GroupTable();
        CuratorTable curatorTable = new CuratorTable();

        try {
            ArrayList<Student> students = studentTable.selectAll();
            if (students.size() <= 15) {
                studentTable.insert(new Student(1, "Светлова Нина Сергеевна", "woman", 1));
                studentTable.insert(new Student(2, "Федоров Василий Иванович", "man", 2));
                studentTable.insert(new Student(3, "Лыжня Алевтина Андреевна", "woman", 3));
                studentTable.insert(new Student(1, "Котик Сергей Николаевич", "man", 4));
                studentTable.insert(new Student(2, "Гаджиев Павел Ашотович", "man", 5));
                studentTable.insert(new Student(3, "Мышкина Алёна Георгиевна", "woman", 6));
                studentTable.insert(new Student(1, "Пвлюхин Дмитрий Антонович", "man", 7));
                studentTable.insert(new Student(2, "Николаева Татьяна Георгиевна", "woman", 8));
                studentTable.insert(new Student(3, "Георгиев Николай Федорович", "man", 9));
                studentTable.insert(new Student(1, "Лопухина Евдокия Фёдоровна", "woman", 10));
                studentTable.insert(new Student(2, "Нарышкин Сергей Алексеевич", "man", 11));
                studentTable.insert(new Student(3, "Луховская Анастасия Юрьевна", "woman", 12));
                studentTable.insert(new Student(1, "Степанов Николай Григорьевич", "man", 13));
                studentTable.insert(new Student(2, "Носикова Анастасия Сергеевна", "woman", 14));
                studentTable.insert(new Student(3, "Григорьевский Юрий Федорович ", "man", 15));
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
            System.out.println();

            studentTable.select(new String[] {"studentFio"},new String[] {"groupId = 3"});
            String[] columns = {"studentFio"};
            String[] where = {"groupId = 3"};

            for (Student tmp : students) {
                System.out.println(tmp.toString());
            }

        } finally {
            MySQLConnector.close();
        }
    }

}

