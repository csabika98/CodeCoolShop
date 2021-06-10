let totalPrice = 0
const initCart = {
    fetchData: function () {
        fetch('/api/cart')
            .then(response => response.json())
            .then(data => initCart.ShoppingSummary(data));

    },
    ShoppingSummary: function (data) {
        if (data !== null) {
            for (item of data.lineItems) {
                let row = document.createElement('tr')
                row.classList.add("table-success")
                let col1 = document.createElement('td')
                let col2 = document.createElement('td')
                let col3 = document.createElement('td')
                let delbtn = document.createElement("button")
                delbtn.setAttribute("type","button")
                delbtn.addEventListener("click",function () {
                    const cart = document.getElementById("myTable");
                    initCart.delRow(delbtn)
                    pr.textContent = "";
                })
                col1.innerHTML = item.productName
                col2.innerHTML = item.quantity
                col3.innerHTML = item.price
                row.appendChild(col1)
                row.appendChild(col2)
                row.appendChild(col3)
                totalPrice += item.price
                document.querySelector('tbody').appendChild(row).appendChild(delbtn)
            }
            const pr = document.createElement("h2")
            pr.style.float = "right";
            console.log("why????")
            pr.textContent = "Total price: " + totalPrice.toFixed(2)
            document.querySelector('tbody').appendChild(pr)
            console.log("1")
            }
        },
    delRow:function (i){
    document.getElementById('myTable').deleteRow(i)

    }
}
    window.onload = function () {
        initCart.fetchData();
        initCart.ShoppingSummary();
        initCart.postData();
    }