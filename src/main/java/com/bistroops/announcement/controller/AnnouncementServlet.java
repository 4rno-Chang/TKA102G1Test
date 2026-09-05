package com.bistroops.announcement.controller;

import java.io.*;
import java.util.*;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import com.bistroops.announcement.model.*;

@WebServlet("/ann/ann.do")
public class AnnouncementServlet extends HttpServlet {
	AnnouncementService annService = new AnnouncementService();
	//	private AnnouncementService annService;
//	@Override
//	public void init() throws ServletException {
//		annService = new AnnouncementServiceImpl();
//	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		String forwardPath = "";
		switch (action) {
		case "getAll":
			forwardPath = getAll(req, res);
			break;
//		case "annNoQuery":
//			forwardPath = qetOne(req, res);
		default:
			forwardPath = "/announcement/index.jsp";
		}

		res.setContentType("text/html; charset=UTF-8");
		RequestDispatcher dispatcher = req.getRequestDispatcher(forwardPath);
		dispatcher.forward(req, res);
	}

	private String getAll(HttpServletRequest req, HttpServletResponse res) {
		List<AnnouncementVO> annList = annService.getAll();
		req.setAttribute("annList", annList);
		
		return "/announcement/listAllAnns.jsp";
	}

	
	private String annNoQuery(HttpServletRequest req, HttpServletResponse res) {
		annService.getAnnNoQuery((Integer)req.getAttribute("annNo"));
		
		return "/announcement/listOneAnn.jsp";
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}
	
}