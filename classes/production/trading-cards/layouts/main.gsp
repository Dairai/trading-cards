<!DOCTYPE html>
<html lang="en" class="no-js" xmlns="http://www.w3.org/1999/html">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <title>
        <g:layoutTitle default="LastFewCards"/>
    </title>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>

    <asset:stylesheet src="application.css"/>
    <asset:stylesheet src="bootstrap.css" />
    <asset:stylesheet src="main.css" />

    <g:layoutHead/>
	<link rel="apple-touch-icon" sizes="57x57" href="/apple-icon-57x57.png">
	<link rel="apple-touch-icon" sizes="60x60" href="/apple-icon-60x60.png">
	<link rel="apple-touch-icon" sizes="72x72" href="/apple-icon-72x72.png">
	<link rel="apple-touch-icon" sizes="76x76" href="/apple-icon-76x76.png">
	<link rel="apple-touch-icon" sizes="114x114" href="/apple-icon-114x114.png">
	<link rel="apple-touch-icon" sizes="120x120" href="/apple-icon-120x120.png">
	<link rel="apple-touch-icon" sizes="144x144" href="/apple-icon-144x144.png">
	<link rel="apple-touch-icon" sizes="152x152" href="/apple-icon-152x152.png">
	<link rel="apple-touch-icon" sizes="180x180" href="/apple-icon-180x180.png">
	<link rel="icon" type="image/png" sizes="192x192"  href="/android-icon-192x192.png">
	<link rel="icon" type="image/png" sizes="32x32" href="/favicon-32x32.png">
	<link rel="icon" type="image/png" sizes="96x96" href="/favicon-96x96.png">
	<link rel="icon" type="image/png" sizes="16x16" href="/favicon-16x16.png">
	<link rel="manifest" href="/manifest.json">
	<meta name="msapplication-TileColor" content="#ffffff">
	<meta name="msapplication-TileImage" content="/ms-icon-144x144.png">
	<meta name="theme-color" content="#ffffff">
</head>

<body>

    <div class="navbar navbar-default navbar-static-top darkback" role="navigation">
        <div class="container darkback">
            <div class="navbar-header darkback">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="/#">
                    <i class="fa grails-icon">
                        <asset:image src="lfc_mini.png"/>
                    </i> LastFewCards
                </a>
            </div>
            <div class="navbar-collapse collapse" aria-expanded="false" style="height: 0.8px;">
                <ul class="nav navbar-nav navbar-right">
                    <g:pageProperty name="page.nav" />
		                <li class="dropdown">
			                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">How To Join<span class="caret"></span></a>
			                <ul class="dropdown-menu">
				                <li><a href="#">Membership</a></li>
				                <li><a href="#">Join Now!</a></li>
				                <li><a href="#">Site Rules</a></li>
			                </ul>
		                </li>
		                <li class="dropdown">
			                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Current Sets<span class="caret"></span></a>
			                <ul class="dropdown-menu">
				                <li><a href="#">List By Manufacturer</a></li>
				                <li><a href="#">List By Year</a></li>
				                <li><a href="#">List By Num Cards Available</a></li>
			                </ul>
		                </li>
		                <li class="dropdown">
			                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">About <span class="caret"></span></a>
			                <ul class="dropdown-menu">
				                <li><a href="#">How to Use This Site</a></li>
				                <li><a href="#">File a Complaint</a></li>
				                <li><a href="#">About Us</a></li>
			                </ul>
		                </li>
	                <sec:ifLoggedIn>
		                <li>
			                <span style="font-size: small; color:cornflowerblue;"> Logged in as <sec:username/> </span>
			                <button><g:form controller="logout" type="POST"><input class="btn btn-link btn-xs" style="color: black !important;" type="submit" value="LOGOUT" /></g:form></button>
		                </li>
	                </sec:ifLoggedIn>
	                <sec:ifNotLoggedIn>
		                <li><a>
			                <button><g:form controller="login" type="POST"><input class="btn btn-link btn-xs" style="color: black !important;" type="submit" value="LOGIN" /></g:form></button>
		                </a>
		                </li>
	                </sec:ifNotLoggedIn>
                </ul>
            </div>
        </div>
    </div>

    <g:layoutBody/>

    <div class="footer" role="contentinfo"></div>

	<asset:javascript src="jquery-2.2.0.min.js" />
	<asset:javascript src="application.js"/>

    <div id="spinner" class="spinner" style="display:none;">
        <g:message code="spinner.alt" default="Loading&hellip;"/>
    </div>

<script>
    $(".nav li").removeClass("active");
    $('a[href="' + this.location.pathname + '"]').parents('li,ul').addClass('active');
</script>

</body>
</html>
