package com.bistroops.announcement.model;

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
		return dao.fingByAnnNo(annNo);
	}
	

}
