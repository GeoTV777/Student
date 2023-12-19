package tables;

import db.MySQLConnector;
import objects.Student;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class StudentTable extends AbsTable{

    public StudentTable(String tableName) {
        super("Student");
        columns = new HashMap<>();
        columns.put("id", "bigint PRIMARY kEY AUTO_INCREMENT");
        columns.put("studentFio", "varchar(50)");
        columns.put("sex", "varchar(50)");
        columns.put("groupID", "bigint");
        create();
    }
    public void insert(Student student) {
        db = new MySQLConnector();
        String sqlQuery = String.format("INSERT INTO %s (studentFio, sex, groupID) VALUES ($s, %s, %d)",
                tableName,student.getFio(), student.getSex(), student.getGroupID() );
    }

// 5 задание, но тут надо подтягивать значения из других таблиц
// SELECT st.id, st.fio, st.sex, g.name, c.fio
// FROM student as st
// JOIN `group` as g ON st.group_id = g.id_group
// JOIN curator as c ON g.id_curator = c.id_curator;

// 6 задание: вывести на экран количество студентов
//    SELECT COUNT * as student_count FROM student;

    public ArrayList<Student> selectCountStudent() {
        String sqlQuery = String.format(" SELECT COUNT * AS student_count FROM %s;", tableName);
        return select(sqlQuery);
    }
// 7 задание: вывести только студенток
//SELECT student_fio
//    FROM student
//    WHERE sex = 'woman';

    public ArrayList<Student> selectWomen(Student student){
              String sqlQuery = String.format(" SELECT %s FROM %s WHERE %s = 'woman';",student.getFio(), tableName, student.getSex());
        return select(sqlQuery);
    }



    public ArrayList select(String sqlQuery) {
    ArrayList<Student> students = new ArrayList<>();
    db = new MySQLConnector();
    ResultSet rs = db.executeRequestWithAnswer(sqlQuery);
        try {
        while (rs.next()){
            students.add(new Student(
                    rs.getLong("id"),
                    rs.getString("studentFio"),
                    rs.getString("sex"),
                    rs.getLong("groupID")
            ));
        }
    } catch (SQLException sqlException) {
        sqlException.printStackTrace();
    } finally {
        db.close();
    }
        return students;
    }

}
