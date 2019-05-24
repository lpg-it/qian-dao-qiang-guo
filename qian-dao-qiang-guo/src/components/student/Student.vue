<template>
  <div>
    <Header/>
    <div class="content">
      <div class="breadcrumb">
        <el-breadcrumb separator="/">
          <el-breadcrumb-item :to="{ path: '/home' }">首页</el-breadcrumb-item>
          <el-breadcrumb-item :to="{path: '/student'}">学生管理</el-breadcrumb-item>
        </el-breadcrumb>
      </div>

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
          value: 'fzu',
          label: '福州大学'
        }
      ]
    };
  },
  methods: {
    // this.getStudentList()
  },
  created() {
    // getStudentList();
  }
};
</script>

<style lang="css" scoped>
.content {
  height: 855px;
  background-color: rgb(227, 227, 227);
}

/* 面包屑 */
.breadcrumb {
  display: inline-block;
  width: 80%;
  padding: 18px;
  margin-left: 20px;
}

/* 学生列表 */
.studentTable {
  margin-top: 10px;
  margin-left: 300px;
  min-width: 86%;
}

.studentTable el-table {
  border-radius: 11px;
  box-shadow: 3px 3px 3px rgba(0, 0, 0, 0.8);
}
</style>
