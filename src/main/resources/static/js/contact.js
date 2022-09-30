
const createContact = () => {
    const name = document.getElementById("name").value;
    const email = document.getElementById("email").value;
    const subject = document.getElementById("msg_subject").value;
    const message = document.getElementById("message").value;
    
    const body = {
        "name": name,
        "email": email,
        "subject": subject,        
        "message": message,
        
    };
    postToCreateContact(body);
};

const postToCreateContact = async (bodyObject) => {
    const url = "contact/register";
    const response = await fetch(url, {
        method: "POST",
        body: JSON.stringify(bodyObject),
        headers: {
            "Content-Type": "application/json"
        }
    });

    if (response.ok) {                          
        showSucces1("Solicitud Registrada Correctamente")
    } else {
        const message = await response.text();
        showError(message);
    }
};

const showSucces1 = (message) => {
    alert3(message, "success");
}

const alert3 = (message, type) => {
     document.getElementById("messageContact").innerHTML = [
        `<div class="alert alert-${type} alert-dismissible" role="alert">`,
        `   <div>${message}</div>`,
        '   <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>',
        '</div>'
    ].join('')
}