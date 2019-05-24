import Vue from 'vue'
import Router from 'vue-router'
import Login from '@/components/manage/Login.vue'
import Home from '@/components/home/Home.vue'
import Role from '@/components/role/Role'
import Student from '@/components/student/Student'
import Teacher from '@/components/teacher/Teacher'
import Course from '@/components/course/Course'



Vue.use(Router)

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      redirect: '/login'
    },
    {
      path: '/home',
      name: 'Home',
      component: Home
    },
    {
      path: '/login',
      name: 'Login',
      component: Login
    },
    {
      path: '/role',
      name: 'Role',
      component: Role
    },
    {
      path: '/student',
      name: 'Student',
      component: Student
    },
    {
      path: '/teacher',
      name: 'Teacher',
      component: Teacher
    },
    {
      path: '/course',
      name: 'Course',
      component: Course
    }
  ]
})