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
 * @date 2021-04-10 17:30:08
 */
@Data
@TableName("team_record_info")
public class TeamRecordInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer teamRecordInfoId;
	/**
	 * 
	 */
	private String teamRecordInfoMemberOne;
	/**
	 * 
	 */
	private String teamRecordInfoMemberTwo;
	/**
	 * 
	 */
	private String teamRecordInfoHexoOne;
	/**
	 * 
	 */
	private String teamRecordInfoHexoTwo;
	/**
	 * 
	 */
	private Integer teamRecordInfoParent;

}
