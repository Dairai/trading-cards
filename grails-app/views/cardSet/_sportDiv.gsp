<g:each in="${sports}" var="sport">
    <div class="col-md-3" style="border:3px solid steelblue; border-radius: 10px; margin-right:50px; margin-bottom:50px; height:100%px; display: inline-block; float: none">
	    <a href="/CardSet/showSport/?sport=${sport}">
	        <img src="${sport.sportImage}" width="80%"/><br />
	        <h1 style="color: steelblue;">${sport.sportName}</h1>
	    </a>
    </div>
</g:each>