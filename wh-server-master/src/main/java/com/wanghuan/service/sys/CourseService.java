package com.wanghuan.service.sys;

import java.util.List;

import com.wanghuan.model.sys.CourseEntity;

public interface CourseService {
	public void insert(CourseEntity courseEntity);

	public void del(CourseEntity courseEntity);

	/**
	 * 通过课程名得到课程信息
	 * @param CourseName
	 * @return
	 */
	public CourseEntity getCourseEntityByCourseName(String courseName);

	/**
	 * 获取Course列表
	 * @param CourseName
	 * @param pageSize
	 * @param page
	 * @return
	 */
	public List<CourseEntity> CoursesList(String courseName, int pageSize, int start);

	/**
	 * 获取Course列表的总量
	 * @param CourseName
	 * @param pageSize
	 * @param page
	 * @return
	 */
	public Integer CoursesSize(String courseName, int pageSize, int start);

	/**
	 * 新建课程信息
	 * @param CourseEntity
	 */
	public void insertCourse(CourseEntity courseEntity);

	/**
	 * 更新课程信息
	 * @param CourseEntity
	 */
	public void updateCourse(CourseEntity courseEntity);

	/**
	 * 删除课程信息
	 * @param groupId
	 */
	public void deleteCourses(List<String> groupId);
}
