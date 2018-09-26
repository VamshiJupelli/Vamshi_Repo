<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style>
  body {
      position: relative; 
  }
  #section1 {padding-top:50px;height:500px;color: #fff; background-color: #D3D3D3;}
  #section2 {padding-top:50px;height:500px;color: #fff; background-color: #673ab7;}
  #section3 {padding-top:50px;height:500px;color: #fff; background-color: #ff9800;}
  #section4 {padding-top:50px;height:500px;color: #fff; background-color: #FF0000;}
  .isim{
  height:180px;
  width:150px;
  }
  </style>
</head>
<body data-spy="scroll" data-target=".navbar" data-offset="50">

<nav class="navbar navbar-inverse navbar-fixed-top">
  <div class="container-fluid">
    <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="#">CAPSTORE</a>
    </div>
    <div>
      <div class="collapse navbar-collapse" id="myNavbar">
        <ul class="nav navbar-nav">
          <li><a href="#section1">Electronics</a></li>
          <li><a href="#section2">Clothing</a></li>
          <li><a href="#section3">Furniture</a></li>
          <li><a href="#section4">Books & Stationary</a></li>
           <li><a href="/viewCart?cid=${customer.customerId}">View Cart</a></li>
        </ul>
      </div>
    </div>
  </div>
</nav>    

<div id="section1" class="container-fluid">
  <h1>Electronics</h1>
  <c:forEach items='${productList}' var='product'>
					<div class="p">
						<a href="/productInfo?id=${product.productId}"><img src="../images/${product.productId}.jpg" class="isim"></a><br />
						<div class="imginfo">${product.productName}</div>
					</div>
				</c:forEach>
</div>

<div id="section2" class="container-fluid">
  <h1>Clothing</h1>
  <c:forEach items='${productList}' var='product'>
					<div class="p">
						<a href="/productInfo?id=${product.productId}"><img src="../images/${product.productId}.jpg" class="isim"></a><br />
						<div class="imginfo">${product.productName}</div>
					</div>
				</c:forEach>
</div>

<div id="section3" class="container-fluid">
  <h1>Furniture</h1>
  <c:forEach items='${productList}' var='product'>
					<div class="p">
						<a href="/productInfo?id=${product.productId}"><img src="../images/${product.productId}.jpg" class="isim"></a><br />
						<div class="imginfo">${product.productName}</div>
					</div>
				</c:forEach>
</div>

<div id="section4" class="container-fluid">
  <h1>Books & Stationary</h1>
  <c:forEach items='${productList}' var='product'>
					<div class="p">
						<a href="/productInfo?id=${product.productId}"><img src="../images/${product.productId}.jpg" class="isim"></a><br />
						<div class="imginfo">${product.productName}</div>
					</div>
				</c:forEach>
</div>
</body>
</html>
