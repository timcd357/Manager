$('input[required]').before('<span style="color:red">*</span>');

var email = /\w+[@]{1}\w+[.]\w+/;
var phone = /^(0[0-9]{2,3}\-)?([2-9][0-9]{6,7})+(\-[0-9]{1,4})?$|(^(13[0-9]|15[0|3|6|7|8|9]|18[8|9])\d{8}$)/;
var psd = /^[0-9a-zA-Z_]{6,15}$/;

function clearClass(){
    $("input").each(function () {
        $(this).next("div").removeClass("invalid-feedback");
        $(this).next("div").removeClass("valid-feedback");
    });
}
//************登录用js方法****************//
/**
 * 使用ajax进行登录
 */
function loginByAjax() {
    var param = $("#loginForm").serialize();
    clearClass();
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
    if(!registVerfi()||$("input[required]").val().trim()==""){
        return false;
    }
    var param = $("#registForm").serialize();
    clearClass();
    $.post("/manager/user/regist",param,function (m) {
        console.log(m);
        if(m.code==200){
            alert("注册成功")
            window.location.href="/login";
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
        regexClass("userName",false);
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
                regexClass("userName",true);
            }else {
                $("#userNameTip").text(m.msg);
                regexClass("userName",false);
            }
        },
        error:function (e) {
            // alert(e.msg);
            $("#userNameTip").text(e.msg);
        }
    })
}
//判断输入是否通过后改变样式
function regexClass(id,bool){
    if(bool){
        $("#"+id).removeClass("is-invalid");
        $("#"+id).addClass("is-valid");
    }else {
        $("#"+id).removeClass("is-valid");
        $("#"+id).addClass("is-invalid");
    }
}

//正则验证
function regex(){
    $("#email").blur(function () {
        verfication("email",email,"邮箱格式不正确，请输入如\"yourname@abc.com\"样式的邮箱地址！")
    })
    $("#phone").blur(function () {
        verfication("phone",phone,"请输入正确的电话号码！")
    })
    $("#password").blur(function () {
        verfication("password",psd,"请输入6至15个任意数字及字母的组合")
    })
    $("#reInputPassword").blur(function () {
        if($("#reInputPassword").val()!=null){
            if($("#reInputPassword").val()!=$("#password").val()){
                $("#reInputPasswordTip").text("请输入与上栏一致的密码")
                regexClass("reInputPassword",false);
            }else {
                regexClass("reInputPassword",true);
            }
        }
    })
}

function verfication(id,regex,tip){
    if($("#"+id).val()!=null&&$("#"+id).val().trim()!=""){
        if(!regex.test($("#"+id).val())){
            $("#"+id+"Tip").text(tip)
            regexClass(id,false);
            return false;
        }else {
            regexClass(id,true);
            return true;
        }
    }else {
        return true;
    }
}

function registVerfi() {
    var bool = true;
    if(!verfication("email",email,"邮箱格式不正确，请输入如\"yourname@abc.com\"样式的邮箱地址！")){
        bool=false;
    }
    if(!verfication("phone",phone,"请输入正确的电话号码！")){
        bool=false;
    }
    if(!verfication("password",psd,"请输入6至15个任意数字及字母的组合")){
        bool=false;
    }
    if($("#reInputPassword").val()!=$("#password").val()){
        $("#reInputPasswordTip").text("请输入与上栏一致的密码")
        regexClass("reInputPassword",false);
        bool = false;
    }else {
        regexClass("reInputPassword",true);
    }
    $("input[required]").each(function (i) {
        if($(this).val().trim()==""){
            var id = $(this).attr("id");
            regexClass(id,false);
            $(this).next("div").text("该项不能为空！")
            bool = false;
        }
    })
    return bool;
}
//************注册用js方法****************//