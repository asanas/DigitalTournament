<%@include file="../common/common-taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>NMS ALL INDIA 2015</title>

    <!-- JQUERY UI STYLE SHEET -->
    <link href="${pageContext.request.contextPath}/static_content/css/jquery-ui.css" rel="stylesheet">
    <!-- Bootstrap Core CSS - Uses Bootswatch Flatly Theme: http://bootswatch.com/flatly/ -->
    <link href="${pageContext.request.contextPath}/static_content/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="${pageContext.request.contextPath}/static_content/css/freelancer.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="${pageContext.request.contextPath}/static_content/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <!--<link href="http://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet" type="text/css"> -->

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body id="page-top" class="index">

    <!-- Navigation -->
    <nav class="navbar navbar-default navbar-fixed-top">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header page-scroll">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#page-top">NMS ALL INDIA 2015</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li class="hidden">
                        <a href="#page-top"></a>
                    </li>
                    <li class="page-scroll">
                        <a href="#StartMatch">Start Match</a>
                    </li>
                    <li class="page-scroll">
                        <a href="#scoresheet">Scoresheet</a>
                    </li>
                    <li class="page-scroll">
                        <a href="#result">Result</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container-fluid -->
    </nav>

    <!-- Header -->
    <header>
        <div class="container">
            <div class="row">
                <div class="col-lg-6">
                    <select id="team1" class="teamList">
                        <option id="">Select Team1</option>
                        <c:forEach items="${teamList}" var="team">
                            <li>
                                <option id="${team.teamId }">${team.name }</option>
                            </li>
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
                            <li>
                                <option id="${team.teamId }">${team.name }</option>
                            </li>
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
                    <span class="skills" id="tossWonBy">Toss won by </span>
                    <span class="info-text" id="teamSelection">
                        and elected 
                        <label><input type="radio" name="electedTo" value="Defence"/>Defence</label>
                        <label><input type="radio" name="electedTo" value="Attack"/>Attack</label>
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

    <!-- Footer -->
    <footer class="text-center">
        <div class="footer-below">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        By Nav Maharashtra Sangh&copy; 2015
                    </div>
                </div>
            </div>
        </div>
    </footer>

    <!-- jQuery -->
    <script src="${pageContext.request.contextPath}/static_content/js/jquery.js"></script>
    <script src="${pageContext.request.contextPath}/static_content/js/jquery-ui.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="${pageContext.request.contextPath}/static_content/js/bootstrap.min.js"></script>

    <!-- Plugin JavaScript -->
    <script src="http://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>
    <script src="${pageContext.request.contextPath}/static_content/js/classie.js"></script>
    <script src="${pageContext.request.contextPath}/static_content/js/cbpAnimatedHeader.js"></script>

    <!-- Contact Form JavaScript -->
    <script src="${pageContext.request.contextPath}/static_content/js/jqBootstrapValidation.js"></script>
    <script src="${pageContext.request.contextPath}/static_content/js/contact_me.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="${pageContext.request.contextPath}/static_content/js/freelancer.js"></script>

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
                        radioBtn1.appendTo('#tossWonBy');
                        radioBtn2.appendTo('#tossWonBy');
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
                        alert('Data: ' + data);
                    }
                });
            }
        });
    });
    </script>
</body>
</html>
