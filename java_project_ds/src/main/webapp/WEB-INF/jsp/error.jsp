<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
 <head> 
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
  <link href="//fonts.googleapis.com/css?family=Capriola" rel="stylesheet" type="text/css" /> 
  <link href="css/style.css" rel="stylesheet" type="text/css" media="all" /> 
 </head> 
 <body> 
  <div class="wrap"> 
   <div class="logo"> 
    <h1>404</h1> 
    <p> Sorry - File not Found!</p> 
    <div class="sub"> 
     <p>${exception}</p>
     <p><a href="${url}"> Back to Home</a></p> 
    </div> 
   </div> 
  </div> 
 </body>
</html>