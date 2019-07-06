<template>
    <div style="margin: 20px;">
        <div>
            <Row style="margin-bottom: 25px;">
                <Col span="8">课程名：
                    <Input v-model="courseName" placeholder="请输入..." style="width:200px"></Input>
                </Col>
                <Col span="8"><Button type="primary" shape="circle" icon="ios-search" @click="search()">搜索</Button></Col>
            </Row>
        </div>
        <div>
            <ul>
                <li>
                    <div style="padding: 10px 0;">
                        <Table border :columns="columns1" :data="data1" :height="400" @on-selection-change="s=>{change(s)}" @on-row-dblclick="s=>{dblclick(s)}"></Table>
                    </div>
                </li>
                <li>
                    <div style="text-align: right;">
                        <Page :total="total" :page-size="pageInfo.pageSize" show-elevator show-total @on-change="e=>{pageSearch(e)}"></Page>
                    </div>
                </li>
            </ul>
        </div>
        <!--添加modal-->
        <Modal :mask-closable="false" :visible.sync="newModal" :loading = "loading" v-model="newModal" width="600" title="新建" @on-ok="newOk('courseNew')" @on-cancel="cancel()">
            <Form ref="courseNew" :model="courseNew" :rules="ruleNew" :label-width="80" >
                <Row>
                    <Col span="12">
                        <Form-item label="课程名:" prop="courseName">
                            <Input v-model="courseNew.courseName" style="width: 204px"/>
                        </Form-item>
                    </Col>
                    <Col span="12">
                        <Form-item label="教师:" prop="teacher">
                            <Input v-model="courseNew.teacher" style="width: 204px"/>
                        </Form-item>
                    </Col>
                </Row>
                <Row>
                    <Col span="12">
                        <Form-item label="时间:" prop="time">
                            <Input v-model="courseNew.time" style="width: 204px"/>
                        </Form-item>
                    </Col>
                </Row>
                <Row>
                    <Col span="12">
                        <Form-item label="电话:" prop="telephone">
                            <Input v-model="courseNew.telephone" style="width: 204px"/>
                        </Form-item>
                    </Col>
                </Row>
            </Form>
        </Modal>
        <!--修改modal-->
        <Modal :mask-closable="false" :visible.sync="modifyModal" :loading = "loading" v-model="modifyModal" width="600" title="修改" @on-ok="modifyOk('courseModify')" @on-cancel="cancel()">
            <Form ref="courseModify" :model="courseModify" :rules="ruleModify" :label-width="80" >
                <Row>
                    <Col span="12">
                        <Form-item label="课程名:" prop="courseName">
                            <Input v-model="courseModify.courseName" style="width: 204px"/>
                        </Form-item>
                    </Col>
                    <Col span="12">
                        <Form-item label="教师:" prop="teacher">
                            <Input v-model="courseModify.teacher" style="width: 204px"/>
                        </Form-item>
                    </Col>
                </Row>
                <Row>
                    <Col span="12">
                        <Form-item label="时间:" prop="time">
                            <Input v-model="courseModify.time" style="width: 204px"/>
                        </Form-item>
                    </Col>
                </Row>
                <Row>
                    <Col span="12">
                        <Form-item label="电话:" prop="telephone">
                            <Input v-model="courseModify.telephone" style="width: 204px"/>
                        </Form-item>
                    </Col>
                </Row>
            </Form>
        </Modal>
    </div>
</template>
<script>
    export default {
        data () {
            return {
                /*用于查找的课程名*/
                courseName:null,
                /*选择的数量*/
                count:null,
                /*选中的组数据*/
                groupId:null,
                /*新建modal的显示参数*/
                newModal:false,
                /*修改modal的显示参数*/
                modifyModal:false,
                /*角色配置modal的显示参数*/
                roleModal:false,
                /*分页total属性绑定值*/
                total:0,
                /*loading*/
                loading: true,
                /*pageInfo实体*/
                pageInfo:{
                    page:0,
                    pageSize:10
                },
                /*course实体*/
                course:{
                    id:null,
                    teacher:null,
                    courseName:null,
                    time:null,
                    telephone:null
                },
                /*用于添加的course实体*/
                courseNew:{
                    id:null,
                    teacher:null,
                    courseName:null,
                    time:null,
                    telephone:null
                },
                /*用于修改的course实体*/
                courseModify:{
                    id:null,
                    teacher:null,
                    courseName:null,
                    time:null,
                    telephone:null
                },
                /*新建验证*/
                ruleNew:{
                    teacher: [
                        { type:'string',required: true, message: '输入教师', trigger: 'blur' }
                    ],
                    courseName: [
                        { type:'string',required: true, message: '输入课程名', trigger: 'blur' }
                    ],
                    time: [
                        { type:'string',required: true, message: '输入时间', trigger: 'blur' }
                    ],
                    telephone: [
                        { type:'string',required: true, message: '输入电话', trigger: 'blur' }
                    ]
                },
                /*修改验证*/
                ruleModify:{
                    teacher: [
                        { type:'string',required: true, message: '输入教师', trigger: 'blur' }
                    ],
                    courseName: [
                        { type:'string',required: true, message: '输入课程名', trigger: 'blur' }
                    ],
                    time: [
                        { type:'string',required: true, message: '输入时间', trigger: 'blur' }
                    ],
                    telephone: [
                        { type:'string',required: true, message: '输入电话', trigger: 'blur' }
                    ]
                },
                /*表显示字段*/
                columns1: [
                    {
                        type: 'selection',
                        width: 60,
                        align: 'center'
                    },
                    {
                        title: '课程名',
                        key: 'courseName'
                    },
                    {
                        title: '教师',
                        key: 'teacher'
                    },
                    {
                        title: '电话',
                        key: 'telephone'
                    },
                    {
                        title: '时间',
                        key: 'time'
                    },
                ],
                /*表数据*/
                data1: [],
                /*表显示字段*/
                columns2: [
                    {
                        type: 'selection',
                        width: 60,
                        align: 'center'
                    },
                    {
                        title: '角色名称',
                        width: 120,
                        key: 'teacher'
                    },
                    {
                        title: '描述',
                        key: 'describe'
                    }
                ],
                /*表数据*/
                data2:[],
                /*data2的临时存储*/
                data2Temp:[],
                /*用户与角色关系列表*/
                relationList:null
            }
        },
        mounted(){
            /*页面初始化调用方法*/
            this.getTable({
                "pageInfo":this.pageInfo,
                "courseName":this.courseName
            });
        },
        methods:{
            /*pageInfo实体初始化*/
            initPageInfo(){
                this.pageInfo.page = 0;
                this.pageInfo.pageSize = 10;
            },
            /*course实体初始化*/
            initcourse(){
                this.course.id = null;
                this.course.teacher = null;
                this.course.courseName = null;
                this.course.time = null;
                this.course.telephone = null;
            },
            /*courseNew实体初始化*/
            initcourseNew(){
                this.courseNew.id = null;
                this.courseNew.teacher = null;
                this.courseNew.courseName = null;
                this.courseNew.time = null;
                this.courseNew.telephone = null;
            },
            /*courseModify实体初始化*/
            initcourseModify(){
                this.courseModify.id = null;
                this.courseModify.teacher = null;
                this.courseModify.courseName = null;
                this.courseModify.time = null;
                this.courseModify.telephone = null;
            },
            /*courseNew设置*/
            courseSet(e){
                this.course.id = e.id;
                this.course.teacher = e.teacher;
                this.course.courseName = e.courseName;
                this.course.time = e.time;
                this.course.telephone = e.telephone;
            },
            /*courseNew设置*/
            courseNewSet(e){
                this.courseNew.id = e.id;
                this.courseNew.teacher = e.teacher;
                this.courseNew.courseName = e.courseName;
                this.courseNew.time = e.time;
                this.courseNew.telephone = e.telephone;
            },
            /*courseModify设置*/
            courseModifySet(e){
                this.courseModify.id = e.id;
                this.courseModify.teacher = e.teacher;
                this.courseModify.courseName = e.courseName;
                this.courseModify.time = e.time;
                this.courseModify.telephone = e.telephone;
            },
            /*得到表数据*/
            getTable(e) {
                this.axios({
                    method: 'get',
                    url: '/courses',
                    params: {
                        'page':e.pageInfo.page,
                        'pageSize':e.pageInfo.pageSize,
                        'courseName':e.courseName
                    }
                }).then(function (response) {
                    this.data1=response.data.data;
                    this.total=response.data.totalCount;
                }.bind(this)).catch(function (error) {
                    alert(error);
                });
            },
            /*搜索按钮点击事件*/
            search(){
                this.initPageInfo();
                this.getTable({
                    "pageInfo":this.pageInfo,
                    "courseName":this.courseName
                });
            },
            /*分页点击事件*/
            pageSearch(e){
                this.pageInfo.page = e-1;
                this.getTable({
                    "pageInfo":this.pageInfo,
                    "courseName":this.courseName
                });
            },
            /*新建点击触发事件*/
            openNewModal(){
                this.newModal = true;
                this.initcourseNew();
                this.data1.sort();
                this.count = 0;
                this.groupId = null;
            },
            /*新建modal的newOk点击事件*/
            newOk (courseNew) {
                this.$refs[courseNew].validate((valid) => {
                    if (valid) {
                        if(true){
                            this.initcourse();
                            this.courseSet(this.courseNew);
                            this.axios({
                                method: 'post',
                                url: '/courses/course',
                                data: this.course
                            }).then(function (response) {
                                this.initcourseNew();
                                this.getTable({
                                    "pageInfo":this.pageInfo,
                                    "courseName":this.courseName
                                });
                                this.$Message.info('新建成功');
                            }.bind(this)).catch(function (error) {
                                alert(error);
                            });
                            this.newModal = false;
                        }else{
                            this.$Message.error('两次输入的时间不相同！');
                            this.loading = false;
                            this.$nextTick(() => {
                                this.loading = true;
                            });
                        }
                    }else {
                        this.$Message.error('表单验证失败!');
                        setTimeout(() => {
                            this.loading = false;
                            this.$nextTick(() => {
                                this.loading = true;
                            });
                        }, 1000);
                    }
                })
            },
            /*点击修改时判断是否只选择一个*/
            openModifyModal(){
                if(this.count > 1 || this.count < 1){
                    this.modifyModal= false;
                    this.$Message.warning('请至少选择一项(且只能选择一项)');
                }else{
                    this.modifyModal = true;
                }
            },
            /*修改modal的modifyOk点击事件*/
            modifyOk (courseModify) {
                this.$refs[courseModify].validate((valid) => {
                    if (valid) {
                        this.initcourse();
                        this.courseSet(this.courseModify);
                        this.axios({
                            method: 'put',
                            url: '/courses/'+this.course.id,
                            data: this.course
                        }).then(function (response) {
                            this.initcourseNew();
                            this.getTable({
                                "pageInfo":this.pageInfo,
                                "courseName":this.courseName
                            });
                            this.$Message.info('修改成功');
                        }.bind(this)).catch(function (error) {
                            alert(error);
                        });
                        this.modifyModal = false;
                    }else {
                        this.$Message.error('表单验证失败!');
                        setTimeout(() => {
                            this.loading = false;
                            this.$nextTick(() => {
                                this.loading = true;
                            });
                        }, 1000);
                    }
                })
            },
            /*modal的cancel点击事件*/
            cancel () {
                this.$Message.info('点击了取消');
            },
            /*table选择后触发事件*/
            change(e){
                if(e.length==1){
                    this.courseModifySet(e['0']);
                }
                this.setGroupId(e);
            },
            /*通过选中的行设置groupId的值*/
            setGroupId(e){
                this.groupId=[];
                this.count=e.length;
                for (var i = 0; i <= e.length - 1; i++) {
                    this.groupId.push(e[i].id);
                }
            },
            /*删除table中选中的数据*/
            del(){
                if(this.groupId!=null && this.groupId!=""){
                    this.axios({
                        method: 'delete',
                        url: '/courses',
                        data: this.groupId
                    }).then(function (response) {
                        this.getTable({
                            "pageInfo":this.pageInfo,
                            "courseName":this.courseName
                        });
                        this.groupId=null;
                        this.count=0;
                        this.$Message.info('删除成功');
                    }.bind(this)).catch(function (error) {
                        alert(error);
                    });
                }
            },
            /*表格中双击事件*/
            dblclick(e){
                this.courseModifySet(e);
                this.modifyModal = true;
                this.data1.sort();
            },
            /*流程配置*/
            relationSet(e){
                this.roleModal = true;
                this.data2 = [];
                this.axios({
                    method: 'get',
                    url: '/relations/'+e.id
                }).then(function (response) {
                    var roleList = [];
                    for(var i in response.data){
                        roleList.push(response.data[i].roleId);
                    }
                    for(var i in this.data2Temp){
                        if(roleList.indexOf(this.data2Temp[i].id) == -1){
                            this.data2.push({
                                "id": this.data2Temp[i].id,
                                "teacher": this.data2Temp[i].teacher,
                                "describe": this.data2Temp[i].describe,
                                "courseId": e.id,
                                "_checked": false
                            });
                        }else {
                            this.data2.push({
                                "id": this.data2Temp[i].id,
                                "teacher": this.data2Temp[i].teacher,
                                "describe": this.data2Temp[i].describe,
                                "courseId": e.id,
                                "_checked": true
                            });
                        }
                    }
                }.bind(this)).catch(function (error) {
                    alert(error);
                });
            },
            /*配置角色modal确认按钮点击事件*/
            roleOk(){
                if(this.relationList!=null){
                    this.axios({
                        method: 'post',
                        url: '/relations',
                        data: this.relationList
                    }).then(function (response) {
                        this.$Message.info('配置成功');
                    }.bind(this)).catch(function (error) {
                        alert(error);
                    });
                    this.relationList = null;
                }
            },
            /*配置角色modal中表选择改变事件*/
            change2(e){
                this.relationList = [];
                if(e.length == 0){
                    this.relationList.push({
                        "courseId": this.data2[0].courseId
                    });
                }
                for (var i in e) {
                    this.relationList.push({
                        "courseId": e[i].courseId,
                        "roleId": e[i].id
                    });
                }
            }
        }
    }
</script>