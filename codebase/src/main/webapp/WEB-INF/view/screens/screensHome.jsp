<%@include file="../common/header.jsp"%>

    <!-- Header -->
    <header>
    <div class="container">
        <div class="modal fade" id="teamNameModal" role="dialog">
            <div class="modal-dialog">
                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title text-left" style="color:black;">
                            Enter Team Name
                        </h4>
                    </div>
                    <div class="modal-body">
                        <p>
                            <input type="text" class="form-control" id="txtTeamName" placeholder="Enter Team Name">
                        </p>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal" id="btnSubmit">Submit</button>
                    </div>
                </div>
            </div>
        </div>
        <div class="row text-center">
            <div class="col-lg-3">
                <h3><a href="#" onclick="addOneToScore('team1Score');">Load Demo Scoresheet</a></h3>
            </div>
        </div>
    </div>
    </header>

    <%@include file="../common/footer.jsp"%>

    <script type="text/javascript">
        var teamNameClicked = 'team1Name';
        var clock = $('.clock').FlipClock({
            clockFace : 'MinuteCounter',
            autoStart : false
        });
        $(".clock").click(function() {
            if(clock.running) {
                clock.stop();
                clock.reset();
            } else {
                clock.start();
            }
            
        });
        $(".teamContainer").click(function() {
            teamNameClicked = $(this).attr('id');
            $("#teamNameModal").modal();
        });
        $("#btnSubmit").click(function() {
            $('#'+teamNameClicked).html($("#txtTeamName").val());
        });
        function addOneToScore(teamScoreDivId) {
            var score = parseInt($("#"+teamScoreDivId).html());
            score = score +1;
            $("#"+teamScoreDivId).html(score);
        }
        
        function minusOneFromScore(teamScoreDivId) {
            var score = parseInt($("#"+teamScoreDivId).html());
            if(score != 0 ) {
                score = score -1;
                $("#"+teamScoreDivId).html(score);
            }
        }
    </script>
    <style>
       a, a:hover, a:focus, a:active, a.active {color:blue;}
    </style>
</body>
</html>
