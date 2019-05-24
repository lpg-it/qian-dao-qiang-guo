import Vue from 'vue'
import Router from 'vue-router'
import Login from '@/components/manage/Login.vue'
import Home from '@/components/home/Home.vue'
import Role from '@/components/role/Role'

import Student from '@/components/student/Student'
import Student from '@/components/student/Student'

import Student from '@/components/student/Student'

import Student from '@/components/student/Student'


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
      path: '/student',
      name: 'Student',
      component: Student
    }
  ]
})