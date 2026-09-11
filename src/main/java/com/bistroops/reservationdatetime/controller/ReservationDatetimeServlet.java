package com.bistroops.reservationdatetime.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import com.bistroops.reservationdatetime.model.ReservationDatetimeService;
import com.bistroops.reservationdatetime.model.ReservationDatetimeVO;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/rsv/rsv.do")
public class ReservationDatetimeServlet extends HttpServlet {
	ReservationDatetimeService rsvService = new ReservationDatetimeService();

//	private ReservationdatetimeService rsvService;
//	@Override
//	public void init() throws ServletException {
//		rsvService = new ReservationdatetimeService();
//	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		if (action == null) {
		    action = "getAll";
		}
		String forwardPath = "";
		
		switch (action) {
		case "getAll":
			forwardPath = getAll(req, res);
			break;
		case "rsvNoQuery":
			forwardPath = rsvNoQuery(req, res);
			break;

		case "insertRsv":
			forwardPath = insertRsv(req, res);
			break;
		case "updateRsv":
			forwardPath = updateRsv(req, res);
			break;
		case "deleteRsv":
			forwardPath = deleteRsv(req, res);
			break;
		default:
			forwardPath = "/reservationdatetime/index.jsp";

		}

		res.setContentType("text/html; charset=UTF-8");
		RequestDispatcher dispatcher = req.getRequestDispatcher(forwardPath);
		dispatcher.forward(req, res);
	}

	private String getAll(HttpServletRequest req, HttpServletResponse res) {
		List<ReservationDatetimeVO> rsvList = rsvService.getAll();
		req.setAttribute("rsvList", rsvList);

		return "/reservationdatetime/index.jsp";
	}

	private String rsvNoQuery(HttpServletRequest req, HttpServletResponse res) {
		// 防呆
		String rsvDtNoStr = req.getParameter("rsvDtNo");
		if (rsvDtNoStr == null || rsvDtNoStr.trim().isEmpty()) {
			req.setAttribute("errorMsg", "請輸入定位時段編號");
			return "/reservationdatetime/index.jsp";
		}

		try {
			Integer rsvDtNo = Integer.parseInt(rsvDtNoStr.trim());
			ReservationDatetimeVO rsv = rsvService.getRsvDtNoQuery(rsvDtNo);

			if (rsv == null) {
				req.setAttribute("errorMsg", "查無此定位時段編號");
				return "/reservationdatetime/index.jsp";
			}
			req.setAttribute("rsv", rsv);
			return "/reservationdatetime/index.jsp";

		} catch (NumberFormatException e) {
			req.setAttribute("errorMsg", "定位時段編號格式錯誤");
			return "/reservationdatetime/index.jsp";
		}
	}

	private String insertRsv(HttpServletRequest req, HttpServletResponse res) {
		String rsvDtStr = req.getParameter("rsvDatetime");

		if (rsvDtStr == null || rsvDtStr.trim().isEmpty()) {
			req.setAttribute("errorMsg", "請輸入訂位時段");
			return "/reservationdatetime/index.jsp";
		}

		try {
			LocalDateTime rsvDt = LocalDateTime.parse(rsvDtStr);

			rsvService.insertReservationdatetime(rsvDt);

		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("errorMsg", "新增訂位時段失敗");
			return "/reservationdatetime/index.jsp";
		}

		return "/reservationdatetime/index.jsp";
	}

	private String updateRsv(HttpServletRequest req, HttpServletResponse res) {
		String rsvDtNoStr = req.getParameter("rsvDtNo");
		String rsvDatetimeStr = req.getParameter("rsvDatetime");

		if (rsvDtNoStr == null || rsvDtNoStr.trim().isEmpty()) {
	        req.setAttribute("errorMsg", "請輸入訂位時段編號");
	        return "/reservationdatetime/index.jsp";
	    }
		
		if (rsvDatetimeStr == null || rsvDatetimeStr.trim().isEmpty()) {
	        req.setAttribute("errorMsg", "請輸入新的訂位日期時間");
	        return "/reservationdatetime/index.jsp";
	    }
		
		try {
			Integer rsvDtNo = Integer.parseInt(rsvDtNoStr.trim());
			LocalDateTime rsvDt = LocalDateTime.parse(rsvDatetimeStr);
			
			rsvService.updateReservationdatetime(rsvDtNo, rsvDt);
			req.setAttribute("successMsg", "訂位時段修改成功");
		} catch (NumberFormatException e) {
	        req.setAttribute("errorMsg", "訂位時段編號格式錯誤");

	    } catch (Exception e) {
	        e.printStackTrace();
	        req.setAttribute("errorMsg", "修改訂位時段失敗");
	    }

	    return "/reservationdatetime/index.jsp";
	}

	private String deleteRsv(HttpServletRequest req, HttpServletResponse res) {

	    
	    String rsvDtNoStr = req.getParameter("rsvDtNo");

	    
	    if (rsvDtNoStr == null || rsvDtNoStr.trim().isEmpty()) {
	        req.setAttribute("errorMsg", "請輸入訂位時段編號");
	        return "/reservationdatetime/index.jsp";
	    }

	    try {
	        
	        Integer rsvDtNo = Integer.parseInt(rsvDtNoStr.trim());

	       
	        rsvService.deleteReservationdatetime(rsvDtNo);

	        req.setAttribute("successMsg", "訂位時段刪除成功");

	    } catch (NumberFormatException e) {
	        req.setAttribute("errorMsg", "訂位時段編號格式錯誤");

	    } catch (Exception e) {
	        e.printStackTrace();
	        req.setAttribute("errorMsg", "刪除訂位時段失敗");
	    }

	    return "/reservationdatetime/index.jsp";
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		doPost(req, res);
	}

}
