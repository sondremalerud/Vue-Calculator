<template>
    <h1>Kebab</h1>
    <form>
        <p>keab</p>
        <BaseInput
            v-model="form.formName"
            label="Name"
            type="text"
        />

    </form>


</template>

<script>
import BaseInput from "@/components/BaseInput.vue";


export default {
    name: "ContactForms",
    data() {
        return {
            form: {
                formName: "",
                email: "",
                message: ""
            }
        }
    },
    components: {
        BaseInput
    }
}
</script>