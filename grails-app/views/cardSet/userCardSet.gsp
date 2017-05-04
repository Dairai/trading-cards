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
		<h3>Cards I am looking for or have extra to trade</h3>
		<br />
	</div>
</div>
<div class="row">
	<g:each var="i" in="${1..thiscardset.numCardsInSet}">
		<div class="col-1" style="display: inline-block; padding:3px">
			<div class="clickbox" id="box${i}" style="color:red;">
				<span style="float:left; padding:1px 0px 0px 1px; font-size:smaller"> ${i}</span>
				<input id="qty${i}" value="0" style="padding:0px; margin:0; font-size:x-large" readonly/>
				<button style="width: 20px; height:20px; padding:0px" class="count" id="up${i}" onclick="modify_qty(1,${i});colorDiv(${i})">▲</button>
				<button style="width: 20px; height:20px; padding:0px" class="count" id="down${i}" onclick="modify_qty(-1,${i});colorDiv(${i})">▼</button>
			</div>
		</div>
	</g:each>
</div>

</body>
</html>