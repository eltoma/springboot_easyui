/**
 * Created by april on 2017/12/7.
 */

$(function() {

});
function regUser() {
    //$('#index_regForm').submit();
    //★★页面加载完后初始化form
    $('#index_regForm').form('submit', { //初始化表单和提交表单放在一起
        url : '${pageContext.request.contextPath}/userAction!reg.action', //如果不定义url,表单会提交到当前页面
        success : function(data) {//检查通过后后台向前台返回的字符串
            //console.info(data);
            //var obj=eval("("+data+")");//eval()方法，将返回的不是标准json形式数据变成json对象形式【不推荐】
            //不推荐的原因：在easyUI中所有的组件利用的json都是标准的json，如果不用标准json，你认为是对的，但是在前台出不来
            var obj=jQuery.parseJSON(data);
            //console.info(obj);
            if(obj.success){
                $('#index_regDialog').dialog('close');
            }
            $.message.show({//★★弹出提示框，显示注册成功
                title:'提示',
                msg:obj.msg,
            });
        }
    });
}