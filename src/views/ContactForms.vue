<template>
    <div class="contact-form">


        <form @submit.prevent="sendForm">
            <fieldset>

                <legend>Contact us!<br><br></legend>
                
            
                <BaseInput
                    v-model="form.formName"
                    label="Name"
                    type="text"
                    @input="updateFormName"
                    
                />
                <p class="errorMessage"> {{ formNameError }} </p>
                

                <BaseInput
                    v-model="form.email"
                    label="Email"
                    type="email"
                    @input="updateEmail"
                    
                />
                <p class="errorMessage"> {{ emailError }} </p>



                <div class="message-box">
                    <label>Message</label>
                    <textarea name="Message" v-model="form.message" placeholder="Enter a message"></textarea>
                </div>


                <button type="submit" :disabled="!isValid">Submit</button>

            </fieldset>

        </form>

        

    </div>

    


</template>

<script>
import axios from 'axios'
import { mapState } from 'vuex'
import BaseInput from '/src/components/BaseInput.vue'
 


export default {
    name: "ContactForms",
    data() {
        return {
            form: {
                formName: "",
                email: "",
                message: "",
            },
            formNameError: "",
            emailError: "",
            messageError: ""
        }
    },

    methods: {
        sendForm() {
            axios.post('http://localhost:3000/posts',
            this.form
            )
            .then(function (response) {
                console.log('Response', response)
                alert("Success!")
            })
            .catch(function (err) {
                console.log('Error', err)
                alert("Something went wrong!")
            })
            this.form.message = "";

        },
        validateEmail() {
        
            if (/^\w+([-]?\w+)*@\w+([-]?\w+)*(\.\w{2,3})+$/.test(this.form.email)) {
                return true;
            } else {
                return false;
            }
        },
        validateName() {
            const arr = this.form.formName.split(" ");
            if (arr.length > 1 && arr[1]) {
                
                return true;
            }
            return false;
        },
        updateFormName(e) {
            this.$store.commit('UPDATE_FORM_NAME', e.target.value)
            if (this.validateName()) this.formNameError = "";
            else this.formNameError = "Enter your full name";
            
        },
        updateEmail(e) {
            this.$store.commit('UPDATE_EMAIL', e.target.value)
            if (this.validateEmail()) this.emailError = ""
            else this.emailError = "Enter a valid email address"
        }

    },
    computed: {
        isValid () {
            return (this.validateEmail() && this.validateName() && this.form.message);
        },
        
    },
    created() {
        this.form.formName = this.$store.state.form.formName;
        this.form.email = this.$store.state.form.email;
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

    .errorMessage {
        color: rgb(154, 154, 252);
        color: #e94893;
        font-size: 15px;
        text-align: left;
        padding-left: 3%;
    }

    textarea {
        background-color:#202340;
        border: 1px #363959 solid;
        border-radius: 15px;
        padding-left: 3%;
        width: 100%;
        height: 100px;
        color:white;


        font-size: 14px;

        font-family: Avenir, Helvetica, Arial, sans-serif;
        -webkit-font-smoothing: antialiased;
        -moz-osx-font-smoothing: grayscale;
    }

    label {
       
        text-align: left;
        margin-bottom: 2%;
        margin-left: 3%;

        
    }

    .message-box {
        text-align: left;
        width: 100%;
    }



</style>