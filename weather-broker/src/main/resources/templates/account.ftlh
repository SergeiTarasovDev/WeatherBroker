<!doctype html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="/style.css" rel="stylesheet" type="text/css">
    <title>IWB - Личный кабинет</title>
</head>
<body>

<div class="logout">
    <p><a href="/account">${user.getLastName()} ${user.getFirstName()}</a></p>
    <p><a href="/logout">logout</a></p>
</div>

<div class="header"><h1>Innopolis Weather Broker</h1></div>

<div class="main">
    <div class="content">
        <div class="city-weather">
            <h2>г. ${user.getCity().getCityName()}</h2>

            <table>
                <tr><td><div class="param-name param-temperature">Текущая температура</div></td><td><div class="param-value param-temperature">${user.getCity().getTemperature()} °С</div></td></tr>
                <tr><td><div class="param-name param-pressure">Атмосферное давление</div></td><td><div class="param-value param-pressure">${user.getCity().getPressure()} мм. рт. ст.</div></td></tr>
                <tr><td><div class="param-name param-humidity">Относительная влажность</div></td><td><div class="param-value param-humidity">${user.getCity().getHumidity()} %</div></td></tr>
                <tr><td><div class="param-name param-wind">Скорость ветра</div></td><td><div class="param-value param-wind">${user.getCity().getWindSpeed()} м/сек</div></td></tr>
                <tr><td><div class="param-name param-wind">Направление ветра</div></td><td><div class="param-value param-wind">${user.getCity().getWindDeg()}°</div></td></tr>
            </table>
        </div>

        <div class="search-city-weather">
            <h3>Узнать погоду в другом городе</h3>
            <form method="get" action="/account">
                <select name="cityId">
                    <#list cities as anotherCity>
                        <#if anotherCity.getId() != user.getCity().getId()>
                            <option value="${anotherCity.getId()}">${anotherCity.getCityName()}</option>
                        </#if>
                    </#list>
                </select>
                <input type="submit" value="&#128269;">
            </form>
        </div>
        <#if city??>
            <div class="city-weather">
                <h2>г. ${city.getCityName()}</h2>

                <table>
                    <tr><td><div class="param-name param-temperature">Текущая температура</div></td><td><div class="param-value param-temperature">${city.getTemperature()} °C</div></td></tr>
                    <tr><td><div class="param-name param-pressure">Атмосферное давление</div></td><td><div class="param-value param-pressure">${city.getPressure()} мм. рт. ст.</div></td></tr>
                    <tr><td><div class="param-name param-humidity">Относительная влажность</div></td><td><div class="param-value param-humidity">${city.getHumidity()} %</div></td></tr>
                    <tr><td><div class="param-name param-wind">Скорость ветра</div></td><td><div class="param-value param-wind">${city.getWindSpeed()} м/сек</div></td></tr>
                    <tr><td><div class="param-name param-wind">Направление ветра</div></td><td><div class="param-value param-wind">${city.getWindDeg()}°</div></td></tr>
                </table>
            </div>
        </#if>

    </div>
</div>



<div class="footer">Тарасов Сергей, 2021</div>

</body>
</html>