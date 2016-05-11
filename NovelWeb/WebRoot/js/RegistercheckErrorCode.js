/**
 * Created by zhangyi on 2016/3/11.
 */
$(document).ready(function(){
// 访问该页面时,查看code为几
    $("#message").hide();
    $("#message2").hide();
    var errorCode=getUrlParam('code');
   if(1==errorCode){
        $("#message").text("   用户名已存在！");
       $("#message").show();
       return;
    }
   if(2==errorCode){
       $("#message2").text("   两次输入密码不同！");
      $("#message2").show();
      return;
   }
   if(4==errorCode){
       $("#message").text("   请填完信息！");
      $("#message").show();
      return;
   }
   if(3==errorCode){
       $("#message").text("   服务器内部错误，请稍后重试！");
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