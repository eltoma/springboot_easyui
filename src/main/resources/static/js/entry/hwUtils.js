/**
 * Created by april on 2017/12/8.
 * 扩展validatebox,添加验证两次密码功能
 */
$.extend($.fn.validatebox.defaults.rules,{
    eqPwd:{
        validator:function(value,param){
            return value==$(param[0]).val();
        },
        message:"两次密码不一致！"
    }
});