<template>
  <div class="mainContent">
    <Header/>
    <div class="content">
      <el-breadcrumb separator="/">
        <el-breadcrumb-item :to="{ path: '/home' }">首页</el-breadcrumb-item>
        <el-breadcrumb-item :to="{path: '/student'}">学生管理</el-breadcrumb-item>
      </el-breadcrumb>

      <!--工具条-->
      <el-col class="toolbar">
        <el-form :inline="true" :model="studentList">
          <el-form-item>
            <el-input
              v-model="studentList.name"
              placeholder="用户名/姓名/昵称"
              style="min-width: 240px;"
              @keyup.enter.native="handleSearch"
            ></el-input>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="handleSearch">查询</el-button>
          </el-form-item>
        </el-form>
      </el-col>

      <!-- 学生列表展示 -->
      <div class="studentTable">
        <el-table
          border
          :data="studentList"
          style="width: 85%"
          :default-sort="{prop: 'id', order: 'descending'}"
        >
          <el-table-column prop="id" label="学号" sortable width="180"></el-table-column>
          <el-table-column prop="name" label="姓名" sortable width="180"></el-table-column>
          <el-table-column prop="sex" label="性别" width="180"></el-table-column>
          <el-table-column prop="birth" label="出生年份" width="180"></el-table-column>
          <el-table-column prop="college" label="学校" width="180"></el-table-column>
          <el-table-column prop="classes" label="专业班级" width="180"></el-table-column>
          <el-table-column label="操作">
            <template>
              <el-button size="mini" @click="editStudent = true">编辑</el-button>
              <el-button size="mini" type="danger" @click="handleDelete()">删除</el-button>
            </template>
          </el-table-column>
        </el-table>
      </div>

      <!-- 编辑学生页面 -->
      <el-dialog title="编辑学生" :visible.sync="editStudent">
        <el-form :model="editStudentList">
          <el-form-item label="学号" label-width="120px">
            <el-input v-model="editStudentList.id" auto-complete="off"></el-input>
          </el-form-item>
          <el-form-item label="姓名" label-width="120px">
            <el-input
              v-model="editStudentList.name"
              value="editStudentList.name"
              auto-complete="off"
            ></el-input>
          </el-form-item>
          <el-form-item label="性别" label-width="120px">
            <el-select v-model="editStudentList.sex" placeholder="请选择">
              <el-option
                v-for="sex in sexList"
                :key="sex.value"
                :label="sex.label"
                :value="sex.value"
              ></el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="出生年份" label-width="120px">
            <el-date-picker v-model="editStudentList.birth" type="date" placeholder="选择日期"></el-date-picker>
          </el-form-item>
          <!-- 学校 -->
          <el-form-item label="学校" label-width="120px">
            <el-select v-model="editStudentList.college" placeholder="请选择学校">
              <el-option
                v-for="college in collegeList"
                :key="college.value"
                :label="college.label"
                :value="college.value"
              ></el-option>
            </el-select>
          </el-form-item>
          <!-- 专业班级 -->
          <el-form-item label="专业班级" label-width="120px">
            <el-input
              v-model="editStudentList.classes"
              value="editStudentList.classes"
              auto-complete="off"
            ></el-input>
          </el-form-item>
        </el-form>
        <div slot="footer" class="dialog-footer">
          <el-button @click="editStudent = false">取 消</el-button>
          <el-button type="primary" @click="editStudent = false">确 定</el-button>
        </div>
      </el-dialog>

      <!-- 添加学生页面 -->
    </div>
  </div>
</template>


<script>
import Header from "@/components/common/Header.vue";
// import blogFooter from '@/components/common/BlogFooter.vue'

export default {
  name: "Student",
  // blogHeader/blogFooter组件给申明到components里面然后在template里面使用
  components: { Header },
  data() {
    return {
      courseList: [],
      studentList: [
        {
          id: 1,
          name: "李华",
          sex: "男",
          birth: "1996-03-16",
          college: "福州大学",
          classes: "计算机技术一班"
        }
      ],
      // 编辑学生控制
      editStudent: false,
      editStudentList: {
        id: 1,
        name: "李华",
        sex: "男",
        birth: "1996-03-16",
        college: "福州大学",
        classes: "计算机技术一班"
      },
      sexList: [
        {
          value: "man",
          label: "男"
        },
        {
          value: "woman",
          label: "女"
        }
      ],
      collegeList: [
        {
          value: "fzu",
          label: "福州大学"
        }
      ]
    };
  },
  created() {
    // this.getStudentList();
    this.getCourseList()
  },
  methods: {
    getCourseList() {
      this.$axios
        .get('course_sub/category/list/')
        .then(res => {
          console.log(res);
          if (res.error_no === 0) {
            this.courseList = res.data;
            //$.each()
            console.log(this.courseList);
          }
        })
        .catch(err => {
          console.log(err);
        });
    },
    handleSearch() {
      this.search();
    }
  },
};
</script>

<style lang="css" scoped>
.content {
  float: left;
  width: 87.5%;
  height: 855px;
  background-color: rgb(227, 227, 227);
}

/* 面包屑 */
.content .el-breadcrumb {
  display: inline-block;
  /* width: 10%; */
  padding: 18px;
  margin-left: 20px;
}

/* 搜索 */
.content .toolbar {
  display: inline-block;
  margin-left: 100px;
}

/* 学生列表 */
.studentTable {
  display: inline-block;
  margin-top: 10px;
  /* margin-left: 100px; */
  width: 120%;
}

.studentTable el-table {
  border-radius: 11px;
  box-shadow: 3px 3px 3px rgba(0, 0, 0, 0.8);
}
</style>
