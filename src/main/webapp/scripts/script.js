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

    let reimbPage = document.getElementById("myReimbursements");
    if (reimbPage) {
        // the element is not undefined. we are on the my reimbursements page
        populateMyReimbursements(userId, "all");
        document.getElementById("pills-pending-tab").addEventListener('click', () => {
            populateMyReimbursements(userId, dropdown.value)
        })
        let dropdown = document.getElementById("reimbType");
        dropdown.addEventListener('change', () => {
            populateMyReimbursements(userId, dropdown.value)
        });

        document.getElementById("submitReimbursement").addEventListener('click', () => sendReimbReq(userId));
    }

    let manEmployees = document.getElementById("manEmployees");
    if (manEmployees) {
        // the element is not undefined. we are on the manager 'view employees' page
        populateAllEmployees();
    }

    let manReimbs = document.getElementById("manReimbursements");
    if (manReimbs) {
        // element is not undefined. we are on manager 'view reimbursements' page
        populateEmpSelector(userId);
        let empSelector = document.getElementById("manTableDisplaySelect");
        let statSelector = document.getElementById("manTableStatusSelect");
        empSelector.addEventListener('change', () =>
            populateManReimbursements(userId, empSelector.value, statSelector.value));
        statSelector.addEventListener('change', () =>
            populateManReimbursements(userId, empSelector.value, statSelector.value));
        populateManReimbursements(userId, empSelector.value, statSelector.value);
    }
});

const formatter = new Intl.NumberFormat('en-US', {
    style: 'currency',
    currency: 'USD',
    minimumFractionDigits: 2
})

const populateMyInfo = (id) => {
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
            document.getElementById("mySalary").value = formatter.format(data.salary);
            document.getElementById("myTitle").value = data.title;
        })
};

const updateInfo = (id) => {
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
        headers: { "Content-Type": "application/json" }
    };
    options.body = JSON.stringify(infoObj);

    fetch(url, options);
};

const toggleForm = () => {
    let fields = document.getElementsByClassName("field");
    for (let field of fields)
        field.readOnly = !field.readOnly;
};

const populateMyReimbursements = (id, status) => {
    let url = `http://localhost:8081/project1/api/reimbursements/employee/${id}`;
    if (status != "all") {
        url = `${url}/${status}`;
    }

    let table = document.getElementById("reimbTableBody");
    table.innerHTML = "";
    fetch(url)
        .then(response => response.json())
        .then(data => {
            let row;
            for (let reimb of data) {
                row = buildReimbursementRow(reimb);
                table.appendChild(row)
            }
        })
};

const buildReimbursementRow = (reimb, calledByMan = false) => {
    let row = document.createElement("tr");

    let idCol = document.createElement("th");
    idCol.scope = "row";
    idCol.innerText = reimb.reimbId;
    row.appendChild(idCol);

    if (calledByMan) {
        let empCol = document.createElement("td");
        empCol.innerText = reimb.ownerId;
        row.appendChild(empCol);
    }

    let descCol = document.createElement("td");
    descCol.innerText = reimb.description;
    row.appendChild(descCol);

    let amtCol = document.createElement("td");
    amtCol.innerText = formatter.format(reimb.amount);
    row.appendChild(amtCol);

    let statusCol = document.createElement("td");
    statusCol.innerText = reimb.status;
    row.appendChild(statusCol);

    if (reimb.status == "PENDING")
        row.classList.add("bg-warning");
    else if (reimb.status == "APPROVED")
        row.classList.add("bg-info");
    else if (reimb.status == "DENIED")
        row.classList.add("bg-danger")

    return row;
}

const sendReimbReq = (id) => {
    let url = `http://localhost:8081/project1/api/reimbursements/employee/${id}`;
    let desc = document.getElementById("reimbDesc").value
    let amt = document.getElementById("reimbAmount").value
    if (desc == "" || amt == "")
        return;
    let infoObj = {
        description: desc,
        amount: amt,
        ownerId: id,
        creator: document.getElementById("welcomeUser").getAttribute("data-id")
    };
    let options = {
        method: "post",
        headers: { "Content-Type": "application/json" }
    };
    options.body = JSON.stringify(infoObj);

    fetch(url, options);

    document.getElementById("myReimbForm").reset();
};

const populateAllEmployees = () => {
    let url = `http://localhost:8081/project1/api/employees`;

    let table = document.getElementById("manEmpTableBody");

    fetch(url)
        .then(response => response.json())
        .then(data => {
            let row;
            for (let emp of data) {
                row = buildEmpRow(emp);
                table.appendChild(row)
            }
        })
};

const buildEmpRow = (emp) => {
    let row = document.createElement("tr");

    let idCol = document.createElement("th");
    idCol.scope = "row";
    idCol.innerText = emp.id;
    row.appendChild(idCol);

    let unameCol = document.createElement("td");
    unameCol.innerText = emp.username;
    row.appendChild(unameCol);

    let url = `http://localhost:8081/project1/api/info/${emp.id}`;
    let fnameCol = document.createElement("td");
    let lnameCol = document.createElement("td");
    fetch(url)
        .then(response => response.json())
        .then(data => {
            fnameCol.innerText = data.firstName;
            lnameCol.innerText = data.lastName;
        })
    row.appendChild(fnameCol);
    row.appendChild(lnameCol);

    let roleCol = document.createElement("td");
    roleCol.innerText = emp.role.slice(0, 1) + emp.role.slice(1).toLowerCase();
    row.appendChild(roleCol);

    let manCol = document.createElement("td");
    manCol.innerText = emp.manager_id;
    row.appendChild(manCol);

    return row;
};

const populateEmpSelector = (id) => {
    let url = `http://localhost:8081/project1/api/employees/manager/${id}`;

    fetch(url)
        .then(response => response.json())
        .then(data => {
            let select = document.getElementById("manTableDisplaySelect");
            let opt;
            for (let emp of data) {
                if (emp.id == id) continue;
                opt = document.createElement("option");
                opt.innerText = emp.username;
                opt.value = emp.id;
                select.appendChild(opt);
            }
        });
};

const populateManReimbursements = (man_id, emp_id, status) => {
    let url = 'http://localhost:8081/project1/api/reimbursements';
    if (emp_id != "all")
        // looking for a certain employee. add appropriate path
        url = `${url}/employee/${emp_id}`;
    else
        // emp_id = all -> we want all employees for this manager
        url = `${url}/manager/${man_id}`

    if (status != "all")
        // looking for reimbursements of a specific type. add it to path
        url = `${url}/${status}`

    let table = document.getElementById("manReimbTableBody");
    table.innerHTML = "";
    fetch(url)
        .then(response => response.json())
        .then(data => {
            let row;
            for (let reimb of data) {
                row = buildReimbursementRow(reimb, true);
                let butHolder = document.createElement("td");
                if (reimb.status == 'PENDING') {
                    // reimbursement is pending. give option to review it.
                    let confBut = document.createElement("button");
                    confBut.innerText = "Approve"
                    let denyBut = document.createElement("button");
                    denyBut.innerText = "Deny"
                    confBut.classList.add("btn");
                    confBut.classList.add("btn-success");
                    confBut.classList.add("btn-sm");
                    confBut.classList.add("w-50");
                    denyBut.classList.add("btn");
                    denyBut.classList.add("btn-danger");
                    denyBut.classList.add("btn-sm");
                    denyBut.classList.add("w-50");

                    confBut.addEventListener('click', () => sendReviewReq(reimb, true, man_id, emp_id, status));
                    denyBut.addEventListener('click', () => sendReviewReq(reimb, false, man_id, emp_id, status));

                    butHolder.appendChild(confBut);
                    butHolder.appendChild(denyBut);
                }
                row.appendChild(butHolder);
                table.appendChild(row);
            }
        })
};

const sendReviewReq = (reimb, confirm, man_id, emp_id, status) => {
    let url = 'http://localhost:8081/project1/api/reimbursements';
    if (confirm)
        reimb.status = "APPROVED";
    else
        reimb.status = "DENIED";

    let options = {
        method: "put",
        headers: { "Content-Type": "application/json" }
    };
    options.body = JSON.stringify(reimb);

    fetch(url, options)
        .then(response => populateManReimbursements(man_id, emp_id, status));


}
