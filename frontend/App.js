function login() {
    const username = document.querySelector('.input-field[placeholder="Username"]').value;
    const password = document.querySelector('.input-field[placeholder="Password"]').value;

    const loginData = {
        username: username,
        password: password
    };

    fetch("http://localhost:8080/api/login", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(loginData)
    })
    .then(response => response.json())
    .then(apiResponse => {

        if (!apiResponse.success) {
            alert("Login failed: " + apiResponse.message);
            return;
        }

        window.location.href = "User/homepage.html";
    })
    .catch(error => {
        alert("Error during login: " + error.message);
    });
}