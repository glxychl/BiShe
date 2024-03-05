// import './assets/main.css'

import { createApp } from 'vue'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import App from './App.vue'
import router from './router'
import axios from 'axios';
import VueAxios from 'vue-axios'

const app = createApp(App)

app.config.globalProperties.$axios = axios
axios.defaults.baseURL = "http://localhost:9000"

app.use(router)
app.use(ElementPlus)
app.use(VueAxios, axios)

app.mount('#app')
