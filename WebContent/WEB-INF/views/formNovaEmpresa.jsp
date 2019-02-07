<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:url value="/controlador" var="linkControladorServlet" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<c:import url="cabecalho-partial.jsp" />

	<form action="${ linkControladorServlet }" method="post">
		Nome: <input type="text" name="nome">
		Data de Abertura: <input type="text" name="data">
		<input type="hidden" name="acao" value="AdicionaEmpresa">
		<input type="submit">
	</form>

</body>
</html>