package com.lms.controllers;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lms.models.Book;
import com.lms.services.LmsService;

@Controller
public class MainController {
	
	@Autowired
	private LmsService lmsService;
	
	@GetMapping("/")
	public String init(HttpServletRequest req) {
		req.setAttribute("books", lmsService.findAllBooks());			//add books from service to http request attribute
		req.setAttribute("mode", "BOOK_VIEW");
		return "index";
	}
	
	@GetMapping("/updateBook")
	public String init(@RequestParam long id, HttpServletRequest req) {
		req.setAttribute("book", lmsService.findOne(id).get());			//add books from service to http request attribute
		req.setAttribute("mode", "BOOK_EDIT");
		return "index";
	}
	
	/*
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-mm-dd"), false));
	}
	*/
	
	@PostMapping("/save")
	public void save(@ModelAttribute Book book, HttpServletRequest req, HttpServletResponse resp) throws IOException, ParseException {
		lmsService.save(book);
		req.setAttribute("books", lmsService.findAllBooks());	
		req.setAttribute("mode", "BOOK_VIEW");
		resp.sendRedirect("/");
	}
	
	
}
