<template>
    <div class="home">
        <br>
        <MyCalculator />
        
    </div>
</template>

<script>
import MyCalculator from "/src/components/MyCalculator.vue";

export default {
    name: "Home",
    components: {
        MyCalculator
    }
};
</script>