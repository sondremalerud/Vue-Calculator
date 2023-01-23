<template>
  <div class="calculator">
    <div class="display">{{ number || '0'}}</div>
    <!-- kan være buttons? -->
    <div class="calculator-button" @click="clear">C</div>
    <div class="calculator-button" @click="getAns">ANS</div>
    <div class="calculator-button" @click="deleteDigit">DEL</div>
    <div class="calculator-button" @click="addOperator('/')">÷</div>
    <div class="calculator-button" @click="addDigit('7')">7</div>
    <div class="calculator-button" @click="addDigit('8')">8</div>
    <div class="calculator-button" @click="addDigit('9')">9</div>
    <div class="calculator-button" @click="addOperator('*')">×</div>
    <div class="calculator-button" @click="addDigit('4')">4</div>
    <div class="calculator-button" @click="addDigit('5')">5</div>
    <div class="calculator-button" @click="addDigit('6')">6</div>
    <div class="calculator-button" @click="addOperator('-')">-</div>
    <div class="calculator-button" @click="addDigit('1')">1</div>
    <div class="calculator-button" @click="addDigit('2')">2</div>
    <div class="calculator-button" @click="addDigit('3')">3</div>
    <div class="calculator-button" @click="addOperator('+')">+</div>
    <div class="calculator-button" id="zero" @click="addDigit('0')">0</div>
    <div class="calculator-button" @click="addComma">.</div>
    <div class="calculator-button" @click="evaluate">=</div>
  </div>

  <div class="log">Log:</div>
</template>

<script>
export default {
  data() {
    return {
      number: '32131',
      ans: '3',
      currentOperator: '',
      previousNumber: '0',
    }
  },
  methods: {
    clear() {
      this.number = '';
      this.previousNumber = '';
      this.currentOperator = '';
    },

    addDigit(num) {
      this.number = this.number + num;
    },

    addComma() {
      if (!this.number.includes('.')){
        if (this.number === '' || this.number === '0') this.number = '0.'
        else this.number = this.number + '.';
      }
    },

    deleteDigit() {
      this.number = this.number.slice(0, -1);
    },

    getAns(){
      this.number = this.ans;
    },

    addOperator(operator) {
      this.operator = operator;
      this.previousNumber = this.number;
      this.number = '';

    },

    evaluate() {
      const temp = this.number;
      this.number = eval(this.previousNumber + this.operator + this.number);
      this.ans = this.number;
      this.previousNumber = temp;

      
      //fiks så 2+4 = 6 = 10 = 14 = 18 etc.
    }
  }
}
</script>

<style scoped>
.calculator{
  width: 400px;
  margin: 0 auto;
  font-size: 40px;
  display: grid;
  grid-template-columns: repeat(4, 1fr);
  grid-auto-rows: minmax(50px, auto);

}

.display {
  text-align: right;
  padding-right: 2%;
  grid-column: 1 / 5;
  background-color: rgb(97, 97, 200);
  background-color: #202340;
}

h1 {
  color: #2c3e50;
}

div {
  color:white;
}

.log {
  text-align: left;
  padding-left: 2%;
  background-color: #202340;

}

.calculator-button {
  border:1px #363959 solid;

}

.calculator-button:hover  {
  border:1px #999 solid;

}

.calculator-button:active {
  background-color: rgb(97, 97, 200);
}

#zero {
  grid-column: 1 / 3;
}


</style>
