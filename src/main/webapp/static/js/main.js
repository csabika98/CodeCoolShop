const initCart = {
    fetchData: function () {
        function AddShoppingList(data) {
            const cart = document.getElementById("shopping-list");
            cart.innerHTML = ""
            if (data!==null){
                for (item of data.lineItems){
                    const card = document.createElement("div")
                    const product= document.createElement("div")
                    const quantity= document.createElement("div")
                    const price = document.createElement("div")
                    product.textContent = "Product name: " + item.productName
                    quantity.textContent = "Quantity: x" + item.quantity
                    price.textContent = "Price: " + item.price
                    card.classList.add("card", "w-auto","p-3")
                    card.append(product,quantity,price)
                    cart.append(card)
                }
            }
        }

        fetch('/api/cart')
            .then(response => response.json())
            .then(data => AddShoppingList(data));
    },
    postData:function (){
        const buttons = document.querySelectorAll('.btn')
        buttons.forEach(function(currentBtn){
            currentBtn.addEventListener('click', function (){
                const data = new FormData();
                data.append("json", JSON.stringify(this.dataset.id))
                fetch("/addtocart", {
                    method:"POST",
                    credentials:"same-origin",
                    body: data,
                    headers: {
                        'Content-Type': 'application/json'
                    }
                })
                    .then(function(res){ return res.json(); })
                    .then(initCart.fetchData())
            })
        })
    }
}
window.onload = function (){
    initCart.fetchData();
    initCart.postData();
}