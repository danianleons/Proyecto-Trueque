const createPublication = () => {
    const title = document.getElementById("titulo").value;
    const description = document.getElementById("descripcion").value;
    const categoryId = document.getElementById("categoria").value;
    const status = document.getElementById("estado").value;
    const changeFor = document.getElementById("cambio").value;
    const contactNumber = document.getElementById("telefono").value;
    const imageUrl = document.getElementById("imagen").value;
    const user = localStorage.getItem("loggedUser");
    const userInfo = JSON.parse(user);

    console.log(categoryId)
    
    const body = {
        "title": title,
        "description": description,
        "category": {
            "id": categoryId,
        },
        "status": status,
        "changeFor": changeFor,
        "contactNumber": contactNumber,
        "imageUrl": imageUrl,
        "user": {
            "email": userInfo.email,
        }
    };
    postToCreatePublication(body);
};

const postToCreatePublication = async (bodyObject) => {
    const url = "api/publication";
    const response = await fetch(url, {
        method: "POST",
        body: JSON.stringify(bodyObject),
        headers: {
            "Content-Type": "application/json"
        }
    });

    if (response.ok) {
        showSucces5("Publicación Registrada Correctamente")
    } else {
        const message = await response.text();
        showError(message);
    }
};

const showSucces5 = (message) => {
    alert5(message, "success");
}

const alert5 = (message, type) => {
    document.getElementById("messageRegisterForm").innerHTML = [
        `<div class="alert alert-${type} alert-dismissible" role="alert">`,
        `   <div>${message}</div>`,
        '   <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>',
        '</div>'
    ].join('')
}