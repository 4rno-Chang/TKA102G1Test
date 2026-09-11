package com.bistroops.waiting.controller;

import java.io.IOException;
import java.sql.Time;
import java.util.List;

import com.bistroops.seattype.model.SeatTypeVO;
//import com.bistroops.seattype.model.SeattypeService;
//import com.bistroops.seattype.model.SeattypeVO;
import com.bistroops.waiting.model.WaitingService;
import com.bistroops.waiting.model.WaitingVO;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/waiting/waiting.do")
public class WaitingServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private WaitingService waitingService = new WaitingService();
//    private SeattypeService seattypeService = new SeattypeService();

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        doPost(req, res);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");

        if ("getAll".equals(action)) {

            List<WaitingVO> list = waitingService.getAll();

            req.setAttribute("list", list);

            RequestDispatcher successView =
                    req.getRequestDispatcher("/waiting/index.jsp");

            successView.forward(req, res);
        }


        if ("waitingNoQuery".equals(action)) {

            String waitingNoStr = req.getParameter("waitingNo");

            if (waitingNoStr == null || waitingNoStr.trim().isEmpty()) {

                req.setAttribute("errorMsg", "請輸入候位編號");

                RequestDispatcher failureView =
                        req.getRequestDispatcher("/waiting/index.jsp");

                failureView.forward(req, res);
                return;
            }

            Integer waitingNo =
                    Integer.valueOf(waitingNoStr.trim());

            WaitingVO waitingVO =
                    waitingService.getOneWaiting(waitingNo);

            if (waitingVO == null) {

                req.setAttribute("errorMsg", "查無此候位資料");

                RequestDispatcher failureView =
                        req.getRequestDispatcher("/waiting/index.jsp");

                failureView.forward(req, res);
                return;
            }

            req.setAttribute("waitingVO", waitingVO);

            RequestDispatcher successView =
                    req.getRequestDispatcher("/waiting/update_waiting.jsp");

            successView.forward(req, res);
        }


        if ("insertWaiting".equals(action)) {

            String seatTypeNoStr =
                    req.getParameter("seatTypeNo");

            String memberNoStr =
                    req.getParameter("memberNo");

            String waitingTel =
                    req.getParameter("waitingTel");

            String waitingName =
                    req.getParameter("waitingName");

            String waitingComment =
                    req.getParameter("waitingComment");

            String waitingStatus =
                    req.getParameter("waitingStatus");

            String waitingNotifyTimeStr =
                    req.getParameter("waitingNotifyTime");


            Integer seatTypeNo =
                    Integer.valueOf(seatTypeNoStr.trim());

//            SeatTypeVO seattypeVO =
//                    seattypeService.getOneSeattype(seatTypeNo);


            Integer memberNo = null;

            if (memberNoStr != null
                    && !memberNoStr.trim().isEmpty()) {

                memberNo =
                        Integer.valueOf(memberNoStr.trim());
            }


            Time waitingNotifyTime = null;

            if (waitingNotifyTimeStr != null
                    && !waitingNotifyTimeStr.trim().isEmpty()) {

                waitingNotifyTime =
                        Time.valueOf(waitingNotifyTimeStr.trim());
            }


            WaitingVO waitingVO = new WaitingVO();

//            waitingVO.setSeattype(seattypeVO);
            waitingVO.setMemberNo(memberNo);
            waitingVO.setWaitingTel(waitingTel);
            waitingVO.setWaitingName(waitingName);
            waitingVO.setWaitingComment(waitingComment);
            waitingVO.setWaitingStatus(waitingStatus);
            waitingVO.setWaitingNotifyTime(waitingNotifyTime);


            waitingService.addWaiting(waitingVO);


            RequestDispatcher successView =
                    req.getRequestDispatcher("/waiting/index.jsp");

            successView.forward(req, res);
        }


        if ("updateWaiting".equals(action)) {

            String waitingNoStr =
                    req.getParameter("waitingNo");

            String seatTypeNoStr =
                    req.getParameter("seatTypeNo");

            String memberNoStr =
                    req.getParameter("memberNo");

            String waitingTel =
                    req.getParameter("waitingTel");

            String waitingName =
                    req.getParameter("waitingName");

            String waitingComment =
                    req.getParameter("waitingComment");

            String waitingStatus =
                    req.getParameter("waitingStatus");

            String waitingNotifyTimeStr =
                    req.getParameter("waitingNotifyTime");


            Integer waitingNo =
                    Integer.valueOf(waitingNoStr.trim());

            Integer seatTypeNo =
                    Integer.valueOf(seatTypeNoStr.trim());


//            SeatTypeVO seattypeVO =
//                    seattypeService.getOneSeattype(seatTypeNo);


            Integer memberNo = null;

            if (memberNoStr != null
                    && !memberNoStr.trim().isEmpty()) {

                memberNo =
                        Integer.valueOf(memberNoStr.trim());
            }


            Time waitingNotifyTime = null;

            if (waitingNotifyTimeStr != null
                    && !waitingNotifyTimeStr.trim().isEmpty()) {

                waitingNotifyTime =
                        Time.valueOf(waitingNotifyTimeStr.trim());
            }


            WaitingVO waitingVO = new WaitingVO();

            waitingVO.setWaitingNo(waitingNo);
//            waitingVO.setSeattype(seattypeVO);
            waitingVO.setMemberNo(memberNo);
            waitingVO.setWaitingTel(waitingTel);
            waitingVO.setWaitingName(waitingName);
            waitingVO.setWaitingComment(waitingComment);
            waitingVO.setWaitingStatus(waitingStatus);
            waitingVO.setWaitingNotifyTime(waitingNotifyTime);


            waitingService.updateWaiting(waitingVO);


            RequestDispatcher successView =
                    req.getRequestDispatcher("/waiting/index.jsp");

            successView.forward(req, res);
        }


        if ("deleteWaiting".equals(action)) {

            String waitingNoStr =
                    req.getParameter("waitingNo");

            Integer waitingNo =
                    Integer.valueOf(waitingNoStr.trim());

            waitingService.deleteWaiting(waitingNo);


            RequestDispatcher successView =
                    req.getRequestDispatcher("/waiting/index.jsp");

            successView.forward(req, res);
        }
    }
}
