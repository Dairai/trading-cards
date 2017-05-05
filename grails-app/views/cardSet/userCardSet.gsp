<!doctype html>
<html>
<head>
	<meta name="layout" content="main"/>
	<asset:stylesheet src="box.css"/>
	<title>${thiscardset.year} ${thiscardset.brand.name} ${thiscardset.sport.sportName}</title>
</head>
<body>

<div class="row" style="text-align:center;">
	<div class="col-lg-offset-3 col-lg-6 col-xs">
		<h1 style="font-size: xx-large; font-weight: 800;">${thiscardset.year} ${thiscardset.brand.name} ${thiscardset.sport.sportName}</h1>
		<h3>Cards you are looking for or have extra to trade</h3>
		<br />
	</div>
</div>
<div class="row">
	<g:each var="card" in="${cardsthisuser}">
		<g:render template="cardCounter" model="[card:card]" />
	</g:each>
</div>
<br />
<div class="row">
    <div class="col-lg-6">
        <button class="btn-danger btn-lg" style="box-shadow: 5px 5px 3px #888888">Save Changes</button>
        <a href=""><button class="btn-primary btn-lg" style="box-shadow: 5px 5px 3px #888888">Reset</button></a>

    </div>
</div>
</body>
</html>