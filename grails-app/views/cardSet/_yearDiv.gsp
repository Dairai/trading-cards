<g:each in="${years}" var="year">
    <div class="col-md-3" style="border:3px solid steelblue; border-radius: 10px; margin-right:50px; margin-bottom:50px; height:100%px; display: inline-block; float: none">
        <a href="/CardSet/showYear/?year=${year}">
            <h1 style="font-size: x-large; color:steelblue;">${year}</h1>
        </a>
    </div>
</g:each>