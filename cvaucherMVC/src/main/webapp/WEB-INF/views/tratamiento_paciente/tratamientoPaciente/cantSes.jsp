<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="t" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@	taglib prefix ="sf" uri ="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>


<div class="form-group">
	<sf:label path="cantSesiones" for ="cantSesiones">Sesiones</sf:label>
	<c:forEach var = "aux" items ="${tratP}">
			
			<c:if test ="${aux.id == tratPacById.id}">
				<c:set var ="aux2" value ="#{tratPacById.sesiones}"/>
				
			</c:if>
	</c:forEach>
	
	<c:if test ="${aux2 == NaN}">
		<c:set var ="aux2" value ="0"/>	
	</c:if>
	
	<sf:label cssClass ="form-control" path="cantSesiones" value ="${aux2}" size ="30">${aux2}</sf:label>
	<sf:errors path ="cantSesiones" cssClass ="error"/>
</div>

<div class="form-group">
	<sf:label path="costoTratSesion" for ="costoTratSesion">Importe</sf:label>
	<c:forEach var = "aux" items ="${tratP}">
			
			<c:if test ="${aux.id == tratPacById.id}">
				<c:set var = "aux3" value ="#{tratPacById.monto}"/>
			</c:if>
	</c:forEach>
	
	<c:if test ="${aux3 == NaN}">
				<c:set var = "aux3" value ="0"/>
			</c:if>
	<input type="hidden" name="costoTratSesion" value="${aux3}"/>
	<sf:label cssClass ="form-control" path="costoTratSesion" value ="${aux3}" size ="30">${aux3}</sf:label>
	
	<sf:errors path ="costoTratSesion" cssClass ="error"/>
</div>
	
	
			 	
			 	

