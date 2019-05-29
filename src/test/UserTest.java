package test;


import java.math.BigDecimal;

import org.junit.Test;


import entity.Book;

import factory.ProFactory;
import proxy.JdkProxy;
import service.BookService;
import service.UserService;
import service.impl.BookServiceImpl;
import service.impl.UserServiceImpl;

public class UserTest {


		//工厂创建Book对象
	@Test
		public  void text1() {
			Book b=ProFactory.CreateBook("book");
			b.setBname("Java");
			b.setAuthor("hqc");
			b.setPrice(new BigDecimal(100));
			JdkProxy j=new JdkProxy();
			BookService proxy=(BookService)j.bind(new BookServiceImpl());
		    proxy.insert(b);
		  
		
		}
	@Test
	public  void text2() {
		
		
		JdkProxy j=new JdkProxy();
		UserService p=(UserService)j.bind(new UserServiceImpl());
	   System.out.println(p.queryAll()); 
	
	
	}
		
	
	
	

	
}
