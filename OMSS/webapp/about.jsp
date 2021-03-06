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

<center style="padding: 30px">
<h3>About Us</h3>
<p align="justify">
The Non Emergency Medical Service System acts as an interface between the patients searching for the quality treatment and the experienced doctors. 
Patient who is looking for a quality treatment which is not properly available in their location can communicate with the specialist through online using this system and get suggestions, treatment and any operations if required. This system contains complete information about the Hospitals, Doctors, experience and their success rate which makes patient to select the doctor and gets quality treatment. 
<br><br>
We mainly focus on the ease of use and help patient to find and communicate the specialist Doctor they want through online.
 This system will bring each and every specialist information together like Doctor Name,
  Doctor Specialization and Hospital name, 
  Geographical location of the Doctor and contact details provided by the desired individual. This will also include the patient's information who are interested in the services we are offering.

</p>
</center>
</body>
<center>
<button type="button" class="button" value="back" onClick="history.go(-1);">Back</button>
<!--  <button type="submit" class="button" value="logoffController">Exit</button>&nbsp;&nbsp;-->
</center>
<html>
