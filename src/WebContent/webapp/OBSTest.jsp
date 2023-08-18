<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
    <title>Login Page</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script>
    $(document).ready(function() {
        $("#login-button").click(function() {
            var userID = $("#userID").val();
            var password = $("#password").val();

            let data = {
                        userID: userID,
                        password: password
                    };

            if (userID === "admin" && password === "123") {
                $.ajax({
                    url: "/OBStest/OBSservlet",
                    method: "POST",
                    data: data,
                    success: function(response) {
                        if (!response.success) {
                            $("#login-message").text("User ID or Password incorrect.");
                        } else {
                        	window.location.href = "/OBStest/HomeServlet";
                        }
                    },
                    error: function(error) {
                        console.error("Error:", error);
                    }
                });
            } else {
                $("#login-message").text("User ID atau Password salah!.");
            }
        });
    });
    </script>
</head>
<body>
    <div style="border: 1px solid black; padding: 10px; width: 300px; margin: 0 auto;">
        <h2>Login</h2>
        <label for="userID">User ID:</label>
        <input type="text" id="userID" name="userID" required><br>
        
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required><br>
        
        <button type="button" id="login-button">Login</button>
        <div id="login-message" style="color: red;"></div>
    </div>
</body>
</html>