let firstName = document.forms["userForm"]["firstName"];
let lastName = document.forms["userForm"]["lastName"];
let dateOfBirth = document.forms["userForm"]["dateOfBirth"];
let phoneNumber = document.forms["userForm"]["phoneNumber"];
let email = document.forms["userForm"]["email"];
let username = document.forms["userForm"]["username"];
let password = document.forms["userForm"]["password"];
let address = document.forms["userForm"]["address"];

let firstNameError = document.getElementById("firstNameError");
let lastNameError = document.getElementById("lastNameError");
let dateOfBirthError = document.getElementById("dateOfBirthError");
let phoneNumberError = document.getElementById("phoneNumberError");
let emailError = document.getElementById("emailError");
let usernameError = document.getElementById("usernameError");
let passwordError = document.getElementById("passwordError");
let addressError = document.getElementById("addressError");

firstName.addEventListener("blur", firstNameVerify, true);
lastName.addEventListener("blur", lastNameVerify, true);
dateOfBirth.addEventListener("blur", dateOfBirthVerify, true);
phoneNumber.addEventListener("blur", phoneNumberVerify, true);
email.addEventListener("blur", emailVerify, true);
username.addEventListener("blur", usernameVerify, true);
password.addEventListener("blur", passwordVerify, true);
address.addEventListener("blur", addressVerify, true);

function validate() {
    if (firstName.value == ""){
        firstName.style.border = "1px solid red";
        firstNameError.textContent = "Không được để trống Tên";
        firstName.focus();
        return false;
    }
    if (lastName.value == ""){
        lastName.style.border = "1px solid red";
        lastNameError.textContent = "Không được để trống Họ và tên đệm";
        lastName.focus();
        return false;
    }
    if (dateOfBirth.value == ""){
        dateOfBirth.style.border = "1px solid red";
        dateOfBirthError.textContent = "Không được để trống Ngày sinh";
        dateOfBirth.focus();
        return false;
    }
    if (phoneNumber.value == ""){
        phoneNumber.style.border = "1px solid red";
        phoneNumberError.textContent = "Không được để trống Số điện thoại";
        phoneNumber.focus();
        return false;
    }
    if (email.value == ""){
        email.style.border = "1px solid red";
        emailError.textContent = "Không được để trống Email";
        email.focus();
        return false;
    }
    if (username.value == ""){
        username.style.border = "1px solid red";
        usernameError.textContent = "Không được để trống Tên đăng nhập";
        username.focus();
        return false;
    }
    if (password.value == ""){
        password.style.border = "1px solid red";
        passwordError.textContent = "Không được để trống Mật khẩu";
        password.focus();
        return false;
    }
    if (address.value == ""){
        address.style.border = "1px solid red";
        addressError.textContent = "Không được để trống Địa chỉ";
        address.focus();
        return false;
    }
}

function firstNameVerify() {
    if (firstName != "") {
        firstName.style.border = "1px solid #c9c8c8";
        firstNameError.innerHTML = "";
        return true;
    }
}
function lastNameVerify() {
    if (lastName != "") {
        lastName.style.border = "1px solid #c9c8c8";
        lastNameError.innerHTML = "";
        return true;
    }
}
function dateOfBirthVerify() {
    if (dateOfBirth != "") {
        dateOfBirth.style.border = "1px solid #c9c8c8";
        dateOfBirthError.innerHTML = "";
        return true;
    }
}
function phoneNumberVerify() {
    if (phoneNumber != "") {
        phoneNumber.style.border = "1px solid #c9c8c8";
        phoneNumberError.innerHTML = "";
        return true;
    }
}
function emailVerify() {
    if (email != "") {
        email.style.border = "1px solid #c9c8c8";
        emailError.innerHTML = "";
        return true;
    }
}
function usernameVerify() {
    if (username != "") {
        username.style.border = "1px solid #c9c8c8";
        usernameError.innerHTML = "";
        return true;
    }
}
function passwordVerify() {
    if (password != "") {
        password.style.border = "1px solid #c9c8c8";
        passwordError.innerHTML = "";
        return true;
    }
}
function addressVerify() {
    if (password != "") {
        password.style.border = "1px solid #c9c8c8";
        passwordError.innerHTML = "";
        return true;
    }
}