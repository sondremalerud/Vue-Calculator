<template>
    <div class="home">
        <MyCalculator />
        
    </div>
</template>

<script>
import MyCalculator from "@/components/MyCalculator.vue";

export default {
    name: "Home",
    components: {
        MyCalculator
    }
};
</script>