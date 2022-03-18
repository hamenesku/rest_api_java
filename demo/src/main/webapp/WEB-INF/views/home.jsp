<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <meta charset="UTF-8">
        <title>Welcome $(userName)</title>
    </head>

    <head><script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script></head> 

    
    <body>
        <form action="/usuario/home/addUser" id="myForm" method="POST">

            <!-- <input type="number" id="" name="id"> -->
            <input type="text" id="" name="apellido">
            <input type="number" id="" name="edad">
            <input type="text" id="" name="nombre">

            <input type="submit" value="Enviar">
        </form>


        <script>
            var formData = JSON.stringify($("#myForm").serializeArray());

            $.ajax({
                type: "POST",
                url: "http://localhost:8084/usuario/home/addUser",
                data: formData,
                success: function(){},
                dataType: "json",
                contentType : "application/json"
            });
        </script>

        
    </body>
</html>