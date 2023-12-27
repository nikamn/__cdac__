exports.product = function (x, y) {
  return x * y;
};
exports.sum = function (x, y) {
  return x + y;
};
exports.diff = function (x, y) {
  return x - y;
};
exports.divide = function (x, y) {
  return x / y;
};
exports.power = function (base, supers) {
  let p = 1;
  for (let i = 1; i <= supers; i++) {
    p = base * p;
  }
  return p;
};
exports.factorial = function (range) {
  return factorial(range);
};
function factorial(range) {
  let f = 1;
  for (let i = 1; i <= range; i++) {
    f = f * i;
  }
  return f;
}
exports.permutation = function (n, r) {
  return factorial(n) / (factorial(n) * factorial(n - r));
};
exports.combinaton = function (n, r) {
  return factorial(n) / factorial(n - r);
};
