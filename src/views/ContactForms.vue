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
                    id="form-name"
                    
                />
                <p class="errorMessage"> {{ formNameError }} </p>
                
                <BaseInput
                    v-model="form.email"
                    label="Email"
                    type="email"
                    @input="updateEmail"
                    id="email"
                    
                />
                <p class="errorMessage"> {{ emailError }} </p>

                <div class="message-box">
                    <label>Message</label>
                    <textarea name="Message" v-model="form.message" placeholder="Enter a message" id="message"></textarea>
                </div>

                <button type="submit" :disabled="!isValid" id="btn-submit">Submit</button>
                <p class="feedbackMessage"> {{feedback}}</p>

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
            messageError: "",
            feedback: ""
        }
    },

    methods: {
        sendForm() {
            axios.post('http://localhost:3000/posts',
            this.form
            )
            .then(response => {
                console.log('Response', response)
                this.feedback = "✓ Form submitted";
            })
            .catch(err => {
                console.log('Error', err)
                this.feedback = "✖ Something went wrong!";
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
        },


    },
    computed: {
        isValid () {
            return (this.validateEmail() && this.validateName() && this.form.message);
        }        
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
        color: #e94893;
        font-size: 15px;
        text-align: left;
        padding-left: 3%;
    }

    .feedbackMessage {      
        color: #48e96b;
        font-size: 18px;
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
        display: flex;
        flex-direction: column;
        justify-content:space-between;
    
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

    button:disabled {
        opacity: 0.5;

    }


</style>