let scoreInput = document.querySelector("#scoreInput");
let submit = document.querySelector("#submit");
let result = document.querySelector("#result");

submit.addEventListener('click', function() {
    const score = Number(scoreInput.value);

    if(score >= 90 && score <= 100) {
        result.textContent = "Excellent";
    } else if (score >= 75 && score <= 89) {
        result.textContent = "Passed";
    } else if (score >= 60 && score <= 74) {
        result.textContent = "Needs Improvement";
    } else if (score >= 0 && score <= 59){
        result.textContent = "Failed";
    } else if (score > 100){
        result.textContent =  "The score are greater than 100";
    } else if (score < 0) {
        result.textContent = "The score are less than 0";
    }
}); 
