const c = require("./calc");

console.log("2 + 3 = ", c.sum(2, 3));
console.log("10 - 5 = ", c.substract(10, 5));
console.log("-8 * 3 = ", c.multiply(-8, 3));
console.log("12 / 0 = ", c.divide(12, 0));
console.log("pow(7, 2)  = ", c.square(7));
console.log("1 + ... + 9 = ", c.sum(1, 2, ...[3, 4, 5, 6, 7, 8, 9]));
