function showTotal() {
    let price = document.getElementById("productPrice").value;
    console.log(price);
    let quantity = document.getElementById("quantity").value;
    console.log(quantity);
    let total = price * quantity;
    console.log(total);
    document.getElementById("total").innerHTML = total.toString();
}

function searching() {

}

function like() {

}