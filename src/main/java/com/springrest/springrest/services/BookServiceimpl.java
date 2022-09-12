package com.springrest.springrest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.springrest.springrest.entities.Book;
@Service
public class BookServiceimpl implements BookService {

	List<Book> list;
	
	public BookServiceimpl() {
		list=new ArrayList<>();
		list.add(new Book(1,"English","jabed"));
		list.add(new Book(2,"Hindi","Asif"));
	}

	@Override
	public List<Book> getBooks() {
		
		return list;
	}

	@Override
	public Book getBook(long bookId) {
		Book c=null;
		for(Book book:list)
		{
			if(book.getId()==bookId)
			{
				c=book;
				break;
			}
		}
		
		return c;
	
	
	}

	@Override
	public Book addBook(Book book) {
		list.add(book);
		return book;
	}

	@Override
	public Book updateBook(Book book) {
		list.forEach(e ->{
			if(e.getId()==book.getId()) {
				e.setTitle(book.getTitle());
				e.setAuthor(book.getAuthor());
			}
		});
		return book;
	}

	@Override
	public void deleteBook(long parseLong) {
		list=this.list.stream().filter(e->e.getId()!=parseLong).collect(Collectors.toList());
		
	}


}
