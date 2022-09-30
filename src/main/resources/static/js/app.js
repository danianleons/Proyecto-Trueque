const loadUserConfig = () => {
    const loginLi = document.getElementById("login-section");
    const logoutLi = document.getElementById("logout-section");
    const historyLi = document.getElementById("history-section");
    const pubicationLi = document.getElementById("pubication-section");
    const registerLi = document.getElementById("register-section");

    const user = localStorage.getItem("loggedUser");
    if (user == undefined) {
        loginLi.classList.add("d-flex");
        logoutLi.classList.remove("d-flex");
        logoutLi.style.display = 'none';
        historyLi.style.display = 'none';
        pubicationLi.style.display = 'none';
        registerLi.style.display = 'block';
    } else {
        loginLi.classList.remove("d-flex");
        loginLi.style.display = 'none';
        logoutLi.style.display = 'block';
        historyLi.style.display = 'block';
        pubicationLi.style.display = 'block';
        registerLi.style.display = 'none';

        const userInfo = JSON.parse(user);
        document.getElementById("user-fullname").innerText = userInfo.name + " " + userInfo.lastname;
        document.getElementById("history-section").getElementsByTagName("a").item(0).setAttribute("href", "/my-posts/" + userInfo.email);
              
    }
};

loadUserConfig();

const logout = () => {
    localStorage.removeItem("loggedUser");
    window.location.reload()    
};
