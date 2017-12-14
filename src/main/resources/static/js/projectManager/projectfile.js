/**
 * Created by april on 2017/12/5.
 */
// 初始化代码，页面加载完成后被自动执行
$(function () {
    console.log(333);
    // datagrid控件的初始化
    $("#dataview3").datagrid({
        // 表格的id字段，用于唯一识别一行数据，可选
        idField:"projectname",

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
        toolbar: '#toolbar3',
        columns:
            [[
                {
                    field:'projectname',
                    title:'项目名称',
                    width:50
                },{
                    field:'date',
                    title:'日期',
                    width:50
                },{
                    field:'username',
                    title:'创建者',
                    width:50
                },{
                    field:'action',
                    title:'操作',
                    width:50
                },
            ]]
    });
})