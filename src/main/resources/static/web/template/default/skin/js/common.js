$(function () {
    var pathName = window.location.pathname;
    for (var i = 0; i < $("#nav li a").length; i++) {
        if ($("#nav li a")[i].pathname == pathName) {
            $($("#nav li")[i]).addClass("on")
            break;
        }
    }
});