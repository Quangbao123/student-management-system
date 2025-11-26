
function signUp() {
    const username = document.querySelector('.input-field[placeholder="Username"]').value;
    const password = document.querySelector('.input-field[placeholder="Password"]').value;

    if (!username || !password) {
        alert("Please fill in all fields.");
        return;
    }

    const signupData = {
        username: username,
        password: password
    };
    fetch("http://localhost:8080/api/login/sign_up", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(signupData)
    })
        .then(response => response.json())
        .then(apiResponse => {
            if (!apiResponse.success) {
                alert("Registration failed: " + apiResponse.message);
                return;
            }
            alert("Registration successful! Please log in.");
            window.location.href = "../index.html";
        })
        .catch(error => {
            console.error("Error during registration:", error);
            alert("An error occurred during registration. Please try again later.");
        });
}