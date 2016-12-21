<%@ include file="header.jsp" %>
<%@ include file="patientnavbar.jsp" %>

<div id="content">
<br>
<center>
<h3>Feedback</h3>
<form action="feedbackController" method="post">

<table id="">


<tr>
<td><label>Doctor Name:</label></td>

<td>
<select class="selectbox" name="doctorId" id="doctorId"  required onchange="">
		<option value=""></option>
				<c:forEach items="${doctors}" var="s">
	            		  <option value="${s.doctorId }">${s.name}</option>
   		</c:forEach>
</select>
<br>
<input hidden="true" name="doctorName" id="doctorName">
</td>
</tr>


<tr>
<td><label>Comments:</label></td>

<td><textarea class="textarea"  name="review" value=""  type="text" rows="5" cols="37"></textarea></td>
</tr>


<tr>
<td><label>Rating:</label></td>

<td>
	<input type="radio" name="rating" value="Not Satisfied"> Not Satisfied
  	<input type="radio" name="rating" value="Satisfied"> Satisfied
  	<input type="radio" name="rating" value="Very Satisfied"> Very Satisfied
</td>
</tr>
<br>
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
<br><br><br>
<center>
<button type="button" class="button" value="back" onClick="history.go(-1);">Back</button>
<a class="button" href="logoffController">Exit</a>
</center>

</html>
