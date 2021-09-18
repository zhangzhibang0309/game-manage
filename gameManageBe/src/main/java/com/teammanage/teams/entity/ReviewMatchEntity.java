package com.teammanage.teams.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * 
 * @author 
 * @email 
 * @date 2021-05-10 16:36:49
 */
@Data
@TableName("review_match")
public class ReviewMatchEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer reviewId;
	/**
	 * 
	 */
	private Long reviewOwner;
	/**
	 * 
	 */
	private String reviewInfo;
	/**
	 * 
	 */
	private Integer reviewParent;

}
