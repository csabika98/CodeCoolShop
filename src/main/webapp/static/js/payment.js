const initPayment = {
    AddPaymentListener: function () {
        const paypalRadio = document.querySelector("#paypal");
        const creditRadio = document.querySelector("#credit");
        const paypal = document.querySelector(".paypal")
        const credit = document.querySelector(".credit-card")
        paypalRadio.addEventListener("change", function ( event){
            if (paypalRadio.checked === true){
                paypal.setAttribute("hidden", true);
                credit.setAttribute("hidden", false);
            } else {
                paypal.setAttribute("hidden", false);
                credit.setAttribute("hidden", true);
            }
        })

    }
}
window.onload = function () {
    initPayment.AddPaymentListener();
}