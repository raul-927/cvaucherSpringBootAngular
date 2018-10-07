<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="t" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@	taglib prefix ="sf" uri ="http://www.springframework.org/tags/form" %>
<%@	taglib prefix ="st" uri ="http://www.springframework.org/tags" %>
<%@ page session="false" %>


	<div class="well well-sm">
		<st:url value="j_spring_security_check" var ="authUrl"/>
		<form  class="form" action="${authUrl}" method="POST">
			<div class="form-group">
				<label  for="username">Usuario:</label>
				<input  id="j_username" name="j_username" type="text" class="form-control" placeholder="Usuario"/>
			</div>
			<div class="form-group">
				<label  for="password">Contrase�a:</label>
				<input  id="j_password" name="j_password" type="password" class="form-control" placeholder="Contrase�a"/>
			</div>	
				<input class ="submit" type="submit" value="Log In"/>
			
		</form>	
	 </div>
