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
 * @date 2021-04-02 14:05:52
 */
@Data
@TableName("video")
public class VideoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer videoId;
	/**
	 * 
	 */
	private String videoName;
	/**
	 * 
	 */
	private String videoAddress;

}
