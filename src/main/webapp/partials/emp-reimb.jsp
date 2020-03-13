<div class="row" id="myReimbursements">
    <div class="col-sm-12">
        <br>
        <h5>My Reimbursements</h5>
    </div>
</div>
<hr>
<div class="row">
    <ul class="nav nav-pills mb-3 ml-2 w-100 nav-fill" id="pills-tab" role="tablist">
        <li class="nav-item">
            <a class="nav-link active" id="pills-pending-tab" data-toggle="pill" href="#pills-pending" role="tab"
                aria-controls="pills-pending" aria-selected="true">View</a>
        </li>
        <div>
            <li class="nav-item">
                <select class="custom-select" id="reimbType">
                    <option selected value="all">All</option>
                    <option value="pending">Pending</option>
                    <option value="resolved">Resolved</option>
                </select>
            </li>
        </div>
        <li class="nav-item">
            <a class="nav-link" id="pills-contact-tab" data-toggle="pill" href="#pills-contact" role="tab"
                aria-controls="pills-contact" aria-selected="false">Create New Reimbursement</a>
        </li>
    </ul>
</div>
<div class="tab-content w-100" id="pills-tabContent">
    <div class="tab-pane fade show active" id="pills-pending" role="tabpanel" aria-labelledby="pills-pending-tab">
        <table class="table w-100">
            <thead class="thead-light">
                <th scope="col">#</th>
                <th scope="col">Description</th>
                <th scope="col">Amount</th>
                <th scope="col">Status</th>
            </thead>
            <tbody id="reimbTableBody">
            </tbody>
        </table>
    </div>
    <div class="tab-pane fade w-100" id="pills-contact" role="tabpanel" aria-labelledby="pills-contact-tab">
        <div class="row">
            <div class="col-1"></div>
            <div class="col-10">
                <form id="myReimbForm">
                    <div class="form-group">
                        <label for="reimbDesc">Description:</label>
                        <textarea class="form-control" id="reimbDesc" rows="3"></textarea>
                    </div>
                    <div class="form-group">
                        <label for="reimbAmount">Amount:</label>
                        <input type="number" class="form-control" id="reimbAmount" placeholder="0.00">
                    </div>
                    <div class="form-group">
                        <label for="reimbImage">Receipt Image:</label>
                        <input type="file" class="form-control-file" id="reimbImage">
                    </div>
                    <button type="button" class="form-control" id="submitReimbursement">Submit</button>
                </form>
            </div>
            <div class="col-1"></div>
        </div>
    </div>
</div>