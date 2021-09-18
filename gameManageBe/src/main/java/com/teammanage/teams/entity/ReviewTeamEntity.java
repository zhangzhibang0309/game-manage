package com.teammanage.teams.entity;

import com.baomidou.mybatisplus.annotation.IdType;
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
 * @date 2021-04-10 14:47:35
 */
@Data
@TableName("review_team")
public class ReviewTeamEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId(type= IdType.AUTO)
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
