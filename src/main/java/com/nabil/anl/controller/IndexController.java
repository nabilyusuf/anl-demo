package com.nabil.anl.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nabil.anl.config.Configuration;
import com.nabil.anl.jdbi.DBManager;
import com.nabil.anl.model.Book;
import com.nabil.anl.model.DatabaseInfo;
import com.nabil.anl.model.Person;

@Controller
public class IndexController {
	
	@ModelAttribute("databaseInfo")
	public DatabaseInfo construct( ){return new DatabaseInfo();}
	
	
	@RequestMapping("/index")
	public String index(Model model)
	{
		Properties prop = Configuration.getpropertyfile();
		String path = "index";
		if (prop.getProperty("resetDatabase").equalsIgnoreCase("true"))
		{
			
			path="config";
		}
		else
		{
		List<Person> pList = DBManager.getAllPersonList();
		model.addAttribute("personList", pList);
		System.out.println("in index");
		}
		return path;
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
	
	
	
	@RequestMapping(value="/index", method=RequestMethod.POST)
	public String setDatabaseInfo(@ModelAttribute("databaseInfo") DatabaseInfo dbinfo )
	{
		String path = "config";
		boolean status = false;
		status =  Configuration.setupDatabaseDatabaseInfo(dbinfo);
		System.out.println("status is " +status);
		if (status)
		{ Configuration.setresetDatabaseFalse();
		
		    path = "redirect:index.html";
		}
		
		return path;
	}
}
