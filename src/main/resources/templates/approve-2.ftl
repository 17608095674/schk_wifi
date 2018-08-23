<!doctype html>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>无线网络申请</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <link rel="icon" type="image/png" href="assets/i/favicon.png">
    <link rel="apple-touch-icon-precomposed" href="assets/i/app-icon72x72@2x.png">
    <meta name="apple-mobile-web-app-title" content="Amaze UI"/>
    <link rel="stylesheet" href="assets/css/amazeui.min.css"/>
    <link rel="stylesheet" href="assets/css/admin.css">
    <link rel="stylesheet" href="assets/css/app.css">
    <script src="assets/js/echarts.min.js"></script>
    <script src="assets/js/gbk.js"></script>
</head>
<script src="assets/js/jquery.min.js"></script>
<style type="text/css">
    .sp1 {
        font-family: 微软雅黑;
        font-size: 12px;
        height: 30px;
        line-height: 30px;
        color: #777777;
        margin-left: 20px;
    }

    .sp2 {
        margin-left: 45px;
        font-size: 13px;
        height: 30px;
        line-height: 30px;
        color: #3C3C3C;
    }

    .sp3 {
        font-family: 微软雅黑;
        font-size: 16px;
        height: 30px;
        line-height: 30px;
    }

    .sp4 {
        margin-left: 120px;
        font-size: 20px;
        height: 30px;
        line-height: 30px;
        color: #36bc99;
    }

    .sp5 {
        font-family: 微软雅黑;
        font-size: 14px;
        color: #2DA9FF;
        margin-left: 20px;
    }

    .sp6 {
        font-family: 微软雅黑;
        margin-left: 16%;
        font-size: 13px;
        color: #FF0000;
    }

    .div1 {
        margin-left: 13%;
    }

    .col-xs-offset-0 {
        margin-left: 0;
    }

    .col-xs-12 {
        float: left;
        width: 100%;
    }

    .table-div {
        margin-left: 5%;
    }

    @media (min-width: 768px) {
        .sp1 {
            font-size: 12px;
        }

        .sp3 {
            font-size: 20px;
        }

        .col-sm-offset-1 {
            margin-left: 8.33333333%;
        }

        .col-sm-10 {
            float: left;
            width: 83.33333333%;
        }
    }

    @media (min-width: 900px) {
        .col-md-offset-3 {
            margin-left: 25%;
        }

        .col-md-6 {
            float: left;
            width: 50%;
        }

        .table-div {
            margin-left: 10%;
        }
    }


</style>
<body data-type="index">

<div class="tpl-page-container tpl-page-header-fixed" style="margin-top: 0px;">
    <div class="col-xs-offset-0 col-xs-12 col-sm-offset-1 col-sm-10 col-md-offset-3 col-md-6"
         style="background:#F5F5F5;">

        <div class="am-panel am-panel-secondary" style="margin-bottom: 0px; ">
            <div class="am-panel-hd">
                <h3 class="am-panel-title">&nbsp;访客信息</h3>
            </div>

            <div>
                <table class="am-table">
                    <tr>
                        <td><span class="sp1">姓名</span></td>
                        <td><span class="sp2" id="realName"></span></td>
                    </tr>
                    <tr>
                        <td><span class="sp1">手机号码</span></td>
                        <td><span class="sp2" id="phoneNumber"></span></td>
                    </tr>
                    <tr>
                        <td><span class="sp1">身份证号码</span></td>
                        <td><span class="sp2" id="idCard"></span></td>
                    </tr>
                    <tr>
                        <td><span class="sp1">业务受理人</span></td>
                        <td><span class="sp2" id="name"></span></td>
                    </tr>


                </table>
            </div>

            <div class="am-panel-hd">
                <h3 class="am-panel-title">&nbsp;申请内容</h3>
            </div>

            <div>
                <table class="am-table">
                    <tr>
                        <td><span class="sp1">网络类别</span></td>
                        <td><span class="sp2">内网、互联网</span></td>
                    </tr>
                    <tr>
                        <td><span class="sp1">申请时长</span></td>
                        <td><span class="sp2" id="day"></span> <span class="sp1">天</span></td>
                    </tr>
                    <tr>
                        <td><span class="sp1">申请用途</span></td>
                        <td><span class="sp2" id="reason"></span></td>
                    </tr>

                </table>
            </div>

            <div class="am-panel-hd">
                <h3 class="am-panel-title">&nbsp;审批流程</h3>
            </div>
            <br>
            <div>
                <span class="am-badge am-badge-secondary am-text-lg" style="margin-left: 8%;">1</span>
                <span class="sp5">网络审核人员审批</span>
                <div class="div1" style="display: none" id="div1">
                    <table>
                        <tr>
                            <td><span class="sp1">处理人</span></td>
                            <td><span class="sp2" id="apn1"></span></td>
                        </tr>
                        <tr>
                            <td><span class="sp1">处理意见</span></td>
                            <td><span class="sp2" id="opinion1"></span></td>
                        </tr>
                        <tr>
                            <td><span class="sp1">处理时间</span></td>
                            <td><span class="sp2" id="date1"></span></td>
                        </tr>
                    </table>
                </div>
                <div style="display: block;" id="div2">
                    <div>
                        <span class="sp6">等待审核</span>
                    </div>
                    <br>
                </div>
            </div>
            <div>
                <span class="am-badge am-badge-secondary am-text-lg" style="margin-left: 8%;">2</span>
                <span class="sp5">机房网络室领导领导审批</span>
                <div style="display: block;">
                    <div>
                        <span class="sp6">待审核</span>
                    </div>
                    <br>
                </div>
            </div>

            <div class="am-panel-hd" id="idea">
                <h3 class="am-panel-title">&nbsp;您的意见</h3>
            </div>

            <br>
            <div style="margin:0 20%;width: 100%;" id="btn">
                <button style="width:20%;" id="passbtn" type="button" class="am-btn am-btn-success am-radius">通过
                </button>
                <button style="margin-left: 10%;width: 20%;" id="refbtn" type="button"
                        class="am-btn am-btn-danger am-radius">驳回
                </button>
            </div>
            <br>

            <div class="am-panel-footer" style="text-align: center;"><span class="sp1">四川航空&copy;</span></div>
        </div>
    </div>
</div>
<script src="assets/js/amazeui.min.js"></script>
<script src="assets/js/iscroll.js"></script>
<script src="assets/js/app.js"></script>
<script type="text/javascript">


    function GetQueryString(name) {
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
        var r = window.location.search.substr(1).match(reg);
        if (r != null) return $URL.decode(r[2]);
        return null;
        //unescape编码级
    }

    window.onload = function () {
        var explorer =navigator.userAgent ;
        console.log(navigator.appName);
        //IE浏览器
        if (explorer.indexOf("MSIE") >= 0) {
            // alert("浏览器版本过低，请用其它浏览器打开！");
            // window.close();
            window.location.href = 'http://172.18.81.246:80/fault';
        }else{
            //加载初始化数据
            loadInit1();
        }
    };

    //加载初始化数据
    function loadInit1() {
        var phoneNumber = GetQueryString("phoneNumber");
        //在这里写你要加载的数据（可以采用jquery的ajax调用，异步、同步均可以）
        $("#phoneNumber").html(GetQueryString("phoneNumber"));
        $("#day").html(GetQueryString("day"));
        $.ajax({
            type: 'Get',
            url: "/api/staff",
            data: {phoneNumber: phoneNumber},
            dataType: "json",
            success: function (result) {
                console.log(result);
                $("#realName").html(result.realName);
                $("#idCard").html(result.idCard);
                $("#name").html(result.business);
                $("#reason").html(result.reason);
            }
        });
    }

    Date.prototype.Format = function (fmt) { // author: meizz
        var o = {
            "M+": this.getMonth() + 1, // 月份
            "d+": this.getDate(), // 日
            "h+": this.getHours(), // 小时
            "m+": this.getMinutes(), // 分
            "s+": this.getSeconds(), // 秒
            "q+": Math.floor((this.getMonth() + 3) / 3), // 季度
            "S": this.getMilliseconds() // 毫秒
        };
        if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
        for (var k in o)
            if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
        return fmt;
    }
    //通过
    $("#passbtn").click(function () {
        $("#date1").html(new Date().Format('yyyy-MM-dd hh:mm:ss'));
        $("#div2").hide();
        $("#idea").hide();
        $("#btn").hide();
        $("#div1").show();
        var day = GetQueryString("day");
        var phoneNumber = GetQueryString("phoneNumber");
        var apa1 = GetQueryString("apa1");
        var date1 = $("#date1").html();
        console.log(day + phoneNumber);
        $.ajax({
            type: 'Get',
            url: "/approve/findByAccount",
            data: {account: apa1},
            dataType: "json",
            success: function (result) {
                $("#apn1").html(result.name);
            }
        });
        $.ajax({
            type: 'Post',
            url: "/api/approve1",
            data: {
                day: day,
                phoneNumber: phoneNumber,
                apa1: apa1,
                date1: date1
            },
            dataType: "json",
            success: function (result) {
                $("#opinion1").html("审批通过");
                alert("审批通过");
                window.close();
            }
        });
    });

    //驳回
    $("#refbtn").click(function () {
        $("#opinion1").html("已驳回");
        $("#date1").html(new Date().Format('yyyy-MM-dd hh:mm:ss'));
        $("#div2").hide();
        $("#idea").hide();
        $("#btn").hide();
        $("#div1").show();
        var apa1 = GetQueryString("apa1");
        var phoneNumber = GetQueryString("phoneNumber");
        $.ajax({
            type: 'Get',
            url: "/approve/findByAccount",
            data: {account: apa1},
            dataType: "json",
            success: function (result) {
                $("#apn1").html(result.name);
            }
        });
        //处理
        $.ajax({
            type: 'Post',
            url: "/api/ref",
            data: {phoneNumber: phoneNumber,step:"1"},
            dataType: "json",
            success: function (result) {
                $("#opinion1").html("已驳回");
                alert(result["information"]);
                window.close();
            }
        });

    });

    //关闭窗口刷新页面
    window.onunload = function () {
        window.location.href = "http://172.18.8.92/mybox/fleshopener.htm";
    };
</script>
</body>

</html>