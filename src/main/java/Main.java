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
            System.out.println("Студенты");
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
            System.out.println("Группы студентов");

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
            System.out.println("Кураторы");

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
            System.out.println("Вывод только студенток");
            System.out.println();

            ArrayList<Student> womenStudent = studentTable.selectAllWomen();

            for (Student student : womenStudent){
                    System.out.println("" + student.getFio());
            }
            System.out.println();
            System.out.println("Вывод количества студентов");
            System.out.println();

            int count= studentTable.selectCountStudent();
            System.out.println("Количество студентов:" + count);

            System.out.println();
            System.out.println("Вывод информации о всех студентах с названиями групп и фио кураторов");
            System.out.println();

            studentTable.printStudentGroupNameCuratorFio();

            System.out.println();
            System.out.println("Обновить данные по группе C, сменив куратора на Федорова Федора Федоровича ");
            System.out.println("Вывод результата замены: группы и их кураторы  после смены куратора");
            System.out.println();

            curatorTable.updateCuratorInGroupC();
            groupTable.printRezultExchang();

            System.out.println();
            System.out.println("Вывод студентов из группы В");
            System.out.println();

            studentTable.printStudentGroupB();

        } finally {
            MySQLConnector.close();
        }
    }
}

