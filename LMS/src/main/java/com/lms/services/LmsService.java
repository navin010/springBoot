package com.lms.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.dao.LmsRepository;
import com.lms.models.Book;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class LmsService {
	
	@Autowired									//ensure dependencies from LmsRepository are loaded
	private LmsRepository lmsRepository;		//create instance of LmsRepository(dao)
	
	public Collection<Book> findAllBooks(){
		List<Book> books = new ArrayList<>();
		for (Book book : lmsRepository.findAll()) {
			books.add(book);
		}
		return books;
	}
	
	
	
}
