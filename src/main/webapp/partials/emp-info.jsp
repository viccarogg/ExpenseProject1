
<div class="row">
    <div class="col-sm-12">
        <br>
        <h5>My Information</h5>
    </div>
</div>
<hr>
<div class="row">
    <div class="col-sm-10">
            <form id="myInfoForm" >
                <div class="form-group">
                    <label for="myID">Employee ID:</label>
                    <input type="text" id="myID" name="employee_id" readonly class="form-control">
                </div>
                <div class="form-group">
                    <label for="myFname">First Name:</label>
                    <input type="text" id="myFname" name="first_name" readonly class="form-control field">
                </div>
                <div class="form-group">
                    <label for="myLname">Last Name:</label>
                    <input type="text" id="myLname" name="last_name" readonly class="form-control field">
                </div>
                <div class="form-group">
                    <label for="myEmail">Email:</label>
                    <input type="text" id="myEmail" name="email" readonly class="form-control field">
                </div>
                <div class="form-group">
                    <label for="myDOB">Date of Birth: </label>
                    <input type="text" id="myDOB" name="date_of_birth" readonly class="form-control field">
                </div>
                <div class="form-group">
                    <label for="myAddress">Address:</label>
                    <input type="text" id="myAddress" name="address" readonly class="form-control field">
                </div>
                <div class="form-group">
                    <label for="myPhone">Phone Number:</label>
                    <input type="text" id="myPhone" name="phone" readonly class="form-control field">
                </div>
                <div class="form-group">
                    <label for="mySalary">Salary:</label>
                    <input type="text" id="mySalary" name="salary" readonly class="form-control">
                </div>
                <div class="form-group">
                    <label for="myTitle">Title:</label>
                    <input type="text" id="myTitle" name="title" readonly class="form-control">
                </div>
            </form>
    </div>
    <div class="col-sm-2">
        <button id="editInfoForm" class="btn btn-secondary btn-lg btn-block form-control">Edit</button>
        <button id="submitInfoForm" class="btn btn-primary btn-lg btn-block form-control" hidden>Save Changes</button>
    </div>
</div>