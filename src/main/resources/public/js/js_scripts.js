document.addEventListener('DOMContentLoaded', function() {
    const questionRange = document.getElementById("questionRange");
    const rangeAnswer = document.getElementById("rangeAnswer");

    questionRange.addEventListener("change", function(event) {
        rangeAnswer.value = questionRange.value;
    });
});