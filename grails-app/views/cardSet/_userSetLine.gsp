<g:each in="${usersets}" var="cardset">
    <div class="row">
        <a href="/CardSet/myCardSet/${cardset.id}">
            ${cardset.year} ${cardset.brand.name} ${cardset.sport.sportName}
        </a>
    </div>
</g:each>