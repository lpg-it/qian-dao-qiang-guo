package com.wanghuan.controller.sys;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wanghuan.model.sys.PageResult;
import com.wanghuan.model.sys.CourseEntity;
import com.wanghuan.service.sys.CourseService;

@RestController
/*@PreAuthorize("hasRole('ADMI')")*/
public class CourseController {

	private Logger log = LoggerFactory.getLogger(CourseController.class);

	@Resource(name = "courseServiceImpl")
	private CourseService courseService;

	@GetMapping("/course/{courseName}")
	public CourseEntity CourseGet(@PathVariable String courseName) {
		CourseEntity courseEntity = courseService.getCourseEntityByCourseName(courseName);
		log.debug("The method is ending");
		return courseEntity;
	}

	/**
	 * 获取Course表数据
	 * 
	 * @param CourseName
	 * @param pageSize
	 * @param page
	 * @return
	 */
	@GetMapping("/courses")
	public PageResult CoursesList(String courseName, int pageSize, int page) {
		PageResult pageResult = new PageResult();
		pageResult.setData(courseService.CoursesList(courseName, pageSize, page * pageSize));
		pageResult.setTotalCount(courseService.CoursesSize(courseName, pageSize, page * pageSize));
		log.debug("The method is ending");
		return pageResult;
	}

	/**
	 * 新建课程信息
	 * 
	 * @param CourseEntity
	 * @return
	 */
	@PostMapping("/courses/course")
	public CourseEntity insertCourse(@RequestBody CourseEntity courseEntity) {
		courseService.insertCourse(courseEntity);
		log.debug("The method is ending");
		return courseEntity;
	}

	/**
	 * 更新课程信息
	 * 
	 * @param CourseEntity
	 * @param id
	 * @return
	 */
	@PutMapping("/courses/{id}")
	public CourseEntity updateCourse(@RequestBody CourseEntity courseEntity, @PathVariable int id) {
		if (courseEntity.getId() == id) {
			courseService.updateCourse(courseEntity);
		}
		log.debug("The method is ending");
		return courseEntity;
	}

	/**
	 * 删除课程信息
	 * 
	 * @param groupId
	 * @return
	 */
	@DeleteMapping("/courses")
	public List<String> deleteCourses(@RequestBody List<String> groupId) {
		courseService.deleteCourses(groupId);
		return groupId;
	}
}
