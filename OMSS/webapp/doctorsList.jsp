<%@ include file="header.jsp" %>
<%@ include file="adminNavbar.jsp" %>
 <link rel="stylesheet" href="./scripts/omss_table.css">
  
<center>

<br>
<c:if test="${type=='doctor' }">

<h3>List of Doctor's</h3>
<h4>${msg }</h4>
		<table class="omss_grid" >
			<thead>
				<tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
                <th>Experience</th>
                <th>HospitalName</th>
                <th>Action</th>
				</tr>
			</thead>
			<tfoot>
			</tfoot>
        <tbody>
            <c:forEach items="${doctors}" var="doctor">
                <tr class="alt">
                    <td><c:out value="${doctor.firstName}" /></td>
                    <td><c:out value="${doctor.lastName}" /></td>
                    <td><c:out value="${doctor.email}" /></td>
                    <td><c:out value="${doctor.experience}" /></td>
                    <td><c:out value="${doctor.hospitalName}" /></td>
                    <td><a href="userController?type=doctor&userId=${doctor.doctorId}&userName=${doctor.firstName}">Delete</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
 </c:if>
 
 <c:if test="${type=='patient'}">
 <h3>List of Patient's</h3>
	<h4>${msg }</h4>
		<table class="omss_grid">
			<thead>
				<tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
                <th >Action</th>
				</tr>
			</thead>
			<tfoot>
			</tfoot>
        <tbody>
            <c:forEach items="${patients}" var="patient">
                <tr class="alt">
                    <td><c:out value="${patient.firstName}" /></td>
                    <td><c:out value="${patient.lastName}" /></td>
                    <td><c:out value="${patient.email}" /></td>
                    <td><a href="userController?type=patient&userId=${patient.patientId}&userName=${patient.firstName}">Delete</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
 
 </c:if>
</center>
</body>
<br>
<br>
<center>
<button type="button" class="button" value="back" onClick="history.go(-1);">Back</button>
<!--  <button type="submit" class="button" value="logoffController">Exit</button>&nbsp;&nbsp;-->
<a class="button" href="logoffController">Exit</a>
</center>

</html>
