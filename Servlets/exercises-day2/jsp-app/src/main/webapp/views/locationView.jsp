<%@ page import="java.text.SimpleDateFormat" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="ro.teamnet.zth.appl.dao.LocationDao" %>
<%@ page import="ro.teamnet.zth.appl.domain.Location" %>

<html>
<head>
    <title>Locations List</title>
</head>
<body>

    <% String str = request.getQueryString();
    Location location = new LocationDao().getLocationById(Integer.parseInt(str.substring(3))); %>
<table border="1">
    <thead>
    <tr>
        <td>Id</td>
        <td>Street address</td>
        <td>Postal code</td>
        <td>City</td>
        <td>State province</td>
    </tr>
    </thead>
    <tbody>
    <%
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    %>

    <tr>
            <td>
                <%=location.getId()%>
            </td>
            <td>
                <%=location.getStreetAddress()%>
            </td>
            <td>
                <%=location.getPostalCode()%>
            </td>
            <td>
                <%=location.getCity()%>
            </td>
            <td>
                <%=location.getStateProvince()%>
            </td>

        </tr>

    </tbody>
</table>
<a href="locationList.jsp">Locations List</a>
</body>
</html>
