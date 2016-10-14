<!DOCTYPE html>
<html>
<head>
<title>Tiles 3 with Spring 3 with JSP or FTL</title>
<style type="text/css">
body {
 font-family: Arial, Verdana, sans-serif;
}

.header,.footer,.leftPane,.rightPane {
 border: 1px solid gray;
}

.header,.main,.footer {
 width: 960px;
 color: #665544;
 margin: 0px auto;
 clear: both;
}

.leftPane,.rightPane {
 float: left;
 margin: 10px;
 height: 400px;
}

.leftPane {
 width: 100px;
}

.rightPane {
 width: 815px;
}

.leftMenu {
 list-style: none;
 padding: 0;
 margin: 10px;
}
</style>
</head>
<body>
header
 <div class="main">
 menu
  <div class="rightPane">
   body
  </div>
 </div>
footer
 
</body>
</html>