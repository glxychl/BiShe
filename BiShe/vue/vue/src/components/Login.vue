<template>
    <div style="width: 500px;margin: auto;">
        <el-form :model="form" label-width="120px">
            <el-form-item label="用户名：">
                <el-input v-model="form.username" />
            </el-form-item>
            <el-form-item label="密码：">
                <el-input v-model="form.password" />
            </el-form-item>
            
            
            <div style="margin-left: 25%;">
                <el-form-item>
                    <el-button type="primary" @click="onSubmit">登录</el-button>
                </el-form-item>
            </div>
        </el-form>
    </div>
</template>

<script lang="ts" setup>
import router from '@/router';
import { reactive } from 'vue';
import axios from 'axios';

// do not use same name with ref
const form = reactive({
  username: '',
  password: '',
})

const onSubmit = () => {
    console.log('submit!')
    axios.get('/user/login',{
        params:{
            username:form.username,
            password:form.password
        }
    }).then(function (res){
        console.log(res.data);
        
        if(res.data.code == "200"){
            router.push('/home')
        }
    })
}
</script>