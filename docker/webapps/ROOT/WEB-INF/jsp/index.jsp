<%@ page isELIgnored="false" %>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<style><%@include file="./styles.css"%></style>

<!DOCTYPE html>
<html lang="es">

    <body>
        <c:forEach var="m" items="${messages}">
            <div style="margin-bottom:10px; border: 1px solid black;">
                ${m.text}
            </div>
        </c:forEach>

        <form action="/index" method="POST">
            Texto: <br>
            <textarea name="text">
            </textarea>
            <br>
            <input type="submit" value="Envia">
        </form>
    </body>

</html>