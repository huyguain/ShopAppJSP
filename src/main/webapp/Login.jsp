<%--
  Created by IntelliJ IDEA.
  User: huynguyen21
  Date: 25/10/24
  Time: 15:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form action="login" method="post">
  Username: <input type="text" name="username" id="username" placeholder="Username">
  <br>
  Password: <input type="password" name="password" id="password" placeholder="Password">
  <br>
  <input type="submit" value="Login">
  <a href="Register.jsp">Register</a>
</form>
<!-- Hiển thị thông báo lỗi nếu có -->
<c:if test="${not empty error}">
  <p style="color: red;">${error}</p>
</c:if>
