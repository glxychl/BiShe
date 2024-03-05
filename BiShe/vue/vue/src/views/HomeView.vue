<template>
  <h3>队伍表</h3>
  <el-table :data="duiwuData" style="width: 100%">
    <el-table-column fixed prop="id" label="id" width="80" />
    <el-table-column prop="duizhang_id" label="队长ID" width="80" />
    <el-table-column prop="xiangMu_id" label="项目ID" width="80" />
    <el-table-column prop="duiwuName" label="队伍名" width="120" />
    <el-table-column prop="zhuan_ye" label="专业" width="120" />
    <el-table-column prop="shan_chang" label="需要技术" width="120" />
    <el-table-column prop="shu_liang" label="成员数量" width="120" />
    <el-table-column prop="chuangJian_time" label="创建时间" width="300" />
    <el-table-column prop="shenQing" label="申请者id" width="80" />
    <el-table-column prop="jian_jie" label="队伍简介" />
    <el-table-column fixed="right" label="操作" width="120">

      <template #="scope">
        <!-- <el-button link type="primary" size="small" @click="edit(scope.row)"
          >编辑</el-button
        > -->
        <el-button link type="danger" size="small" @click="deletedDuiwu(scope.row)">删除</el-button>
      </template>
    </el-table-column>
  </el-table>

  <h3>反馈表</h3>
  <el-table :data="fankuiData" style="width: 100%">
    <el-table-column fixed prop="id" label="id" width="80" />
    <el-table-column prop="xiangMu_id" label="项目id" width="80" />
    <el-table-column prop="xiangMu_name" label="项目名" width="220" />
    <el-table-column prop="fanKuiRen_id" label="反馈者id" width="80" />
    <el-table-column prop="fanKuiRen_name" label="反馈者名称" width="220" />
    <el-table-column prop="fanKui" label="反馈内容" />
    <el-table-column fixed="right" label="操作" width="120">
      <template #="scope">
        <el-button link type="danger" size="small" @click="deletedFankui(scope.row)">删除</el-button>
      </template>
    </el-table-column>
  </el-table>

  <h3>消息通知表</h3>
  <el-table :data="tongzhiData" style="width: 100%">
    <el-table-column fixed prop="id" label="id" width="80" />
    <el-table-column prop="beiTongZhiRen_id" label="被通知人id" width="80" />
    <el-table-column prop="beiTongZhiRen_name" label="被通知人名称" width="220" />
    <el-table-column prop="tongZhiRen_id" label="通知人id" width="80" />
    <el-table-column prop="tongZhiRen_name" label="通知人名称" width="220" />
    <el-table-column prop="isRead" label="已读情况" width="80" />
    <el-table-column prop="tongZhiNeiRong" label="通知内容" />
    <el-table-column fixed="right" label="操作" width="120">
      <template #="scope">
        <el-button link type="danger" size="small" @click="deleteTongzhi(scope.row)">删除</el-button>
      </template>
    </el-table-column>
  </el-table>

  <h3>用户表</h3>
  <el-table :data="userData" style="width: 100%">
    <el-table-column fixed prop="id" label="id" width="80" />
    <el-table-column prop="username" label="用户名" width="120" />
    <el-table-column prop="password" label="密码" width="120" />
    <el-table-column prop="safe" label="安全码" width="120" />
    <el-table-column prop="role" label="角色" width="80" />
    <el-table-column prop="name" label="姓名/企业名称" width="220" />
    <el-table-column prop="address" label="地址" width="220" />
    <el-table-column prop="contact" label="联系方式" width="220" />
    <el-table-column prop="zhuan_ye" label="专业领域" width="120" />
    <el-table-column prop="shan_chang" label="擅长技术" width="120" />
    <el-table-column prop="bu_shanchang" label="不擅长技术" width="120" />
    <el-table-column prop="experience" label="工作经历" width="600" />
    <el-table-column prop="gui_mo" label="企业规模" width="120" />
    <el-table-column prop="ye_wu" label="主营业务" width="600" />
    <el-table-column prop="duiWu" label="队伍号" width="80" />
    <el-table-column prop="isDuiZhang" label="是否队长" width="80" />
    <el-table-column prop="xiangMu_id" label="是否接单" width="80" />
    <el-table-column fixed="right" label="操作" width="120">
      <template #="scope">
        <el-button link type="danger" size="small" @click="deleteUser(scope.row)">删除</el-button>
      </template>
    </el-table-column>
  </el-table>

  <h3>项目表</h3>
  <el-table :data="xiangmuData" style="width: 100%">
    <el-table-column fixed prop="id" label="id" width="80" />
    <el-table-column prop="xiangMuMing" label="项目名" width="220" />
    <el-table-column prop="zhuan_ye" label="专业" width="120" />
    <el-table-column prop="shan_chang" label="需要技术" width="120" />
    <el-table-column prop="start_shijian" label="发布时间" width="300" />
    <el-table-column prop="end_shijian" label="截止时间" width="300"/>
    <el-table-column prop="qiye_id" label="企业id" width="80"/>
    <el-table-column prop="duizhang_id" label="队长id" width="80"/>
    <el-table-column prop="jie_duan" label="阶段" width="80"/>
    <el-table-column prop="xiang_qing" label="需求详情" />
    <el-table-column fixed="right" label="操作" width="120">
      <template #="scope">
        <el-button link type="danger" size="small" @click="deleteXiangmu(scope.row)">删除</el-button>
      </template>
    </el-table-column>
  </el-table>

  <h3>项目接取表</h3>
  <el-table :data="xiangmujiequData" style="width: 100%">
    <el-table-column fixed prop="id" label="id" width="80" />
    <el-table-column prop="xiangMu_id" label="项目id" width="80" />
    <el-table-column prop="xiangMu_name" label="项目名"  />
    <el-table-column prop="shenQingRen_id" label="申请人/队长id" width="220" />
    <el-table-column prop="shenQingRen_name" label="申请人姓名"  />
    <el-table-column prop="qiYe_id" label="企业id" width="80" />
    <el-table-column prop="qiYe_name" label="企业名称"  />
    <el-table-column prop="chuLiJieDuan" label="处理阶段" width="80" />
    <el-table-column fixed="right" label="操作" width="120">
      <template #="scope">
        <el-button link type="danger" size="small" @click="deleteXiangmujiequ(scope.row)">删除</el-button>
      </template>
    </el-table-column>
  </el-table>

</template>

<script lang="ts" setup>
import router from '@/router';
import { ref } from 'vue'
import axios from 'axios';
import { nextTick } from "vue";


// const activeIndex = ref('1')
// const handleSelect = (key: string, keyPath: string[]) => {
//   console.log(key, keyPath)
// }

nextTick(() => {
        getData();
    })
const getData=()=>{
  //队伍
  axios.get('/DuiWu/findAllduiwu', {
      params: {}
  }).then(function (res) {
      if(res.data.code == "200"){
        duiwuData.value = res.data.data
      }
  })
  //反馈
  axios.get('/fanKui/getAllFankui', {
      params: {}
  }).then(function (res) {
      if(res.data.code == "200"){
        fankuiData.value = res.data.data
      }
  })
  //通知
  axios.get('/TongZhi/getAllTongzhi', {
      params: {}
  }).then(function (res) {
      if(res.data.code == "200"){
        tongzhiData.value = res.data.data
      }
  })
  //用户
  axios.get('/user/getAllUser', {
      params: {}
  }).then(function (res) {
      if(res.data.code == "200"){
        userData.value = res.data.data
      }
  })
  //项目
  axios.get('/XiangMu/getAllXiangMu', {
      params: {}
  }).then(function (res) {
      if(res.data.code == "200"){
        xiangmuData.value = res.data.data
      }
  })
  //项目接取
  axios.get('/XiangMuJieQu/getAllXiangMuJieQu', {
      params: {}
  }).then(function (res) {
      if(res.data.code == "200"){
        xiangmujiequData.value = res.data.data
      }
  })
}
    
//队伍表
const duiwuData = ref([])
const deletedDuiwu=(value:any)=>{
  console.log(value.id);
  axios.get('/DuiWu/deleteDuiwuById', {
    params: {
      id:value.id
    }
  }).then(function (res) {
    if(res.data.code == "200"){
      getData();
    }
  })
}
//反馈表
const fankuiData = ref([])
const deletedFankui=(value:any)=>{
  console.log(value.id);
  axios.get('/fanKui/deleteFankuiById', {
    params: {
      id:value.id
    }
  }).then(function (res) {
    if(res.data.code == "200"){
      getData();
    }
  })
}
//通知表
const tongzhiData = ref([])
const deleteTongzhi=(value:any)=>{
  console.log(value.id);
  axios.get('/TongZhi/deleteTongZhiById', {
    params: {
      id:value.id
    }
  }).then(function (res) {
    if(res.data.code == "200"){
      getData();
    }
  })
}
//用户表
const userData = ref([])
const deleteUser=(value:any)=>{
  console.log(value.id);
  axios.get('/user/deleteUserById', {
    params: {
      id:value.id
    }
  }).then(function (res) {
    if(res.data.code == "200"){
      getData();
    }
  })
}
//项目表
const xiangmuData = ref([])
const deleteXiangmu=(value:any)=>{
  console.log(value.id);
  axios.get('/XiangMu/deleteXiangMuById', {
    params: {
      id:value.id
    }
  }).then(function (res) {
    if(res.data.code == "200"){
      getData();
    }
  })
}
//项目接取表
const xiangmujiequData = ref([])
const deleteXiangmujiequ=(value:any)=>{
  console.log(value.id);
  axios.get('/XiangMuJieQu/deleteXiangMuJieQuById', {
    params: {
      id:value.id
    }
  }).then(function (res) {
    if(res.data.code == "200"){
      getData();
    }
  })
}


</script>

<style>

</style>