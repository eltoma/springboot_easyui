/**
 * Created by elotoma on 2017/12/1.
 */

$(function () {
    var SystemManager_treeData =
        [
            { text : "用户管理", attributes : {url : "/pages/systemManager/userMan"} },
            { text : "权限管理", attributes : {url : "/pages/systemManager/authorityMan"} } ,
            { text : "日志查询", attributes : {url : "/pages/systemManager/log"} },
        ];

    $('#SystemManager').tree({
        data : SystemManager_treeData,
        lines : true,
        onClick : function (node)
        {
            $(this).tree('toggle',node.target);
            OpenTab(node.text, node.attributes.url);
        }
    });

    var ProjectManager_treeData=
        [
            {text : "项目文档管理", attributes : { url : "/pages/projectManager/projectFile"}},
            { text : "项目阶段管理", attributes : {url : "/pages/projectManager/projectPeriod"}}
        ];
    $('#ProjectManager').tree({
        data : ProjectManager_treeData,
        line : true,
        onClick : function(node1){
            $(this).tree('toggle',node1.target);
            OpenTab(node1.text, node1.attributes.url);
        }
    });
    var ProjectManager_treeData=
        [
            {text : "活动管理", attributes : { url : "/pages/activityManger/activity"}}
        ];
    $('#ActivityManager').tree({
        data : ProjectManager_treeData,
        line : true,
        onClick : function(node1){
            $(this).tree('toggle',node1.target);
            OpenTab(node1.text, node1.attributes.url);
        }
    });
});

function OpenTab(text, url) {
    if ($("#tabs").tabs('exists', text)) {
        $('#tabs').tabs('select', text);
    } else {
        var content = '<iframe scrolling="auto" frameborder="0"  src="'
            + url
            + '" style="width:100%;height:100%;"></iframe>';

        $('#tabs').tabs('add', {
            title : text,
            closable : true,
            content : content
        });
    }
}

