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
 * @date 2021-04-10 14:33:23
 */
@Data
@TableName("u_member")
public class UMemberEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId(type= IdType.AUTO)
	private Integer memberId;
	/**
	 * 
	 */
	private String memberName;
	/**
	 * 
	 */
	private String memberInfo;
	/**
	 * 
	 */
	private Long memberSupport;
	/**
	 * 
	 */
	private Integer memberTeam;
	/**
	 * 
	 */
	private String memberIcon;

}
