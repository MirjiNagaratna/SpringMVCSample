<style>
.error {
   color: #ff0000;
}

.errorblock {
   color: #000;
   background-color: #ffEEEE;
   border: 3px solid #ff0000;
   padding: 8px;
   margin: 16px;
}
</style>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<form:form method="post" action="/SpringMVCError/addStudent" commandName="student">
<form:errors path="*" cssStyle="errorblock" element="div"></form:errors>
<table>
<tr>
<td><form:label path="name">name</form:label></td>
<td><form:input path="name"/></td>
<td><form:errors path="name" cssClass="error"></form:errors> </td>
</tr>

<tr>
<td><form:label path="age">age</form:label></td>
<td><form:input path="age"/></td>
</tr>

<tr>
<td><form:label path="id">id</form:label></td>
<td><form:input path="id"/></td>
<td><form:errors path="name" cssClass="error"></form:errors> </td>
</tr>


<tr>
<td colspan="2"><input type="submit" value="Submit" /></td>
</tr>

</table>

</form:form>