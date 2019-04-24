var pathName = "";
$(function () {
    pathName = window.location.pathname;
    for (var i = 0; i < $("#nav li a").length; i++) {
        if (pathName.indexOf($("#nav li a")[i].pathname) > -1 && $("#nav li a")[i].pathname!="/") {
            $($("#nav li")[i]).addClass("on");
            break;
        }
        if(pathName=="/")
        {
            $($("#nav li")[0]).addClass("on");
        }
    }
});