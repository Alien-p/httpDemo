package com.mysoft;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAO {

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");

        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/WebDB", "root", "root");
    }

    public static List<Post> getPosts()throws ClassNotFoundException, SQLException{
        Connection connect = getConnection();
        PreparedStatement prepStat = connect.prepareStatement("SELECT id,txt FROM posts");
        ResultSet result = prepStat.executeQuery();
        ArrayList<Post> posts = new ArrayList<>();
        while(result.next())
        {
            int id = result.getInt(1);
            String text = result.getString(2);
            posts.add(new Post(id,text));
        }
        return posts;
    }

    public static void deletePost(Integer id){
        try{
            Connection connect = getConnection();
            PreparedStatement prepStat = connect.prepareStatement("DELETE FROM posts WHERE id=" + id +";");
            prepStat.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static void setPosts(String txt){
        try{
            Connection connect = getConnection();
            PreparedStatement prepStat = connect.prepareStatement("INSERT INTO posts(txt) VALUES ('" + txt + "');");
            prepStat.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
