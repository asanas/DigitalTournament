<%@include file="../common/header.jsp"%>
<section class="success">
    <div class="container">
        <div class="row" style="padding-bottom: 5px;">
            <div class="col-lg-8 text-right">
                <h2>Select Chase Numbers</h2>
            </div>
        </div>
        <div class="row" style="padding-bottom: 5px;">
            <div class="col-lg-8 text-right">
                <button id="gotoSelectTourSchedule" type="button" class="btn btn-info disabled">Next</button>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-8 text-center">
                <c:forEach items="${ teamList}" var="team" varStatus="plHandle">
                    <div id="teamrow-panel-wrap-${team.teamId}" class="panel panel-info">
                        <div class="panel-heading text-left">
                            ${team.teamName}
                            <a href="javascript:void(0);" class="expandTime" style="float: right; margin-top: ">
                            <span class="glyphicon glyphicon-circle-arrow-down icon-big"></span></a>
                        </div>
                        <div class="panel-body" style="display: none">
                            <div class="row" style="border-bottom: 1px solid blue">
                                <div class="col-lg-1 text-right">Sr.No.</div>
                                <div class="col-lg-4 text-left">Player Name</div>
                                <div class="col-lg-3">Chase Number
                                    <a id="editChaseNumbersTeam${team.teamId }" href="javascript:void(0);" style="float: right; " class="editChase">
                                        <span class="glyphicon glyphicon-edit icon-small"></span></a>
                                    
                                    <a id="saveChaseNumbersTeam${team.teamId }" href="javascript:void(0);" style="float: right; display: none;" class="saveChase">
                                        <span class="glyphicon glyphicon-ok icon-small"></span></a>
                                </div>
                            </div>
                            <c:forEach items="${ team.playersList}" var="player" varStatus="plHandle">
                                <c:if test="${player.role ne 'COACH' && player.role ne 'MANAGER'}">
                                    <div id="player-profile-row-${player.playerProfileId }" class="row playerProfile" style="border-bottom: 1px solid white">
                                        <div class="col-lg-1 text-right">${plHandle.count }.</div>
                                        <div class="col-lg-4 text-left">${player.firstName} ${player.lastName}</div>
                                        <div class="col-lg-3" >
                                           <span id="defaultChaseNumber${team.teamId }_${player.playerProfileId}" class="defaultChase">${plHandle.count }</span>
                                           <input type="text" class="chaseNumberText" id="chaseNumberTeam${team.teamId }_${player.playerProfileId}" 
                                                                           style="display: none; width: 30px; color:black;" value="${plHandle.count }"/>
                                        </div>
                                    </div>
                                </c:if>
                            </c:forEach>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
</section>

<style>
.panel-body{background-color: #BCC4CA;}
.panel-body .row {margin: 0 -10px 0 -10px;}
.panel-primary .glyphicon-circle-arrow-up, .panel-primary .glyphicon-circle-arrow-down {color:white;}
</style>
<script type="text/javascript">
(function(window, document) {
    $(".expandTime").click(function() {
        if($(this).parent().parent().find('.panel-body').is(':visible')) {
            $(this).parent().parent().find('.panel-body').slideUp('slow');
            $(this).find('span').removeClass('glyphicon-circle-arrow-up').addClass('glyphicon-circle-arrow-down');
        } else {
            $(this).parent().parent().find('.panel-body').slideDown('slow');
            $(this).find('span').removeClass('glyphicon-circle-arrow-down').addClass('glyphicon-circle-arrow-up');
        }
    });

        $(".editChase").click(function() {
            var teamId = $(this).attr("id").substr("editChaseNumbersTeam".length);
            $("#editChaseNumbersTeam" + teamId).hide();
            $("#teamrow-panel-wrap-" + teamId).find(".chaseNumberText").show();
            $("#teamrow-panel-wrap-" + teamId).find(".defaultChase").hide();
            $("#saveChaseNumbersTeam" + teamId).show();
        });

        $("#gotoSelectTourSchedule").click(function() {
            $.ajax({
                // /tournament/{tournamentId}/home
                url: "${pageContext.request.contextPath}/tournament/${tournamentDetails.tournamentId}/markTourInProgress",
                data: "",
                type: "GET",
                success: function(data) {
                    window.location = '${pageContext.request.contextPath}/tournament/${tournamentDetails.tournamentId}/home';
                }
            });
        });

        $(".saveChase").click(function() {
            var teamId = $(this).attr("id").substr("saveChaseNumbersTeam".length);
            var playerProfilesDivs = $("#teamrow-panel-wrap-" + teamId).find(".playerProfile");
            var playerProfileChaseNumberMap = "";
            for(var i = 0; i < playerProfilesDivs.length; i++) {
                var playerProfileId = $(playerProfilesDivs[i]).attr("id").substr("player-profile-row-".length);
                playerProfileChaseNumberMap = playerProfileChaseNumberMap + "," + playerProfileId + "-" + $("#chaseNumberTeam" + teamId + "_" + playerProfileId).val();
            }

            $.ajax({
                // /tournament/{tournamentId}/team/{teamId}/saveChaseNumbers
                url: "${pageContext.request.contextPath}/tournament/${tournamentDetails.tournamentId}/team/"+ teamId +"/saveChaseNumbers",
                data: "playerProfileChaseNumberMap="+playerProfileChaseNumberMap.substr(1),
                type: "POST",
                success: function(data) {
                    $("#teamrow-panel-wrap-" + teamId).removeClass("panel-info").addClass("panel-primary");
                    $("#editChaseNumbersTeam" + teamId).show();
                    $("#teamrow-panel-wrap-" + teamId).find(".chaseNumberText").hide();
                    $("#teamrow-panel-wrap-" + teamId).find(".defaultChase").show();
                    $("#saveChaseNumbersTeam" + teamId).hide();
                    
                    for(var i = 0; i < playerProfilesDivs.length; i++) {
                        var playerProfileId = $(playerProfilesDivs[i]).attr("id").substr("player-profile-row-".length);
                        $("#defaultChaseNumber" + teamId + "_" + playerProfileId).html($("#chaseNumberTeam" + teamId + "_" + playerProfileId).val());
                    }
                    
                    if($(".panel .panel-info").length === 0) {
                        $("#gotoSelectTourSchedule").removeClass("disabled");
                    }
                }
            });
        });
})(window, document);
</script>
<%@include file="../common/footer.jsp"%>