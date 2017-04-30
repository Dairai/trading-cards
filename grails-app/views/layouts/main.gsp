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
	<link rel="manifest" href="/manifest.json">
	<meta name="msapplication-TileColor" content="#ffffff">
	<meta name="msapplication-TileImage" content="/ms-icon-144x144.png">
	<meta name="theme-color" content="#ffffff">
</head>

<body>
    <div class="container">
        <div class="row">
            <div class="col">
                <div class="navbar navbar-default navbar-static-top" role="navigation" style="background-color: steelblue">
                    <div class="navbar-header">
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
                                    <sec:ifLoggedIn>
                                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">My Account<span class="caret"></span></a>
                                        <ul class="dropdown-menu">
                                            <li><a href="/CardSet/userSets">My Sets</a></li>
                                            <li><a href="/CardSet/myTrades">My Trades</a></li>
                                            <li><a href="/userProfile">My Profile</a></li>
                                        </ul>
                                    </sec:ifLoggedIn>
                                    <sec:ifNotLoggedIn>
                                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">How To Join<span class="caret"></span></a>
                                        <ul class="dropdown-menu">
                                            <li><a href="#">Membership</a></li>
                                            <li><a href="#">Join Now!</a></li>
                                            <li><a href="#">Site Rules</a></li>
                                        </ul>
                                    </sec:ifNotLoggedIn>
                                </li>
                                <li class="dropdown">
                                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Current Sets<span class="caret"></span></a>
                                    <ul class="dropdown-menu">
                                        <li><a href="/CardSet/searchByBrand">List By Brand</a></li>
                                        <li><a href="/CardSet/searchByYear">List By Year</a></li>
                                        <li><a href="/CardSet/searchBySport">List By Sport</a></li>
                                    </ul>
                                </li>
                                <li class="dropdown">
                                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">About <span class="caret"></span></a>
                                    <ul class="dropdown-menu">
                                        <li><a href="#">How to Use This Site</a></li>
                                        <li><a href="#">About This Site</a></li>
                                        <li><a href="/credits">Credits</a></li>
                                    </ul>
                                </li>
                            <sec:ifLoggedIn>
                                <li>
                                    <span style="font-size: small; color:darkblue;"> Logged in as <sec:username/> </span><br />
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
        </div>

        <g:layoutBody/>

        <div class="row" id="footer">
            <div clas="col-lg-10">
                <div class="footer" role="contentinfo" style="background-color: steelblue">
                    Copyright 2017 - Morgan & Nyanbando
                </div>
            </div>
        </div>
    </div>

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
