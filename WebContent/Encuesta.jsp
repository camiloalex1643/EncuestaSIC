<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="Header.jsp" />

<c:if test="${mensaje == 1}">  
	<div class="alert alert-primary" role="alert">
  		Encuesta enviada satisfactoriamente	
	</div>
</c:if>  

<form action="Encuesta" method="POST">
  <div class="form-group">
    <label for="exampleInputEmail1">No. documento</label>
    <input type="text" class="form-control" id="documento" name="documento" aria-describedby="emailHelp">
  </div>
  <div class="form-group">
    <label for="exampleInputEmail1">Email</label>
    <input type="email" class="form-control" id="email" name="email" aria-describedby="emailHelp" placeholder="Enter email">
  </div>
  <div class="form-group">
    <label for="exampleInputEmail1">Comentarios</label>
    <input type="text" class="form-control" id="comentarios" name="comentarios" aria-describedby="emailHelp">
  </div>
  <div class="form-group">
    <label for="exampleInputEmail1">Marca favorita de PC</label>

    <select class="form-control" id="marca" name="marca" aria-describedby="marcaHelp">
    <option>-- Seleccione --</option>
    
    <c:forEach var="marca" items="${lista}">
		<option value="<c:out value="${marca.id}"/>"><c:out value="${marca.marca}"/></option>
	</c:forEach>
    </select>
  </div>
  <button type="submit" class="btn btn-primary">Enviar</button>
</form>

<jsp:include page="Footer.jsp" />