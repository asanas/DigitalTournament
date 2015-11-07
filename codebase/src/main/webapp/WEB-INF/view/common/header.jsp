<%@include file="common-taglibs.jsp"%>
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
    
    <!-- <link href="${pageContext.request.contextPath}/static_content/css/flipclock.css" rel="stylesheet" type="text/css"> -->
    
    <link href="${pageContext.request.contextPath}/static_content/js/timecircles/TimeCircles.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/static_content/js/timecircles/readme.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/static_content/css/custom.css" rel="stylesheet" type="text/css">
    <!--<link href="http://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet" type="text/css"> -->

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

    <!-- jQuery -->
    <script src="${pageContext.request.contextPath}/static_content/js/jquery.js"></script>
    <script src="${pageContext.request.contextPath}/static_content/js/jquery-ui.js"></script>
    
    <!-- Bootstrap Core JavaScript -->
    <script src="${pageContext.request.contextPath}/static_content/js/bootstrap.min.js"></script>
    
    <!-- Plugin JavaScript -->
    <!-- <script src="http://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script> -->
    <script src="${pageContext.request.contextPath}/static_content/js/classie.js"></script>
    <script src="${pageContext.request.contextPath}/static_content/js/cbpAnimatedHeader.js"></script>
    
    <!-- Contact Form JavaScript -->
    <script src="${pageContext.request.contextPath}/static_content/js/jqBootstrapValidation.js"></script>
    <!-- <script src="${pageContext.request.contextPath}/static_content/js/contact_me.js"></script> -->
    
    <!-- Custom Theme JavaScript -->
    <script src="${pageContext.request.contextPath}/static_content/js/freelancer.js"></script>
    
    <!-- <script src="${pageContext.request.contextPath}/static_content/js/flipclock.js"></script> -->
    <script src="${pageContext.request.contextPath}/static_content/js/common/commonUtils.js"></script>
    <script src="${pageContext.request.contextPath}/static_content/js/timecircles/TimeCircles.js"></script>
</head>

<body id="page-top" class="index">
<!-- Navigation -->
    <nav class="navbar navbar-default navbar-fixed-top navbar-shrink">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header page-scroll">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">${tournamentDetails.tournamentName }</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li class="hidden">
                        <a href="#page-top"></a>
                    </li>
                    <li class="page-scroll">
                        <a href="${pageContext.request.contextPath}/home">Digital Tournament</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container-fluid -->
    </nav>