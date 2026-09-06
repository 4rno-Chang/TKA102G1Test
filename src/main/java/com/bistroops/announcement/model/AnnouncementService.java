package com.bistroops.announcement.model;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import com.bistroops.announcement.model.AnnouncementVO;

public class AnnouncementService {

	private AnnouncementDAO_interface dao;

	public AnnouncementService() {
		dao = new AnnouncementDAO();
	}

	public List<AnnouncementVO> getAll() {
		return dao.getAll();
	}

	public AnnouncementVO getAnnNoQuery(Integer annNo) {
		return dao.findByAnnNo(annNo);
	}

	public void insertAnn(String annTitle, LocalDateTime annBegin, byte[] annImg, String annText) {
		AnnouncementVO ann = new AnnouncementVO();

		ann.setAnnTitle(annTitle);
		ann.setAnnBegin(annBegin);
		
		System.out.println("Service圖片大小：" +
			    (annImg == null ? "null" : annImg.length));
		
		ann.setAnnImg(annImg);
		ann.setAnnText(annText);
		
		dao.insert(ann);
	}
}
