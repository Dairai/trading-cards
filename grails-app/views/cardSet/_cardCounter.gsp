<div class="col-1" style="display: inline-block; padding:3px">
    <div class="clickbox" id="box${card.number}" style="color:red;" >
        <span style="float:left; padding:1px 0px 0px 1px; font-size:smaller"> ${card.number}</span>
        <input id="qty${card.number}" value="${card.qty}" style="padding:0px; margin:0; font-size:x-large" readonly />
        <button style="width: 20px; height:20px; padding:0px" class="count" id="up${cardnum}" onclick="modify_qty(1,${card.number});colorDiv(${card.number})">▲</button>
        <button style="width: 20px; height:20px; padding:0px" class="count" id="down${card.number}" onclick="modify_qty(-1,${card.number});colorDiv(${card.number})">▼</button>
        <script>
            var qty = document.getElementById('qty'+${card.number}).value;
            var div = document.getElementById('box'+${card.number});
            div.style.backgroundColor = '#444';

            switch (qty) {
                case "-1":
                    div.style.backgroundColor = '#ff9999';
                    break;
                case "0":
                    div.style.backgroundColor = '#444';
                    break;
                default:
                    div.style.backgroundColor = '#85e085';
                    break;
            }
        </script>
    </div>
</div>
