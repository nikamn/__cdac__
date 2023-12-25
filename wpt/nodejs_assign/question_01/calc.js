add = (a, b) => {
  return a + b;
};

substract = (a, b) => {
  return a - b;
};

multiply = (a, b) => {
  return a * b;
};

divide = (a, b) => {
  return a / b;
};

square = (a) => {
  return a * a;
};

sum = (a, b, ...c) => {
  let sum = 0;
  sum += a + b;

  c.forEach((element) => {
    sum += element;
  });

  return sum;
};

export default { add, substract, multiply, divide, sum, square };
