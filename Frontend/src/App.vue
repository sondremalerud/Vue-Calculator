<template>
  <div id="app">
    <div id="nav">
      <router-link to="/">Calculator</router-link> |
      <router-link to="/ContactForms">Contact forms</router-link> |
      <router-link to="/LoginPage">Login</router-link>
    </div>
    <div id="current-login"><p>Currently logged in as: {{ this.$store.state.username }}</p></div>
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

  created() {
      //this.username = this.$store.state.username;
  }

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

</style>
