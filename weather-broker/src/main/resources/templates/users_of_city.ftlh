<!doctype html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="/style.css" rel="stylesheet" type="text/css">
    <title>Пользователи</title>
</head>
<body>

<div class="logout"><a href="/logout">logout</a></div>

<div class="header"><h1>Innopolis Weather Broker</h1></div>

<div class="main">
    <div class="content">
        <table>
            <tr>
                <th>ID</th>
                <th>EMail</th>
                <th>Имя</th>
                <th>Фамилия</th>
            </tr>
            <#list users as user>
                <tr>
                    <td>${user.id}</td>
                    <td>${user.email}</td>
                    <td>${user.firstName}</td>
                    <td>${user.lastName}</td>
                </tr>
            </#list>
        </table>
    </div>
</div>

<div class="footer">Тарасов Сергей, 2021</div>

</body>
</html>