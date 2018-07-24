$(function(){
      window.onload=function(){
          //加载初始化数据
          loadInit1();
      };
      //加载初始化数据
      function loadInit1(){
        //在这里写你要加载的数据（可以采用jquery的ajax调用，异步、同步均可以）
        var pageNumber = $("#pageNumber").val();
        var name = $("#name").val();
        var totalPage = $("#totalPage").val();
        var tbody = window.document.getElementById("tbody"); 
        $.ajax({
            type: 'Get', // 获取头信息，type=HEAD即可
            url : "/employee/page",
            data: {pageNumber:pageNumber,name:name},
            dataType:"json",
            success: function(result) {
                console.log(result) ;
                totalPage = result["totalPage"];
                pageNumber = result["pageNumber"];
                //console.log(pageNumber);
                $("#pageNumber").html(pageNumber);
                $("#totalPage").html(totalPage);
                $("#name").val("");
                var str = "";
                var rows = result["rows"];
                for (i in rows) { 
                	var level = rows[i].level;
                	if("1"==level){
                		level = "业务受理人";
                	}
                	if("2"==level){
                		level = "网络审核人员";
                	}
                	if("3"==level){
                		level = "机房网络室领导";
                	}
                	if("4"==level){
                		level = "信息服务部经理";
                	}
                	
                    str += "<tr>" + 
                    "<td><span>" + (parseInt(i)+1) + "</span></td>" +
                    "<td>" + rows[i].account+ "</td>" +  
                    "<td>" + rows[i].name + "</td>" +  
                    "<td>" + rows[i].department + "</td>" +  
                    "<td>" + level + "</td>" +  
                    "<td>" + (new Date(rows[i].createTime)).Format('yyyy-MM-dd hh:mm:ss')+ "</td>" +
                    "<td> <div class='am-btn-toolbar'>"+
                    "<div class='am-btn-group am-btn-group-xs'>"+
                    "<button type='button' class='am-btn am-btn-default am-btn-xs am-text-secondary' id='"+rows[i].id+"' onclick='update("+rows[i].id+")'>" +
                    "<span class='am-icon-pencil-square-o'></span> 编辑</button>"+
                    "<button class='am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only' onclick='remove("+rows[i].id+")'>" +
                    "<span class='am-icon-trash-o'></span>  删除</button>"+
                    "</div></div></td>" +
                    "</tr>";  
                } 
                tbody.innerHTML = str;
            }
        });
      }
      
   // 对Date的扩展，将 Date 转化为指定格式的String
    	// 月(M)、日(d)、小时(h)、分(m)、秒(s)、季度(q) 可以用 1-2 个占位符，
    	// 年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字)
    	// 例子：
    	// (new Date()).Format ("yyyy-MM-dd hh:mm:ss.S") ==> 2006-07-02 08:09:04.423
    	// (new Date()).Format ("yyyy-M-d h:m:s.S") ==> 2006-7-2 8:9:4.18
    	Date.prototype.Format  = function (fmt) { // author: meizz
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
    	
    	/* 模糊查询 */
      	$("#search").click(function(){
      		var pageNumber = $("#pageNumber").val();
            var name = $("#name").val();
            console.log(name);
            var totalPage = $("#totalPage").val();
            var tbody = window.document.getElementById("tbody"); 
            $.ajax({
                type: 'Get', // 获取头信息，type=HEAD即可
                url : "/employee/page",
                data: {pageNumber:pageNumber,name:name},
                dataType:"json",
                success: function(result) {
                    console.log(result) ;
                    totalPage = result["totalPage"];
                    pageNumber = result["pageNumber"];
                    //console.log(pageNumber);
                    $("#pageNumber").html(pageNumber);
                    $("#totalPage").html(totalPage);
                    var str = "";
                    var rows = result["rows"];
                    for (i in rows) { 
                    	var level = rows[i].level;
                    	if("1"==level){
                    		level = "业务受理人";
                    	}
                    	if("2"==level){
                    		level = "网络审核人员";
                    	}
                    	if("3"==level){
                    		level = "机房网络室领导";
                    	}
                    	if("4"==level){
                    		level = "信息服务部经理";
                    	}
                    	
                        str += "<tr>" + 
                        "<td><span>" + (parseInt(i)+1) + "</span></td>" +
                        "<td>" + rows[i].account+ "</td>" +  
                        "<td>" + rows[i].name + "</td>" +  
                        "<td>" + rows[i].department + "</td>" +  
                        "<td>" + level + "</td>" +  
                        "<td>" + (new Date(rows[i].createTime)).Format('yyyy-MM-dd hh:mm:ss')+ "</td>" +
                        "<td> <div class='am-btn-toolbar'>"+
                        "<div class='am-btn-group am-btn-group-xs'>"+
                        "<button type='button' class='am-btn am-btn-default am-btn-xs am-text-secondary' id='"+rows[i].id+"' onclick='update("+rows[i].id+")'>" +
                        "<span class='am-icon-pencil-square-o'></span> 编辑</button>"+
                        "<button class='am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only' onclick='remove("+rows[i].id+")'>" +
                        "<span class='am-icon-trash-o'></span>  删除</button>"+
                        "</div></div></td>" +
                        "</tr>";  
                    } 
                    tbody.innerHTML = str;
                }
            });
      	});
  	/* 向上翻页*/
  	$("#up").click(function(){
  		var name = $("#name").val();
  		var pageNumber = $("#pageNumber")[0]["textContent"];
        var tbody = window.document.getElementById("tbody"); 
        $.ajax({
            type: 'Get', // 获取头信息，type=HEAD即可
            url : "/employee/page",
            data: {pageNumber:pageNumber-1,name:name},
            dataType:"json",
            success: function(result) {
                console.log(result) ;
                totalPage = result["totalPage"];
                pageNumber = result["pageNumber"];
                //console.log(pageNumber);
                $("#pageNumber").html(pageNumber);
                $("#totalPage").html(totalPage);
                var str = "";
                var rows = result["rows"];
                for (i in rows) { 
                	var level = rows[i].level;
                	if("1"==level){
                		level = "业务受理人";
                	}
                	if("2"==level){
                		level = "网络审核人员";
                	}
                	if("3"==level){
                		level = "机房网络室领导";
                	}
                	if("4"==level){
                		level = "信息服务部经理";
                	}
                	
                    str += "<tr>" + 
                    "<td><span>" + (parseInt(i)+1) + "</span></td>" +
                    "<td>" + rows[i].account+ "</td>" +  
                    "<td>" + rows[i].name + "</td>" +  
                    "<td>" + rows[i].department + "</td>" +  
                    "<td>" + level + "</td>" +  
                    "<td>" + (new Date(rows[i].createTime)).Format('yyyy-MM-dd hh:mm:ss')+ "</td>" +
                    "<td> <div class='am-btn-toolbar'>"+
                    "<div class='am-btn-group am-btn-group-xs'>"+
                    "<button class='am-btn am-btn-default am-btn-xs am-text-secondary' onclick='modify("+rows[i].id+")'>" +
                    "<span class='am-icon-pencil-square-o'></span> 编辑</button>"+
                    "<button class='am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only' onclick='remove("+rows[i].id+")'>" +
                    "<span class='am-icon-trash-o'></span>  删除</button>"+
                    "</div></div></td>" +
                    "</tr>";  
                }
                tbody.innerHTML = str;
            }
        });
  	});
  	
  	/* 向下翻页*/
  	$("#down").click(function(){
  		var pageNumber = $("#pageNumber")[0]["textContent"];
  		console.log(pageNumber);
  		var totalPage = $("#totalPage")[0]["textContent"];
  		console.log(totalPage);
  		pageNumber = (parseInt(pageNumber)+1)>totalPage ? parseInt(totalPage) : (parseInt(pageNumber)+1);
  		console.log(pageNumber);
  		var name = $("#name").val();
        var tbody = window.document.getElementById("tbody"); 
        $.ajax({
            type: 'Get', // 获取头信息，type=HEAD即可
            url : "/employee/page",
            data: {pageNumber:pageNumber,name:name},
            dataType:"json",
            success: function(result) {
                console.log(result) ;
                totalPage = result["totalPage"];
                pageNumber = result["pageNumber"];
                //console.log(pageNumber);
                $("#pageNumber").html(pageNumber);
                $("#totalPage").html(totalPage);
                var str = "";
                var rows = result["rows"];
                for (i in rows) { 
                	var level = rows[i].level;
                	if("1"==level){
                		level = "业务受理人";
                	}
                	if("2"==level){
                		level = "网络审核人员";
                	}
                	if("3"==level){
                		level = "机房网络室领导";
                	}
                	if("4"==level){
                		level = "信息服务部经理";
                	}
                	
                    str += "<tr>" + 
                    "<td><span>" + (parseInt(i)+1) + "</span></td>" +
                    "<td>" + rows[i].account+ "</td>" +  
                    "<td>" + rows[i].name + "</td>" +  
                    "<td>" + rows[i].department + "</td>" +  
                    "<td>" + level + "</td>" +  
                    "<td>" + (new Date(rows[i].createTime)).Format('yyyy-MM-dd hh:mm:ss')+ "</td>" +
                    "<td> <div class='am-btn-toolbar'>"+
                    "<div class='am-btn-group am-btn-group-xs'>"+
                    "<button class='am-btn am-btn-default am-btn-xs am-text-secondary' onclick='modify("+rows[i].id+")'>" +
                    "<span class='am-icon-pencil-square-o'></span> 编辑</button>"+
                    "<button class='am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only' onclick='remove("+rows[i].id+")'>" +
                    "<span class='am-icon-trash-o'></span>  删除</button>"+
                    "</div></div></td>" +
                    "</tr>";  
                } 
                tbody.innerHTML = str;
            }
        });
  	});
  	
});