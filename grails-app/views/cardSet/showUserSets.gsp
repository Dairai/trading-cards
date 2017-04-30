<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>My Card Sets</title>
</head>
<body>

<div class="row" style="text-align:center;">
    <div class="col-lg-offset-3 col-lg-6">
        <h1 style="font-size: xx-large; font-weight: 800;">Sets I am Collecting</h1>
    </div>
</div>
<div class="col-lg-offset-4 col-lg-4" style="text-align:center; background-color: #cceeff;">
    <g:render template="userSetLine" model="[usersets:usersets]" />
</div>


</body>
</html>