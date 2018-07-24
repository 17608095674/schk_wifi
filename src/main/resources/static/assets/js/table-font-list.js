$(function(){
      window.onload=function(){
          //加载初始化数据
          loadInit1();
         // console.log("222");
      };
      //加载初始化数据
      function loadInit1(){
        //在这里写你要加载的数据（可以采用jquery的ajax调用，异步、同步均可以）
        var pageNumber = $("#pageNumber").val();
        var userName = $("#userName").val();
        var totalPage = $("#totalPage").val();
        var tbody = window.document.getElementById("tbody"); 
        $.ajax({
            type: 'Get', // 获取头信息，type=HEAD即可
            url : "/users/page",
            data: {pageNumber:pageNumber,userName:userName},
            dataType:"json",
            success: function(result) {
                console.log(result) ;
                totalPage = result["totalPage"];
                pageNumber = result["pageNumber"];
                //console.log(pageNumber);
                $("#pageNumber").html(pageNumber);
                $("#totalPage").html(totalPage);
                $("#userName").val("");
                var str = "";
                var rows = result["rows"];
                for (i in rows) {  
                    str += "<tr>" + 
                    "<td><span>" + (parseInt(i)+1) + "</span></td>" +
                    "<td>" + rows[i].userName + "</td>" +  
                    "<td>" + rows[i].realName + "</td>" + 
                    "<td>" + rows[i].idCard + "</td>" +
                    "<td>" + rows[i].area + "</td>" +  
                    "<td>" + (new Date(rows[i].loginTime)).Format('yyyy-MM-dd hh:mm:ss') + "</td>" +  
                    "<td>" + (new Date(rows[i].overTime)).Format('yyyy-MM-dd hh:mm:ss') + "</td>" +                                       
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
        var userName = $("#userName").val();
        var totalPage = $("#totalPage").val();
        var tbody = window.document.getElementById("tbody"); 
        $.ajax({
            type: 'Get', // 获取头信息，type=HEAD即可
            url : "/users/page",
            data: {pageNumber:pageNumber,userName:userName},
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
                    str += "<tr>" + 
                    "<td><span>" + (parseInt(i)+1) + "</span></td>" +
                    "<td>" + rows[i].userName + "</td>" +  
                    "<td>" + rows[i].realName + "</td>" + 
                    "<td>" + rows[i].idCard + "</td>" +
                    "<td>" + rows[i].area + "</td>" +  
                    "<td>" + (new Date(rows[i].loginTime)).Format('yyyy-MM-dd hh:mm:ss') + "</td>" +  
                    "<td>" + (new Date(rows[i].overTime)).Format('yyyy-MM-dd hh:mm:ss') + "</td>" +                                       
                    "</tr>";  
                } 
                tbody.innerHTML = str;
            }
        });  	      
  	});
  	/* 向上翻页*/
  	$("#up").click(function(){
  		var pageNumber = $("#pageNumber")[0]["textContent"];
        var userName = $("#userName").val();
        var tbody = window.document.getElementById("tbody"); 
        $.ajax({
            type: 'Get', // 获取头信息，type=HEAD即可
            url : "/users/page",
            data: {pageNumber:pageNumber-1,userName:userName},
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
                    str += "<tr>" + 
                    "<td><span>" + (parseInt(i)+1) + "</span></td>" +
                    "<td>" + rows[i].userName + "</td>" +  
                    "<td>" + rows[i].realName + "</td>" + 
                    "<td>" + rows[i].idCard + "</td>" +
                    "<td>" + rows[i].area + "</td>" +  
                    "<td>" + (new Date(rows[i].loginTime)).Format('yyyy-MM-dd hh:mm:ss') + "</td>" +  
                    "<td>" + (new Date(rows[i].overTime)).Format('yyyy-MM-dd hh:mm:ss') + "</td>" +                                       
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
        var userName = $("#userName").val();
        var tbody = window.document.getElementById("tbody"); 
        $.ajax({
            type: 'Get', // 获取头信息，type=HEAD即可
            url : "/users/page",
            data: {pageNumber:pageNumber,userName:userName},
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
                    str += "<tr>" + 
                    "<td><span>" + (parseInt(i)+1) + "</span></td>" +
                    "<td>" + rows[i].userName + "</td>" +  
                    "<td>" + rows[i].realName + "</td>" + 
                    "<td>" + rows[i].idCard + "</td>" +
                    "<td>" + rows[i].area + "</td>" +  
                    "<td>" + (new Date(rows[i].loginTime)).Format('yyyy-MM-dd hh:mm:ss') + "</td>" +  
                    "<td>" + (new Date(rows[i].overTime)).Format('yyyy-MM-dd hh:mm:ss') + "</td>" +                                       
                    "</tr>";  
                } 
                tbody.innerHTML = str;
            }
        });
  	});
  	
  	/* 第一页*/
  	$("#first").click(function(){ 
        var tbody = window.document.getElementById("tbody"); 
        $.ajax({
            type: 'Get', // 获取头信息，type=HEAD即可
            url : "/users/page",
            data: {pageNumber:1},
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
                    str += "<tr>" + 
                    "<td><span>" + (parseInt(i)+1) + "</span></td>" +
                    "<td>" + rows[i].userName + "</td>" +  
                    "<td>" + rows[i].realName + "</td>" + 
                    "<td>" + rows[i].idCard + "</td>" +
                    "<td>" + rows[i].area + "</td>" +  
                    "<td>" + (new Date(rows[i].loginTime)).Format('yyyy-MM-dd hh:mm:ss') + "</td>" +  
                    "<td>" + (new Date(rows[i].overTime)).Format('yyyy-MM-dd hh:mm:ss') + "</td>" +                                       
                    "</tr>";  
                } 
                tbody.innerHTML = str;
            }
        });
  	});
  	
  	
  	/* 尾页*/
  	$("#last").click(function(){		
  		var totalPage = $("#totalPage")[0]["textContent"];  		
        var tbody = window.document.getElementById("tbody"); 
        $.ajax({
            type: 'Get', // 获取头信息，type=HEAD即可
            url : "/users/page",
            data: {pageNumber:totalPage},
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
                    str += "<tr>" + 
                    "<td><span>" + (parseInt(i)+1) + "</span></td>" +
                    "<td>" + rows[i].userName + "</td>" +  
                    "<td>" + rows[i].realName + "</td>" + 
                    "<td>" + rows[i].idCard + "</td>" +
                    "<td>" + rows[i].area + "</td>" +  
                    "<td>" + (new Date(rows[i].loginTime)).Format('yyyy-MM-dd hh:mm:ss') + "</td>" +  
                    "<td>" + (new Date(rows[i].overTime)).Format('yyyy-MM-dd hh:mm:ss') + "</td>" +                                       
                    "</tr>";  
                } 
                tbody.innerHTML = str;
            }
        });
  	});
  
});