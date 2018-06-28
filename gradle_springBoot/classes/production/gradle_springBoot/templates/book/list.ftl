<!DOCTYPE html>
<html lang="zh">

<head>
    <meta charset="utf-8">
    <title>列表</title>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.css">
    <script  src="js/jquery.min.js"></script>
    <script src="bootstrap/js/bootstrap.js"></script>
</head>

<body>
<div class="navbar navbar-expand-sm bg-primary navbar-dark fixed-top">
    <a class="navbar-brand" href="/bookPage">图书馆</a>
    <ul class="navbar-nav">
        <li class="nav-item">
            <a class="nav-link" href="/bookPage">清单</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="/insertPage">添加</a>
        </li>
        <#--<li class="nav-item">-->
            <#--<span class="navbar-text">-->
            <#--状态-->
            <#--</span>-->
        <#--</li>-->
        <#--<li class="nav-item">-->
            <#--<form class="form-inline">-->
                <#--<input class="form-control" type="text" placeholder="Search">-->
                <#--<button class="btn btn-success" type="button">Search</button>-->
            <#--</form>-->
        <#--</li>-->
    </ul>
</div>
<div class="container-fluid">
    <br>
    <br>
    <br>
    <div>
        <form class="form-inline" id="formInsert">
            <label for="name">书名:</label>
            <input class="form-control" id="name" name="name" placeholder="Enter name">
            <label for="author">作者:</label>
            <input class="form-control" id="author" name="author" placeholder="Enter author">
            <label for="press">出版社:</label>
            <input class="form-control" id="press" name="press" placeholder="Enter press">
            <label for="state">状态:</label>
            <input class="form-control" id="state" name="state" placeholder="Enter state">
            <button type="submit" class="btn btn-primary" id="insert" onsubmit="insertSubmit()">添加</button>
        </form>
    </div>
    <p></p>
    <div>
        <table class="table table-striped">
            <thead>
            <tr>
                <th>书名</th>
                <th>作者</th>
                <th>出版社</th>
                <th>借出时间</th>
                <th>还书时间</th>
                <th>状态</th>
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
    </div>
</div>

<script language="javascript" type="text/javascript">

    $("formInsert").submit(function (e) {
        var form = $("formInsert");
        alert("insert");
        var formJson = form.serializeArray();
        var newJson = {};
        $.each(formJson, function(idx, obj) {
            newJson[obj.name] = obj.value;
        });
        $.ajax("/book/insert", {
            type: 'post',
            data: JSON.stringify(newJson),
            contentType: "application/json",
            success: function(data){
                alert(data);
                window.location.href ="/bookPage";
            },
            error: function (data) {
                alert("error: " + data);
            }
        });
        return false;
    });

    // $("formDelete").submit(function (e) {
    //     var form = $("formDelete");
    //     var formJson = form.serializeArray();
    //     var newJson = {};
    //     $.each(formJson, function(idx, obj) {
    //         newJson[obj.name] = obj.value;
    //     });
    //     $.ajax("/book/delete", {
    //         type: 'post',
    //         data: JSON.stringify(newJson),
    //         contentType: "application/json",
    //         success: function(data){
    //             alert(data);
    //             window.location.href ="/bookPage";
    //         },
    //         error: function (data) {
    //             alert("error: " + data);
    //         }
    //     });
    //     return false;
    // });
</script>
</body>

</html>
