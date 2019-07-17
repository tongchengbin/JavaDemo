package dao;

import bean.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class UserDao {


    public UserDao() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://47.107.75.121:3306/ssm?characterEncoding=UTF-8", "ssm",
                "123456");
    }

    public List<User> list() {
        List<User> users = new ArrayList<User>();
        User user = null;

        try (Connection c = getConnection(); Statement s = c.createStatement();) {

            String sql = "select id,name,age,sex from user";

            ResultSet rs = s.executeQuery(sql);
            if (rs.next()) {
                user = new User();
                Integer id = rs.getInt(1);
                String name=rs.getString(2);
                Integer age=rs.getInt(3);
                String sex = rs.getString(4);
                System.out.println(name);
                user.setName(name);
                user.setAge(age);
                user.setSex(sex);
                user.setId(id);
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

}
