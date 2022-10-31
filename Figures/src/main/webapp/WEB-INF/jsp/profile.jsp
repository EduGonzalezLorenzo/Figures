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
                <a class="nav-link text-center" href="profile">Mis figuras</a>
            </li>
        </ul>
    </header>

    <main class="container">
        <article id="allFig" class="row justify-content-center">
            <h1 class="text-center">Perfil de ${currentUser.name}</h1>
            <table>
                <tr style="margin-bottom:10px; border: 1px solid black;">
                    <th style="margin-bottom:10px; border: 1px solid black;">Nombre de usuario</th>
                    <th style="margin-bottom:10px; border: 1px solid black;">Nombre de la figura</th>
                    <th style="margin-bottom:10px; border: 1px solid black;">Tipo de figura</th>
                    <th style="margin-bottom:10px; border: 1px solid black;">Fecha de creación</th>
                    <th style="margin-bottom:10px; border: 1px solid black;">Mostrar figura</th>
                    <th style="margin-bottom:10px; border: 1px solid black;">Borrar figura</th>
                </tr>
                <c:forEach var="figure" items="${figures}">
                    <c:if test="${figure.user.name == currentUser.name}">
                        <tr style="margin-bottom:10px; border: 1px solid black;">
                            <td style="margin-bottom:10px; border: 1px solid black;">${figure.user.name}</td>
                            <td style="margin-bottom:10px; border: 1px solid black;">${figure.name}</td>
                            <td style="margin-bottom:10px; border: 1px solid black;">${figure.shape}</td>
                            <td style="margin-bottom:10px; border: 1px solid black;">${figure.creationDate}</td>
                            <td style="margin-bottom:10px; border: 1px solid black;"> <button
                                    onclick="drawByForm()">Dibujar figura</button></td>
                            <td style="margin-bottom:10px; border: 1px solid black;"> <button
                                    onclick="DeleteFigure()">Borrar figura</button></td>
                        </tr>
                    </c:if>
                </c:forEach>
            </table>
            <canvas class="col-10" id="canvas" width="1024" height="768" style="border:1px solid #000000;"></canvas>
        </article>
        <script>
            const canvas = document.getElementById("canvas");
            const ctx = canvas.getContext("2d");
            const boundingRect = canvas.getBoundingClientRect();

            canvas.addEventListener("mousedown", function (event) {
                getData();
            });

            function drawButton() {
                ctx.clearRect(0, 0, canvas.width, canvas.height);
                let x = parseInt(document.getElementById("xCoor").value);
                let y = parseInt(document.getElementById("yCoor").value);
                let shape = document.getElementById("shape").value;
                let color = document.getElementById("color").value;
                let size = parseInt(document.getElementById("size").value);
                drawFigure(shape, x, y, color, size);
            }
            function drawFigure(shape, x, y, color, size) {
                switch (shape) {
                    case "circle":
                        drawCircle(x, y, color, size);
                        break;
                    case "square":
                        drawSquare(x, y, color, size);
                        break;
                    case "triangle":
                        drawTriangle(x, y, color, size);
                        break;
                    case "pentagon":
                        drawPengaton(x, y, color, size);
                        break;
                    case "star":

                        break;
                    default:

                }
            }
            function drawCircle(x, y, color, size) {
                ctx.beginPath();
                ctx.arc(x, y, size / 2, 0, 2 * Math.PI);
                ctx.stroke();
                ctx.fillStyle = color;
                ctx.fill();
            }
            function drawSquare(x, y, color, size) {
                let radius = size / 2;
                ctx.beginPath();
                ctx.rect(x - radius, y - radius, size, size);;
                ctx.stroke();
                ctx.fillStyle = color;
                ctx.fill();
            }
            function drawTriangle(x, y, color, size) {
                let radius = size / 2;
                ctx.beginPath();
                ctx.moveTo(x, y - radius);
                ctx.lineTo(x - radius, y + radius);
                ctx.lineTo(x + radius, y + radius);
                ctx.closePath();
                ctx.stroke();
                ctx.fillStyle = color;
                ctx.fill();
            }
            function drawPengaton(x, y, color, size) {
                let side = 2 * Math.PI / 5;
                let turnAngle = (Math.PI / 180.0) * - 0.05;

                ctx.beginPath();
                for (let i = 0; i <= 5; i++) {
                    let curStep = i * (side + turnAngle);
                    ctx.lineTo(x + (size * Math.cos(curStep)) / 2, y + (size * Math.sin(curStep)) / 2);
                }
                ctx.stroke();
                ctx.fillStyle = color;
                ctx.fill();
            }
        </script>
    </main>
    <script>

    </script>
</body>

</html>