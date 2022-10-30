<%@ page isELIgnored="false" %>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<style><%@include file="./styles.css"%></style>


<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="styles.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"></script>
    <title>Figures</title>
</head>

<body>
    <header class="fixed-top">
        <ul class="nav nav-tabs justify-content-around row" role="tablist">
            <li class="nav-item col-4">
                <a class="nav-link text-center active" href="draw">Dibujar</a>
            </li>
            <li class="nav-item col-4">
                <a class="nav-link text-center" href="allFig">Todas las figuras</a>
            </li>
            <li class="nav-item col-4">
                <a class="nav-link text-center" href="profile.jsp">Mis figuras</a>
            </li>
        </ul>
    </header>

    <main class="container">
        <article id="allFig">
            <h1 class="text-center">Todas las figuras</h1>
            <table>
                <tr>
                   <th>X</th>
                   <th>Y</th>
                   <th>Size</th>
                   <th>Color</th>
                   <th>Shape</th>
                </tr>
                <c:forEach var="figure" items="${figures}">
                    <tr>
                       <td>${figure.x}</td> 
                       <td>${figure.y}</td> 
                       <td>${figure.size}</td> 
                       <td>${figure.color}</td>
                       <td>${figure.shape}</td> 
                    </tr>
                </c:forEach>
            </table>
        </article>
    </main>
    <script>

    </script>
</body>

</html>