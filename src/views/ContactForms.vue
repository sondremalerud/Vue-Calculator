<template>
    <div class="contact-form">


        <form @submit.prevent="sendForm">
            <fieldset>

                <legend>123 🧌</legend>
            
                <BaseInput
                    v-model="form.formName"
                    label="Name"
                    type="text"
                    required
                />

                <BaseInput
                    v-model="form.email"
                    label="Email"
                    type="email"
                    required
                />


                <label>Message</label>
                <textarea name="Message" id="message" cols="30" rows="10" v-model="form.message"></textarea>

                <button type="submit" :disabled="!isValid">Submit</button>

            </fieldset>

        </form>

        

    </div>

    


</template>

<script>
import axios from 'axios'


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
        },
        validateEmail() {
        
            if (/^\w+([-]?\w+)*@\w+([-]?\w+)*(\.\w{2,3})+$/.test(this.form.email)) {
                return true;
            } else {
                console.log("truuuue");
                return false;
            }
        },
        validateName() {
            const arr = this.form.formName.split(" ");
            if (arr.length > 1 && arr[1]) {
                console.log("ye")
                return true;
            }
            return false;
        },
/*         validate() {
            this.v$.$validate();
            if (!this.v$.$error) this.$refs['submitBtn'].disabled = false;
            else {
                this.$refs['submitBtn'].btnIsDisabled = true;
                alert('kebba')

            }
        } */

    },
    computed: {
        isValid () {
            //return this.form.formName && this.form.email && this.form.message;

            return (this.validateEmail() && this.validateName() && this.form.message);
        }
    }
}




    
    

/* 
        const email = useField('email', function (value) {
            if (!value) return 'This field is required'

            const regex = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/
            if (!regex.test(String(value).toLowerCase())) {
                return 'Please enter a valid email address'
            }

            return true
        })

        const formName = useField('formName', function (value) {
            if (!value) return 'This field is required'
            if (!value.split(" ") > 1) return 'Please enter your full name'
            return true
        }) */

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
        display: flex;
        max-width: 500px;
        flex-direction: column;
        max-width: 400px;
        min-width: 50%;
        font-size: 20px;
        align-items: center;
        margin: 0 auto;
    }

    legend {
        font-size: 28px;
        font-weight: 700;
        margin-top: 20px;
        margin: 0 auto;
    }


</style>