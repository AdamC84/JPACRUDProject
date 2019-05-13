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

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String index() {
		return "WEB-INF/home.jsp";
	}
	@RequestMapping(path = "home.do", method = RequestMethod.GET)
	public String home() {
		return "WEB-INF/home.jsp";
	}

//	@RequestMapping(path = "/", method = RequestMethod.GET)
//	public String createGolfer(Golfer golfer) {
//		ModelAndView mv = new ModelAndView();
//		Golfer newGolfer = null;
//		try {
//			newGolfer = pd.createGolfer(golfer);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		mv.addObject("newGolfer", newGolfer);
//		return "WEB-INF/addGolferForm.jsp";
//	}

	@RequestMapping(path = "findGolferByID.do", method = RequestMethod.GET)
	public ModelAndView getgolferById(@RequestParam("id") int id) {
		ModelAndView mv = new ModelAndView();
		Golfer golfer = null;
		try {
			golfer = pd.findGolferById(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mv.addObject("newGolfer", golfer);
		mv.setViewName("WEB-INF/results.jsp");
		return mv;
	}

	@RequestMapping(path = "deleteGolfer.do", method = RequestMethod.GET)
	public ModelAndView deleteGolfer(@RequestParam("golfer") Golfer golfer) {
		ModelAndView mv = new ModelAndView();
		try {
			pd.deleteGolfer(golfer);
			;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mv.setViewName("WEB-INF/results.jsp");
		return mv;
	}

	@RequestMapping(path = "updateGolfer.do", method = RequestMethod.GET)
	public ModelAndView updateGolfer(int id) throws SQLException {
		Golfer golf = pd.findGolferById(id);
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("newGolfer", golf);
		mv.setViewName("WEB-INF/Edit.jsp");
		return mv;
	}

	@RequestMapping(path = "keyword.do", method = RequestMethod.GET)
	public ModelAndView searchByKeyword(@RequestParam("keyword") String keyword) {
		ModelAndView mv = new ModelAndView();
		List<Golfer> golfer = new ArrayList<>();
		try {
			golfer = pd.findGolferByKeyword(keyword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(golfer);
		mv.addObject("golferList", golfer);
		mv.setViewName("WEB-INF/keyword.jsp");
		return mv;
	}

}
