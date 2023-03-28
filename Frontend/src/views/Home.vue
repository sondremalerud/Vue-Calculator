<template>
    <div v-if=this.isLoggedIn class="home">
        <br>
        <MyCalculator />
        
    </div>

    <div v-else class="home">
        <h3>Log in to use the calculator</h3>
    </div>
</template>

<script>
import MyCalculator from "/src/components/MyCalculator.vue";

export default {
    name: "Home",
    components: {
        MyCalculator
    },
    data() {
        return {
            isLoggedIn: false,
        }
    },
    mounted() {
        if (this.$store.state.username.length > 0){
            this.isLoggedIn = true;
        } else {
            this.isLoggedIn = false;
        }
    }
};
</script>

<style>

    h3 {
        color:rgb(192, 81, 247);
    }

</style>