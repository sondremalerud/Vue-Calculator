<template>
    <div class="login">
        <legend>Welcome back<br><br></legend>
        <BaseInput
            v-model="username"
            label="Username"
            id="login-field"
        />
        <p class="errorMessage"> {{ errorFeedback }}</p>
        <button @click="login">Log in</button>

    </div>




</template>

<script>
import axios from 'axios'
import router from "../router/index.js";

export default {
    name: "LoginPage",
    data() {
        return {
            username: "",
            errorFeedback: "",
        }
    },
  methods: {
      login() {
        let input = document.getElementById("login-field");

        axios.get('http://localhost:8888/users?username=' + this.username)
            .then(response => {
              console.log("yes")
              this.$store.commit('UPDATE_USERNAME', response.data)
              this.username = ""
              this.errorFeedback = ""
              router.push('/')
            })
            .catch(err => {
              console.log('Could not login')
              this.errorFeedback = "Could not log in, try again"
            })

      }


  }
}

</script>

<style scoped>

    div {
        color: white;
    }

    .login {
        display: flex;
        max-width: 500px;
        flex-direction: column;
        max-width: 400px;
        min-width: 50%;
        font-size: 20px;
        align-items: center;
        margin: 0 auto;


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
    legend {
        font-size: 28px;
        font-weight: 700;
        margin-top: 20px;
        margin: 0 auto;
    }

    .errorMessage {
      color: #e94893;
      font-size: 15px;
      text-align: left;
      padding-left: 3%;
    }

    .loginMessage {
      color: #48e96b;
      font-size: 15px;
      text-align: left;
      padding-left: 3%;

    }


</style>