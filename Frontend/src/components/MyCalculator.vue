<template>
  <div class="calculator">
    <div class="controls">
      <div class="display" id="display">{{ number || "0" }}</div>
      <button class="calculator-button" id="btn-clear" @click="clear">C</button>
      <button class="calculator-button" id="btn-ans" @click="getAns">ANS</button>
      <button class="calculator-button" @click="deleteDigit">DEL</button>
      <button class="calculator-button" @click="addOperator('/')">÷</button>
      <button class="calculator-button" @click="addDigit('7')">7</button>
      <button class="calculator-button" @click="addDigit('8')">8</button>
      <button class="calculator-button" @click="addDigit('9')">9</button>
      <button class="calculator-button" @click="addOperator('*')">×</button>
      <button class="calculator-button" @click="addDigit('4')">4</button>
      <button class="calculator-button" @click="addDigit('5')">5</button>
      <button class="calculator-button" @click="addDigit('6')">6</button>
      <button class="calculator-button" @click="addOperator('-')">-</button>
      <button class="calculator-button" id="btn-1" @click="addDigit('1')">1</button>
      <button class="calculator-button" @click="addDigit('2')">2</button>
      <button class="calculator-button" @click="addDigit('3')">3</button>
      <button class="calculator-button" id="btn-plus" @click="addOperator('+')">+</button>
      <button class="calculator-button" id="zero" @click="addDigit('0')">
        0
      </button>
      <button class="calculator-button" @click="addComma">.</button>
      <button class="calculator-button" id="btn-evaluate" @click="evaluate">=</button>
    </div>

    <div class="log" id="log">
      <ul>
        <li v-for="item in logItems" v-bind:key="item" type="kebab">
          {{ item }}
        </li>
      </ul>
    </div>
  </div>
</template>

<script>
export default {
  name: "MyCalculator",
  data() {
    return {
      number: "",
      ans: "",
      currentOperator: "",
      previousNumber: "0",
      logItems: [],
    };
  },
  methods: {
    clear() {
      this.number = "";
      this.previousNumber = "";
      this.currentOperator = "";
    },

    addDigit(num) {
      this.number = this.number + num;
    },

    addComma() {
      if (!this.number.includes(".")) {
        if (this.number === "" || this.number === "0") this.number = "0.";
        else this.number = this.number + ".";
      }
    },

    deleteDigit() {
      this.number = this.number.toString().slice(0, -1);
    },

    getAns() {
      this.number = this.ans;
    },

    addOperator(operator) {
      this.operator = operator;
      this.previousNumber = this.number;
      this.number = "";
    },

    evaluate() {
      const temp = this.number;
      this.number = eval(this.previousNumber + this.operator + this.number);

      this.logItems.unshift(
        this.previousNumber +
          " " +
          this.operator +
          " " +
          temp +
          " = " +
          this.number
      );
      this.ans = this.number;
      this.previousNumber = temp;
    },
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
