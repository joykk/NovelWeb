/**
 * Created by zhangyi on 2016/3/11.
 */
$(document).ready(function(){
// 访问该页面时,查看code为几
    $("#message").hide();
    var errorCode=getUrlParam('code');
   if(1==errorCode){
        $("#message").text("   请填写用户名和密码。");
       $("#message").show();
       return;
    }
    if(2==errorCode){
        $("#message").text("   您填写的用户名或密码错误。");
        $("#message").show();
        return;
    }
    if(3==errorCode){
        $("#message").text("   你的用户已被停用，请联系管理员。");
        $("#message").show();
        return;
    }
    if(4==errorCode){
        $("#message").text("   你必须登陆才能购买。");
        $("#message").show();
        return;
    }
    if(5==errorCode){
        $("#message").text("   你必须登陆才能查看个人中心。");
        $("#message").show();
        return;
    }
});
//获取url中的参数
function getUrlParam(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
    var r = window.location.search.substr(1).match(reg);  //匹配目标参数
    if (r != null) return unescape(r[2]); return null; //返回参数值
}