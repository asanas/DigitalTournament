<%@include file="../common/header.jsp"%>
    <!-- Header -->
    <header>
        <div class="container">
            <div class="row">
                <div class="col-lg-6">
                    <select id="team1" class="teamList">
                        <option id="">Select Team1</option>
                        <c:forEach items="${teamList}" var="team">
                            <option id="${team.teamId }">${team.displayName }</option>
                        </c:forEach>
                    </select>
                    <div class="">
                        <img src="${pageContext.request.contextPath}/static_content/img/team1.png" class="img-responsive img-circle" alt="Team1" width="304" height="236">
                    </div>
                </div>
                <div class="col-lg-6">
                    <select id="team2" class="teamList">
                        <option id="">Select Team2</option>
                        <c:forEach items="${teamList}" var="team">
                            <option id="${team.teamId }">${team.displayName}</option>
                        </c:forEach>
                    </select>
                    <div class="">
                        <img src="${pageContext.request.contextPath}/static_content/img/team2.png" class="img-responsive img-circle" alt="Team 2" width="304" height="236">
                    </div>
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
-->
</style>
<%@include file="../common/footer.jsp"%>
<script type="text/javascript">
$(function() {
    $(".teamList").selectmenu({
       select: function( event, ui ) {
            if($("#team1").val() != 'Select Team1' && $("#team2").val() != 'Select Team2') {
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
    
    $( "#beginMatch" ).click(function() {
        if($('input[name=tossWonTeam]:checked') && $('input[name=electedTo]:checked')) {
        	var team1Id = $("#team1").find(":selected").attr("id");
            var team2Id = $("#team2").find(":selected").attr("id");
            var queryParam = 'team1Id='+team1Id+'&team2Id='+team2Id+'&tossWonBy='
            +$('input[name=tossWonTeam]:checked').val()+'&electedTo='+$('input[name=electedTo]:checked').val();
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
});
</script>
</body>
</html>
