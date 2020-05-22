let firstName = document.forms["userForm"]["firstName"];
let lastName = document.forms["userForm"]["lastName"];
let gender = document.forms["userForm"]["gender"];
let dateOfBirth = document.forms["userForm"]["dateOfBirth"];
let phoneNumber = document.forms["userForm"]["phoneNumber"];
let email = document.forms["userForm"]["email"];
let username = document.forms["userForm"]["username"];
let password = document.forms["userForm"]["password"];
let repassword = document.forms["userForm"]["repassword"];
let address = document.forms["userForm"]["address"];

let firstNameError = document.getElementById("firstNameError");
let lastNameError = document.getElementById("lastNameError");
let genderError = document.getElementById("genderError");
let dateOfBirthError = document.getElementById("dateOfBirthError");
let phoneNumberError = document.getElementById("phoneNumberError");
let emailError = document.getElementById("emailError");
let usernameError = document.getElementById("usernameError");
let passwordError = document.getElementById("passwordError");
let repasswordError = document.getElementById("repasswordError");
let addressError = document.getElementById("addressError");

let emailPattern = "^[A-Za-z0-9+_.-]+@(.+)$";
let namePattern = "^[a-zA-Z_ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶ" +
    "ẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợ" +
    "ụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\s]+$";
// let datePattern = "^[0-3]?[0-9]/[0-3]?[0-9]/(?:[0-9]{2})?[0-9]{2}$";
let phoneNumberPattern = "^0[0-9]{9}$";
let usernamePattern = "^[a-z0-9_-]{6,16}$";
// let addressPattern = "^[a-zA-Z0-9\\s,.'-]{3,}$";
let addressPattern = "^[a-zA-Z0-9_ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶ" +
    "ẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợ" +
    "ụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\s]{3,}+$";

firstName.addEventListener("blur", firstNameVerify, true);
lastName.addEventListener("blur", lastNameVerify, true);
gender.addEventListener("blur", genderVerify, true);
dateOfBirth.addEventListener("blur", dateOfBirthVerify, true);
phoneNumber.addEventListener("blur", phoneNumberVerify, true);
email.addEventListener("blur", emailVerify, true);
username.addEventListener("blur", usernameVerify, true);
password.addEventListener("blur", passwordVerify, true);
repassword.addEventListener("blur", repasswordVerify, true);
address.addEventListener("blur", addressVerify, true);

function validate() {

    if (firstName.value == "") {
        firstName.style.border = "1px solid red";
        firstNameError.textContent = "Không được để trống Tên";
        firstName.focus();
        return false;
    } else if (!firstName.value.match(namePattern)) {
        firstName.style.border = "1px solid red";
        firstNameError.textContent = "Tên bắt đầu bằng chứ cái";
        firstName.focus();
        return false;
    }
    if (lastName.value == "") {
        lastName.style.border = "1px solid red";
        lastNameError.textContent = "Không được để trống Họ và tên đệm";
        lastName.focus();
        return false;
    } else if (!lastName.value.match(namePattern)) {
        lastName.style.border = "1px solid red";
        lastNameError.textContent = "Họ và tên đệm bắt đầu bằng chứ cái";
        lastName.focus();
        return false;
    }
    if (gender.value == "-1") {
        gender.style.border = "1px solid red";
        genderError.textContent = "Không được để trống Giới tính";
        gender.focus();
        return false;
    }
    if (dateOfBirth.value == "") {
        dateOfBirth.style.border = "1px solid red";
        dateOfBirthError.textContent = "Không được để trống Ngày sinh";
        dateOfBirth.focus();
        return false;
    }
    /*    else if (!dateOfBirth.value.match(datePattern)) {
            dateOfBirth.style.border = "1px solid red";
            dateOfBirthError.textContent = "Không đúng định dạng Ngày sinh";
            dateOfBirth.focus();
            return false;
        }*/
    if (phoneNumber.value == "") {
        phoneNumber.style.border = "1px solid red";
        phoneNumberError.textContent = "Không được để trống Số điện thoại";
        phoneNumber.focus();
        return false;
    } else if (!phoneNumber.value.match(phoneNumberPattern)) {
        phoneNumber.style.border = "1px solid red";
        phoneNumberError.textContent = "Không đúng định dạng Số điện thoại";
        phoneNumber.focus();
        return false;
    }
    if (email.value == "") {
        email.style.border = "1px solid red";
        emailError.textContent = "Không được để trống Email";
        email.focus();
        return false;
    } else if (!email.value.match(emailPattern)) {
        email.style.border = "1px solid red";
        emailError.textContent = "Định dạng email không phù hợp";
        email.focus();
        return false;
    }
    if (username.value == "") {
        username.style.border = "1px solid red";
        usernameError.textContent = "Không được để trống Tên đăng nhập";
        username.focus();
        return false;
    } else if (!username.value.match(usernamePattern)) {
        username.style.border = "1px solid red";
        usernameError.textContent = "Tên đăng nhập có độ dài từ 6 - 16 ký tự";
        username.focus();
        return false;
    }
    if (password.value == "") {
        password.style.border = "1px solid red";
        passwordError.textContent = "Không được để trống Mật khẩu";
        password.focus();
        return false;
    }
    if (repassword.value == "") {
        repassword.style.border = "1px solid red";
        repasswordError.textContent = "Không được để trống";
        repassword.focus();
        return false;
    }
    if (password.value != repassword.value) {
        password.style.border = "1px solid red";
        repassword.style.border = "1px solid red";
        repasswordError.innerHTML = "Mật khẩu không giống nhau";
        return false;
    }
    if (address.value == "") {
        address.style.border = "1px solid red";
        addressError.textContent = "Không được để trống Địa chỉ";
        address.focus();
        return false;
    } else if (!address.value.match(addressPattern)) {
        address.style.border = "1px solid red";
        addressError.textContent = "Địa chỉ có độ dài tối thiểu 3 ký tự";
        address.focus();
        return false;
    }
}

function firstNameVerify() {
    if (firstName != "") {
        firstName.style.border = "1px solid #6c757d";
        firstNameError.innerHTML = "";
        return true;
    }
}

function lastNameVerify() {
    if (lastName != "") {
        lastName.style.border = "1px solid #6c757d";
        lastNameError.innerHTML = "";
        return true;
    }
}

function genderVerify() {
    if (gender != "") {
        gender.style.border = "1px solid #6c757d";
        genderError.innerHTML = "";
        return true;
    }
}

function dateOfBirthVerify() {
    if (dateOfBirth != "") {
        dateOfBirth.style.border = "1px solid #6c757d";
        dateOfBirthError.innerHTML = "";
        return true;
    }
}

function phoneNumberVerify() {
    if (phoneNumber != "") {
        phoneNumber.style.border = "1px solid #6c757d";
        phoneNumberError.innerHTML = "";
        return true;
    }
}

function emailVerify() {
    if (email != "") {
        email.style.border = "1px solid #6c757d";
        emailError.innerHTML = "";
        return true;
    }
}

function usernameVerify() {
    if (username != "") {
        username.style.border = "1px solid #6c757d";
        usernameError.innerHTML = "";
        return true;
    }
}

function passwordVerify() {
    if (password != "") {
        password.style.border = "1px solid #6c757d";
        passwordError.innerHTML = "";
        return true;
    }
}

function repasswordVerify() {
    if (repassword != "") {
        repassword.style.border = "1px solid #6c757d";
        repasswordError.innerHTML = "";
        return true;
    }
}

function addressVerify() {
    if (password != "") {
        password.style.border = "1px solid #6c757d";
        passwordError.innerHTML = "";
        return true;
    }
}