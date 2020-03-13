<div class="row w-100 ml-1 mr-1 d-flex justify-content-between">
    <ul class="nav nav-tabs" id="myTab" role="tablist">
        <li class="nav-item">
            <a class="nav-link active" id="home-tab" data-toggle="tab" href="#home" role="tab" aria-controls="home"
                aria-selected="true">Home</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" id="emp-tab" data-toggle="tab" href="#manEmployees" role="tab" aria-controls="manEmployees"
                aria-selected="false">View Employees</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" id="reimb-tab" data-toggle="tab" href="#manReimbursements" role="tab"
                aria-controls="manReimbursements" aria-selected="false">View Reimbursements</a>
        </li>
    </ul>

    <form action="logout">
        <input type="submit" class="btn btn-dark" value="Logout">
    </form>

</div>
<div class="tab-content" id="myTabContent">
    <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
        <div class="row w-100">
            <div class="card w-100">
                <h3 class="card-header">Reminder</h3>
                <div class="card-body">
                    <h5 class="card-title">Be wary of infectious disease.</h5>
                    <p class="card-text">
                        We know you don't like to interact with your employees. Luckily for you, we are announcing a
                        company Work-From-Home policy effective immediately. All of our systems are cloud based, so
                        there's no reason for anyone to come in. Stay indoors and try not to get sick.
                        <blockquote class="blockquote">
                            <p class="mb-0">Gotta wash those hands.</p>
                            <footer class="blockquote-footer">George, of GEORGE, LLC. in <cite title="Source Title">The
                                    American Journal of Medicine</cite></footer>
                        </blockquote>
                        For more information visit the <a href="https://www.cdc.gov/">CDC website</a>.
                    </p>

                </div>
            </div>
        </div>
        <div class="row w-100">
            <div class="card w-100">
                <h5 class="card-header">Reminder</h5>
                <div class="card-body">
                    <h5 class="card-title">Cut back on the approvals.</h5>
                    <p class="card-text">
                        This is just a reminder to all managers that they should be striving to reject as many reimbursement requests as possible.
                        <blockquote class="blockquote">
                            <p class="mb-0">How do you think we make so much money?</p>
                            <footer class="blockquote-footer">George, of GEORGE, LLC. in <cite title="Source Title">Money</cite></footer>
                        </blockquote>
                        If a request seems legitimate, do not be fooled. Only in the case of absolute certainty should you accept a request.
                    </p>

                </div>
            </div>
        </div>
        <div class="row w-100">
            <div class="card w-100">
                <h5 class="card-header">Congrats</h5>
                <div class="card-body">
                    <h5 class="card-title">Happy Friday!</h5>
                    <p class="card-text">
                        <blockquote class="blockquote">
                            <p class="mb-0">Go outside or something</p>
                            <footer class="blockquote-footer">George, of GEORGE, LLC. in <cite title="Source Title">Better Home and Gardens</cite></footer>
                        </blockquote>
                    </p>

                </div>
            </div>
        </div>
    </div>
    <div class="tab-pane fade" id="manEmployees" role="tabpanel" aria-labelledby="emp-tab">
        <div class="row">
            <table class="table w-100">
                <thead class="thead-light">
                    <th scope="col">#</th>
                    <th scope="col">Username</th>
                    <th scope="col">First Name</th>
                    <th scope="col">Last Name</th>
                    <th scope="col">Role</th>
                    <th scope="col">Manager ID</th>
                </thead>
                <tbody id="manEmpTableBody">
                </tbody>
            </table>
        </div>
    </div>
    <div class="tab-pane fade" id="manReimbursements" role="tabpanel" aria-labelledby="reimb-tab">
        <div class="row">
            <table class="table w-100">
                <thead class="thead-light">
                    <th scope="col">#</th>
                    <th scope="col">Employee</th>
                    <th scope="col">Description</th>
                    <th scope="col">Amount</th>
                    <th scope="col">Status</th>
                    <th scope="col">
                        <div class="d-flex flex-row">
                            <select class="custom-select" id="manTableDisplaySelect">
                                <option selected value="all">All</option>
                            </select>
                            <select class="custom-select" id="manTableStatusSelect">
                                <option selected value="all">All</option>
                                <option value="PENDING">Pending</option>
                                <option value="RESOLVED">Resolved</option>
                            </select>
                        </div>
                    </th>
                </thead>
                <tbody id="manReimbTableBody">
                </tbody>
            </table>
        </div>
    </div>
</div>