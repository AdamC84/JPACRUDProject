package com.skilldistillery.PGA.controllers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	@RequestMapping(path = "addGolferForm.do", method = RequestMethod.GET)
	public ModelAndView addFilmForm() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("golfer", new Golfer());
		mv.setViewName("WEB-INF/addGolferForm.jsp");
		return mv;
	}


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

	@RequestMapping(path ="editGolfer.do", method = RequestMethod.POST)
	public ModelAndView editGolferForm(@RequestParam("value")int id) throws SQLException {
		ModelAndView mv = new ModelAndView();
//		int id = Integer.parseInt(value);
		Golfer golfer = pd.findGolferById(id);
		System.out.println(golfer);
		mv.addObject("golfer", golfer);
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
//		System.out.println(golfer);
		mv.addObject("golferList", golfer);
		mv.setViewName("WEB-INF/keyword.jsp");
		return mv;
	}
	@RequestMapping("updateGolfer.do")
	public ModelAndView updateGolferForm(@ModelAttribute("golfer") Golfer golfer) throws SQLException {
		ModelAndView mv = new ModelAndView();
		try {
			pd.updateGolfer(golfer);
			mv.setViewName("WEB-INF/update.jsp");
		} catch (Exception e) {
			mv.setViewName("WEB-INF/error.jsp");
		}

		return mv;
	}
	@RequestMapping(path = "createGolfer.do", method = RequestMethod.GET)
	public ModelAndView createGolferForm(@ModelAttribute("golfer") Golfer golfer) throws SQLException {
		ModelAndView mv = new ModelAndView();
		try {
			pd.createGolfer(golfer);
			mv.setViewName("WEB-INF/update.jsp");
		} catch (Exception e) {
			mv.setViewName("WEB-INF/error.jsp");
		}
		
		return mv;
	}

}
