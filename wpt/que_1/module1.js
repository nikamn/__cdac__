export function factorial(num) {
    var fact = 1;
    for(var i = 1; i <= num; i++){
        fact *= i;
    }
    return fact;
}

export function myprime(num) {
    var count = 0;
    for(var i=2; i <= Math.floor(Math.sqrt(num)); i++){
        if(num % i === 0){
            count = count + 1;
            break;
        }
    }
    if(count == 0){
        return true;
    }
    return false;
}

export function printable(num) {
    var arrNum = [];
    for(var i = 1; i <= 10; i++){
        arrNum.push(num * i);
        console.log(num * i);
    }
    return arrNum;
}