package com.skilldistillery.film.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.film.data.FilmDAO;

@Controller
public class FilmController {
	
	@Autowired
	private FilmDAO filmDao;
	
	@RequestMapping(path = {"home.do", "/"} )
	public String goToHome() {
		return "WEB-INF/home.jsp";
	}
	
	@RequestMapping(path = "GetFilmData.do", params = "filmId", method = RequestMethod.GET)
	public ModelAndView getFilmById(@RequestParam("filmId") int filmNumber) {
//		System.out.println(filmNumber);  //Debugging Line
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("WEB-INF/individualFilmResult.jsp");
		modelAndView.addObject("film", filmDao.findFilmById(filmNumber));
//		System.out.println(filmDao.findFilmById(filmNumber));  //Debugging Line
		return modelAndView;
	}
	
	@RequestMapping(path = "GetFilmData.do", params = "searchString", method = RequestMethod.GET)
	public ModelAndView getFilmBySearchString(@RequestParam("searchString") String searchString) {
//		System.out.println(searchString); //Debug Line
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("WEB-INF/filmResult.jsp");
		modelAndView.addObject("films", filmDao.findFilmByString(searchString));
		modelAndView.addObject("searchString", searchString );
//		System.out.println(filmDao.findFilmByString(searchString)); //Debug Line
		return modelAndView;
	}
}
