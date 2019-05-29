package dao.impl;

import java.util.List;

import dao.BaseDao;
import dao.UserDao;
import entity.Book;
import entity.User;

public class UserDaoImpl extends BaseDao implements UserDao {

	@Override
	public int insert(User user) {
		String sql = "insert into user1(username,password) values(?,?)";
		return executeUpdate(sql, user.getUsername(),user.getPassword());
	}


	@Override
	public List<User> queryAll() {
		String sql = "select * from user1";
		return executeQuery(sql, User.class);
	}

	


}
