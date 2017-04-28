<g:each in="${brandcardsets}" var="cardset">
    <div class="row">
        <a href="/CardSet/showCardSet/${cardset.id}">
            ${cardset.year} ${cardset.brand.name} ${cardset.sport.sportName}
        </a>
    </div>
</g:each>