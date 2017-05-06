// This is a manifest file that'll be compiled into application.js.
//
// Any JavaScript file within this directory can be referenced here using a relative path.
//
// You're free to add application-wide JavaScript to this file, but it's generally better
// to create separate JavaScript files as needed.
//
//= require jquery-2.2.0.min
//= require bootstrap
//= require_tree .
//= require_self

if (typeof jQuery !== 'undefined') {
    (function($) {
        $(document).ajaxStart(function() {
            $('#spinner').fadeIn();
        }).ajaxStop(function() {
            $('#spinner').fadeOut();
        });
    })(jQuery);
}

function modify_qty(val,i) {
    var qty = document.getElementById('qty' + i).value;

    var new_qty = parseInt(qty,10) + val;

    if (new_qty < -1) {
        new_qty = 0;
    }

    document.getElementById('qty' + i).value = new_qty;
    return new_qty;
}

function colorDiv(i) {
    var qty = document.getElementById('qty'+i).value;
    var div = document.getElementById('box'+i);
    var qty_int = parseInt(qty,10);
    div.style.backgroundColor = '#444';

    switch (qty_int) {
        case -1:
            div.style.backgroundColor = '#ff9999';
            break;
        case 0:
            div.style.backgroundColor = '#444';
            break;
        default:
            div.style.backgroundColor = '#85e085';
            break;
    }
}