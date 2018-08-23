<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>四川航空无线登录系统入口</title>
    <link rel="shortcut icon" href="bootstrap/images/short-icon.png">
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="bootstrap/css/bootstrap-datetimepicker.min.css">
    <link rel="stylesheet" href="bootstrap/css/animate.min.css">
    <link rel="stylesheet" href="bootstrap/css/bootstrapValidator.min.css">
    <link rel="stylesheet" href="bootstrap/css/style.css">
</head>

<body>
<div class="preloader">
    <div class="status"></div>
</div>
<section class="header">
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-2 col-sm-3 col-xs-4">
                <img class="logo img-responsive" src="bootstrap/images/logo.png">
            </div>
        </div>
    </div>
</section>
<section id="intro" style="display: block;">
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-offset-8 col-md-3 col-sm-offset-7 col-sm-4 col-xs-offset-6 col-xs-5 text-left intro-form">
                <form id="form-login">
                    <div class="form-group">
                        <input id="userName" name="userName" type="text" class="form-control icon-user"
                               placeholder="请输入用户名" aria-describedby="basic-addon1">
                    </div>
                    <div class="form-group has-feedback">
                        <input id="password" name="password" type="password" class="form-control icon-psw"
                               placeholder="请输入密码" aria-describedby="basic-addon2">
                        <span class="form-control-feedback" aria-hidden="true">
                <a href="#" class="psw-status">
                <img src="bootstrap/images/icon_03eye.png" alt="">
              </a>
              </span>
                    </div>
                    <#--<div class="form-group">-->
                        <#--<label class="sr-only" for="selectValues">无线认证</label>-->
                        <#--<select id="selectValues" name="category" class="form-control wifi-auth">-->
                            <#--<option value="1" selected="selected">无线认证</option>-->
                            <#--<option value="2">其他1</option>-->
                            <#--<option value="3">其他2</option>-->
                        <#--</select>-->
                    <#--</div>-->
                    <div class="row">
                        <div class="col-md-offset-3 col-md-6 col-sm-offset-3 col-sm-6 col-xs-offset-3 col-xs-6">
                            <button id="login-btn" type="button" class="btn btn-default btn-submit">登录</button>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-offset-3 col-md-6 col-sm-offset-3 col-sm-6 col-xs-offset-3 col-xs-6">
                            <button id="visitor-btn" type="button" class="btn btn-default btn-submit-else">访客登录</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</section>
<section id="register" style="display: none;">
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-offset-8 col-lg-3 col-md-offset-7 col-md-4 col-xs-offset-6 col-xs-5 text-left register-form">
                <form id="form-regist">
                    <div class="form-title text-center">
                        访客登录
                    </div>
                    <div class="form-scroll">
                        <div class="form-group">
                            <input name="realName" type="text" class="form-control icon-name" placeholder="姓名"
                                   aria-describedby="basic-addon9">
                        </div>
                        <div class="form-group">
                            <input name="idCard" type="text" class="form-control icon-ID-Card" placeholder="身份证号码"
                                   aria-describedby="basic-addon5">
                        </div>
                        <div class="form-group">
                            <label class="sr-only" for="selectValues2">申请用途</label>
                            <select id="selectValues2" name="limit" class="form-control wifi-auth">
                                <option value="1" selected="selected">互联网权限</option>
                                <option value="2">内网权限</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <input name="day" type="text" class="form-control icon-date" placeholder="有效时间(天)"
                                   aria-describedby="basic-addon10">
                            <!-- <div class="input-group date form_datetime" data-date="2018-06-20" data-date-format="yyyy-mm-dd" data-link-field="dtp_input1">
                              <input type="text" class="form-control icon-active-time" size="16" placeholder="有效时间" aria-describedby="basic-addon6" readonly>
                              <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                              <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                            </div>
                            <input type="hidden" id="dtp_input1" value="" /> -->
                        </div>
                        <div class="form-group">
                            <input name="account" type="text" id="account" class="form-control icon-elnumber"
                                   placeholder="业务受理人工号" aria-describedby="basic-addon7" onblur="getName()">
                        </div>
                        <div class="form-group">
                            <input name="name" type="text" id="name" class="form-control icon-apName"
                                   placeholder="业务受理人姓名" aria-describedby="basic-addon8">
                        </div>

                        <div class="form-group">
                            <textarea name="reason" class="form-control icon-reason" placeholder="申请理由"
                                      rows="1"></textarea>
                            <!-- <label class="sr-only" for="selectValues3">审批部门</label>
                            <select id="selectValues3" class="form-control icon-department">
                              <option value="1" selected="selected">人事部</option>
                              <option value="2">市场部</option>
                            </select> -->
                        </div>
                        <div class="form-group">
                            <div class="input-group">
                                <input id="phoneNumber" name="phoneNumber" type="text" class="form-control icon-phone"
                                       placeholder="手机号" aria-describedby="basic-addon3">
                                <span class="input-group-btn">
                    <button id="code-btn" type="button" class="btn btn-default btn-getcode">获取验证码</button>
                  </span>
                            </div>
                        </div>
                        <div class="form-group">
                            <input name="code" type="text" class="form-control icon-psw" placeholder="验证码"
                                   aria-describedby="basic-addon4">
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-offset-3 col-md-6 col-sm-offset-3 col-sm-6 col-xs-offset-3 col-xs-6">
                            <button id="submitBtn" type="button" class="btn btn-default btn-submit">注册</button>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-offset-3 col-md-6 col-sm-offset-3 col-sm-6 col-xs-offset-3 col-xs-6">
                            <button id="cancel-btn" type="button" class="btn btn-default btn-submit-else">取消</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</section>
<section class="bottomstyle">
    <div class="container-fluid">
        <div class="row">
            <div class="col-xs-offset-3 col-xs-6">
                <img class="center-block img-responsive" src="bootstrap/images/logo.png">
            </div>
        </div>
    </div>
</section>
<div id="popModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header text-center">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>

            </div>
            <div class="modal-body">
                <img class="modal-icon" src="bootstrap/images/icon-suc.png"></img>
                <span class="out-of-time text-center">注册成功</span>
                <span class="out-of-time text-center">请等待短信通知...</span>
            </div>
            <div class="modal-footer">

            </div>
        </div>
    </div>
</div>
<script src="bootstrap/js/jquery-1.11.1.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
<script src="bootstrap/js/bootstrapValidator.min.js"></script>
<!-- <script src="../js/bootstrap-datetimepicker.js"></script> -->
<!-- <script src="../js/locales/bootstrap-datetimepicker.zh-CN.js"></script> -->
<script>
    $(window).load(function () {
        $('.status').fadeOut();
        $('.preloader').delay(300).fadeOut('slow');
    });
    $(document).ready(function () {
        // $('.form_datetime').datetimepicker({
        //   weekStart: 1,
        //   autoclose: true,
        //   minView: 2,
        //   todayBtn: true,
        //   todayHighlight: true,
        //   language: "zh-CN",
        //   pickerPosition: "top-left"
        // });
        /**
         * 获取input中时间（有效时间输入）
         */
        // var expiryDate = $("#dtp_input1").val();
        // console.log(expiryDate);
// -------------------------------------------------------------------------------------------
        /**
         * 调用弹框
         */
        // $('#popModal').modal("show");
        /**
         * 手机页面从登录页面和申请页面切换的时候需要更新
         */


        // document.body.style.backgroundImage = "url('../images/bj00.jpg')";

        //页面切换
        $("#visitor-btn").click(function () {
            $('#intro').hide();
            if (/Android|webOS|iPhone|iPod|BlackBerry/i.test(navigator.userAgent)) {
                document.body.style.backgroundImage = "url('bootstrap/images/bj00.jpg')";
            }
            $('#register').show();
        });

        $("#cancel-btn").click(function () {
            // $('#intro').show();
            // document.body.style.backgroundImage = "url('bootstrap/images/bg.png')";
            // $('#register').hide();
            window.location.href = '/wifi';
            // window.location.href = 'http://172.18.81.246:80/wifi';
        });
        // $('#intro').hide();
        // $('#register').show();
    });

    //
    //根据工号获取名字
    // function getName() {
    //     var account = $("#account").val();
    //     $.ajax({
    //         type: 'Get',
    //         url: "/approve/findByAccount",
    //         data: {account: account},
    //         dataType: "json",
    //         success: function (result) {
    //             console.log(result);
    //             var name = result["name"];
    //             $("#name").val(name);
    //         }
    //     });
    // }
    //验证码
    $("#code-btn").click(function () {
        var that = $(this);
        var phoneNumber = $("#phoneNumber").val();
        if (phoneNumber == "" || phoneNumber == null) {
            alert("手机号码不能为空！");
            return;
        }
        var reg = /^([0-9]{11})?$/;      //  \D代表非数字
        if (reg.test(phoneNumber)) {
            //防止恶意点击，三分钟之后才能再次点击
            var timeo = 180;
            var timeStop = setInterval(function () {
                timeo--;
                if (timeo > 0) {
                    that.text('重新发送' + timeo + 's');
                    that.attr('disabled', 'disabled');//禁止点击
                } else {
                    timeo = 180;//当减到0时赋值为90
                    that.text('获取验证码');
                    clearInterval(timeStop);//清除定时器
                    that.removeAttr('disabled');//移除属性，可点击
                }
            }, 1000)
            //后台发送验证码
            $.ajax({
                type: 'Get',
                url: "http://172.18.81.246:80/api/code",
                data: {phoneNumber: phoneNumber},
                dataType: "json",
                success: function (result) {
                    console.log(result);
                    alert(result["information"]);
                }
            });
        } else {
            alert('手机号码格式有误！');
        }
    });
    //登录验证
    $(document).ready(function () {
        $("#form-login").bootstrapValidator({
            live: 'enabled',//验证时机，enabled是内容有变化就验证（默认），disabled和submitted是提交再验证
            feedbackIcons: {//根据验证结果显示的各种图标
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: {
                userName: {
                    validators: {
                        notEmpty: {
                            message: '请输入用户名'
                        }
                    }
                },
                password: {
                    validators: {
                        notEmpty: {//检测非空,radio也可用
                            message: '请输入密码'
                        }
                    }
                }
            }
        });
        //登录
        $("#login-btn").click(function () {//非submit按钮点击后进行验证，如果是submit则无需此句直接验证
            $("#form-login").bootstrapValidator('validate');
            if ($("#form-login").data('bootstrapValidator').isValid()) {//获取验证结果，如果成功，执行下面代码
                $.ajax({
                    type: 'POST',
                    // url: "http://localhost:80/api/login",
                    url: "http://172.18.81.246:80/api/login",
                    data: $("#form-login").serialize(),
                    dataType: "json",
                    success: function (result) {
                       console.log(result);
                        // alert("登录成功！")
                        var res = result["status"];
                        if (res == false) {
                            alert(result["information"]);
                        } else {
                            //跳转页面
                            // window.location.href = '/success';
                            window.location.href = 'http://172.18.81.246:80/success';
                        }
                    }
                });

            }
        });
    });

    //注册验证
    $(document).ready(function () {
        $("#form-regist").bootstrapValidator({
            live: 'enabled',//验证时机，enabled是内容有变化就验证（默认），disabled和submitted是提交再验证
            feedbackIcons: {//根据验证结果显示的各种图标
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: {
                realName: {
                    validators: {
                        notEmpty: {//检测非空,radio也可用
                            message: '请输入姓名'
                        },
                        stringLength: {
                            min: 1,
                            max: 10,
                            message: '请输入1到10个字符'
                        },
                        regexp: {
                            regexp: /^[\u4E00-\u9FA5\uf900-\ufa2d·s]{2,20}$/,
                            message: '姓名格式错误 '
                        }
                    }
                },
                phoneNumber: {
                    validators: {
                        notEmpty: {//检测非空,radio也可用
                            message: '请输入手机号码'
                        },
                        regexp: {
                            regexp: /^([0-9]{11})?$/,
                            message: '手机号码格式错误'
                        }
                    }
                },
                code: {
                    validators: {
                        notEmpty: {//检测非空,radio也可用
                            message: '请输入验证码'
                        }
                    }
                },
                idCard: {
                    validators: {
                        notEmpty: {//检测非空,radio也可用
                            message: '请输入身份证'
                        },
                        regexp: {
                            regexp: /^(^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$)|(^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])((\d{4})|\d{3}[Xx])$)$/,
                            message: '身份证格式错误 '
                        }
                    }
                },
                day: {
                    validators: {
                        notEmpty: {//检测非空,radio也可用
                            message: '请输入申请时间'
                        },
                        regexp: {
                            regexp: /^\+?[1-9][0-9]*$/,
                            message: '时间格式错误'
                        },
                        lessThan: {
                            inclusive: true,
                            value: 90,
                            message: '最长申请 90 天！'
                        }
                    }
                },
                account: {
                    validators: {
                        notEmpty: {//检测非空,radio也可用
                            message: '请输入受理人工号'
                        },
                        regexp: {
                            regexp: /(^SCALG\d{4}$)|(^[0-9]{6}$)/,
                            message: '受理人工号格式错误'
                        }
                    }
                },
                name: {
                    validators: {
                        notEmpty: {//检测非空,radio也可用
                            message: '请输入受理人姓名'
                        },
                        regexp: {
                            regexp: /^[\u4E00-\u9FA5\uf900-\ufa2d·s]{2,20}$/,
                            message: '受理人姓名格式错误'
                        }
                    }
                },
                reason: {
                    validators: {
                        notEmpty: {//检测非空,radio也可用
                            message: '请输入申请理由'
                        },
                        stringLength: {//检测长度
                            min: 5,
                            max: 40,
                            message: '申请理由5-40字'
                        }
                    }
                }
            }
        });
        //注册
        $("#submitBtn").click(function () {//非submit按钮点击后进行验证，如果是submit则无需此句直接验证
            $("#form-regist").bootstrapValidator('validate');
            if ($("#form-regist").data('bootstrapValidator').isValid()) {//获取验证结果，如果成功，执行下面代码
                $.ajax({
                    type: 'POST',
                    url: "http://172.18.81.246:80/api/regist",
                    data: $("#form-regist").serialize(),
                    dataType: "json",
                    success: function (result) {
                        console.log(result["status"]);
                        var res = result["status"];
                        if (res == false) {
                            alert(result["information"]);
                        } else {
                            $('#popModal').modal("show");
                        }
                    }
                });

            }
        });
    });

</script>
</body>

</html>