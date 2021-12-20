<!doctype html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="/style.css" rel="stylesheet" type="text/css">
    <title>${city.cityName}</title>
</head>
<body>

<div class="logout"><a href="/logout">logout</a></div>

<div class="header"><h1>Innopolis Weather Broker</h1></div>

<div class="main">
    <div class="content">

        <div class="city-weather">
            <h2>г. ${city.getCityName()}</h2>
            <table>
                <tr><td>Текущая температура</td><td>${city.getTemperature()}</td></tr>
                <tr><td>Атмосферное давление</td><td>${city.getPressure()}</td></tr>
                <tr><td>Относительная влажность</td><td>${city.getHumidity()}</td></tr>
                <tr><td>Скорость ветра</td><td>${city.getWindSpeed()}</td></tr>
                <tr><td>Направление ветра</td><td>${city.getWindDeg()}</td></tr>
            </table>
        </div>

        <div class="search-city-weather">
            <h3>Узнать погоду в другом городе</h3>
            <form method="get" action="/city">
                <select name="cityId">
                    <#list cities as city>
                        <option value="${city.getId()}">${city.getCityName()}</option>
                    </#list>
                </select>
                <input type="submit" value="Узнать">
            </form>
        </div>
    </div>
</div>

<div class="footer">Тарасов Сергей, 2021</div>


</body>
</html>