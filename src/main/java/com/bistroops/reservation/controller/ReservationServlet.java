package com.bistroops.reservation.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import com.bistroops.reservation.model.ReservationService;
import com.bistroops.reservation.model.ReservationVO;
import com.bistroops.reservationdatetime.model.ReservationDatetimeService;
import com.bistroops.reservationdatetime.model.ReservationDatetimeVO;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/rsv/rsv.do")
public class ReservationServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private ReservationService rsvService = new ReservationService();
    private ReservationDatetimeService rsvDtService = new ReservationDatetimeService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

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
            forwardPath = "/reservation/index.jsp";
            break;
        }

        res.setContentType("text/html; charset=UTF-8");

        RequestDispatcher dispatcher = req.getRequestDispatcher(forwardPath);
        dispatcher.forward(req, res);
    }

    private String getAll(HttpServletRequest req, HttpServletResponse res) {

        List<ReservationVO> rsvList = rsvService.getAll();

        req.setAttribute("rsvList", rsvList);

        return "/reservation/index.jsp";
    }

    private String rsvNoQuery(HttpServletRequest req, HttpServletResponse res) {

        String rsvNoStr = req.getParameter("rsvNo");

        if (rsvNoStr == null || rsvNoStr.trim().isEmpty()) {
            req.setAttribute("errorMsg", "請輸入訂位編號");
            return "/reservation/index.jsp";
        }

        try {

            Integer rsvNo = Integer.parseInt(rsvNoStr.trim());

            ReservationVO rsv = rsvService.getRsvNoQuery(rsvNo);

            if (rsv == null) {
                req.setAttribute("errorMsg", "查無此訂位編號");
                return "/reservation/index.jsp";
            }

            req.setAttribute("rsv", rsv);

            return "/reservation/index.jsp";

        } catch (NumberFormatException e) {

            req.setAttribute("errorMsg", "訂位編號格式錯誤");

            return "/reservation/index.jsp";
        }
    }

    private String insertRsv(HttpServletRequest req, HttpServletResponse res) {

        String memNoStr = req.getParameter("memNo");
        String rsvDtNoStr = req.getParameter("rsvDtNo");
        String seatTypeNoStr = req.getParameter("seatTypeNo");
        String rsvStatus = req.getParameter("rsvStatus");
        String rsvComment = req.getParameter("rsvComment");

        if (memNoStr == null || memNoStr.trim().isEmpty()) {
            req.setAttribute("errorMsg", "請輸入會員編號");
            return "/reservation/index.jsp";
        }

        if (rsvDtNoStr == null || rsvDtNoStr.trim().isEmpty()) {
            req.setAttribute("errorMsg", "請輸入訂位時段編號");
            return "/reservation/index.jsp";
        }

        if (seatTypeNoStr == null || seatTypeNoStr.trim().isEmpty()) {
            req.setAttribute("errorMsg", "請輸入桌型編號");
            return "/reservation/index.jsp";
        }

        try {

            Integer memNo = Integer.parseInt(memNoStr.trim());
            Integer rsvDtNo = Integer.parseInt(rsvDtNoStr.trim());
            Integer seatTypeNo = Integer.parseInt(seatTypeNoStr.trim());

            ReservationDatetimeVO reservationdatetime =
                    rsvDtService.getRsvDtNoQuery(rsvDtNo);

            if (reservationdatetime == null) {
                req.setAttribute("errorMsg", "查無此訂位時段編號");
                return "/reservation/index.jsp";
            }

            ReservationVO rsv = new ReservationVO();

            rsv.setMemNo(memNo);
            rsv.setReservationdatetime(reservationdatetime);
            rsv.setSeatTypeNo(seatTypeNo);
            rsv.setRsvCreateTime(LocalDateTime.now());
            rsv.setRsvStatus(rsvStatus);
            rsv.setRsvComment(rsvComment);

            rsvService.insert(rsv);

            req.setAttribute("successMsg", "新增訂位成功");

            return getAll(req, res);

        } catch (NumberFormatException e) {

            req.setAttribute("errorMsg", "會員編號、訂位時段編號或桌型編號格式錯誤");

            return "/reservation/index.jsp";

        } catch (Exception e) {

            e.printStackTrace();

            req.setAttribute("errorMsg", "新增訂位失敗");

            return "/reservation/index.jsp";
        }
    }

    private String updateRsv(HttpServletRequest req, HttpServletResponse res) {

        String rsvNoStr = req.getParameter("rsvNo");
        String memNoStr = req.getParameter("memNo");
        String rsvDtNoStr = req.getParameter("rsvDtNo");
        String seatTypeNoStr = req.getParameter("seatTypeNo");
        String rsvStatus = req.getParameter("rsvStatus");
        String rsvComment = req.getParameter("rsvComment");

        if (rsvNoStr == null || rsvNoStr.trim().isEmpty()) {
            req.setAttribute("errorMsg", "請輸入訂位編號");
            return "/reservation/index.jsp";
        }

        if (memNoStr == null || memNoStr.trim().isEmpty()) {
            req.setAttribute("errorMsg", "請輸入會員編號");
            return "/reservation/index.jsp";
        }

        if (rsvDtNoStr == null || rsvDtNoStr.trim().isEmpty()) {
            req.setAttribute("errorMsg", "請輸入訂位時段編號");
            return "/reservation/index.jsp";
        }

        if (seatTypeNoStr == null || seatTypeNoStr.trim().isEmpty()) {
            req.setAttribute("errorMsg", "請輸入桌型編號");
            return "/reservation/index.jsp";
        }

        try {

            Integer rsvNo = Integer.parseInt(rsvNoStr.trim());
            Integer memNo = Integer.parseInt(memNoStr.trim());
            Integer rsvDtNo = Integer.parseInt(rsvDtNoStr.trim());
            Integer seatTypeNo = Integer.parseInt(seatTypeNoStr.trim());

            ReservationDatetimeVO reservationdatetime =
                    rsvDtService.getRsvDtNoQuery(rsvDtNo);

            if (reservationdatetime == null) {
                req.setAttribute("errorMsg", "查無此訂位時段編號");
                return "/reservation/index.jsp";
            }

            ReservationVO rsv = new ReservationVO();

            rsv.setRsvNo(rsvNo);
            rsv.setMemNo(memNo);
            rsv.setReservationdatetime(reservationdatetime);
            rsv.setSeatTypeNo(seatTypeNo);
            rsv.setRsvStatus(rsvStatus);
            rsv.setRsvComment(rsvComment);

            rsvService.update(rsv);

            req.setAttribute("successMsg", "訂位修改成功");

            return getAll(req, res);

        } catch (NumberFormatException e) {

            req.setAttribute("errorMsg", "訂位編號、會員編號、訂位時段編號或桌型編號格式錯誤");

            return "/reservation/index.jsp";

        } catch (Exception e) {

            e.printStackTrace();

            req.setAttribute("errorMsg", "修改訂位失敗");

            return "/reservation/index.jsp";
        }
    }

    private String deleteRsv(HttpServletRequest req, HttpServletResponse res) {

        String rsvNoStr = req.getParameter("rsvNo");

        if (rsvNoStr == null || rsvNoStr.trim().isEmpty()) {
            req.setAttribute("errorMsg", "請輸入訂位編號");
            return "/reservation/index.jsp";
        }

        try {

            Integer rsvNo = Integer.parseInt(rsvNoStr.trim());

            rsvService.delete(rsvNo);

            req.setAttribute("successMsg", "訂位刪除成功");

            return getAll(req, res);

        } catch (NumberFormatException e) {

            req.setAttribute("errorMsg", "訂位編號格式錯誤");

        } catch (Exception e) {

            e.printStackTrace();

            req.setAttribute("errorMsg", "刪除訂位失敗");
        }

        return "/reservation/index.jsp";
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        doPost(req, res);
    }
}