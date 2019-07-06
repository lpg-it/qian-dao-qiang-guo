package com.wanghuan.model.sys;

public class CourseEntity {
	/**
	 * id
	 */
	private int id;
	/**
	 * 课程名
	 */
	private String CourseName;
	/**
	 * 教师
	 */
	private String Teacher;
	/**
	 * 电话
	 */
	private String Telephone;
	/**
	 * 上课时间
	 */
	private String Time;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCourseName() {
		return CourseName;
	}
	public void setCourseName(String courseName) {
		CourseName = courseName;
	}
	public String getTeacher() {
		return Teacher;
	}
	public void setTeacher(String teacher) {
		Teacher = teacher;
	}
	public String getTelephone() {
		return Telephone;
	}
	public void setTelephone(String telephone) {
		Telephone = telephone;
	}
	public String getTime() {
		return Time;
	}
	public void setTime(String time) {
		Time = time;
	}
	
}
