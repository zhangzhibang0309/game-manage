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
 * @date 2021-05-10 16:36:49
 */
@Data
@TableName("fan_group")
public class FanGroupEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 自增
	 */
	@TableId(type= IdType.AUTO)
	private Integer groupId;
	/**
	 * 
	 */
	private String groupName;
	/**
	 * 
	 */
	private Integer groupTeamId;
	/**
	 * 
	 */
	private String groupMember;

}
