<%@include file="../common/header.jsp"%>
<header>
    <div class="container" style="padding-top: 30px;">
        <h2>Create New Tournament</h2>
        <form class="form-horizontal" role="form" method="POST" action="${pageContext.request.contextPath}/createnew/tournament" enctype="multipart/form-data">
            <div class="form-group">
                <label class="control-label col-lg-4" for="teamName">Tournament Name:</label>
                <div class="col-lg-6 text-left" >
                    <input type="text" class="form-control" name="tourName" id="tourName" placeholder="Enter tournament name" autocomplete="off">
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-lg-4" for="tourDescription">Tournament Description:</label>
                <div class="col-lg-6 text-left" >
                    <input type="text" class="form-control" name="tourDescription" id="tourDescription" placeholder="Enter tournament description" autocomplete="off">
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-lg-4" for="tourLocation">Location:</label>
                <div class="col-lg-6 text-left" >
                    <input type="text" class="form-control" name="tourLocation" id="tourLocation" placeholder="Enter tournament location" autocomplete="off">
                </div>
            </div>
            <div class="form-group" style="display: none;">
                <label class="control-label col-lg-4" for="tourType">Tour Type:</label>
                <div class="col-lg-3 text-left" style="width:310px;">
                    <input type="text" class="form-control" name="tourType" id="tourType" placeholder="Established-In" autocomplete="off">
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-lg-4" for="startDate">Start Date:</label>
                <div class="col-lg-6 text-left" >
                    <input type="text" class="form-control" name="startDate" id="startDate" placeholder="Enter tournament start date" autocomplete="off" style="width: 280px;">
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-lg-4" for="endDate">End Date:</label>
                <div class="col-lg-6 text-left" >
                    <input type="text" class="form-control" name="endDate" id="endDate" placeholder="Enter tournament end date" autocomplete="off" style="width: 280px;">
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-lg-4" for="ageGroup">Age Group:</label>
                <div class="col-lg-6 text-left" >
                    <select name="ageGroup" id="ageGroup" class="form-control">
                       <option value="Under-14">Under 14</option>
                       <option value="Under-18">Under 18</option>
                       <option value="Open">Open</option>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-lg-4" for="city">Prize:</label>
                <div class="col-lg-6">
                    <input type="text" class="form-control" name="prize" id="prize" placeholder="Enter tournament prize" autocomplete="off">
                </div>
            </div>
            <div class="form-group">
                <div class="col-lg-6 col-lg-offset-4 text-left" >
                    <input type="submit" class="btn btn-info" value="Create Tournament" class="form-control">
                </div>
            </div>
        </form>
    </div>
</header>
<%@include file="../common/footer.jsp"%>
<script>
$( "#startDate, #endDate" ).datepicker({
    changeMonth: true,
    changeYear: true,
    dateFormat: "mm/dd/yy"
  });
</script>