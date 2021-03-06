<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Products List</title>
</head>
<body>
<div align="center" style="padding-top: 50px">
<h3>List of all Products</h3>
	  
  <table cellspacing="20">
    <tr>
      <th align="center">Product Name</th>
      <th align="center">Price</th>
      <th align="center">Quantity</th>
      <th align="center">Rating</th>
      <th align="center">Merchant</th>
    </tr>
    <c:forEach items='${productsList}' var='product'>
      <tr>
      <td>${product.productName}</td>
      <td>${product.productPrice}</td>
      <td>${product.productQuantity}</td>
      <td>${product.productRating}</td>
	  <td><form action="/addToCart">
	  <input type="submit" value="Add To Cart"></form>
      </tr>
    </c:forEach>
 
  </table>
  <br>
</div>
</body>
</html>