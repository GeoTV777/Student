package tables;

import db.MySQLConnector;
import objects.Student;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class StudentTable extends AbsTable{
    private final static String TABLE_NAME = "student";

    public StudentTable() {
        super(TABLE_NAME);
        columns = new HashMap<>();
        columns.put("groupId", "bigint");
        columns.put("studentFio", "varchar(50)");
        columns.put("sex", "varchar(50)");
        columns.put("studentId", "bigint");

        create();
    }

    public ArrayList<Student> selectAll() {
       String sqlQuery = String.format("SELECT * FROM %s", tableName);
        return selectByQuery(sqlQuery);
    }

    private ArrayList<Student> selectByQuery(String sqlQuery) {
        ArrayList<Student> students = new ArrayList<>();
        ResultSet rs = db.executeRequestWithAnswer(sqlQuery);
        try {
            while (rs.next()) {
                students.add(new Student(
                        rs.getLong("groupId"),
                        rs.getString("studentFio"),
                        rs.getString("sex"),
                        rs.getLong("studentId")
                ));
            }
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
        return students;
    }

    public void insert(Student student) {
            String sqlQuery = String.format("INSERT INTO %s (studentId, studentFio, sex, groupId) VALUES ('%d','%s', '%s', '%d')",
                tableName, student.getStudentId(), student.getFio(), student.getSex(), student.getGroupId());
        db.executeRequest(sqlQuery);
    }
    public void select(String[] columns, String[] whwre) {
        String columnStr = "*";
        if(columns.length >0) {
            columnStr = String. join(",", columns);
        }
        String sqlQuery = String.format("SELECT %s FROM student", columnStr);
        db.executeRequest(sqlQuery);
    }

    public void update(Student student) {
         String sqlQuery = String.format("UPDATE %s SET studentFio = '%s', sex = '%s', groupId = '%d' WHERE studentId = '%d'",
                tableName,
                student.getFio(),
                student.getSex(),
                student.getGroupId(),
                student.getStudentId());
        db.executeRequest(sqlQuery);
     }

//
//// 5 задание, но тут надо подтягивать значения из других таблиц
//// SELECT st.id, st.fio, st.sex, g.name, c.fio
//// FROM student as st
//// JOIN `group` as g ON st.group_id = g.id_group
//// JOIN curator as c ON g.id_curator = c.id_curator;
//
//// 6 задание: вывести на экран количество студентов
////    SELECT COUNT * as student_count FROM student;
//
    public int selectCountStudent() {
        String sqlQuery = String.format("SELECT COUNT(*) AS student_count FROM %s;", tableName);
        ResultSet rs = db.executeRequestWithAnswer(sqlQuery);
        int count = 0;
        try {
            if (rs.next()) {
                count = rs.getInt("student_count");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return count;
    }



    public ArrayList<Student> selectAllWomen(){
        db = new MySQLConnector();
        final String sqlRequest = String.format("SELECT * FROM %s WHERE sex = 'woman' ", tableName);
        ResultSet rs = db.executeRequestWithAnswer(sqlRequest);
        return resultSetToArray(rs);
    }


    public ArrayList select(String sqlQuery) {
    ArrayList<Student> students = new ArrayList<>();
    ResultSet rs = db.executeRequestWithAnswer(sqlQuery);
        try {
        while (rs.next()) students.add(new Student(
                    rs.getLong("studentId"),
                rs.getString("studentFio"),
                rs.getString("sex"),
                rs.getLong("groupId")
        ));
    } catch (SQLException sqlException) {
        sqlException.printStackTrace();
    }
        return students;
    }
    private ArrayList<Student> resultSetToArray(ResultSet rs){
        ArrayList<Student> result = new ArrayList<>();
           try {
               while (rs.next()) {

                result.add(
                        new Student(
                                rs.getLong("studentId"),
                                rs.getString("studentFio"),
                                rs.getString("sex"),
                                rs.getLong("groupId"))
                   );
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
        }
        return result;
    }
    }

