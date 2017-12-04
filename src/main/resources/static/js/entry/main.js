/**
 * Created by elotoma on 2017/12/1.
 */

$(function () {
    var SystemManager_treeData =
        [
            { text : "用户管理", attributes : {url : "/pages/systemManager/userMan"} },
            { text : "权限管理", attributes : {url : "/pages/systemManager/authorityMan"} } ,
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

