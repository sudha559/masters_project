<%@ include file="header.jsp" %> 
<%@ include file="patientnavbar.jsp" %>
 <link rel="stylesheet" href="./scripts/omss_table.css">

<script type="text/javascript">
function download(appointment){
	
/* $.ajax({
    type : "POST",
    url : 'pdfController',
    contentType: "application/json; charset=utf-8",
    data : download=appointment,
    async : false,
    success : function(data) {
        alert("got some data");
        console.log(data);
    },
}); */

	 
		$.post('pdfController',{download:appointment},function(result){
			if (result.success){
				alert('success');
			} else {
				alert('result:'+result)
			}
		},'json');
	 
 
}
</script>

 <center>
 <h3><u> Appointments</u></h3>

<table class="omss_grid">
			<thead>
				<tr>
                <th>Patient Name</th>
                <th>AppointmentType</th>
                <th>AppointmentDate</th>
                <th>Comments</th>
                <th>Doctor</th>
                <th colspan="1">Case Resolution</th>
				</tr>
			</thead>
			<tfoot>
			</tfoot>
        <tbody>
            <c:forEach items="${appointment}" var="doctor">
                <tr class="alt">
                    <td><c:out value="${doctor.patientName}" /></td>
                    <td><c:out value="${doctor.appointmentType}" /></td>
                    <td><c:out value="${doctor.appointmentDate}" /></td>
                    <td ><c:out value="${doctor.description}" /></td>
                    <td><c:out value="${doctor.doctorName}" /></td>
                    <td><a onclick="" href="${pageContext.request.contextPath}/caseResolutionController?appointmentId=<c:out value="${doctor.appointmentId}"/>">View</a></td>
<%--                     <td><a onclick="" href="${pageContext.request.contextPath}/pdfController?download=<c:out value="${doctor.appointmentId}"/>">Download</a></td> --%>
<%--                     <td><a  href="javascript:download(${doctor.appointmentId});">Download</a></td> --%>
                </tr>
            </c:forEach>
        </tbody>
    </table>
 <br>
    <span >${msg} </span>
<br>
</center>    

</body>

<br><br><br>
<center>
<button type="button" class="button" value="back" onClick="history.go(-1);">Back</button>
<a class="button" href="logoffController">Exit</a>
</center>

</html>
