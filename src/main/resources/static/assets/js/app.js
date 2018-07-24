$(function() {

        var $fullText = $('.admin-fullText');
        $('#admin-fullscreen').on('click', function() {
            $.AMUI.fullscreen.toggle();
        });

        $(document).on($.AMUI.fullscreen.raw.fullscreenchange, function() {
            $fullText.text($.AMUI.fullscreen.isFullscreen ? '退出全屏' : '开启全屏');
        });


        var dataType = $('body').attr('data-type');
        for (key in pageData) {
            if (key == dataType) {
                pageData[key]();
            }
        }

        $('.tpl-switch').find('.tpl-switch-btn-view').on('click', function() {
            $(this).prev('.tpl-switch-btn').prop("checked", function() {
                    if ($(this).is(':checked')) {
                        return false
                    } else {
                        return true
                    }
                })
                // console.log('123123123')

        })
    })
    // ==========================
    // 侧边导航下拉列表
    // ==========================

$('.tpl-left-nav-link-list').on('click', function() {
        $(this).siblings('.tpl-left-nav-sub-menu').slideToggle(80)
            .end()
            .find('.tpl-left-nav-more-ico').toggleClass('tpl-left-nav-more-ico-rotate');
    })
    // ==========================
    // 头部导航隐藏菜单
    // ==========================

$('.tpl-header-nav-hover-ico').on('click', function() {
    $('.tpl-left-nav').toggle();
    $('.tpl-content-wrapper').toggleClass('tpl-content-wrapper-hover');
})

 window.onload=function(){
		  loadInit();          
      };
      
    //在线数据
      function loadInit(){        
        $.ajax({
            type: 'Get', 
            url : "/h3c/online",
            dataType:"json",
            success: function(data) {
                console.log(data) ;
                $('#one').html(data[1]);
                $('#two').html(data[2]);
                $('#three').html(data[3]);
                $('#four').html(data[4]);
            }
        });
      }
         
// 页面数据
var pageData = {
    // ===============================================
    // 首页
    // ===============================================
    'index': function indexData() {

        var echartsA = echarts.init(document.getElementById('tpl-echarts-A'));
        var option = {

            tooltip: {
                trigger: 'axis',
            },
            legend: {
                data: ['在线用户数']
            },
            grid: {
                left: '3%',
                right: '4%',
                bottom: '3%',
                containLabel: true
            },
            xAxis: [{
                type: 'category',
                boundaryGap: true,
                data: ['第1天', '第2天', '第3天', '第4天', '第5天', '第6天', '第7天']
            }],

            yAxis: [{
                type: 'value'
            }],
            series: [{
                    name: '在线用户数',
                    type: 'line',
                    stack: '总数',
                    areaStyle: { normal: {} },
                    data: [],
                    itemStyle: {
                        normal: {
                            color: '#59aea2'
                        },
                        emphasis: {

                        }
                    }
                }              
            ]
        };
        
        echartsA.setOption(option);
        //在线用户数               
            $.ajax({
                type: 'Get', 
                url : "/h3c/last",
                dataType:"json",
                success: function(result) {
                	data = result;
                	echartsA.setOption({
                		series: [{
                        // 根据名字对应到相应的系列
                        name: '在线用户数',
                        type: 'line',
                        data: [result["1"],result["2"],result["3"],result["4"],result["5"],result["6"],result["7"]],
                		}]
                    });
                }
            });

        

    var myCharts1 = echarts.init(document.getElementById('tpl-echarts-B'));
    var option1 = {
            tooltip: {
                trigger: 'item',
                formatter: "{a} <br/>{b}: {c} ({d}%)"
            },
            legend: {
                orient: 'vertical',
                x: 'left',
                data:['南区','北区']
            },
            series: [
                {
                    name:'热点区域分布',
                    type:'pie',
                    radius: ['40%', '80%'],
                    avoidLabelOverlap: false,
                    label: {
                        normal: {
                            show: false,
                            position: 'center'
                        },
                        emphasis: {
                            show: true,
                            textStyle: {
                                fontSize: '30',
                                fontWeight: 'bold'
                            }
                        }
                    },
                    labelLine: {
                        normal: {
                            show: false
                        }
                    },
                    data:[
                        {value:335, name:'南区'},
                        {value:310, name:'北区'}                       
                    ]
                }
            ]
        };
    myCharts1.setOption(option1);

    }
}