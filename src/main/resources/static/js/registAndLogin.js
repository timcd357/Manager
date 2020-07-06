$('input[required]').before('<span style="color:red">*</span>');

//************登录用js方法****************//
/**
 * 使用ajax进行登录
 */
function loginByAjax() {
    var param = $("#loginForm").serialize();
    $.post("/manager/user/login",param,function (m) {
        console.log(m);
        if(m.code==200){
            window.location.href="/";
        }else {
            // alert(m.msg);
            $("#loginMsg").text(m.msg);
        }

    })
}




//************登录用js方法****************//

//************注册用js方法****************//

/**
 * 使用ajax进行注册
 */
function registerByAjax() {
    var param = $("#registForm").serialize();
    $.post("/manager/user/regist",param,function (m) {
        console.log(m);
        if(m.code==200){
            alert("注册成功")
            window.location.href="/user/login";
        }else {
            // alert(m.msg);
            $("#registMsg").text(m.msg);
        }
    })
}

/**
 * 判断用户名是否已被使用
 */
function isDupUserName() {
    var param = $("[name='userName']").val();
    if(param.trim()==''){
        $("#userNameTip").text("用户名不能为空");
        return;
    }
    $.ajax({
        url:"/manager/user/checkUserName",
        data:"userName="+param,
        method:"post",
        success:function (m) {
            if(m.code==200){
                // alert(m.msg);
                $("#userNameTip").text("");
            }else {
                $("#userNameTip").text(m.msg);
            }
        },
        error:function (e) {
            alert(e.msg);
            $("#userNameTip").text(e.msg);
        }
    })
}

//************注册用js方法****************//