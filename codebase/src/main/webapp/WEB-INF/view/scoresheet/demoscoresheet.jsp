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
<link
	href="${pageContext.request.contextPath}/static_content/css/jquery-ui.css"
	rel="stylesheet">
<!-- Bootstrap Core CSS - Uses Bootswatch Flatly Theme: http://bootswatch.com/flatly/ -->
<link
	href="${pageContext.request.contextPath}/static_content/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom CSS -->
<link
	href="${pageContext.request.contextPath}/static_content/css/freelancer.css"
	rel="stylesheet">

<!-- Custom Fonts -->
<link
	href="${pageContext.request.contextPath}/static_content/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">

<link
	href="${pageContext.request.contextPath}/static_content/css/flipclock.css"
	rel="stylesheet" type="text/css">
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
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#page-top">NMS ALL INDIA 2015</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav navbar-right">
				<li class="hidden"><a href="#page-top"></a></li>
				<li class="page-scroll"><a href="#StartMatch">Start Match</a></li>
				<li class="page-scroll"><a href="#scoresheet">Scoresheet</a></li>
				<li class="page-scroll"><a href="#result">Result</a></li>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid --> </nav>

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
		<div class="row">
			<div class="col-lg-4 text-center">
				<h2 class="teamContainer" id="team1Name">Team 1</h2>
			</div>
			<div class="col-lg-4 col-lg-offset-4 text-center">
				<h2 class="teamContainer" id="team2Name">Team 2</h2>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-4 text-center">
				<h1 id="team1Score">0</h1>
			</div>
			<div class="col-lg-4 text-center">
				<div class="clock clearfix"></div>
			</div>
			<div class="col-lg-4 text-center">
				<h1 id="team2Score">0</h1>
			</div>
		</div>
		<div class="row">
            <div class="col-lg-2 text-center">
                <a href="#" onclick="addOneToScore('team1Score');">
		          <span class="glyphicon glyphicon-plus"></span>
		        </a>
            </div>
            <div class="col-lg-2 text-center">
                <a href="#" onclick="minusOneFromScore('team1Score');">
		          <span class="glyphicon glyphicon-minus"></span>
		        </a>
            </div>
            <div class="col-lg-4 text-center">
                &nbsp;
            </div>
            <div class="col-lg-2 text-center">
                <a href="#" onclick="addOneToScore('team2Score');">
                  <span class="glyphicon glyphicon-plus"></span>
                </a>
            </div>
            <div class="col-lg-2 text-center">
                <a href="#" onclick="minusOneFromScore('team2Score');">
                  <span class="glyphicon glyphicon-minus"></span>
                </a>
            </div>
        </div>
		<div class="row">
			<div class="col-lg-12">
				<hr class="star-light">
				<span class="skills">Venue: S.P. College Ground, Pune</span>
			</div>
		</div>
	</div>
	</header>

	<!-- Footer -->
	<footer class="text-center">
	<div class="footer-below">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">By Nav Maharashtra Sangh&copy; 2015</div>
			</div>
		</div>
	</div>
	</footer>

	<!-- jQuery -->
	<script
		src="${pageContext.request.contextPath}/static_content/js/jquery.js"></script>
	<script
		src="${pageContext.request.contextPath}/static_content/js/jquery-ui.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script
		src="${pageContext.request.contextPath}/static_content/js/bootstrap.min.js"></script>

	<!-- Plugin JavaScript -->
	<script
		src="http://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/static_content/js/classie.js"></script>
	<script
		src="${pageContext.request.contextPath}/static_content/js/cbpAnimatedHeader.js"></script>

	<!-- Contact Form JavaScript -->
	<script
		src="${pageContext.request.contextPath}/static_content/js/jqBootstrapValidation.js"></script>
	<script
		src="${pageContext.request.contextPath}/static_content/js/contact_me.js"></script>

	<!-- Custom Theme JavaScript -->
	<script
		src="${pageContext.request.contextPath}/static_content/js/freelancer.js"></script>
	<script
		src="${pageContext.request.contextPath}/static_content/js/flipclock.js"></script>

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
