const operation = (operation) => {
    var originalString = document.getElementById("org-string").value;
    var subString = document.getElementById("sub-string").value;
    var replaceString = document.getElementById("replace-string").value;
    switch (operation) {
        case "search":
            if(originalString.includes(subString)){
                return "Sub String present";
            }
            return "Sub string not present";

        case "upper":
            return originalString.toUpperCase();

        case "lower":
            return originalString.toLowerCase();

        case "trim":
            return originalString.trim();

        case "concat":
            return originalString.concat(subString);
            
        case "replace":
            return originalString.replace(subString, replaceString); 
    
        default:
            return "invalid operation"; 
    }
}

const manipulateString = () => {
    var operList = document.getElementsByName("str-mani");
    var result = document.getElementById("result");
    var operationResult;
    for(var i=0; i<operList.length; i++){
        if(operList[i].checked){
            operationResult = operation(operList[i].id);
        }
    }
    result.innerHTML = operationResult;
}