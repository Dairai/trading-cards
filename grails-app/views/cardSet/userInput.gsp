<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>CardSet User Input</title>
    <script type="text/javascript" src="script.js"></script>
    <style>
    input {
        font-size: 2.4em;
        background-color: transparent;
        text-align: center;
        border-width: 0;
        width: 100%;
        margin: 0 0 .1em 0;
        color: #fff;
    }

    label {
        display: block;
        font-size: .8em;
    }

    .count {
        /* basics */
        color: #444;
        background-color: #B5B198;
        /* rounded corners */
        -webkit-border-radius: 6px;
        border-radius: 6px;
        -moz-background-clip: padding; -webkit-background-clip: padding-box; background-clip: padding-box;
        font-weight: bold;
        font-size: .8em;
    }

    button:hover, button:active, button:focus {
        background-color: #CBC7AE;
    }

    .box {
        /* basics */
        background-color: #444;
        color: #C4BE92;
        text-align: center;

        /* rounded corners */
        -webkit-border-radius: 12px;
        border-radius: 12px;
        -moz-background-clip: padding; -webkit-background-clip: padding-box; background-clip: padding-box;
        padding: .1em .1em 1em;
        width: 4em;
        height: 6em;
        margin: 0 auto;
        -webkit-box-shadow: 0px 0px 12px 0px #000;
        box-shadow: 0px 0px 12px 0px #000;
    }
    </style>
</head>
<body>

<div class="row" style="text-align:center;">
    <div class="col-lg-offset-3 col-lg-6">
        <h1 style="font-size: xx-large; font-weight: 800;">Card Set Input</h1>
    </div>
</div>
<div class="row" style="text-align:center">
    <g:render template="cardCounter" />
</div>


</body>
</html>