<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <asset:stylesheet src="box.css"/>
    <title>${thiscardset.year} ${thiscardset.brand.name} ${thiscardset.sport.sportName}</title>
</head>
<body>

<div class="row" style="text-align:center;">
    <div class="col-lg-offset-3 col-lg-6">
        <h1 style="font-size: xx-large; font-weight: 800;">${thiscardset.year} ${thiscardset.brand.name} ${thiscardset.sport.sportName}</h1>
        <h3>Total cards available from all users</h3>
	    <br />
    </div>
</div>
<div class="row">
	<g:if test="${totalcardcount == []}">
		<h1 style="color:red; text-align:center; font-size:xx-large">No cards have been entered for this set</h1>
	</g:if>
	<g:else>
		<g:each var="card" in="${totalcardcount}">
			<g:render template="totalCardCounter" model="[card:card]" />
		</g:each>
	</g:else>
</div>

</body>
</html>