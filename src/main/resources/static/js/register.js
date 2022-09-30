
const createUser = () => {
    const name = document.getElementById("nombre").value;
    const lastname = document.getElementById("apellido").value;
    const email = document.getElementById("email").value;
    const password = document.getElementById("contrasena").value;
    const country = document.getElementById("pais").value;
    const city = document.getElementById("ciudad").value;
    const phone = document.getElementById("telefono").value; 

    const body = {
        "email": email,
        "password": password,
        "name": name,
        "lastname": lastname,
        "country": country,
        "city": city,
        "phone": phone,
    };
    postToCreateUser(body);
};

const postToCreateUser = async (bodyObject) => {
    const url = "api/user";
    const response = await fetch(url, {
        method: "POST",
        body: JSON.stringify(bodyObject),
        headers: {
            "Content-Type": "application/json"
        }
    });

    if (response.ok) {                          
        showSucces("Usuario Registrado Correctamente")
    } else {
        const message = await response.text();
        showError(message);
    }
};

const showSucces = (message) => {
    alert2(message, "success");
}

const alert2 = (message, type) => {
     document.getElementById("messageRegisterForm").innerHTML = [
        `<div class="alert alert-${type} alert-dismissible" role="alert">`,
        `   <div>${message}</div>`,
        '   <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>',
        '</div>'
    ].join('')
}