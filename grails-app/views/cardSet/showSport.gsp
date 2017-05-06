<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Search by Sport Results</title>
</head>
<body>

<div class="row" style="text-align:center;">
    <div class="col-lg-offset-3 col-lg-6">
        <h1 style="font-size: xx-large; font-weight: 800;">Current Sets by Sport</h1>
    </div>
</div>
<div class="col-lg-offset-4 col-lg-4" style="text-align:center; background-color: #cceeff;">
    <g:if test="${sportcardsets == []}">
	    <h1 style="text-align: center; font-size:xx-large; color:red;">No card sets have been entered for this sport</h1>
    </g:if>
	<g:else>
		<g:render template="sportSearchLine" model="[sportcardsets:sportcardsets]" />
	</g:else>
</div>


</body>
</html>