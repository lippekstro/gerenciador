<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List,br.com.alura.gerenciador.modelo.Empresa"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>



<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Java Standard Tag Lib</title>
</head>
<body>

	<c:import url="cabecalho-partial.jsp" />

	<c:if test="${not empty empresa}">
            Empresa ${ empresa } cadastrada com sucesso!
    </c:if>

	<ul>
		<c:forEach items="${ empresas }" var="empresa">
			
			<li>
				${ empresa.nome } - <fmt:formatDate value="${ empresa.dataAbertura }" pattern="dd/MM"/>
				- <a href="/gerenciador/controlador?acao=MostraEmpresa&id=${empresa.id}">edita</a> 
				- <a href="/gerenciador/controlador?acao=RemoveEmpresa&id=${empresa.id}">remove</a>
			</li>
		</c:forEach>
	</ul>
	
	<a href="/gerenciador/controlador?acao=FormNovaEmpresa">adiciona</a>




	<%-- <ul>
		<% 
			List<Empresa> lista = (List<Empresa>)request.getAttribute("empresas");
			for(Empresa empresa : lista){
		%>
			<li>
				<%= empresa.getNome() %>
			</li>
		<%
			}
		%>
	</ul> --%>

</body>
</html>