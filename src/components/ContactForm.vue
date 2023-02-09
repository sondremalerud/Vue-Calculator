<template>
    <div class="contact-form">
        
        <h2>Contact us!</h2>
        <label v-if="label"> {{ label }} </label>
        <input 
            :value="modelValue"
            :placeholder="label"
            @input="$emit('update:modelValue', $event.target.value)"
            class="field"
        >


<!--             
            <p>
                <input type="text" placeholder="Name" v-model="formName"/>
            </p>
            <p>
                <input type="text" placeholder="Email" v-model="email"/>
                <span v-if="v$.email.$error">
                    {{ v$.email.$errors[0].$message }}
                </span>
            </p>
            <p>
                <input type="text" placeholder="Message" v-model="message"/>
            </p>

            <button @click="submitForm">Submit</button> -->


<!--             <label for="formName">Name:</label><br>
            <input type="text" id="formName" name="formName" required><br>
            <label for="email">Email:</label><br>
            <input type="text" id="email" name="email" required><br>
            <label for="message">Message:</label><br>
            <input type="text" id="message" name="message" required><br>
            <input type="submit" value="Submit"> -->
        
    


    </div>    
</template>
  
<script>

import useValidate from '@vuelidate/core'
import { required, email } from '@vuelidate/validators'

export default {
    


    data() {
      return {
        props: {
            label: {
                type: String,
                default: ''
            },
            modelValue: {
                type: [String, Number],
                default: ''
            }
        },
        form: {
                formName: "",
                email: "",
                message: ""
            },

        v$: useValidate(),
/*         formName: "",
        email: "",
        message: "" */

      };
    },
    validations() {
        return {
            formName: { required },
            email: { required, email },
            message: { required },
        }
    },
    methods: {
      validateEmail() {
        if (/^\w+([-]?\w+)*@\w+([-]?\w+)*(\.\w{2,3})+$/.test(this.email)) {
            this.msg['email'] = 'Please enter a valid email address';
        } else {
            this.msg['email'] = '';
        }
      },

      submitForm() {
        this.v$.$validate()
        if (!this.v$.$error) {
            alert("kebab")
        } else {
            alert("fail")
        }
      }


    },
  };
  </script>
   
<style scoped>
.controls {
max-width: 400px;
min-width: 50%;
font-size: 20px;
display: grid;
grid-template-columns: repeat(4, 1fr);
grid-auto-rows: minmax(50px, auto);
}

.calculator {
display: flex;
flex-direction: row;
margin: 0 auto;
justify-content: center;
max-width: 800px;
}

.display {
text-align: right;
padding-right: 2%;
grid-column: 1 / 5;
background-color: rgb(97, 97, 200);
background-color: #202340;
font-size: 40px;
}

h1 {
color: #2c3e50;
}

div {
color: white;
}

.log {
width: 200px;
text-align: left;
background-color: #202340;
overflow: scroll;
overflow-x: hidden;
overflow-y: auto;

align-self: flex-start;
height: 305px;
}

.calculator-button {
border: 1px #363959 solid;
background-color: #0f1126;
color: white;
font-size: 30px;
}

.calculator-button:hover {
border: 1px #999 solid;
}

.calculator-button:active {
/*   background-color: #5922a5;*/
background-color: #42b983;
}

#zero {
grid-column: 1 / 3;
}

.log ul li {
list-style-type: none;
}

.log ul {
padding-top: 20%;
padding-left: 2%;
}

@media only screen and (max-width: 768px) {
.calculator {
    flex-direction: column;

    justify-content: center;
    align-items: center;
}

.controls {
    width: 100%;
    min-height: 200px;
    margin: 0 auto;
}
.log {
    width: 100%;
    max-width: 400px;
    min-height: 200px;
    margin: 0 auto;
}

.log ul {
    padding-top: 0%;
}
}
</style> 