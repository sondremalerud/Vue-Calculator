<template>
    <div class="contact-form">

    


        <form @submit.prevent="sendForm">
            <fieldset>

                <legend>123 🧌</legend>
            
                <BaseInput
                    v-model="form.formName"
                    label="Name"
                    type="text"
                />

                <BaseInput
                    v-model="form.email"
                    label="Email"
                    type="email"
                />

                <BaseInput
                    v-model="form.message"
                    label="Message"
                    type="text"
                    id="message"
                />
            
                <textarea name="Message" id="message" cols="30" rows="10"></textarea>

                <button type="submit">Submit</button>

            </fieldset>

        </form>

        

    </div>

    


</template>

<script>
import axios from 'axios'
import { useField } from 'vee-validate'



export default {
    name: "ContactForms",
    data() {
        return {
            form: {
                formName: "",
                email: "",
                message: ""
            },
        }
    },
    methods: {
        sendForm() {
            axios.post('http://localhost:3000/posts',
            this.form
            )
            .then(function (response) {
                console.log('Response', response)
            })
            .catch(function (err) {
                console.log('Error', err)
            })
        }
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

    fieldset {
        border: 0;
        margin: 0;
        padding: 0;
    }

    legend {
        font-size: 28px;
        font-weight: 700;
        margin-top: 20px;
    }


</style>