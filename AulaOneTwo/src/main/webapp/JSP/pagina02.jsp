<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Página02</title>
</head>
<body>

	<%	
	int n1 = 10;
	int n2 = 5;
	int soma = (n1 + n2);	
	%>
	
	<h1>Soma utilizando pagina com JSP</h1>
	
	<p> 
 	   Digite o primeiro número: <% out.print(n1); %><br>
	   Digite o segundo número: <% out.print(n2); %><br> 
	   A soma dos números Digitados é: <% out.print(soma); %>
	</p>

</body>
</html>