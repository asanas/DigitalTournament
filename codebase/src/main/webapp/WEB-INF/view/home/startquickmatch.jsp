<%@include file="../common/header.jsp"%>
    <!-- Header -->
    <header>
        <div class="container" style="padding-top: 80px;">
            <%@include file="../team/playerProfilleWrapperModal.jsp"%>
            <div class="row">
                <div class="col-lg-6">
                    <div class="text-left">
                        <select id="team1" class="teamList">
                            <option id="">Select Team</option>
                            <c:forEach items="${teamList}" var="team">
                                <option id="${team.teamId }">${team.displayName }</option>
                            </c:forEach>
                        </select>
                        <button id="loadteam1PlayerProfile" type="button" class="btn btn-info showPlayerProfile disabled" style="display: inline; margin-top: -32px;">Player Profile</button>
                    </div>
                    <div id="team1Players" style="width: 85%;"></div>
                </div>
                <div class="col-lg-6">
                    <div>
                        <select id="team2" class="teamList">
                            <option id="">Select Team</option>
                            <c:forEach items="${teamList}" var="team">
                                <option id="${team.teamId }">${team.displayName}</option>
                            </c:forEach>
                        </select>
                        <button id="loadteam2PlayerProfile" type="button" class="btn btn-info showPlayerProfile disabled" style="display: inline; margin-top: -32px;">Player Profile</button>
                    </div>
                    <div id="team2Players" style="width: 85%;"></div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <hr class="star-light">
                    <span class="skills">Venue: S.P. College Ground, Pune</span>
                </div>
            </div>
            <div class="row" id="beginMatchRow" style="display: none;">
                <div class="col-lg-7 col-lg-offset-1 text-right" style="padding-top: 30px;">
                    <div class="skills" id="tossWonBy" style="display: inline-block;">Toss won by
                        <span class="skills" id="tossWonByRadioContainer"></span>
                    </div>
                    <span class="info-text" id="teamSelection">
                        and elected 
                        <label><input type="radio" name="electedTo" value="Defence"/>Defence</label>
                        <label><input type="radio" name="electedTo" value="Chase"/>Chase</label>
                    </span>
                </div>
                <div class="col-lg-2 col-lg-offset-1 text-right">
                    <a id="beginMatch" href="javascript:void(0);" class="btn btn-lg btn-outline">
                        <i class="fa fa-download"></i> Begin Match
                    </a>
                </div>
            </div>
        </div>
    </header>
<style>
<!--
label { padding: 10px;}
#team1-button {width: 200px !important;}
#team2-button {width: 200px !important;}
-->
</style>
<%@include file="../common/footer.jsp"%>
<script type="text/javascript">
$(function() {
    $(".teamList").selectmenu({
       select: function( event, ui ) {
           var clickTeamElementId = $(this).find(":selected").attr("id");
           var clickTeamId = $(this).attr("id");
           if($(this).val() != 'Select Team') {
               $.ajax({
                   url: '${pageContext.request.contextPath}/loadTeamDetails/team/' + clickTeamElementId + '/weight/false/height/false/tournament/${tournamentDetails.tournamentId}',
                   data: "",
                   type: "GET",
                   success: function(data) {
                       var playersListHTML = $(data).find("#playersList").html();
                       $("#" + clickTeamId + "Players").html(playersListHTML);
                   }
               });
               if($("#load" + $(this).attr("id") + "PlayerProfile").hasClass("disabled")) {
                   $("#load" + $(this).attr("id") + "PlayerProfile").toggleClass("disabled");
               }
           } else {
               $("#load" + $(this).attr("id") + "PlayerProfile").toggleClass("disabled");
           }
           if($("#team1").val() != 'Select Team' && $("#team2").val() != 'Select Team') {
                if($("#team1").val() === $("#team2").val()) {
                    alert('Please select two different teams to start match.');
                    $("#beginMatchRow").hide();
                } else {
                    var team1Id = $("#team1").find(":selected").attr("id");
                    var team2Id = $("#team2").find(":selected").attr("id");
                    var radioBtn1 = $('<label><input type="radio" name="tossWonTeam" value="'+team1Id+'"/>'+$("#team1").val()+'</label>');
                    var radioBtn2 = $('<label><input type="radio" name="tossWonTeam" value="'+team2Id+'"/>'+$("#team2").val()+'</label>');
                    $('#tossWonByRadioContainer').html('');
                    radioBtn1.appendTo('#tossWonByRadioContainer');
                    radioBtn2.appendTo('#tossWonByRadioContainer');
                    $("#beginMatchRow").show();
                }
            } else {
                $("#beginMatchRow").hide();
            }
       }
    });

    $("#beginMatch").click(function() {
        if($('input[name=tossWonTeam]:checked') && $('input[name=electedTo]:checked')) {
            var team1Id = $("#team1").find(":selected").attr("id");
            var team2Id = $("#team2").find(":selected").attr("id");
            var queryParam = 'team1Id='+team1Id+'&team2Id='+team2Id+'&tossWonBy='
            +$('input[name=tossWonTeam]:checked').val()+'&electedTo='+$('input[name=electedTo]:checked').val() + '&tournamentId=${tournamentDetails.tournamentId}';
            $.ajax({
                url: '${pageContext.request.contextPath}/startQuickMatch',
                data: queryParam,
                type: "POST",
                success: function(data) {
                    window.location = '${pageContext.request.contextPath}/loadScoresheet/match/'+data+'/inning/1/turn/1';
                }
            });
        }
    });

    $( ".showPlayerProfile" ).click(function() {
        var teamId = $("#"+ $(this).attr("id").substr(4, 5)).find(":selected").attr("id");
        $.ajax({
            url: '${pageContext.request.contextPath}/fetchTeamPlayers/team/'+teamId+'/tournament/${tournamentDetails.tournamentId}',
            data: "",
            type: "GET",
            success: function(data) {
                $('#teamPlayerProfileModal').html(data);
                $('#teamPlayerProfileModal').modal();
                $('#cbp-contentslider').cbpContentSlider();
            }
        });
    });
});
</script>
</body>
</html>
