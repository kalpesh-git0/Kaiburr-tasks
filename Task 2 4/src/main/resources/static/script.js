// script.js

// Function to fetch and display user data
function fetchUsers() {
    $.get("http://localhost:8080/api/objects/get", function (data) {
        // Clear the existing user list
        $("#user-list").empty();
        data.forEach(function (user) {
            // Append user data to the table
            $("#user-list").append(`
                <tr>
                    <td>${user.id}</td>
                    <td>${user.name}</td>
                    <td>${user.language}</td>
                    <td>${user.framework}</td>
                    <td>
                        <button class="btn btn-sm btn-danger delete-btn" data-id="${user.id}">Delete</button>
                    </td>
                </tr>
            `);
        });
    });
}


// Handle form submission (Add and Update)
$("#user-form").submit(function (e) {
    e.preventDefault();
    const userId = $("#user-id").val();
    const name = $("#name").val();
    const language = $("#language").val();
    const framework = $("#framework").val();

    const userData = {
           "id": userId,
           "name": name,
           "language": language,
           "framework": framework
       };

    // Convert the user data to a JSON string
    const userDataJsonString = JSON.stringify(userData);
    console.log(userDataJsonString);
    // Make an AJAX POST request to add or update user
//    $.ajax({
//        url: userId ? `http://localhost:8080/api/objects/add/?userData=${encodeURIComponent(userDataJsonString)}` : "http://localhost:8080/api/objects/add",
//        method: userId ? "PUT" : "POST",
//        success: function () {
//            // Clear the form and fetch updated user data
//            $("#user-form")[0].reset();
//            fetchUsers();
//        },
//        error: function (error) {
//            console.error('Error:', error);
//        }
//    });

fetch('http://localhost:8080/api/objects/add', {
    method: 'POST',
    headers: {
        'Content-Type': 'application/json',
    },
    body: JSON.stringify(userData),
})
.then(response => {
    if (!response.ok) {
        throw new Error('Network response was not ok');
    }
    return response.json();
})
.then(data => {
    // Handle success
})
.catch(error => {
    console.error('Error:', error);
});

});

//handle delete operation

$("#user-list").on("click", ".delete-btn", function () {
    const userId = $(this).data("id");
    $.ajax({
        url: `http://localhost:8080/api/objects/delete/${userId}`,
        method: "DELETE",
        success: function () {
            fetchUsers();
        },
        error: function (error) {
            console.error('Error:', error);
        }
    });
});

// Fetch initial user data
fetchUsers();
