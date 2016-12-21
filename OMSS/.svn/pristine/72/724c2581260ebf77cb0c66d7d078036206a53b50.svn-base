<%@ include file="header.jsp" %>
 <%@ include file="patientnavbar.jsp" %>
 
   <c:set var="apnow" value="show" />
 <script type="text/javascript">

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
		//document.getElementById("dateTime").attributes["required"] = true;  
		document.getElementById("dateTime").required = true;
	}
	
	function others(){
		var mdf = document.getElementById('mdf');
		mdf.setAttribute('class', 'hidden');
// 		document.getElementById("dateTime").attributes["required"] = false;  
		document.getElementById("dateTime").required = false;
	}
</script>

<c:set var="now" value="<%=new java.util.Date()%>"  />

<div id="content">
<center>

<h2>Appointment</h2>
<form action="appointmentController" method="POST" enctype="multipart/form-data" onsubmit="return validateAppointment();">

<table id="">
<tr>
<td>
<label>Specialization:</label></td>

<td><select class="selectbox" name="specialization" id="specializationId"  required>
		<option value=""></option>
				<c:forEach items="${specializations}" var="s">
	            		  <option value="${s.specializationId }">${s.specializationName}</option>
	        		</c:forEach>
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
</td>
</tr>

<tr id="mdf" class="hidden">
<td><label>Appointment Date& time:</label>
</td>

<td>
<input class="textbox" type="datetime-local" name="dateTime" title="walk-in Appointment available from 11am to 4pm only."  id="dateTime" ><span></span>
</td>
</tr>

<tr>
<td><label>Reason for Appointment(Max 50 words):</label></td>
<td><textarea  type="text" name="description" id="desciption" rows="5" cols="37" title="Max 50 words" maxlength="50"></textarea></td>
</tr>
<tr>
<td><label>
Upload Previous Medical Reports(optional):</label></td>

<td><div class="fileUpload btn btn-primary">
    <input type="file" name="medicalReport" id="medicalReport"    class="upload" accept=".pdf,.PDF" />
</div>
</tr>


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

</div>


</body>

<br><br>
<center>
<button type="button" class="button" value="back" onClick="history.go(-1);">Back</button>
<a class="button" href="logoffController">Exit</a>
</center>

</html>
