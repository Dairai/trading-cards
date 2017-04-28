<g:each in="${brands}" var="brand">
    <div class="col-md-3" style="border:3px solid steelblue; border-radius: 10px; margin-right:50px; margin-bottom:50px; height:100%px; display: inline-block; float: none">
        <a href="/CardSet/showBrand/${brand.id}">
            <img src="${brand.logo_url}" width="100%" style="vertical-align: middle"/>
        </a>
    </div>
</g:each>