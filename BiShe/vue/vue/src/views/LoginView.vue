<template>
    <div class="common-layout">
        <el-container>
            <el-header>
                <el-menu :default-active="activeIndex" class="el-menu-demo" mode="horizontal" :ellipsis="false"
                    @select="handleSelect">

                    <h3>企业资源对接管理平台</h3>

                </el-menu>
            </el-header>
            <el-main>
                <!-- <router-view></router-view> -->
                <Login></Login>
            </el-main>
        </el-container>
    </div>
</template>


<script lang="ts" setup>
import router from '@/router';
import { ref } from 'vue'
import Login from '@/components/Login.vue';

const activeIndex = ref('1')
const handleSelect = (key: string, keyPath: string[]) => {
    console.log(key, keyPath)
}

const index = ref(router.currentRoute.value)
const switchSubRouter=()=>{
    index.value = router.currentRoute.value

    
}
</script>
