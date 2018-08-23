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
<script type="text/javascript">
    /* 删除*/
    function remove(id) {
        var con = confirm("确定删除？");
        if (con == true) {
            $.ajax({
                type: 'POST',
                url: "/employee/delete",
                data: {id: id, _method: 'DELETE'},
                dataType: "json",
                success: function (result) {
                    console.log(result);
                }
            });
            alert("删除成功!");
        }
    };

    /* 编辑 */
    function update(id) {
        var tr = $('#' + id).parent().parent().parent().parent();
        var td = tr.children("td");
        var account = td[1]["textContent"];
        var name = td[2]["textContent"];
        $('#edit-account').val(account);
        $('#edit-name').val(name);
        var id = id;
        $('#my-edit').modal({
            onConfirm: function (e) {
                console.log(id);
                var a = $('#edit-account').val();
                var b = $('#edit-name').val();
                if (b == "" || b == null) {
                    alert("姓名不能为空！");
                    return;
                }
                var c = $('#edit-department').val();
                var d = $("#edit-level").val();
                console.log(d);
                $.ajax({
                    type: 'PUT',
                    url: "/employee/update",
                    data: {id: id, account: a, name: b, department: c, level: d},
                    dataType: "json",
                    success: function (result) {
                        console.log(result);
                        alert(result["information"]);
                        location.reload(true);
                    }
                });
            },
            onCancel: function (e) {
                console.log("close");
            }
        });

    };

    /* 添加 */
    $(function () {
        $('#doc-prompt-toggle').on('click', function () {
            $('#my-prompt').modal({
                onConfirm: function (e) {
                    var account = $("#input-account").val();
                    var name = $("#input-name").val();
                    var department = $("#input-department").val();
                    var level = $("#select-level").val();
                    var patt1 = /^[\u4E00-\u9FA5\uf900-\ufa2d·s]{2,20}$/;
                    var patt2 = /(^SCALG\d{4}$)|(^[0-9]{6}$)/;
                    if (account == "" || account == null) {
                        alert("帐号不能为空！");
                        return;
                    }
                    if (!patt2.test(account)) {
                        alert("帐号格式错误！");
                        return;
                    }
                    if (name == "" || name == null) {
                        alert("姓名不能为空！");
                        return;
                    }
                    if (!patt1.test(name)) {
                        alert("姓名格式错误！");
                        return;
                    }
                    console.log(account);
                    $.ajax({
                        type: 'Post',
                        url: "/employee/add",
                        data: {account: account, name: name, department: department, level: level},
                        dataType: "json",
                        success: function (result) {
                            console.log(result);
                            $("#input-account").val("");
                            $("#input-name").val("");
                            alert(result["information"]);
                            location.reload(true);
                        }
                    });
                },
                onCancel: function (e) {
                    console.log("close");
                }
            });
        });
    });

</script>
<body data-type="generalComponents">


<header class="am-topbar am-topbar-inverse admin-header">
    <div class="am-topbar-brand">
        <a href="javascript:;" class="tpl-logo">
            <img src="assets/img/logo.png" alt="">
        </a>
    </div>
    <div class="am-icon-list tpl-header-nav-hover-ico am-fl am-margin-right">

    </div>

    <button class="am-topbar-btn am-topbar-toggle am-btn am-btn-sm am-btn-success am-show-sm-only"
            data-am-collapse="{target: '#topbar-collapse'}"><span class="am-sr-only">导航切换</span> <span
            class="am-icon-bars"></span></button>
    <div class="am-collapse am-topbar-collapse" id="topbar-collapse">
        <ul class="am-nav am-nav-pills am-topbar-nav am-topbar-right admin-header-list tpl-header-list">
            <li class="am-dropdown" data-am-dropdown data-am-dropdown-toggle>
                <ul class="am-dropdown-content tpl-dropdown-content">
                </ul>
            </li>
            <li class="am-dropdown" data-am-dropdown data-am-dropdown-toggle>
                <ul class="am-dropdown-content tpl-dropdown-content">
                    </li>
                </ul>
            </li>
            <li class="am-hide-sm-only"><a href="javascript:;" id="admin-fullscreen" class="tpl-header-list-link"><span
                    class="am-icon-arrows-alt"></span> <span class="admin-fullText">开启全屏</span></a></li>

        </ul>
    </div>
</header>


<div class="tpl-page-container tpl-page-header-fixed">


    <div class="tpl-left-nav tpl-left-nav-hover">
        <div class="tpl-left-nav-title">
            功能列表
        </div>
        <div class="tpl-left-nav-list">
            <ul class="tpl-left-nav-menu">
                <li class="tpl-left-nav-item">
                    <a href="/index" class="nav-link">
                        <i class="am-icon-home"></i>
                        <span>首页</span>
                    </a>
                </li>

                <li class="tpl-left-nav-item">
                    <!-- 打开状态 a 标签添加 active 即可   -->
                    <a href="javascript:;" class="nav-link tpl-left-nav-link-list">
                        <i class="am-icon-table"></i>
                        <span>表格</span>
                        <!-- 列表打开状态的i标签添加 tpl-left-nav-more-ico-rotate 图表即90°旋转  -->
                        <i class="am-icon-angle-right tpl-left-nav-more-ico am-fr am-margin-right tpl-left-nav-more-ico-rotate"></i>
                    </a>
                    <ul class="tpl-left-nav-sub-menu" style="display:block">
                        <li>
                            <!-- 打开状态 a 标签添加 active 即可   -->
                            <a href="/list1">
                                <i class="am-icon-angle-right"></i>
                                <span>访客信息</span>
                                <i class="am-icon-star tpl-left-nav-content-ico am-fr am-margin-right"></i>
                            </a>
                            <a href="/list2">
                                <i class="am-icon-angle-right"></i>
                                <span>审批信息维护</span>
                                <i class="am-icon-star tpl-left-nav-content-ico am-fr am-margin-right"></i>
                            </a>

                        </li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>


    <div class="tpl-content-wrapper">
        <div class="tpl-portlet-components">
            <div class="portlet-title">
                <div class="caption font-green bold">
                    <span class="am-icon-code"></span> 审批人员列表
                </div>
                <div class="tpl-portlet-input tpl-fz-ml">
                    <div class="portlet-input input-small input-inline">
                        <div class="am-input-group am-input-group-sm">
                            <input type="text" class="am-form-field" id="name">
                            <span class="am-input-group-btn">
            <button class="am-btn  am-btn-default am-btn-success tpl-am-btn-success am-icon-search" type="button"
                    id="search"></button>
          </span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="tpl-block">
                <div class="am-g">
                    <div class="am-u-sm-12 am-u-md-6">
                        <div class="am-btn-toolbar">
                            <div class="am-btn-group am-btn-group-xs">
                                <button id="doc-prompt-toggle" type="button"
                                        class="am-btn am-btn-default am-btn-success"><span class="am-icon-plus"></span>
                                    新增
                                </button>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="am-modal am-modal-prompt" tabindex="-1" id="my-prompt">
                    <div class="am-modal-dialog" style="width: 380px;border-radius: 5px;">
                        <div class="am-modal-hd am-active">添加审批人员</div>
                        <hr data-am-widget="divider" style="" class="am-divider am-divider-default"/>
                        <div class="am-modal-bd">
                            <table>
                                <tr>
                                    <td><span
                                            style="font-family: 微软雅黑;font-size: 15px;color:#808080;height: 40px;line-height: 40px;margin-left: 55px;">工 号 ：</span>
                                    </td>
                                    <td><input class="am-form-field" type="text" id="input-account"/></td>
                                </tr>
                                <tr>
                                    <td><span
                                            style="font-family: 微软雅黑;font-size: 15px;color:#808080;height: 40px;line-height: 40px;margin-left: 55px;">姓 名 ：</span>
                                    </td>
                                    <td><input class="am-form-field" type="text" id="input-name"/></td>
                                </tr>
                                <tr>
                                    <td><span
                                            style="font-family: 微软雅黑;font-size: 15px;color:#808080;height: 40px;line-height: 40px;margin-left: 55px;">部 门 ：</span>
                                    </td>
                                    <td><input class="am-form-field" type="text" id="input-department" value="信息服务部"
                                               readonly="readonly"/></td>
                                </tr>
                                <tr>
                                    <td><span
                                            style="font-family: 微软雅黑;font-size: 15px;color:#808080;height: 40px;line-height: 40px;margin-left: 55px;">职 级 ：</span>
                                    </td>
                                    <td>
                                        <select id="select-level" data-am-selected="{btnSize: 'sm'}">
                                            <option value="1">业务受理人</option>
                                            <option value="2">网络审核人员</option>
                                            <option value="3">机房网络室领导</option>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <td>&nbsp;</td>
                                </tr>
                            </table>

                        </div>
                        <div class="am-modal-footer">
                            <span class="am-modal-btn" data-am-modal-cancel>取消</span>
                            <span class="am-modal-btn" data-am-modal-confirm>提交</span>
                        </div>
                    </div>
                </div>


                <div class="am-modal am-modal-prompt" tabindex="-1" id="my-edit">
                    <div class="am-modal-dialog" style="width: 380px;border-radius: 5px;">
                        <div class="am-modal-hd am-active">修改审批人员</div>
                        <hr data-am-widget="divider" style="" class="am-divider am-divider-default"/>
                        <div class="am-modal-bd">
                            <table>
                                <tr>
                                    <td><span
                                            style="font-family: 微软雅黑;font-size: 15px;color:#808080;height: 40px;line-height: 40px;margin-left: 55px;">工 号 ：</span>
                                    </td>
                                    <td><input class="am-form-field" type="text" id="edit-account" readonly="readonly"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td><span
                                            style="font-family: 微软雅黑;font-size: 15px;color:#808080;height: 40px;line-height: 40px;margin-left: 55px;">姓 名 ：</span>
                                    </td>
                                    <td><input class="am-form-field" type="text" id="edit-name"/></td>
                                </tr>
                                <tr>
                                    <td><span
                                            style="font-family: 微软雅黑;font-size: 15px;color:#808080;height: 40px;line-height: 40px;margin-left: 55px;">部 门 ：</span>
                                    </td>
                                    <td><input class="am-form-field" type="text" id="edit-department" value="信息服务部"
                                               readonly="readonly"/></td>
                                </tr>
                                <tr>
                                    <td><span
                                            style="font-family: 微软雅黑;font-size: 15px;color:#808080;height: 40px;line-height: 40px;margin-left: 55px;">职 级 ：</span>
                                    </td>
                                    <td>
                                        <select id="edit-level" data-am-selected="{btnSize: 'sm'}">
                                            <option value="1">业务受理人</option>
                                            <option value="2">网络审核人员</option>
                                            <option value="3">机房网络室领导</option>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <td>&nbsp;</td>
                                </tr>
                            </table>

                        </div>
                        <div class="am-modal-footer">
                            <span class="am-modal-btn" data-am-modal-cancel>取消</span>
                            <span class="am-modal-btn" data-am-modal-confirm>提交</span>
                        </div>
                    </div>
                </div>

                <div class="am-g">
                    <div class="am-u-sm-12">
                        <form class="am-form">
                            <table class="am-table am-table-striped am-table-hover table-main">
                                <thead>
                                <tr>
                                    <th class="table-check"></th>
                                    <th class="table-type">工号</th>
                                    <th class="table-type">姓名</th>
                                    <th class="table-type">部门</th>
                                    <th class="table-type">职级</th>
                                    <th class="table-type">创建时间</th>
                                    <th class="table-type">操作</th>
                                </tr>
                                </thead>
                                <tbody id="tbody">
                                </tbody>
                            </table>
                            <div class="am-cf">

                                <div class="am-fr">
                                    <ul class="am-pagination tpl-pagination">
                                        <!-- <li class="am-disabled"><a href="#">«</a></li> -->
                                        <!--   <li class="am-active"><a href="#">1</a></li> -->
                                        <li><a id="up"><</a></li>
                                        <li><a href="#">第<span id="pageNumber"></span>页/共<span
                                                id="totalPage"></span>页</a></li>
                                        <li><a id="down">></a></li>
                                    </ul>
                                </div>
                            </div>
                            <hr>

                        </form>
                    </div>

                </div>
            </div>
            <div class="tpl-alert"></div>
        </div>

    </div>
</div>
<script src="assets/js/amazeui.min.js"></script>
<script src="assets/js/app.js"></script>
<script type="text/javascript" src="assets/js/table-font-list1.js"></script>
</body>

</html>