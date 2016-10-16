package com.nabil.anl.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nabil.anl.jdbi.DBManager;
import com.nabil.anl.model.Book;
import com.nabil.anl.model.Person;

@Controller
public class IndexController {
	
	
	@RequestMapping("/index")
	public String index(Model model)
	{
		
		List<Person> pList = DBManager.getAllPersonList();
		model.addAttribute("personList", pList);
		System.out.println("in index");
		return "index";
	}
	
	@RequestMapping(value="/index/{id}")
	public String getBookList(Model model, @PathVariable int id)
	{
		System.out.println("in requetmapping" + id);
		List<Book> pbList = DBManager.getAllLendBookListByPerson(id);
		List<Person> pList = DBManager.getAllPersonList();
		model.addAttribute("bookList", pbList);
		model.addAttribute("personList", pList);
		System.out.println("in requetmapping bookList size " + pbList.size());
		return "index";
	}
	
	
}
