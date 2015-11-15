<%@include file="../common/common-taglibs.jsp"%>
<div class="modal-dialog modal-lg">
    <!-- Modal content-->
    <div class="modal-content " style="background-color: #87CEEA;">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal">&times;</button>
            <h2 class="modal-title text-center">${teamDetails.teamName}</h2>
        </div>
        <div class="modal-body">
            <div class="row">
                <div class="col-lg-12 text-center" style="height: 475px;">
                    <div id="cbp-contentslider" class="cbp-contentslider">
                        <ul>
                            <c:forEach items="${ listPlayerProfile}" var="playerProfile" varStatus="lpHandle">
                                <li id="slide${lpHandle.count }">
	                                <h3>
	                                    <div class="row">
	                                        <div class="col-lg-6 text-left">
	                                            <small>Sponsored By</small>
	                                            <img class="sponsorLogo" src="${pageContext.request.contextPath}/static_content/images/${sponsorsDetails.logoLink}"/>
	                                            <div class="sponsorName">${sponsorsDetails.name}</div>
	                                        </div>
	                                        <div class="col-lg-6 text-right">
	                                            <img class="playerFoto" src="${pageContext.request.contextPath}/static_content/images/${playerProfile.photoUrl}" onError="this.onerror=null; this.src='${pageContext.request.contextPath}/static_content/images/no_player_photo.png';"/>
	                                        </div>
	                                    </div>
	                                </h3>
	                                <div class="cbp-content">
	                                <div class="row">
	                                    <div class="col-lg-6 text-left">
	                                        Name:
	                                    </div>
	                                    <div class="col-lg-6 text-right">
	                                        ${playerProfile.firstName } ${playerProfile.lastName }
	                                    </div>
	                                </div>
	                                <div class="row">
	                                    <div class="col-lg-6 text-left">
	                                        Age:
	                                    </div>
	                                    <div class="col-lg-6 text-right">
	                                        ${playerProfile.age }
	                                    </div>
	                                </div>
	                                <div class="row">
	                                    <div class="col-lg-6 text-left">
	                                        Height:
	                                    </div>
	                                    <div class="col-lg-6 text-right">
	                                        <c:if test="${not empty playerProfile.height}">${playerProfile.height}(cms)</c:if>
	                                    </div>
	                                </div>
	                                <div class="row">
	                                    <div class="col-lg-6 text-left">
	                                        Weight:
	                                    </div>
	                                    <div class="col-lg-6 text-right">
	                                        <c:if test="${not empty playerProfile.weight}">${playerProfile.weight}(Kg)</c:if>
	                                    </div>
	                                </div>
	                                <div class="row">
	                                    <div class="col-lg-6 text-left">
	                                        Total tournaments participanted in:
	                                    </div>
	                                    <div class="col-lg-6 text-right">
	                                        ${playerProfile.totalToursParticipated}
	                                    </div>
	                                </div>
	                                <div class="row">
	                                    <div class="col-lg-6 text-left">
	                                        Major Achievements:
	                                    </div>
	                                    <div class="col-lg-6 text-right">
	                                        ${playerProfile.achievements}
	                                    </div>
	                                </div>
	                                </div>
	                            </li>
                            </c:forEach>
                        </ul>
                        <nav>
                            <c:forEach items="${ listPlayerProfile}" var="playerProfile" varStatus="lpHandle">
                                <a href="#slide${lpHandle.count}"><div>${lpHandle.count}</div></a>
                            </c:forEach>
                        </nav>
                    </div>
                </div>
            </div>
        </div>
        <div class="modal-footer">
            &nbsp;
        </div>
    </div>
</div>
<style>
.cbp-contentslider {height: 100%; border: 4px solid #3677A5;}
.cbp-contentslider h3 {height: 9em; font-size: 17px;}
header img.sponsorLogo {margin: 0 0 10px; height:90px;}
header img.playerFoto {float:right; border: 1px solid gray; height: 150px;}
.cbp-contentslider .cbp-content {
    -webkit-column-rule: none;
    -moz-column-rule: none;
    column-rule: none;
    -webkit-column-count: 1;
    -moz-column-count: 1;
    -o-column-count: 1;
    column-count: 1;
    -webkit-column-gap: 0;
    -moz-column-gap: 0;
    -o-column-gap: 0;
    column-gap: 0;
    vertical-align: top;
    padding: 0;
}
.cbp-content .row {    padding: 0px 20px 0px 25px; font-size: 20px; font-weight: bold;}
.cbp-contentslider nav a {padding: 0px; font-size: 25px; }
.cbp-contentslider nav a div {line-height: 2em; text-decoration: none;}
.cbp-contentslider li > div {position: static;}
.sponsorName {letter-spacing: 0;}
.cbp-contentslider > ul li {padding: 0.3em;}
.modal-body {background-color: #E2F1F7; }
.modal-footer {padding: 0; border: 0;}
</style>
