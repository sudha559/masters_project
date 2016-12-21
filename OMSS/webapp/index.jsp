<%@ include file="header.jsp" %>
<c:choose>
    <c:when test="${type=='doctor'}">
    	<%@ include file="doctornavbar.jsp" %> 
    </c:when>
    <c:when test="${type=='patient'}">
    	<%@ include file="patientnavbar.jsp" %> 
    </c:when>
    <c:when test="${type=='admin'}">
    	<%@ include file="adminNavbar.jsp" %> 
    </c:when>
    <c:otherwise>
	<%@ include file="navbar.jsp" %>
    </c:otherwise>
</c:choose>

<center style="padding:30px;">
<h2>Welcome to Non Emergency Medical Service System..!</h2>
<br>
<p align="justify" style="" >
The Non Emergency Medical Service System (OMSS) acts as an interface between the patients searching for the quality treatment and the experienced doctors. Patient who is looking for a quality treatment which is not properly available in their location can communicate with the specialist through online using this system and get suggestions, treatment and any operations if required. This system contains complete information about the Hospitals, Doctors, experience and their success rate which makes patient to select the doctor and gets quality treatment.
</p> 
<img alt="" src="./images/omsslogo.png" width="1233" height="845">
</center>
</body>
<br>
<center>
<!-- <button type="button" class="button" value="back" onClick="history.go(-1);">Back</button> -->
<!-- <button type="submit" class="button" value="logoffController">Exit</button>&nbsp;&nbsp; -->
</center>
<span ><b>${msg}</b></span>
<html>
