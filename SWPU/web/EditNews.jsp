<%--
  Created by IntelliJ IDEA.
  User: 86038
  Date: 2020/6/12
  Time: 16:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="SaveNewsServlet"  method="post">
    ID<input type="text" name="newsID" value="${news.newsID}"/>
    news<input type="text" name="newsTitle" value="${news.newsTitle}"/>
    作者<input type="text" name="newsWriter" value="${news.newsWriter}"/>
    时间<input type="text" name="newsDate" value="${news.newsDate}"/>
    类型<input type="text" name="newsCon" value="${news.newsCon}"/>
    <input type="submit" value="更新"/>
</form>
</body>
</html>
