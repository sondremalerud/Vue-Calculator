<template>
    <div class="login">
        <legend>Welcome back<br><br></legend>
        <BaseInput
            v-model="username"
            label="Username"
            @input="updateUsername"
        />

        <button>Log in</button>


    </div>




</template>

<script>

export default {
    name: "LoginPage",
    data() {
        return {
            username: "",
            
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


</style>