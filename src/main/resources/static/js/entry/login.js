/**
 * Created by april on 2017/12/7.
 */
function submitForm() {
    $('#ff').form('submit', {
        url:"/login",
        onSubmit: function(){
            // do some check
            // return false to prevent submit;
        },
        success:function(res){
            // 注意要先把json字符串转换为对象，然后才能使用.运算符
            var res = JSON.parse(res)
            if(res.success) {
                transferToMainPage();
            } else {
                alert(res.msg);
            }
        }
    });
}

function transferToMainPage() {
    var main = window.location.href + "main";
    window.location.href = main;
}

function clearForm(){
    $('#ff').form('clear');
}


