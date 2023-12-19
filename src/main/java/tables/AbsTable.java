package tables;

import db.IDBConnector;
import db.MySQLConnector;

import java.sql.SQLException;
import java.util.Map;

public class AbsTable {
    protected String tableName;
    protected Map<String, String> columns;
    IDBConnector db;

    public AbsTable(String tableName) {
        this.tableName = tableName;
    }

    public void create() {
        String sqlRequest = String.format("CREATE TABLE IF NOT EXIST %S (%S)", this.tableName, convertMapColumnsToString());
        db = new MySQLConnector();
        db.executeRequest(sqlRequest);
        db.close();
    }

    private String convertMapColumnsToString() {
        String result = (String)this.columns.entrySet().stream().map((entry) -> {
            return String.format("%s %s", entry.getKey(), entry.getValue());
        }).collect(Collectors.joining(", "));
        return result;
    }

    public void writeAll() {
        db = new MySQLConnector();
        final String sqlRequestWiteAnswer(sqlRequest);

        try {
            int columns = rs.getMetaData().getColumnCount();

            while (rs.next()) {
                for (int i = 1; 1<= columns; i++) {
                    System.out.println( rs.getString(i) + "\t");
                }
                System.out.println();
            }
        }catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            db.close();
        }
    }
}
