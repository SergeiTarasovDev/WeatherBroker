<!doctype html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="/style.css" rel="stylesheet" type="text/css">
    <title>IWB - Список пользователей</title>
</head>
<body>

<div class="logout"><a href="/logout">logout</a></div>

<div class="header"><h1>Innopolis Weather Broker</h1></div>

<div class="main">
    <div class="content">
            <h1>список пользователей</h1>
        <table>
            <tr>
                <th>ID</th>
                <th>E-mail</th>
                <th>Имя</th>
                <th>Фамилия</th>
                <th>Категория</th>
            </tr>
            <#list users as user>
                <tr>
                    <td><a href="/users/${user.id}/user">${user.id}</a></td>
                    <td>${user.email}</td>
                    <td>${user.firstName}</td>
                    <td>${user.lastName}</td>
                    <td>${user.role}</td>
                </tr>

            </#list>
        </table>
    </div>
</div>

<div class="footer">Тарасов Сергей, 2021</div>

</body>
</html>