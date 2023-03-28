<template>
  <div id="app">
    <div id="nav">
      <router-link to="/">Calculator</router-link> |
      <router-link to="/ContactForms">Contact forms</router-link> |
      <router-link to="/LoginPage">Login</router-link>
    </div>
    <router-view />
  </div>  
</template>


<script>
import { mapState } from 'vuex'

export default {
  data() {
    return {
        username: "",
      }
  },

}

</script>



<style scoped>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  background-color: #0f1126;
}

body {
  background-color: #0f1126;
}

#nav {
  padding:30px;
}

#nav a {
  font-weight: bold;
  color: white;
}

#nav a.router-link-exact-active {
  color: #42b983;
}

#current-login {
  position: absolute;
  top: 0;
  left: 2%;
  padding-top: 22px;
  color: white;

}

button {
        margin-top: 20px;
        border: 1px #363959 solid;
        background-color:#202340;
        color: white;
        border-radius: 15px;
        font-size: 16px;
        width: 100px;
        height: 30px;

    }

button:hover:enabled {
    border: 1px #999 solid;
}

</style>
