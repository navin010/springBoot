package com.lms.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.dao.LmsRepository;
import com.lms.models.Book;

import java.util.Collection;

@Service
public class LmsService {
	
	@Autowired									//ensure dependencies from LmsRepository are loaded
	private LmsRepository lmsRepository;		//create instance of LmsRepository(dao)
	
	private Collection<Book> 

}
