package service.impl;

import java.util.List;

import dao.BookDao;
import dao.impl.BookDaoImpl;
import entity.Book;
import service.BookService;

public class BookServiceImpl implements BookService {

	BookDao dao = new BookDaoImpl();
	
	@Override
	public List<Book> queryAll() {
		System.out.println("执行queryAll方法");
		return dao.queryAll();
	
	}

//	@Override
	public int insert(Book book) {
		// TODO Auto-generated method stub
		System.out.println("执行insert方法");
		return dao.insert(book);
	}

	@Override
	public int update(Book book) {
		// TODO Auto-generated method stub
		System.out.println("执行update方法");
		return dao.update(book);
	}

	@Override
	public int delete(int bid) {
		// TODO Auto-generated method stub
		System.out.println("执行delete方法");
		return dao.delete(bid);
	}

}
