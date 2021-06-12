const initCart = {
    fetchData: function () {
        fetch('/api/cart')
            .then(response => response.json())
            .then(data => initCart.ShoppingSummary(data));

    },
    ShoppingSummary: function (data) {
        let tbody = document.querySelector('.orderBody');
        tbody.innerHTML = "";
        let index = 1;
        for (let item of data.lineItems) {
            let outerHTML =
                `<tr>
                    <th>${index}</th>
                    <td>${item.productName}</td>
                    <td>${item.supplier}</td>
                    <td>${item.productPrice}</td>
                    <td>${item.quantity}</td>
                    <td class="text-start"><i class="fas fa-minus-circle me-2"></i><i class="fas fa-plus-circle"></i></td>
                    <td>${item.linePrice}</td>
                    <td><i class="fas fa-trash lineRemover" data-productId="${item.productId}"></i></td>
                </tr>`
            tbody.insertAdjacentHTML("beforeend", outerHTML);
            index++;
        }
        initCart.addRemoveListener();
    },
    addRemoveListener: function() {
        let removers = document.querySelectorAll(".lineRemover");
        for(let remover of removers){
            remover.addEventListener("click", function(event){
                let productId = event.target.getAttribute('data-productId');
                console.log(productId);
                fetch("/deletelineitem", {
                    method: "POST",
                    credentials: "same-origin",
                    body: productId,
                    headers: {
                        'Content-Type': 'text/plain'
                    }
                }).then(initCart.fetchData)
                    .then(initCart.ShoppingSummary)
            });
        }

    },
}
window.onload = function () {
    initCart.fetchData();
    initCart.ShoppingSummary();
}