const calc = require("../../calc");

$(document).ready(function () {
    $("#btn_add").click(function () {
        let n1 = $("#n1add").val();
        let n2 = $("#n2add").val();

        console.log(n1);
        console.log(n2);
        
        n1 = parseInt(n1);
        n2 = parseInt(n2);

        $("#res_add").val(calc.add(n1, n2));
    });


    $("#btn_sub").click(function () {
        let n1 = $("#n1sub").val();
        let n2 = $("#n2sub").val();

        n1 = parseInt(n1);
        n2 = parseInt(n2);

        $("#res_sub").val(calc.substract(n1, n2));
    });

    $("#btn_mult").click(function () {
        let n1 = $("#n1mult").val();
        let n2 = $("#n2mult").val();

        n1 = parseInt(n1);
        n2 = parseInt(n2);

        $("#res_mult").val(calc.multiply(n1, n2));
    });

    $("#btn_div").click(function () {
        let n1 = $("#n1div").val();
        let n2 = $("#n2div").val();

        n1 = parseInt(n1);
        n2 = parseInt(n2);

        $("#res_div").val(calc.divide(n1, n2));
    });

    $("#btn_sq").click(function () {
        let n = $("#nsq").val();

        n = parseInt(n);

        $("#res_sq").val(calc.square(n));

    });

    let numbers = [];
    $("#btn_sum").click(function () {
        let n = $("#nsum").val();
        
        n = parseInt(n);

        numbers.push(n);

        $("#res_sum").val(calc.sum(...[numbers]));
    });
});