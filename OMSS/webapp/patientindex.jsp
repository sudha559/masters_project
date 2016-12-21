<%@ include file="header.jsp" %>
<%@ include file="patientnavbar.jsp" %>

<script >

function ScheduleAppointment(){
	//alert("checked:");
	var n = $( "input:checked" ).length;
		// alert("checked:"+n);
		 if(n==1){
// 			 alert('checked');
			 asdoctor();
		 }else{
			 otherUsers();
			 //alert('un-checked');
		 }
		 
	 }
	 
function asdoctor(){	 
	var sp = document.getElementById('sp');
	var fmsa = document.getElementById('fmsa');
	
	sp.setAttribute('class', 'hidden');
	fmsa.setAttribute('class', 'visible');
 
	$.get('appointmentController?type=specilization', function(response) {
	       var select = $('#specializationId');
	       select.find('option').remove();
	         $.each(response, function(index, value) {
	       	  
	         $('<option>').val(value.specializationId).text(value.specializationName).appendTo(select);
	     });
	       });
	       
}
$(document).ready(function() {
$('#specializationId').change(function(event) {
	 //alert('hi');
       var spe = $("select#specializationId").val();
      // alert(spe);
       $.get('doctorController', {
       	spe : spe
       }, function(response) {

       var select = $('#doctor');
       select.find('option').remove();
         $.each(response, function(index, value) {
       	  
         $('<option>').val(value.doctorId).text(value.firstName+" "+value.lastName).appendTo(select);
     });
       });
       });
});
 



function walkin(){
	var mdf = document.getElementById('mdf');
	mdf.setAttribute('class', 'visible');
	document.getElementById("dateTime").attributes["required"] = true;  
}

function others(){
	var mdf = document.getElementById('mdf');
	mdf.setAttribute('class', 'hidden');
	document.getElementById("dateTime").attributes["required"] = false;  
}

</script>

<br>
<center >
<h2>Welcome to Online Medical Service System..!</h2> <h3>${username }</h3>
<h3><span >${msg} </span></h3>


<input type="checkbox" id="cd"  onclick="ScheduleAppointment()"> &nbsp <span style="font:italic" >If you want to Schedule an Appointment.</span>

<br>
<img class="visible" id="sp" alt="" src="./images/omsslogo.png" width="300" height="150">


<%-- <p>Formatted Date (8): <fmt:formatDate pattern="MM-dd-yyyy hh:mm:ss a" value="${now}" /></p> --%>
<form action="appointmentController" method="POST" enctype="multipart/form-data" id="fmsa" class="hidden">
<table id="">
<tr>
<td>
<label>Specialization:</label></td>

<td>
<!-- <select class="selectbox" name="specialization" id="specializationId"  required> -->
<select class="selectbox" type="text" name="specialization" id="specializationId"  required="true">
				</select>
</td>				
</tr>


<tr>
<td><label>Doctor Name:</label></td>

<td><select class="selectbox" type="text" name="doctor" id="doctor"  required="true"></td>

</tr>

<tr>
<td><label>Appointment Type: </label></td>
<td>
	<input type="radio" name="apType" onclick="others()" id="apType1" value="Online"> Online
  	<input type="radio" name="apType" onclick="walkin()" id="apType2" value="Walkin"> Walkin
<!--   	<input type="radio" name="apType" onclick="others()" id="apType3" value="Home"> Home -->
</td>
</tr>

<tr id="mdf" class="hidden">
<td><label>Appointment Date& time:</label>
</td>

<td>
<input class="textbox" type="datetime-local" name="dateTime"  id="dateTime" min="2016-06-06 04:04:04 AM">
</td>
</tr>

<tr>
<td><label>Reason for Appointment:</label></td>
<td><textarea  type="text" name="description" id="desciption" rows="5" cols="37"></textarea></td>
</tr>
<tr>
<td><label>Upload Previous Medical Reports:</label></td>

<td><div class="fileUpload btn btn-primary">
    <input type="file" name="medicalReport" id="medicalReport"    class="upload" accept=".pdf,.PDF" />
</div>
</tr>
<br>

<tr>
<td colspan="2">
<center>
<br>
<button type="submit" class="button" type="submit" value="Submit">Submit</button>
<button type="reset" class="button" value="Reset">Reset</button>
  </center>
  </td>
</tr>

</table>

</form>


</center>
</body>
<br><br><br>
<center>
<button type="button" class="button" value="back" onClick="history.go(-1);">Back</button>
<!-- <button type="submit" class="button" value="logoffController">Exit</button>&nbsp;&nbsp; -->
<a class="button" href="logoffController">Exit</a>
</center>


</html>
