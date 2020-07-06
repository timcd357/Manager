$(function () {
    isLogin();
})
/**
 * 确认是否是登录状态,并改变导航栏的状态
 */
function isLogin(){
    var loginToken = $.cookie('login_token');
    // alert(loginToken);
    if(loginToken!=null&&loginToken.length!=0){
        $.ajax({
            url:'/manager/user/getUserByToken',
            data:"token="+loginToken,
            method:'POST',
            success:function (m) {
                m = JSON.parse(m);
                // console.log(m.userName);
                $("#isLogin").replaceWith("<span>欢迎：</span>\n" +
                    "                    <span id=\"userName\">"+m.userName+"</span>");
            },
            error:function (e) {
                alert(e);
                console.log(e);
            }
        })
    }
}