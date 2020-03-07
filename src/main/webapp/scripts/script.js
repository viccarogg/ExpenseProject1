window.onload = () => {
    let div = document.createElement('div');
    div.innerHTML = '<p>Welcome to my site</p>';
    document.getElementById('main').appendChild(div);
};

var load = () => {
    let url = 'localhost:8080/project1/users';
    let request;

    if (window.XMLHttpRequest) {
        request = new XMLHttpRequest();
    }
    else if (window.ActiveXObject) {
        request = new ActiveXObject();
    }

    request.onreadystatechange = () => {
        if (request.readyState == 4) {
            console.log(request.responseText);
            let jsonObj = JSON.parse(request.responseText);

            let nameDiv = document.createElement('div');
            nameDiv.innerHTML = `<p>Username: ${jsonObj.USERNAME}</p>`
            let passDiv = document.createElement('div');
            passDiv.innerHTML = `<p>Password: ${jsonObj.PASSWORD}</p>`
            let idDiv = document.createElement('div');
            idDiv.innerHTML = `<p>ID: ${jsonObj.USER_ID}</p>`
            let typeDiv = document.createElement('div');
            if (jsonObj.USER_TYPE == 1)
                typeDiv.innerHTML = '<p>Type: Customer</p>'
            else
                typeDiv.innerHTML = '<p>Type: Employee</p>'

            document.getElementsByTagName('body')[0].appendChild(nameDiv);
            document.getElementsByTagName('body')[0].appendChild(passDiv);
            document.getElementsByTagName('body')[0].appendChild(idDiv);
            document.getElementsByTagName('body')[0].appendChild(typeDiv);
        }
    }

    request.open("GET", url, true);
    request.send();
};

var load2 = () => {
    fetch('http://localhost:8080/project1/users')
    .then(response => {
        console.log(response);
        return response.json();
    })
    .then(data => {
        console.log(data);
        let nameDiv = document.createElement('div');
        nameDiv.innerHTML = `<p>Username: ${data.USERNAME}</p>`
        let passDiv = document.createElement('div');
        passDiv.innerHTML = `<p>Password: ${data.PASSWORD}</p>`
        let idDiv = document.createElement('div');
        idDiv.innerHTML = `<p>ID: ${data.EMPLOYEE_ID}</p>`
        let typeDiv = document.createElement('div');
        if (data.ROLE == 0)
            typeDiv.innerHTML = '<p>Type: Employee</p>'
        else
            typeDiv.innerHTML = '<p>Type: Manager</p>'

        let manDiv = document.createElement('div');
        manDiv.innerHTML = `<p>Manager ID: ${data.MANAGER_ID}</p>`
        let container = document.getElementById('main');
        container.appendChild(nameDiv);
        container.appendChild(passDiv);
        container.appendChild(idDiv);
        container.appendChild(typeDiv);
        container.appendChild(manDiv);
    })
}
var load3 = () => {
	let uName = document.getElementById('uname').value;
	let passW = document.getElementById('pass').value;
	let toSend = {uname: uName, pass: passW};
	console.log(toSend);
	console.log(JSON.stringify(toSend));
    fetch('http://localhost:8080/project1/users', {
        method: 'post',
        body: JSON.stringify(toSend)
      })
    .then(response => {
        console.log(response);
        return response.json();
    })
    .then(data => {
        console.log(data);
        let nameDiv = document.createElement('div');
        nameDiv.innerHTML = `<p>Username: ${data.USERNAME}</p>`
        let passDiv = document.createElement('div');
        passDiv.innerHTML = `<p>Password: ${data.PASSWORD}</p>`
        let idDiv = document.createElement('div');
        idDiv.innerHTML = `<p>ID: ${data.EMPLOYEE_ID}</p>`
        let typeDiv = document.createElement('div');
        if (data.ROLE == 0)
            typeDiv.innerHTML = '<p>Type: Employee</p>'
        else
            typeDiv.innerHTML = '<p>Type: Manager</p>'

        let manDiv = document.createElement('div');
        manDiv.innerHTML = `<p>Manager ID: ${data.MANAGER_ID}</p>`
        let container = document.getElementById('main');
        container.appendChild(nameDiv);
        container.appendChild(passDiv);
        container.appendChild(idDiv);
        container.appendChild(typeDiv);
        container.appendChild(manDiv);
    })
}

document.getElementById('login').addEventListener('click', load2);
//document.getElementById('userpass').addEventListener('click', load3);