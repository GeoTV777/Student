package tables;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import db.MySQLConnector;
import objects.GroupStudent;
import java.util.ArrayList;
import java.util.Arrays;


public class GroupTable extends AbsTable{

        public GroupTable() {
           super("GroupStudent");
            columns = new HashMap<>();
            columns.put("groupId","bigint PRIMARY KEY AUTO_INCREMENT");
            columns.put("groupName","varchar(25)");
            columns.put("curatorId","bigint");
            create();
        }

    public ArrayList<GroupStudent> selectAllGroup() {
        String sqlQuery = String.format("SELECT * FROM %s", tableName);
        return select(sqlQuery);
    }

    public void insert(GroupStudent groupStudent) {
        db = new MySQLConnector();
        String sqlQuery = String.format("INSERT INTO %s (groupId, groupName, curatorId) VALUES ('%s', '%d', '%s')",
                tableName, groupStudent.getGroupID(), groupStudent.getName(), groupStudent.getCuratorID());
        db.executeRequest(sqlQuery);
        db.close();

    }
    public void update(GroupStudent groupStudent) {
        db = new MySQLConnector();
        String sqlQuery = String.format("UPDATE %s SET '%d', WHERE groupId = '%d'",
                tableName, groupStudent.getCuratorID(), groupStudent.getGroupID());
        db.executeRequest(sqlQuery);
        db.close();
    }

    public ArrayList select(String sqlQuery) {
        ArrayList<GroupStudent> groupStudents = new ArrayList<>();
        db = new MySQLConnector();
        ResultSet rs = db.executeRequestWithAnswer(sqlQuery);
        try {
            while (rs.next()) groupStudents.add(new GroupStudent(
                    rs.getLong("groupId"),
                    rs.getString("groupName"),
                    rs.getLong("curatorId")
            ));
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } finally {
            db.close();
        }
        return groupStudents;
    }
    }

