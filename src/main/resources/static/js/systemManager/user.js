// 初始化代码，页面加载完成后被自动执行
$(function () {
    console.log(111);
    // datagrid控件的初始化
    $("#dataview").datagrid({
        // 表格的id字段，用于唯一识别一行数据，可选
        idField:"username",

        // 数据来源的url，对应的controller的映射路径
        url:'',

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
                    field:'username',
                    title:'用户名',
                    width:50
                },{
                    field:'age',
                    title:'年龄',
                    width:50
                },{
                    field:'sex',
                    title:'性别',
                    width:50
                },
            ]]
    });
})