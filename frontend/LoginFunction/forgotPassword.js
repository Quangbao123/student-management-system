
function resetPassword() {
    const username = document.getElementById('username').value;
    const newPassword = document.getElementById('newPassword').value;
    const confirmPassword = document.getElementById('confirmPassword').value;

    if (!username || !newPassword || !confirmPassword) {
        alert("Please fill in all fields.");
        return;
    }

    if (newPassword !== confirmPassword) {
        alert("Passwords do not match.");
        return;
    }

    const resetData = {
        username: username,
        password: newPassword
    };

    fetch("http://localhost:8080/api/login/reset_password", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(resetData)
    })
        .then(response => response.json())
        .then(apiResponse => {
            if (!apiResponse.success) {
                alert("Reset failed: " + apiResponse.message);
                return;
            }

            alert("Password reset successful! Please log in.");
            window.location.href = "../index.html";
        })
        .catch(error => {
            console.error("Error during password reset:", error);
            alert("An error occurred. Please try again later.");
        });

}