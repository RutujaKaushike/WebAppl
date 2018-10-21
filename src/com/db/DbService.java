package com.db;

import com.restaurant.Restaurant;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DbService {
    public List<Restaurant> getAll() {
        DbManager dbManager = new DbManager();
        List<Restaurant> volist = new ArrayList<Restaurant>();
        ResultSet resultset=null;
        try {
            resultset = dbManager.find("SELECT * FROM restaurant");
            while (resultset.next()) {
                volist.add(new Restaurant(resultset.getString("rname")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            dbManager.closeConnection();
        }
        if(volist.size()==0){
            volist.add(new Restaurant("Starbucks"));
        }
        return volist;
    }

    public Integer getCount() throws SQLException {
        DbManager dbManager = new DbManager();
        ResultSet resultset = dbManager.find("select count(*) as count from account");
        Integer count = 0;
        try {
            while (resultset.next()) {
                count = resultset.getInt("count");
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            dbManager.closeConnection();
        }
        return count;
    }

    public void saveAccount(Restaurant rest) {
        DbManager dbManager = new DbManager();
        dbManager.save("INSERT INTO restaurant(rname) VALUES ('"+ rest.getRname()+ "')");
        dbManager.closeConnection();

    }

}
