<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="utf-8">
    <title>List</title>
    <link rel="stylesheet" href="/bootstrap/css/bootstrap.min.css">
    <script src="/js/jquery.min.js"></script>
    <script src="/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<table class="table table-bordered">
    <thead>
    <tr>
        <th>name</th>
        <th>author</th>
        <th>press</th>
        <th>outDate</th>
        <th>inDate</th>
        <th>state</th>
    </tr>
    </thead>
    <tbody>
    <#list books as book>
    <tr>
        <td>${book.name}</td>
        <td>${book.author}</td>
        <td>${book.press}</td>
        <td>${book.outDate?string('yyyy/MM/dd HH:mm:ss')}</td>
        <td>${book.inDate?string('yyyy/MM/dd HH:mm:ss')}</td>
        <td>${book.state}</td>
    </tr>
    </#list>
    </tbody>
</table>

</body>

</html>
