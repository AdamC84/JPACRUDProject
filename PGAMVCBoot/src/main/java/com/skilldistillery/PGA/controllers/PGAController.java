package com.skilldistillery.PGA.controllers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
//
//	@RequestMapping(path = "/", method = RequestMethod.GET)
//	public String index() {
//		return "WEB-INF/home.jsp";
//	}

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String createGolfer(Golfer golfer) {
		ModelAndView mv = new ModelAndView();
		Golfer newGolfer = null;
		try {
			newGolfer = pd.createGolfer(golfer);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mv.addObject("newGolfer", newGolfer);
		return "WEB-INF/addGolferForm.jsp";
	}

	@RequestMapping(path = "findGolferById.do", method = RequestMethod.GET)
	public String getgolferById(@RequestParam("id") int id) {
		ModelAndView mv = new ModelAndView();
		Golfer golfer = null;
		try {
			golfer = pd.findGolferById(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mv.addObject("newGolfer", golfer);
		return "WEB-INF/results.jsp";
	}

	@RequestMapping(path = "deleteGolfer.do", method = RequestMethod.GET)
	public String deleteGolfer(@RequestParam("golfer") Golfer golfer) {
		try {
			pd.deleteGolfer(golfer);
			;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "WEB-INF/results.jsp";
	}

	@RequestMapping(path = "updateGolfer.do", method = RequestMethod.GET)
	public String updateGolfer(@RequestParam("golfer") Golfer golfer) {
		ModelAndView mv = new ModelAndView();
		try {
			golfer = pd.updateGolfer(golfer);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mv.addObject("newGolfer", golfer);
		return "WEB-INF/Edit.jsp";
	}

	@RequestMapping(path = "keyword.do", method = RequestMethod.GET)
	public String searchByKeyword(@RequestParam("keyword") String keyword) {
		ModelAndView mv = new ModelAndView();
		List<Golfer> golfer = new ArrayList<>();
		try {
			golfer = pd.findGolferByKeyword(keyword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mv.addObject("newGolfer", golfer);
		return "WEB-INF/Edit.jsp";
	}

}
