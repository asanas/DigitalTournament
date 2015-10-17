<%@include file="../common/header.jsp"%>
<header>
    <div class="container">
        <h2>Create a New Team</h2>
        <form class="form-horizontal" role="form" method="POST" action="${pageContext.request.contextPath}/createnew/team" enctype="multipart/form-data">
            <div class="form-group">
                <label class="control-label col-lg-4" for="teamName">Team Name:</label>
                <div class="col-lg-6 text-left" style="padding-top: 10px;">
                    <input type="text" class="form-control" name="teamName" id="teamName" placeholder="Enter team name">
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-lg-4" for="founderName">Founder Name:</label>
                <div class="col-lg-6 text-left" style="padding-top: 10px;">
                    <input type="text" class="form-control" name="founderName" id="founderName" placeholder="Enter founder name">
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-lg-4" for="description">More Information:</label>
                <div class="col-lg-6 text-left" style="padding-top: 10px;">
                    <textarea class="form-control" rows="5" name="description" id="description" placeholder="More Information"></textarea>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-lg-4" for="address">Address:</label>
                <div class="col-lg-6 text-left" style="padding-top: 10px;">
                    <textarea class="form-control" rows="5" name="address" id="address" placeholder="Address"></textarea>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-lg-4" for="achievements">Achievements:</label>
                <div class="col-lg-6 text-left" style="padding-top: 10px;">
                    <textarea class="form-control" rows="5" name="achievements" id="achievements" placeholder="Achiements"></textarea>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-lg-4" for="city">City:</label>
                <div class="col-lg-6">
                    <select name="cityId" id="city" class="form-control">
                        <c:forEach items="${ cityList}" var="city" varStatus="lpHandle">
                            <option value="${city.cityId }">${city.cityName}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-lg-4" for="establishedIn">Established In:</label>
                <div class="col-lg-6 text-left" style="padding-top: 10px;">
                    <input type="text" class="form-control" name="establishedIn" id="establishedIn" placeholder="Established-In">
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-lg-4" for="playersList">Players List:</label>
                <div class="col-lg-6 text-left" style="padding-top: 10px;">
                    <input type="file" name="playersList" class="form-control">
                </div>
            </div>
            <div class="form-group">
                <div class="col-lg-6 col-lg-offset-4 text-left" style="padding-top: 10px;">
                    <input type="submit" class="btn btn-info" value="Add Team" class="form-control">
                </div>
            </div>
        </form>
    </div>
</header>