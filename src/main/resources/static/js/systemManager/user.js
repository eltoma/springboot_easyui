/* 初始化代码，页面加载完成后被自动执行 */
$(function () {
    initMainDG(); // 初始化主界面datagrid控件
})


function addSubmit(formId) {
    var tarForm = $('#'+formId);

    if(!tarForm.form('validate')) { // 检验输入格式
        $.messager.alert(
            '输入校验失败',
            '请检查必输项目和格式',
            'warning'
        );

        return;
    }

    tarForm.submitForm(
        '/user/add',
        function(res) {
            if(res.success) {
                alert("成功！")
                return;
            }

            alert("出错了" + res.msg);
        }
    );
}


function initMainDG() {
    // datagrid控件的初始化
    $("#dataview").datagrid({
        // 表格的id字段，用于唯一识别一行数据，可选
        idField:"username",

        // 数据来源的url，对应的controller的映射路径
        url:'/user/all/',

        // 是否需要分页支持，一般是需要的
        pagination:true,
        // 初始的一页多少行
        pageSize:10,
        // 可选的每页多少行选项
        pageList:[10,20,30,40],

        // 自适应调整，一般为true
        fit:true,
        fitColumns:true,
        // 是否只能单行选中
        singleSelect:true,
        // 行号
        rownumbers:true,
        toolbar: '#toolbar',
        columns:
            [[
                {
                    field:'userid',
                    title:'id',
                    width:50,
                    hidden:true
                },
                {
                    field:'username',
                    title:'用户名',
                    width:50
                },
                {
                    field:'name',
                    title:'姓名',
                    width:50
                },
                {
                      field:'gender',
                      title:'性别',
                      width:50,
                      formatter: function(value,row,index) {
                        if(row.gender) {
                            return '男'
                        } else {
                            return '女'
                        }
                      }
                },
                {
                     field:'studentid',
                     title:'学号',
                     width:50
                },
                {
                     field:'emailaddress',
                     title:'邮箱',
                     width:50
                },
                {
                     field:'major',
                     title:'专业',
                     width:50
                },
                {
                     field:'birthtime',
                     title:'生日',
                     width:50,
                     formatter: function(value,row,index) {
                         if(row.gender) {
                             return '男'
                         } else {
                             return '女'
                         }
                     }
                },
                {
                     field:'graduatetime',
                     title:'毕业时间',
                     width:50
                },
                {
                     field:'graduatedestination',
                     title:'就业地点',
                     width:50
                },
            ]]
    });
}