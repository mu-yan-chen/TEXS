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
		System.out.println("ִ��queryAll����");
		return dao.queryAll();
	
	}

//	@Override
	public int insert(Book book) {
		// TODO Auto-generated method stub
		System.out.println("ִ��insert����");
		return dao.insert(book);
	}

	@Override
	public int update(Book book) {
		// TODO Auto-generated method stub
		System.out.println("ִ��update����");
		return dao.update(book);
	}

	@Override
	public int delete(int bid) {
		// TODO Auto-generated method stub
		System.out.println("ִ��delete����");
		return dao.delete(bid);
	}

}
