<template>
    <div class="content">
    <label v-if="label">{{ label }}</label>
    <input
      v-bind="$attrs"
      :value="modelValue"
      :placeholder="label"
      @input="$emit('update:modelValue', $event.target.value)"
      class="field"
    >
    <p v-if="error" class="errorMessage">
      {{ error }}
    </p>
  </div>
  </template>
  
  <script>
    
    export default {
        name: "BaseInput",
        props: {
            label: {
                type: String,
                default: ''
            },
            modelValue: {
                type: [String, Number],
                default: ''
            },
            error: {
              type: String,
              default: ''
            }
        }
    }
  </script>

<style scoped>
  .errorMessage {
    color: rgb(154, 154, 252);
    color: #e94893;
    font-size: 15px;
    text-align: left;
    padding-left: 3%;
  }

  .content{
    position: relative;
  }

  input{
    height: 2rem;
    width: 20rem;
    /*border: 1px solid #42b983;*/
    border-radius: 15px;
    background-color: #202340;
    color: white;
    border: 1px #363959 solid;
    padding-left: 3%;

    font-family: Avenir, Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;

  }

  ::placeholder {
    position: absolute;
    top: 0;
    bottom: 0;
    left: 0;
    right: 0;
    border: 3px solid transparent;
    background-color: transparent;
    display: flex;
    align-items: center;
  
  }

  input, label {
    display:block;
    
  }

  label {
    text-align: left;
    margin-left: 3%;
    margin-bottom: 2%;
  }

  input:hover {
    border: 1px #999 solid;
  }



</style>