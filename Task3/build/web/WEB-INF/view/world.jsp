<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>

<div id="tabBar">

    <div class="selectedTab">
        <a href="world">Рейтинг: Мир</a>
    </div>

    <div class="tab">
        <a href="country">Рейтинг: <%=request.getAttribute("player_country")%></a>
    </div>

</div>
<div>
    <table class="table">
        <tr>
            <td>Страна</td>
            <td>Игрок</td>
            <td>Счет</td>
            <td>Выиграно матчей</td>
            <td>Проиграно матчей</td>
        </tr>
        <% ArrayList<String[]> rows = (ArrayList<String[]>) request.getAttribute("players");%>
        <% for (String[] s : rows)
            {%>
        <tr>
            <% for (int i = 0; i < s.length; i++)
                {%>
            <td>
                <%=s[i]%>
            </td>
            <% }%>
        </tr>
        <% }%>
    </table>
</div>