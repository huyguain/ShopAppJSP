<%--
  Created by IntelliJ IDEA.
  User: huynguyen21
  Date: 25/10/24
  Time: 16:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="models.Product" %>
<%@ page import="DAO.ProductDAO" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h2>Product List</h2>
<table>
    <tr>
        <th>Name</th>
        <th>Price</th>
        <th>Quantity</th>
        <th>Brand</th>
    </tr>
    <c:forEach var="product" items="${products}">
        <tr>
            <td>${product.productName}</td>
            <td>${product.price}</td>
            <td>${product.quantity}</td>
            <td>${product.brand.brandName}</td>
        </tr>
    </c:forEach>
</table>
<a href="products">Add Product</a>
<a href="addBrand.jsp">Add Brand</a>
