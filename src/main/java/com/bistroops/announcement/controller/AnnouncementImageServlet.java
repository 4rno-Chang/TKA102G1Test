package com.bistroops.announcement.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.bistroops.announcement.model.AnnouncementService;
import com.bistroops.announcement.model.AnnouncementVO;

@WebServlet("/ann/annImage.do")
public class AnnouncementImageServlet extends HttpServlet {

    private AnnouncementService annService = new AnnouncementService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        Integer annNo = Integer.parseInt(req.getParameter("annNo"));

        AnnouncementVO ann = annService.getAnnNoQuery(annNo);

        byte[] image = ann.getAnnImg();

        if (image != null) {
            res.setContentType("image/jpeg");
            res.getOutputStream().write(image);
        }
    }
}