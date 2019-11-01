var openItem=function (obj) {
    if($("body").hasClass("mini-nav")){
        $("body").removeClass("mini-nav");
        init(300);
    }
    if($(obj).hasClass("active")){
        $(obj).removeClass("active");
        $(obj).children("ul").addClass("unactive")
    }else{
        $('.nav-menu .active').children("ul").addClass("unactive")
        $('.nav-menu .active').removeClass("active");
        $(obj).addClass("active");
        $(obj).children("ul").removeClass("unactive")
    }
};
function GetUrlRelativePath()
{
    var url = document.location.toString();
    var arrUrl = url.split("//");

    var start = arrUrl[1].indexOf("/");
    var relUrl = arrUrl[1].substring(start);//stop省略，截取从start开始到结尾的所有字符

    if(relUrl.indexOf("?") != -1){
        relUrl = relUrl.split("?")[0];
    }
    return relUrl;
}
$(function () {
    init(300);
    $(".navbar-minimalize").click(function () {
        if($("body").hasClass("mini-nav")){
            $("body").removeClass("mini-nav");
            init(300);
        }else{
            $("body").addClass("mini-nav");
            init(70);
        }
    })
    var relUrl=GetUrlRelativePath().replace("#","");
    $(".nav-first-leve").find('li').find('a').each(function () {
        var href=$(this).attr('href');
        if(relUrl.indexOf(href)!=-1){
            $(this).parent().addClass("active");
            return;
        }
    })
    $(".nav-second-leve").find('li').find('a').each(function () {
        var href=$(this).attr('href');
        if(relUrl.indexOf(href)!=-1){
            $(this).parent().parent().parent().addClass("active");
            $(this).parent().parent().parent().find('ul').removeClass("unactive");
        }
    })

})

var listener={
    resizeWindow : function () {
    },
    resizeEcharts : function () {

    }
};
window.onresize = function() {
    listener.resizeWindow();
    listener.resizeEcharts();
};
listener.resizeWindow=function () {
    if($("body").hasClass("mini-nav")){
        init(70);
    }else{
        init(300);
    }
}
var init=function (w) {
    var height=document.body.scrollHeight;
    var width=document.body.scrollWidth ;
    $(".layout_content").css({"height":height-60});
    $(".layout_nav").css({"height":height-60});
    $(".container").css({"height":height-60-39});
    $(".layout_content").css({"width":width-w});
}