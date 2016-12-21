<%@ include file="header.jsp" %>
<%@ include file="adminNavbar.jsp" %>
<link rel="stylesheet" href="./scripts/omss_table.css"> 

<center>
<h3>List of Patient's</h3>

<br>

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
                    <td><a href="userController?type=patient&userId=<c:out value="${patient.patientId}"/>">Delete</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    
    </center>
</body>
<br><br>
<center>
<button type="button" class="button" value="back" onClick="history.go(-1);">Back</button>
<a class="button" href="logoffController">Exit</a>
</center>

</html>
