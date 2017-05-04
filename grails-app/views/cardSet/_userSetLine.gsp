<g:each in="${usersets}" var="cardset">
    <div class="row">
        <a href="/CardSet/userCardSet?year=${cardset.year}&brand=${cardset.brand.name}&sport=${cardset.sport.sportName}">
            ${cardset.year} ${cardset.brand.name} ${cardset.sport.sportName} (${cardset.numCardsInSet} cards in set)
        </a>
    </div>
</g:each>