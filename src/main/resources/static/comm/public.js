var pathName = "";

$(function () {
    $('#fav').click(function () {
        AddFavorite(location.href, '收藏本站');
    });
    pathName = window.location.pathname;
    for (var i = 0; i < $(".nav li a").length; i++) {
        if (pathName.indexOf($(".nav li a")[i].pathname.replace(" ", "")) > -1 && $(".nav li a")[i].pathname.replace(" ", "") != "/" && $(".nav li a")[i].pathname.replace(" ", "") != "/en/") {
            $($(".nav li")[i]).addClass("on");
            break;
        }
        if (pathName == "/") {
            $($(".nav li")[0]).addClass("on");
        } else if (pathName == "/en/") {
            $($(".nav li")[0]).addClass("on");
        }
    }
    //图片滚动
    $(function () {
        $('.silder-box-1').mySilder({
            width: 210, //容器的宽度 必选参数!!!!!!
            height: 200, //容器的高度 必选参数!!!!!!
            auto: true,//是否自动滚动
            autoTime: 5, //自动滚动时，时间间隙，即多长滚动一次,单位(秒)
            direction: 'x',//滚动方向,默认X方向
            autoType: 'left', //滚动方向，auto为true时生效
            few: 1,//一次滚动几个，默认滚动1张
            showFew: 3, //显示几个,就不用调css了,默认显示一个
            clearance: 10, //容器之间的间隙，默认为 0
            silderMode: 'linear',//滚动方式
            timeGap: 350,//动画间隙，完成一次动画需要多长时间，默认700ms
            buttonPre: '.silder-button.btl',//上一个，按钮
            buttonNext: '.silder-button.btr',//下一个，按钮
            jz: true, //点击时，是否等待动画完成
            runEnd: function () {//回调函数
            }
        });
        $('.silder-box-2').mySilder({
            width: 210, //容器的宽度 必选参数!!!!!!
            height: 200, //容器的高度 必选参数!!!!!!
            auto: true,//是否自动滚动
            autoTime: 5, //自动滚动时，时间间隙，即多长滚动一次,单位(秒)
            direction: 'x',//滚动方向,默认X方向
            autoType: 'left', //滚动方向，auto为true时生效
            few: 5,//一次滚动几个，默认滚动1张
            showFew: 5, //显示几个,就不用调css了,默认显示一个
            clearance: 10, //容器之间的间隙，默认为 0
            silderMode: 'linear',//滚动方式
            timeGap: 350,//动画间隙，完成一次动画需要多长时间，默认700ms
            buttonPre: '.silder-button.btl',//上一个，按钮
            buttonNext: '.silder-button.btr',//下一个，按钮
            jz: true, //点击时，是否等待动画完成
            runEnd: function () {//回调函数
            }
        });
        $('.silder-box-3').mySilder({
            width: 210, //容器的宽度 必选参数!!!!!!
            height: 200, //容器的高度 必选参数!!!!!!
            auto: true,//是否自动滚动
            autoTime: 5, //自动滚动时，时间间隙，即多长滚动一次,单位(秒)
            direction: 'x',//滚动方向,默认X方向
            autoType: 'left', //滚动方向，auto为true时生效
            few: 5,//一次滚动几个，默认滚动1张
            showFew: 5, //显示几个,就不用调css了,默认显示一个
            clearance: 10, //容器之间的间隙，默认为 0
            silderMode: 'linear',//滚动方式
            timeGap: 350,//动画间隙，完成一次动画需要多长时间，默认700ms
            buttonPre: '.silder-button.btl',//上一个，按钮
            buttonNext: '.silder-button.btr',//下一个，按钮
            jz: true, //点击时，是否等待动画完成
            runEnd: function () {//回调函数
            }
        });
    });
    $("#li_newTop").click(function () {
        $("#li_newTop").addClass("active");
        $("#li_companyDynamicsList").removeClass("active");
        $("#newTop").show();
        $("#companyDynamicsList").hide();
    });
    $("#li_companyDynamicsList").click(function () {
        $("#li_newTop").removeClass("active");
        $("#li_companyDynamicsList").addClass("active");
        $("#newTop").hide();
        $("#companyDynamicsList").show();
    });
    $("#btnFactory").click(function () {
        $("#btnHonor").removeClass("btnBgColorActive");
        $("#btnHonor").addClass("btnBgColorNormal");
        $("#btnFactory").addClass("btnBgColorActive");
        $("#btnFactory").removeClass("btnBgColorNormal");
        $(".silder-box-3").hide();
        $(".silder-box-2").show();
    });
    $("#btnHonor").click(function () {
        $("#btnHonor").removeClass("btnBgColorNormal");
        $("#btnHonor").addClass("btnBgColorActive");
        $("#btnFactory").addClass("btnBgColorNormal");
        $("#btnFactory").removeClass("btnBgColorActive");
        $(".silder-box-2").hide();
        $(".silder-box-3").show();
    });
    $("#aLanguage").click(function () {
    });
});

//收藏本站代码
function AddFavorite(sURL, sTitle) {
    try {
        //IE
        window.external.addFavorite(sURL, sTitle);
    } catch (e) {
        try {
            //Firefox
            window.sidebar.addPanel(sTitle, sURL, "");
        } catch (e) {
            alert("您的浏览器不支持自动加入收藏，请手动设置！", "提示信息");
        }
    }
}

function showNewsDetail(id) {
    if ($("#newsDetail_" + id).is(':hidden')) {
        $("#newsDetail_" + id).show();
        $("#cimg_" + id + " img").attr("src", "/images/jiantou_03.png");
    } else {
        $("#newsDetail_" + id).hide();
        $("#cimg_" + id + " img").attr("src", "/images/jiantouright_03.png");
    }
}

