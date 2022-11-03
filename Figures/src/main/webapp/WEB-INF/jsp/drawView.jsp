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

<body onload="drawButton()">
    <main class="container">
        <article id="drawView" class="row justify-content-center">
            <h1 class="text-center">Muestra de la figura ${figureToDraw.name} del usuario ${figureToDraw.user.name}.</h1>
            <canvas class="col-10" id="canvas" width="1024" height="768" style="border:1px solid #000000;"></canvas>
            <input type="hidden" name="xCoor" id="xCoor" value=${figureToDraw.x}>
            <input type="hidden" name="yCoor" id="yCoor" value=${figureToDraw.y}>
            <input type="hidden" name="shape" id="shape" value=${figureToDraw.shape}>
            <input type="hidden" name="color" id="color" value=${figureToDraw.color}>
            <input type="hidden" name="size" id="size" value=${figureToDraw.size}>               
        </article>
    </main>

    <script>
        const canvas = document.getElementById("canvas")
        const ctx = canvas.getContext("2d");
        
        function drawButton() {
            ctx.clearRect(0, 0, canvas.width, canvas.height);
            let x = parseInt(document.getElementById("xCoor").value);
            console.log(x);
            let y = parseInt(document.getElementById("yCoor").value);
            console.log(y);
            let shape = document.getElementById("shape").value;
            console.log(shape);
            let color = document.getElementById("color").value;
            console.log(color);
            let size = parseInt(document.getElementById("size").value);
            console.log(size);
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
</body>

</html>