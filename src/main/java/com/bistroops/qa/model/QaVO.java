package com.bistroops.qa.model;
import java.sql.Timestamp;

import jakarta.persistence.Column;


public class QaVO implements java.io.Serializable{
	private Integer qaNo;
	private String qaTitle;
	
	@Column(name="qaContent", columnDefinition = "midiumtext")
	private String qaContent;
	
	/*
qa_no INT UNSIGNED AUTO_INCREMENT COMMENT '編號',
qa_title VARCHAR(30) COMMENT '標題',
qa_content TEXT COMMENT '內容',*/
			  
	
}
