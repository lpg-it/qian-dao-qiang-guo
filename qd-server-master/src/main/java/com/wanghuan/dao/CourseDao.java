package com.wanghuan.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.wanghuan.model.sys.CourseEntity;

@Mapper
public interface CourseDao {

	public ArrayList<CourseEntity> select(@Param("courseEntity") CourseEntity courseEntity);
	
	public void del(@Param("courseEntity") CourseEntity courseEntity);
	
	public void update(@Param("courseEntity") CourseEntity courseEntity);
	
	public void insert(@Param("courseEntity") CourseEntity courseEntity);
	
	/**
	 * 通过课程名拿到用户信息
	 * @return
	 */
	public CourseEntity getCourseEntityByCourseName(@Param("CourseName") String CourseName);

	/**
	 * 获取user列表
	 * @param loginName
	 * @param pageSize
	 * @param page
	 * @return
	 */
	public ArrayList<CourseEntity> CoursesList(@Param("CourseName")String CourseName,@Param("pageSize") int pageSize,@Param("start") int start);

	/**
	 * 获取user列表的总量
	 * @param loginName
	 * @param pageSize
	 * @param page
	 * @return
	 */
	public Integer CoursesSize(@Param("CourseName")String CourseName,@Param("pageSize") int pageSize,@Param("start") int start);

	/**
	 * 新建用户信息
	 * @param CourseEntity
	 */
	public void insertCourse(@Param("CourseEntity") CourseEntity CourseEntity);

	/**
	 * 更新用户信息
	 * @param CourseEntity
	 */
	public void updateCourse(@Param("CourseEntity") CourseEntity CourseEntity);

	/**
	 * 删除用户信息
	 * @param groupId
	 */
	public void deleteCourses(@Param("groupId") List<String> groupId);
	
}
