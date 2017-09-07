package dao;

import po.Category;
import util.DButil;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by LENOVO on 2017/9/5.
 */
public class CategoryDao {
    public List<Category> getAll(){
        String sql = "select * from category ";
        //要把这个定义写到这里，如果写到try，catch中，就成为局部函数，不能当做返回值了
        List<Category> categoryList = new ArrayList<>();
        try (Connection connection = DButil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            ResultSet resultSet = preparedStatement.executeQuery();
             while(resultSet.next()){
                 Category category = new Category();
                 category.setId(resultSet.getInt("id"));
                 category.setName(resultSet.getString("name"));
                 category.setAge(resultSet.getInt("age"));
                 category.setPassword(resultSet.getString("password"));
                 categoryList.add(category);
             }
        }catch(SQLException e){
                 e.printStackTrace();
        }
        return categoryList;
    }

}

