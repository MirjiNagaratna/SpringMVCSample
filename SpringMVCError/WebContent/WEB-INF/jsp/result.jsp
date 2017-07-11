<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Spring MVC Form Handling</title>
</head>
<body>

<h2>Submitted User Information</h2>
   <table>
      <tr>
         <td>Username</td>
         <td>${name}</td>
      </tr>
      <tr>
         <td>age</td>
         <td>${age}</td>
      </tr>    
      <tr>
         <td>id</td>
         <td>${id}</td>
      </tr>  
     </table>
</body>
</html>