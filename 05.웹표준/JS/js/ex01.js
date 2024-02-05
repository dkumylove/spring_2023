// defer 사용시 생략해도 실행가능
// defer = window.addEventListener("DOMContentLoaded", function()
//window.addEventListener("DOMContentLoaded", function() {
    // DOM 구성 완료후 실행됨
    const button = document.getElementById("button");
    console.log(button);
//});
