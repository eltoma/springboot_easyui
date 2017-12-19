/**
 * 作者: elto
 * 时间: 2017/12/09
 * 内容：扩展JQuery
 */


/**
 * 功能：将表单数据序列化为对象
 * 注意：只能作用于表单(Form)节点上
 */
$.fn.serializeObject = function() {
    var o = {};
    var a = this.serializeArray();
    $.each(a, function() {
        if (o[this.name]) {
            if (!o[this.name].push) {
                o[this.name] = [o[this.name]];
            }
            o[this.name].push(this.value || '');
        } else {
            o[this.name] = this.value || '';
        }
    });
    return o;
};

/**
 * 功能：提交表单的数据
 * 参数：
 *  - url: 提交的目标地址
 *  - successCallback: 成功后的回调函数
 *  - errorCallback: 失败后的回调函数, 如果没有特殊需求建议不传该参数
 */
$.fn.submitForm = function(url, successCallback, errorCallback) {
    var data = this.serializeObject();

    console.log("\n-------------form content-------------");
    console.log(JSON.stringify(data));
    console.log("-------------form content-------------\n");

    $.messager.progress();	// 开启进度条，防止重复点击
    $.ajax({
            type: "POST",
            url: url,
            contentType: "application/json; charset=utf-8",
            data: JSON.stringify(data),
            dataType: "json",
            /* res: 返回的数据, status: 状态 */
            success: function (res, status) {
               $.messager.progress('close');

               if(successCallback) {
                   successCallback(res, status);
               } else {
                   console.log("提交表单成功 | " + status + " | " + res)
               }
            },
            error: function (res) {
                $.messager.progress('close');

                if(errorCallback) {
                    errorCallback(res);
                } else {
                    console.log("提交表单出错 | " + res)
                }
            }
        });

}

$.fn.datebox.defaults.formatter = function(date){
	var y = date.getFullYear();
	var m = date.getMonth()+1;
	var d = date.getDate();
	return y+'-'+m+'-'+d;
}
