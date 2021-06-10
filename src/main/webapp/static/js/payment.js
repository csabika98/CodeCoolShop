const initPayment = {
    AddPaymentListener: function () {
        const paypalRadio = document.querySelector("#paypal");
        paypalRadio.addEventListener("change", function ( event){
            if (paypalRadio.checked === true){

            } else {

            }
        })

    }
}
window.onload = function () {
    initPayment.AddPaymentListener();
}