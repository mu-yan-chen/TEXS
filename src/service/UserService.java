package service;

import java.util.List;

import entity.Book;
import entity.User;

public interface UserService {

	  List<User> queryAll();
		
		int insert(User User);
		
		
	
}
