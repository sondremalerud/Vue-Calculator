import { createApp } from 'vue'
import './style.css'
import App from './App.vue'
import router from './router/index.js'
import store from './store'
import BaseInput from './components/BaseInput.vue'


const app = createApp(App);
app.component('BaseInput', BaseInput);
app.use(router);
app.use(store);
app.mount('#app');



