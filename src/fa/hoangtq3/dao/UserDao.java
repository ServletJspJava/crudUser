
/*
	* (C) copyright 2018 Fresher Academy.
	* 
	* @author hoangcode
	* @date Apr 7, 2018
	* @version 1.0
*/

package fa.hoangtq3.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import fa.hoangtq3.database.DBConnection;
import fa.hoangtq3.model.UserModel;

public class UserDao {
	private Connection connection;

	public UserDao() {
		connection = DBConnection.createConnection();
	}

	public void addUser(UserModel userModel) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into users(fullname,gender,email,username,password,role) values (?, ?, ?, ? ,?,?)");
			// Parameters start with 1
			preparedStatement.setString(1, userModel.getFullname());
			preparedStatement.setString(2, userModel.getGender());
			preparedStatement.setString(3, userModel.getEmail());
			preparedStatement.setString(4, userModel.getUsername());
			preparedStatement.setString(5, userModel.getPassword());
			preparedStatement.setString(6, userModel.getRole());
			
			
			
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteUser(int idus) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("delete from users where idus=?");
			// Parameters start with 1
			preparedStatement.setInt(1, idus);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<UserModel> getAllUsers() {
		List<UserModel> users = new ArrayList<UserModel>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from users");
			while (rs.next()) {
				UserModel user = new UserModel();
				user.setIdus(rs.getInt("idus"));
				user.setFullname(rs.getString("fullname"));
				user.setGender(rs.getString("gender"));
				user.setEmail(rs.getString("email"));
				user.setUsername(rs.getString("username"));
				user.setRole(rs.getString("role"));
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return users;
	}
	public void updateUser(UserModel userModel) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("update users set fullname=?, gender=?, email=?, username=?, password=?,role=?" +
							"where idus=?");
			// Parameters start with 1
			
			preparedStatement.setString(1, userModel.getFullname());
			preparedStatement.setString(2, userModel.getGender());
			preparedStatement.setString(3, userModel.getEmail());
			preparedStatement.setString(4, userModel.getUsername());
			preparedStatement.setString(5, userModel.getPassword());
			preparedStatement.setString(6, userModel.getRole());
			preparedStatement.setInt(7, userModel.getIdus());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public UserModel getUserById(int idus) {
		UserModel user = new UserModel();
		try {
			PreparedStatement preparedStatement = connection.
					prepareStatement("select * from users where idus=?");
			preparedStatement.setInt(1, idus);
			ResultSet rs = preparedStatement.executeQuery();
			
			if (rs.next()) {
				user.setIdus(rs.getInt("idus"));
				user.setFullname(rs.getString("fullname"));
				user.setGender(rs.getString("gender"));
				user.setEmail(rs.getString("email"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setRole(rs.getString("role"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;
	}

}
