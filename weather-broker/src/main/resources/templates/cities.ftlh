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
    <label>Добавить город:
        <input name="cityName" placeholder="Введите город...">
    </label>
    <input type="hidden" name="temperature" value="-100.0">
    <input type="hidden" name="pressure" value="-100">
    <input type="hidden" name="humidity" value="-100">
    <input type="hidden" name="windSpeed" value="-100.0">
    <input type="hidden" name="windDeg" value="-100">
    <input type="submit" value="Добавить">
</form>


<h1>список городов</h1>
<table>
    <tr>
        <th>ID</th>
        <th>Название</th>
        <th>Температура воздуха</th>
        <th>Атмосферное давление</th>
        <th>Относительная влажность</th>
        <th>Скорость ветра</th>
        <th>Направление ветра</th>
    </tr>
    <#list cities as city>
        <tr>
            <td>${city.id}</td>
            <td>${city.cityName}</td>
            <td>${city.temperature}</td>
            <td>${city.pressure}</td>
            <td>${city.humidity}</td>
            <td>${city.windSpeed}</td>
            <td>${city.windDeg}</td>
        </tr>

    </#list>
</table>
</body>
</html>