const add = (a, b) => {
  return a + b;
};

const substract = (a, b) => {
  return a - b;
};

const multiply = (a, b) => {
  return a * b;
};

const divide = (a, b) => {
  return a / b;
};

const square = (a) => {
  return a * a;
};

const sum = (...nums) => {
  let sum = 0;

  nums.forEach((element) => {
    sum += element;
  });

  return sum;
};

module.exports = { add, substract, multiply, divide, sum, square };
