<%@ include file="header.jsp" %>
 <%@ include file="navbar.jsp" %>



 <script>

 function doctorRegistration(){
	 
		var sp = document.getElementById('sp');
		var hn = document.getElementById('hn');
		var xp = document.getElementById('xp');
		
		var bg= document.getElementById('bg');
		var bm = document.getElementById('bm');
		var dbt = document.getElementById('dbt');
		
		bg.setAttribute('class', 'hidden');
		bm.setAttribute('class', 'hidden');
		dbt.setAttribute('class', 'hidden');
		
		sp.setAttribute('class', 'visible');
		xp.setAttribute('class', 'visible');
		hn.setAttribute('class', 'visible');
		
		$("hospitalName").attr('required',true);
		$("experience").attr('required',true);
		$("specializationId").attr('required',true);
		
		$("bloodgroup").attr('required',false);
		$("bmi").attr('required',false);
		$("dbt").attr('required',false);
		//$("type").val('doctor');
			
}

function otherUsers(){
	var sp = document.getElementById('sp');
	var hn = document.getElementById('hn');
	var xp = document.getElementById('xp');
	
	var bg= document.getElementById('bg');
	var bm = document.getElementById('bm');
	var dbt = document.getElementById('dbt');
	
	sp.setAttribute('class', 'hidden');
	xp.setAttribute('class', 'hidden');
	hn.setAttribute('class', 'hidden');
	
	bg.setAttribute('class', 'visible');
	bm.setAttribute('class', 'visible');
	dbt.setAttribute('class', 'visible');
	
	//$("type").val('patient');
	$("hospitalName").attr('required',false);
	$("experience").attr('required',false);
	$("specializationId").attr('required',false);
	
	$("bloodgroup").attr('required',true);
	$("bmi").attr('required',true);
	$("dbt").attr('required',true);
	
}

function validateType(){
	
	/* 
	if (document.getElementById("type")==null) {
		alert('Please choose  Docotr  |  Patient');
		return false;
	} */
	
	return validatePsw();
}

function ValidateAlpha(evt)
{
    var keyCode = (evt.which) ? evt.which : evt.keyCode
    if ((keyCode < 65 || keyCode > 90) && (keyCode < 97 || keyCode > 123) && keyCode != 32)
     
    return false;
        return true;
}
</script>


<div id="content">
<center>

<h3> Registration</h3>

<span>${msg}</span>

<form action="registrationController" method="post" onsubmit="return validateType();">

<table id="">
<tr>
<td><label>First Name:</label></td>
<td><input class="textbox" type="text" id="firstName" value="${doctor.firstName}${patient.firstName}" name="firstName" required="required" oninvalid="this.setCustomValidity('Please Enter First Name')"></td>
</tr>


<tr>
<td><label>Last Name:</label></td>
<td><input class="textbox" type="text" id="lastName" name="lastName" value="${doctor.lastName}${patient.lastName}" required="required" oninvalid="this.setCustomValidity('Please Enter Last Name')"/></td>
</tr>

<tr>
<td><label>Gender: </label></td>
<td> 
  <input type="radio" name="gender" id="gender" checked="checked" value="male"> Male
  <input type="radio" name="gender" id="gender" value="female"> Female
  <input type="radio" name="gender" id="gender" value="other"> Other
  </td>
</tr>
 
<tr>
<td><label>Email Id:</label></td>
<td><input class="textbox" type="email" id="email" name="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" required="required"  value="${doctor.email}${patient.email}" ></td>
</tr>

<tr>
<td><label>Password:</label></td>
<td><input class="textbox" type="password" id="password" name="password" pattern=".{6,}" required title="6 characters minimum" required="required" ></td>
</tr>


<tr>
<td><label>Confirm Password:</label></td>
<td><input class="textbox" type="password" id="confirmpassword" pattern=".{6,}" required title="6 characters minimum" name="confirmpassword" required="required"  ></td>
</tr>

<tr>
<td><label>State:</label></td>
<td><input class="textbox" type="text" id="state" name="state" onkeypress="return ValidateAlpha(event);" value="${doctor.state}" required /></td>
</tr>
<tr>
<td><label>City:</label></td>
<td><input class="textbox" type="text" id="city" name="city" onkeypress="return ValidateAlpha(event);"  value="${doctor.city}" required /></td>
</tr>
<tr>
<td><label>ZipCode:</label></td>
<td><input class="textbox" type="text" id="zipcode" name="zipcode" onkeypress="return event.charCode > 47 && event.charCode < 58;" pattern="[0-9]{5}"  value="${doctor.zipcode}" required /></td>
</tr>

<tr>
<td><label>Choose: </label></td>
<td> 
  <input type="radio" name="type" id="type1" onclick="doctorRegistration()"  value="doctor">Doctor
  <input type="radio" name="type" id="type1" onclick="otherUsers()" checked="checked" value="patient"> Patient

  </td>
</tr>

<tr class="hidden" id="sp">
<td><label>Specialization:</label></td>
<td>
	 <select class="selectbox" name="specializationId" id="specializationId"  >
				<c:forEach items="${specializations}" var="s">
	            		  <option value="${s.specializationId }">${s.specializationName}</option>
	        		</c:forEach>
				</select>
</td>
</tr>

<tr  class="hidden" id="xp">
<td><label>Enter Years of experience:</label></td>
<td><input class="textbox" type="text" id="experience" min="0" name="experience"  value="${doctor.experience}"  /></td>
</tr>

<tr  class="hidden" id="hn">
<td><label>Hospital Name:</label></td>
<td><input class="textbox" type="text" id="hospitalName" name="hospitalName"  value="${doctor.hospitalName}"  /></td>
</tr>


<tr  class="visible" id="bm">
<td><label>Enter BMI:</label></td>
<td><input class="textbox" type="text" id="experience" min="0" name="bmi" id="bmi"  value="${patient.bmi}"  /></td>
</tr>

<tr  class="visible" id="bg">
<td><label> Blood Group:</label></td>
<td>
 <select class="selectbox" name="bloodgroup" id="bloodgroup"  >
				<option>O+ve</option>
				<option>O-ve</option>
				<option>A+ve</option>
				<option>A-ve</option>
				<option>B+ve</option>
				<option>B-ve</option>
				<option>AB+ve</option>
				<option>AB-ve</option>
 </select>
</td>
</tr>

<tr  class="visible" id="dbt">
<td><label> Diabetes:</label></td>
<td>
 <select class="selectbox" name="diabetes" id="diabetes"  >
				<option>YES</option>
				<option>NO</option>
				 
 </select>
</td>
</tr>


<tr>
<td colspan="2">
<center>All fields are mandatory.</center>
</td>
</tr>
<tr>
<td colspan="2">
<center>
<button type="submit" class="button" type="submit" value="Submit">Submit</button>
<button type="reset" class="button" value="Reset">Reset</button>
  </center>
  </td>
</tr>
</table>
</form>

</center>
</div>

</body>
</html>
