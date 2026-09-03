package com.bistroops.announcement.controller;

import java.io.*;
import java.util.*;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import com.bistroops.announcement.model.*;

@WebServlet("/ann/ann.do")
public class AnnouncementServlet extends HttpServlet {
//	private AnnouncementService annService;
	
//	public AnnouncementServlet() {
		AnnouncementService annService = new AnnouncementService();
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
		default:
			forwardPath = "/index.jsp";
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

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}
}