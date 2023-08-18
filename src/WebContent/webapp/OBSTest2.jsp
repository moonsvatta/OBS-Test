<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Welcome Page</title>
</head>
<body>
    <div style="border: 1px solid black; padding: 20px; width: 500px; margin: 0 auto;">
        <h2>Welcome, <span id="logged-user"></span></h2>
        <table border="1">
            <tr style="background-color: lightblue;">
                <th>Department</th>
                <th>Student ID</th>
                <th>Marks</th>
                <th>Pass%</th>
            </tr>
            <tr>
                <td rowspan="4">Dep 1</td>
                <td><a href="#" class="student-link">S1</a></td>
                <td>35</td>
                <td rowspan="4">${mapPassRate["Dep 1"]}</td>
            </tr>
            <tr>
                <td><a href="#" class="student-link">S2</a></td>
                <td>70</td>
            </tr>
            <tr>
                <td><a href="#" class="student-link">S3</a></td>
                <td>60</td>
            </tr>
            <tr>
                <td><a href="#" class="student-link">S4</a></td>
                <td>90</td>
            </tr>
            <tr>
                <td rowspan="1">Dep 2</td>
                <td><a href="#" class="student-link">S5</a></td>
                <td>30</td>
                <td>${mapPassRate["Dep 2"]}</td>
            </tr>
            <tr>
                <td rowspan="3">Dep 3</td>
                <td><a href="#" class="student-link">S6</a></td>
                <td>32</td>
                <td rowspan="3">${mapPassRate["Dep 3"]}</td>
            </tr>
            <tr>
                <td><a href="#" class="student-link">S7</a></td>
                <td>70</td>
            </tr>
            <tr>
                <td><a href="#" class="student-link">S8</a></td>
                <td>20</td>
            </tr>
        </table>
    </div>
    
    <div id="student-popup" style="display: none; position: absolute; border: 1px solid black; background-color: white; padding: 10px;"></div>
    
    <script>
        // function get URL query parameter by name
        function getQueryParam(name) {
            var urlParams = new URLSearchParams(window.location.search);
            return urlParams.get(name);
        }

        // ambil userID query dari URL query parameter
        var userID = getQueryParam("userID");

        // Set userID in logged-user span
        if (userID) {
            document.getElementById("logged-user").textContent = userID;
        } else {
            document.getElementById("logged-user").textContent = "Unknown User";
        }

        // Student data
        var studentData = [
            { studentID: "S1", studentName: "Student 1", mark: 35, department: "Dep 1" },
            { studentID: "S2", studentName: "Student 2", mark: 70, department: "Dep 1" },
            { studentID: "S3", studentName: "Student 3", mark: 60, department: "Dep 1" },
            { studentID: "S4", studentName: "Student 4", mark: 90, department: "Dep 1" },
            { studentID: "S5", studentName: "Student 5", mark: 30, department: "Dep 2" },
            { studentID: "S6", studentName: "Student 6", mark: 32, department: "Dep 3" },
            { studentID: "S7", studentName: "Student 7", mark: 70, department: "Dep 3" },
            { studentID: "S8", studentName: "Student 8", mark: 20, department: "Dep 3" }
        ];

        // Popup saat klik Student ID
        var studentLinks = document.querySelectorAll(".student-link");
        studentLinks.forEach(function(link) {
            link.addEventListener("click", function(e) {
                e.preventDefault();
                var studentId = this.textContent;
                var student = studentData.find(function(s) {
                    return s.studentID === studentId;
                });

                if (student) {
                    var popup = document.getElementById("student-popup");
                    popup.textContent = "Student Name: " + student.studentName;
                    popup.style.top = e.clientY + "px";
                    popup.style.left = e.clientX + "px";
                    popup.style.display = "block";
                }
            });
        });
    </script>
</body>
</html>