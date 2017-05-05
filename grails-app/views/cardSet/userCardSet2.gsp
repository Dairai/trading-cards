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
	<g:each var="cardnum" in="${1..thiscardset.numCardsInSet}">
		<div class="col-1" style="display: inline-block; padding:3px">
			<div class="clickbox" id="box${cardnum}" style="color:red;">
				<span style="float:left; padding:1px 0px 0px 1px; font-size:smaller"> ${cardnum}</span>
                <g:if test="${cardsthisuser.number.get(cardnum)}">
                    <input id="qty${cardnum}" value="1" style="padding:0px; margin:0; font-size:x-large" readonly/>
                </g:>
                <g:else>
                    <input id="qty${cardnum}" value="0" style="padding:0px; margin:0; font-size:x-large" readonly/>
                </g:else>
				<button style="width: 20px; height:20px; padding:0px" class="count" id="up${cardnum}" onclick="modify_qty(1,${cardnum});colorDiv(${cardnum})">▲</button>
				<button style="width: 20px; height:20px; padding:0px" class="count" id="down${cardnum}" onclick="modify_qty(-1,${cardnum});colorDiv(${cardnum})">▼</button>
			</div>
		</div>
	</g:each>
</div>
<br />
<div class="row">
    <div class="col-lg-6">
        <button class="btn-danger btn-lg" style="box-shadow: 5px 5px 3px #888888">Save Changes</button>
        <div>${cardsthisuser}</div>

    </div>
</div>
</body>
</html>