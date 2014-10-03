<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="t" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@	taglib prefix ="sf" uri ="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>

	<sf:form id ="frmTipoTrat" 
		method ="POST" 
		modelAttribute ="pacientes" >
		 <fieldset style="width: 350px;">
		 	<legend>&nbsp;BAJA DE PACIENTES&nbsp;</legend>
	        <br />
		 	 
		 	<sf:label path="pacId" for ="pacId">Id</sf:label>
		 	<sf:input path="pacId" size ="10" id="descCAT"/>
		 	<sf:errors path ="pacId" cssClass ="error"/>
		 	
		 	<br /> <br />
		 	
		 </fieldset>
		 <div class="botonForm">
		 	<input type ="submit" value ="Aceptar"/>
		 	<input type ="reset" value ="Cancelar"/>
		 </div>
	 </sf:form>
