<!doctype html>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>四川航空无线网络后台管理系统</title>
    <meta name="description" content="这是一个 index 页面">
    <meta name="keywords" content="index">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <link rel="icon" type="image/png" href="assets/i/favicon.png">
    <link rel="apple-touch-icon-precomposed" href="assets/i/app-icon72x72@2x.png">
    <meta name="apple-mobile-web-app-title" content="Amaze UI"/>
    <link rel="stylesheet" href="assets/css/amazeui.min.css"/>
    <link rel="stylesheet" href="assets/css/admin.css">
    <link rel="stylesheet" href="assets/css/app.css">
</head>
<script src="assets/js/jquery.min.js"></script>
<script src="assets/js/amazeui.min.js"></script>
<script src="assets/js/app.js"></script>
<script type="text/javascript">
    $(function () {
        $("#a").click(function () {
            var account = $("#doc-ipt-email-1").val();
            var pwd = $("#doc-ipt-pwd-1").val();
            $.ajax({
                type: 'Post',
                url: "/employee/login",
                data: {account: account, pwd: pwd},
                dataType: "json",
                success: function (result) {
                    if (result["status"] == true) {
                        window.location.href = "/index";
                    } else {
                        alert(result["information"]);
                    }
                    $("#doc-ipt-email-1").val("");
                    $("#doc-ipt-pwd-1").val("");
                }
            });
        });
    })

    function on_return(event) {
        if (event.keyCode == 13) {
            $("#a").click();
        }
    }
</script>
<body data-type="login" onkeydown="on_return(event);">

<div class="am-g myapp-login " style="background-image: url(assets/img/background.jpg);">
    <div class="myapp-login-logo-block tpl-login-max">
        <div class="myapp-login-logo-text" style="margin-top: 200px;">
            <div class="myapp-login-logo-text">
                <span> Wi-Fi CMS</span> <i class="am-icon-skyatlas"></i>

            </div>
        </div>


        <div class="am-u-sm-10 login-am-center">
            <form class="am-form">
                <fieldset>
                    <div class="am-form-group">
                        <input type="text" class="" id="doc-ipt-email-1" placeholder="UserName">
                    </div>
                    <div class="am-form-group">
                        <input type="password" class="" id="doc-ipt-pwd-1" placeholder="Password">
                    </div>
                    <!-- <p><button type="submit" class="am-btn am-btn-default">登录</button></p> -->
                    <p><a id="a" class="am-btn am-btn-default">登录</a></p>
                </fieldset>
            </form>
        </div>
    </div>
</div>

</body>

</html>