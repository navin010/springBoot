package com.lms.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lms.services.LmsService;
import com.lms.models.Book;

import java.util.Collection;


@RestController
public class MainRestController {
	
	@Autowired
	LmsService lmsService;
	
	@GetMapping(value="/")
	public String hello() {
		return "Hello World!";
	}
	
	@GetMapping(value="/findAllBooks")
	public Collection<Book> getAllBooks() {
		return lmsService.findAllBooks();
	}

}
