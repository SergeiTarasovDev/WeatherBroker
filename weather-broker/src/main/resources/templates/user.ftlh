<!doctype html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="/style.css" rel="stylesheet" type="text/css">
    <title>${user.firstName} ${user.lastName}</title>
</head>
<body>

<div class="logout"><a href="/logout">logout</a></div>

<div class="header"><h1>Innopolis Weather Broker</h1></div>

<div class="main">
    <div class="content">
        <table>
            <tr><td class="column-name">Имя:</td><td class="column-value">${user.firstName}</td></tr>
            <tr><td class="column-name">Фамилия:</td><td class="column-value">${user.lastName}</td></tr>
            <tr><td class="column-name">Email:</td><td class="column-value">${user.email}</td></tr>
            <tr><td class="column-name">Город:</td><td class="column-value">${user.getCity().cityName}</td></tr>
            <tr><td class="column-name">Права:</td><td class="column-value">${user.role}</td></tr>
        </table>
    </div>
</div>

<div class="footer">Тарасов Сергей, 2021</div>


</body>
</html>