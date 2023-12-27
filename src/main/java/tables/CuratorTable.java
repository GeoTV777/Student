package tables;

import db.MySQLConnector;
import objects.Curator;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CuratorTable extends AbsTable {
    public CuratorTable() {
        super("Curator");
        columns.put("curatorId", "bigint PRIMARY KEY AUTO_INCREMENT");
        columns.put("curatorFio", "varchar(50)");
        create();
    }

    public ArrayList<Curator> selectAllCurator() {
        String sqlQuery = String.format("SELECT * FROM %s", tableName);
        return select(sqlQuery);
    }

    public void insert(Curator curator) {
        db = new MySQLConnector();
        String sqlQuery = String.format("INSERT INTO %s (curatorId, curatorFio) VALUES ('%s', '%d')",
                tableName, curator.getCuratorID(),curator.getCuratorFio());
        db.executeRequest(sqlQuery);
        db.close();

    }
    public void update(Curator curator) {
        db = new MySQLConnector();
        String sqlQuery = String.format("UPDATE %s SET '%d', WHERE curatorId = '%d'",
                tableName, curator.getCuratorID());
        db.executeRequest(sqlQuery);
        db.close();
    }

        public ArrayList select (String sqlQuery){
            ArrayList<Curator> curators = new ArrayList<>();
            db = new MySQLConnector();
            ResultSet rs = db.executeRequestWithAnswer(sqlQuery);
            try {
                while (rs.next()) curators.add(new Curator(
                        rs.getLong("curatorId"),
                        rs.getString("curatorFio")
                ));

            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            } finally {
            }
            return curators;
        }
    }
