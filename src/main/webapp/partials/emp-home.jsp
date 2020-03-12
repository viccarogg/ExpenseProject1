
<ul class="nav nav-tabs" id="myTab" role="tablist">
    <li class="nav-item">
        <a class="nav-link active" id="home-tab" data-toggle="tab" href="#home" role="tab" aria-controls="home"
            aria-selected="true">Home</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" id="info-tab" data-toggle="tab" href="#myInfo" role="tab" aria-controls="myInfo"
            aria-selected="false">My Information</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" id="reimb-tab" data-toggle="tab" href="#myReimbursements" role="tab"
            aria-controls="myReimbursements" aria-selected="false">My Reimbursements</a>
    </li>
</ul>
<div class="tab-content" id="myTabContent">
    <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
        <div class="row">
            <div class="col-sm-9">
                <div class="card">
                    <h3 class="card-header">Featured</h3>
                    <div class="card-body">
                        <h5 class="card-title">GEORGE has record-shattering IPO!</h5>
                        <p class="card-text">GEORGE, LLC. has finally come to a decision on an Initial Public Offering.
                            After being valued at $150 billion, the company made its IPO with an a staggering $35
                            billion! This historic IPO beats out the previous record for largest IPO set in 2020 by
                            <i>Saudi Aramco</i> by almost $10
                            billion. Founder, CEO, and majority shareholder George has this to say:
                            <blockquote class="blockquote">
                                <p class="mb-0">Yeah, it's pretty cool. I'm stoked about the whole deal.</p>
                                <footer class="blockquote-footer">George, of GEORGE, LLC. in <cite
                                        title="Source Title">Forbes</cite></footer>
                            </blockquote>
                            Things are looking up for the company as George vows to take GEORGE, LLC. to new heights.
                        </p>
                        <a href="#" class="btn btn-primary">Read more on <i>Forbes</i></a>
                    </div>
                </div>
            </div>
            <div class="col-sm-3 d-flex align-items-center">
                <img src="assets/stockgraph.png" alt="Stock Image" class="w-100">
            </div>
        </div>
        <div class="row">
            <div class="col-sm-3 d-flex align-items-center">
                <img src="assets/mteverest.jpg" alt="Everest Image" class="w-100 rounded">
            </div>
            <div class="col-sm-9">
                <div class="card">
                    <h5 class="card-header">Leisure</h5>
                    <div class="card-body">
                        <h6 class="card-title">George climbs Mount Everest</h6>
                        <p class="card-text">
                            <blockquote class="blockquote">
                                <p class="mb-0">It was super tall.</p>
                                <footer class="blockquote-footer">George, of GEORGE, LLC. in <cite
                                        title="Source Title">Himalayan Journal</cite></footer>
                            </blockquote>
                        </p>
                        <a href="#" class="btn btn-primary">How can I climb Mt. Everest?</a>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-9">
                <div class="card">
                    <h5 class="card-header">Lifestyle</h5>
                    <div class="card-body">
                        <h6 class="card-title">Is GEORGE-ING the new Googling?</h6>
                        <p class="card-text">
                            Market trends are turning in the favor of GEORGE, LLC. Soon, they will overtake Google's
                            market share. People are even beginning to use the name George as a verb! This means great
                            PR for the company.
                            <blockquote class="blockquote">
                                <p class="mb-0">It's a little weird to be honest.</p>
                                <footer class="blockquote-footer">George, of GEORGE, LLC. in <cite
                                        title="Source Title">Popular Science</cite></footer>
                            </blockquote>
                        </p>
                        <a href="#" class="btn btn-primary">Try to GEORGE yourself!</a>
                    </div>
                </div>
            </div>
            <div class="col-sm-3 d-flex align-items-center">
                <img src="assets/googlelogo.png" alt="Everest Image" class="w-100 rounded">
            </div>
        </div>
    </div>
    <div class="tab-pane fade" id="myInfo" role="tabpanel" aria-labelledby="info-tab">
        <%@ include file="emp-info.jsp" %>
    </div>
    <div class="tab-pane fade" id="myReimbursements" role="tabpanel" aria-labelledby="reimb-tab">
        <%@ include file="emp-reimb.jsp" %>
    </div>
</div>