package com.springrest.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.springrest.entities.Book;
import com.springrest.springrest.services.BookService;

@RestController
public class MyController {
	@Autowired
	private BookService bookService;
	
@GetMapping("/home")
public String home()
{
	return "welcome to books-shop";
}
	//Get the courses
@GetMapping("/books")
public List<Book> getBooks()
{
	return this.bookService.getBooks();
}
@GetMapping("books/{bookId}")
public Book getBook(@PathVariable String bookId)
{
	return this.bookService.getBook(Long.parseLong(bookId));
}

@PostMapping("/books")
public Book addBook(@RequestBody Book book)
{
	return this.bookService.addBook(book);
}
@PutMapping("/books")
public Book updateBook(@RequestBody Book book)
{
	return this.bookService.updateBook(book);
}
@DeleteMapping("books/{bookId}")
public ResponseEntity<HttpStatus> deleteBook(@PathVariable String bookId)
{
	try {
		this.bookService.deleteBook(Long.parseLong(bookId));
		return new ResponseEntity<>(HttpStatus.OK);
	}
	catch(Exception e)
	{
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
}
