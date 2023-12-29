package tables;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import db.MySQLConnector;
import objects.Curator;
import objects.GroupStudent;

import javax.swing.*;
import java.util.ArrayList;


public class GroupTable extends AbsTable{

    private GroupStudent groupStudent;

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
        return selectByQuery(sqlQuery);
    }
    private ArrayList<GroupStudent> selectByQuery(String sqlQuery) {
        ArrayList<GroupStudent> groupStudents = new ArrayList<>();
         ResultSet rs = db.executeRequestWithAnswer(sqlQuery);
        try {
            while (rs.next()) {
                groupStudents.add(new GroupStudent(
                        rs.getLong("groupId"),
                        rs.getString("groupName"),
                        rs.getLong("curatorId")
                ));
            }
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
        return groupStudents;
    }

    public void insertGroup(GroupStudent groupStudent) {
        this.groupStudent = groupStudent;
        String sqlQuery = String.format("INSERT INTO %s (groupId, groupName, curatorId) VALUES (%d, '%s', %d)",
                tableName, groupStudent.getGroupID(), groupStudent.getName(), groupStudent.getCuratorID());
        db.executeRequest(sqlQuery);
        db.close();

    }
    public void update(GroupStudent groupStudent) {
            String sqlQuery = String.format("UPDATE %s SET %d, WHERE groupId = %d",
                tableName, groupStudent.getCuratorID(), groupStudent.getGroupID());
        db.executeRequest(sqlQuery);
        db.close();
    }

    public ArrayList <GroupStudent> select(String sqlQuery) {
        ArrayList<GroupStudent> groupStudents = new ArrayList<>();
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

