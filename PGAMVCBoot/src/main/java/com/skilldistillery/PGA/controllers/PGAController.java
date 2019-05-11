package com.skilldistillery.PGA.controllers;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.PGA.data.PGADAO;
import com.skilldistillery.PGA.entities.Golfer;

@Controller
public class PGAController {

	@Autowired
	private PGADAO pd;

	@RequestMapping(path = "findGolferById", method = RequestMethod.GET)
	public String getgolferById(@RequestParam("id") int id) {
		ModelAndView mv = new ModelAndView();
		Golfer golfer = null;
		try {
			golfer = pd.findGolferById(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mv.addObject("golfer", golfer);
		return "WEB-INF/results.jsp";
	}

//	@RequestMapping(path = "getGolfer.do", method = RequestMethod.GET)
//	public ModelAndView getFilm(@RequestParam("fid") int fid) {
//		ModelAndView mv = new ModelAndView();
//
//		Film film = filmDAO.findById(fid);
//
//		mv.addObject("film", film);
//		mv.setViewName("WEB-INF/film/show.jsp");
//		return mv;
//	}

}
