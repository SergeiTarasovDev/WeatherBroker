<!doctype html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Пользователи из выбранного города</title>
</head>
<body>
<h1>Пользователи из города</h1>

<table>
    <tr>
        <th>id</th>
        <th>login</th>
        <th>name</th>
    </tr>
    <#list usersOfCity as user>
        <tr>
            <td>${user.id}</td>
            <td>${user.login}</td>
            <td>${user.email}</td>
        </tr>

    </#list>
</table>

</body>
</html>