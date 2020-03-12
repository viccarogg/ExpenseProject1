document.addEventListener("DOMContentLoaded", () => {
    let userId;
    if (document.getElementById("welcomeUser"))
        userId = document.getElementById("welcomeUser").getAttribute("data-id");
    let userRole;
    if (document.getElementById("welcomeUser"))
        userRole = document.getElementById("welcomeUser").getAttribute("data-role");


    let infoForm = document.getElementById("myInfoForm");
    if (infoForm) {
        // the element is not undefined. we are on the update my info page.
        populateMyInfo(userId);

        let editBtn = document.getElementById("editInfoForm");
        let saveBtn = document.getElementById("submitInfoForm");
        editBtn.addEventListener('click', () => {
            saveBtn.hidden = false;
            editBtn.hidden = true;

            toggleForm();
        });
        saveBtn.addEventListener('click', () => {
            saveBtn.hidden = true;
            editBtn.hidden = false;

            toggleForm();
            updateInfo(userId);
        });
    }
});

let populateMyInfo = (id) => {
    // ajax db call to display user info on readonly form
    let url = `http://localhost:8081/project1/api/info/${id}`;
    fetch(url)
        .then(response => response.json())
        .then(data => {
            document.getElementById("myID").value = id;
            document.getElementById("myFname").value = data.firstName;
            document.getElementById("myLname").value = data.lastName;
            document.getElementById("myEmail").value = data.email;
            document.getElementById("myDOB").value = data.dob;
            document.getElementById("myAddress").value = data.address;
            document.getElementById("myPhone").value = data.phone;
            document.getElementById("mySalary").value = data.salary;
            document.getElementById("myTitle").value = data.title;
        })
};

let updateInfo = (id) => {
    let url = `http://localhost:8081/project1/api/info`;
    let infoObj = {
        empId: id,
        firstName: document.getElementById("myFname").value,
        lastName: document.getElementById("myLname").value,
        email: document.getElementById("myEmail").value,
        dob: document.getElementById("myDOB").value,
        address: document.getElementById("myAddress").value,
        phone: document.getElementById("myPhone").value,
        modified: document.getElementById("welcomeUser").getAttribute("data-id")
    };
    let options = {
        method: "put",
        headers: {"Content-Type" : "application/json"}
    };
    options.body = JSON.stringify(infoObj);
    // return;
    fetch(url, options);
};

let toggleForm = () => {
    let fields = document.getElementsByClassName("field");
    for(let field of fields) 
        field.readOnly = !field.readOnly;
};