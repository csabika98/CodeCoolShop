const initPayment = {
    AddPaymentListener: function () {
        const paypalRadio = document.querySelector("#paypal");
        const creditRadio = document.querySelector("#credit");
        const paypal = document.querySelector(".paypal")
        const credit = document.querySelector(".credit-card")
        paypalRadio.addEventListener("change", function ( event){
            if (paypalRadio.checked === true){
                paypal.style.visibility="visible";
                credit.style.visibility="hidden";
            }
        })
        creditRadio.addEventListener("change", function ( event){
            if (creditRadio.checked === true){
                paypal.style.visibility="hidden";
                credit.style.visibility="visible";
            }
        })

    }
}
window.onload = function () {
    initPayment.AddPaymentListener();
}