package factory;

import entity.Book;
import entity.User;



public class ProFactory  {
public static Book CreateBook(String obj){
	
	return new Book();
}
public static User CreateUser(String obj){
	
	return new User();
}
}
