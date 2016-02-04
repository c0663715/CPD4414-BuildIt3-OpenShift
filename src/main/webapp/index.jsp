<%@page import="jbosswildfly.Jbosswildfly"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Web Page</title>
    </head>
    <body>
        <% out.print(Jbosswildfly.getJSON()); %>
    </body>
</html>