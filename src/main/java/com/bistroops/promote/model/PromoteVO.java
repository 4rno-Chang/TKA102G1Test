package com.bistroops.promote.model;

import java.time.LocalDateTime;
import java.util.Set;

import com.bistroops.promotemeal.model.PromoteMealVO;
import com.bistroops.promotemeal.model.PromoteMealVO;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;

@Entity
@Table(name="promote")
public class PromoteVO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="promote_no")
	private Integer promoteNo;
	
	@Column(name="promote_name")
	private String promoteName;
	
	@Column(name="promote_begin")
	private LocalDateTime promoteBegin;
	
	@Column(name="promote_end")
	private LocalDateTime promoteEnd;
	
	@Column(name="promote_status")
	private String promoteStatus;
	
	@Column(name="promote_content")
	private String promoteContent;
	
	@Column(name="promote_img", columnDefinition = "mediumblob")
	private byte[] promoteImg;
	
	@OneToMany(mappedBy = "promoteNo", cascade = CascadeType.ALL)
	@OrderBy("empno asc")
	private Set<PromoteMealVO> promoteMeals;
	

}
