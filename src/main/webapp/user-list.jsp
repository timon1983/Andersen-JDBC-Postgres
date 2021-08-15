<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Users</title>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>
        <h2>Users</h2>
        <table>
            <thead>
            <tr>
                <th>Id</th>
                <th>First name</th>
                <th>Last name</th>
                <th>Age</th>
            </tr>
            </thead>
            <tbody>

                <c:forEach var="user" items="${users}">
                <tr>
                    <td>${user.id}</td>
                    <td>${user.firstName}</td>
                    <td>${user.lastName}</td>
                    <td>${user.age}</td>
                    <td><a href=user-update?id=${user.id}><button>Edit</button></a></td>
                    <td><a href=user-delete?id=${user.id}><button>Delete</button></a></td>
                </tr>
                </c:forEach>

            </tbody>
        </table>
        </div>
        <p><a href=user-create><button>Create user</button></a></p>
        </div>
</body>
</html>

