<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<form:form method="get" action="/SpringMVCTextBox/addStudent">
<table>
<tr>
<td><form:label path="username">username</form:label></td>
<td><form:input path="username"/></td>
</tr>

<tr>
<td><form:label path="password">password</form:label></td>
<td><form:password path="password"/></td>
</tr>

<tr>
<td><form:label path="address">address</form:label></td>
<td><form:textarea path="address"/></td>
</tr>

<tr>
<td><form:label path="receivePaper">receivePaper</form:label></td>
<td><form:checkbox path="receivePaper"/></td>
</tr>

<tr>
<td><form:label path="gender">gender</form:label></td>
<td><form:radiobutton  path="gender"  value="M" label="MAle"/></td>
<td><form:radiobutton  path="gender"  value="F" label="female"/></td>
</tr>

<tr>
<td><form:label path="favoriteFrameworks">favoriteFrameworks</form:label></td>
<td><form:checkboxes  items="${webFrameworkList}" path="favoriteFrameworks" /></td>
</tr>

<tr>
<td><form:label path="favoriteNumber">favoriteNumber</form:label></td>
<td><form:radiobuttons  path="favoriteNumber"  items="${numbersList}"/></td>
</tr>

<tr>
<td><form:label path="country">country</form:label></td>
<form:select path="country">
               <form:option value="NONE" label="Select"/>
               <form:options items="${countryList}" />
</form:select>     
</tr>


<tr>
<td><form:label path="skills">skills</form:label></td>
<form:select path="skills" items="${skilList}" multiple="true"></form:select>   
</tr>

<tr>
<td colspan="2"><input type="submit" value="Submit" /></td>
</tr>

</table>

</form:form>