package com.wanghuan.service.impl.sys;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wanghuan.dao.CourseDao;
import com.wanghuan.model.sys.CourseEntity;
import com.wanghuan.service.sys.CourseService;

@Service(value = "courseServiceImpl")
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseDao courseDao;
	
	@Override
	public void insert(CourseEntity courseEntity) {
		courseDao.insert(courseEntity);
	}

	@Override
	public void del(CourseEntity courseEntity) {
		courseDao.del(courseEntity);
	}

	@Override
	public CourseEntity getCourseEntityByCourseName(String courseName) {
		return courseDao.getCourseEntityByCourseName(courseName);
	}

	@Override
	public List<CourseEntity> CoursesList(String courseName, int pageSize, int start) {
		return courseDao.CoursesList(courseName,  pageSize,  start);
	}

	@Override
	public Integer CoursesSize(String courseName, int pageSize, int start) {
		return courseDao.CoursesSize(courseName, pageSize, start);
	}

	@Override
	public void insertCourse(CourseEntity courseEntity) {
		/*String password = null;
		try {
			password = MD5Util.encrypt(CourseEntity.getPassword());
			CourseEntity.setPassword(password);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}*/
		//CourseEntity.setPassword(new Md5PasswordEncoder().encodePassword(CourseEntity.getPassword(), null));
		courseDao.insertCourse(courseEntity);
	}

	@Override
	public void updateCourse(CourseEntity courseEntity) {
		//CourseEntity.setPassword(new Md5PasswordEncoder().encodePassword(CourseEntity.getPassword(), null));
		courseDao.updateCourse(courseEntity);
	}

	@Override
	public void deleteCourses(List<String> groupId) {
		courseDao.deleteCourses(groupId);
	}

}
