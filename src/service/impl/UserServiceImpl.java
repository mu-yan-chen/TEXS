
package service.impl;

import java.util.List;


import dao.UserDao;

import dao.impl.UserDaoImpl;
import entity.User;
import service.UserService;

public class UserServiceImpl implements UserService {
	UserDao dao = new UserDaoImpl();
	public List<User> queryAll() {
		System.out.println("执行queryAll方法");
		return dao.queryAll();
	
	}

//	@Override
	public int insert(User User) {
		// TODO Auto-generated method stub
		System.out.println("执行insert方法");
		return dao.insert(User);
	}


}