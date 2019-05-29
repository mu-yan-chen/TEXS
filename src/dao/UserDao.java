package dao;

import java.util.List;


import entity.User;

public interface UserDao {

	List<User> queryAll();
	
	int insert(User User);
	

	
}
