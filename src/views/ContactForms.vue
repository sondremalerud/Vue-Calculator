<template>
    <div class="contact-form">

    
        <h1>123 🧌</h1>
        
            
            <BaseInput
                v-model="form.formName"
                label="Name"
                type="text"
            />

            <BaseInput
                v-model="form.email"
                label="Email"
                type="text"
            />

            <BaseInput
                v-model="form.message"
                label="Message"
                type="text"
                id="message"
            />
        
            <textarea name="Message" id="message" cols="30" rows="10"></textarea>

            <button>Submit</button>

        

    </div>

    


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

<style scoped>


    div {
        color: white;
    }

    .contact-form {
        display: flex;
        max-width: 500px;
        flex-direction: column;
        max-width: 400px;
        min-width: 50%;
        font-size: 20px;
        align-items: center;
        margin: 0 auto;

    }

    #message {
        resize: both;

    }


</style>