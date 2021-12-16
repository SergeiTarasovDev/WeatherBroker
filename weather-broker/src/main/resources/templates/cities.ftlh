<!doctype html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>IWB - Города</title>
</head>
<body>
<h1>Список городов</h1>

<form method="post" action="/cities">
    <label>Название города:
        <input name="cityName" placeholder="Введите город...">
        <input type="hidden" name="currentTemperature" value="-100.0">
    </label>
    <input type="submit" value="Добавить">
</form>


<h1>список городов</h1>
<table>
    <tr>
        <th>ID</th>
        <th>Название</th>
        <th>Текущая температура</th>
    </tr>
    <#list cities as city>
        <tr>
            <td>${city.id}</td>
            <td>${city.cityName}</td>
            <td>${city.currentTemperature}</td>
        </tr>

    </#list>
</table>
</body>
</html>