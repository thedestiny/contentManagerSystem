<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/comm/mytags.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <title>后台管理系统</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="keywords" content="后台管理系统">
    <meta name="description" content="致力于提供通用版本后台管理解决方案">

    <link rel="shortcut icon" href="${ctx}/static/img/favicon.ico">
    <link rel="stylesheet" href="${ctx}/static/layui_v2/css/layui.css">
    <link rel="stylesheet" href="${ctx}/static/css/global.css">
    <link rel="stylesheet" type="text/css" href="${ctx}/static/css/common.css" media="all">
    <link rel="stylesheet" type="text/css" href="${ctx}/static/css/personal.css" media="all">
    <link rel="stylesheet" type="text/css" href="http://at.alicdn.com/t/font_9h680jcse4620529.css">
    <script src="${ctx}/static/layui_v2/layui.js"></script>


<body>
<div class="larry-grid layui-anim layui-anim-upbit larryTheme-A ">
    <div class="larry-personal">
        <div class="layui-tab layui-tab-brief">
            <ul class="layui-tab-title">
                <li class="layui-this">未读公告<span class="layui-badge">4</span></li>
                <li>已读公告<span class="layui-badge layui-bg-green">0</span></li>
                <li>全部公告<span class="layui-badge layui-bg-blue">0</span></li>
            </ul>
            <div class="layui-tab-content">
                <div class="layui-tab-item layui-show">
                    <!-- 公告列表 -->
                    <table id="announcementTableList" lay-filter="announcementTableId"></table>
                </div>
                <div class="layui-tab-item">内容2</div>
                <div class="layui-tab-item">内容3</div>
            </div>

        </div>
    </div>
</div>

<script type="text/javascript">
    layui.config({
        base : "${ctx}/static/js/"
    }).use(['form', 'table', 'layer','common','laydate','element'], function () {
        var $ =  layui.$,
                form = layui.form,
                table = layui.table,
                layer = layui.layer,
                laydate = layui.laydate,
                element = layui.element,
                common = layui.common;
        /**公告表格加载*/
        table.render({
            elem: '#announcementTableList',
            url: '${ctx}/announcement/ajax_announcement_list.do',
            id:'announcementTableId',
            method: 'post',
            height:'full-120',
            skin:'row',
            even:'true',
            size: 'sm',
            cols: [[
                {field:'announcementTitle', title: '公告标题',width: 400 },
                {field:'announcementType', title: '公告类型',align:'center',width: 200,templet: '#announcementTypeTpl'},
                {field:'announcementAuthor', title: '发布人',align:'center',width: 220},
                {field:'announcementTime', title: '发布时间',align:'center',width: 220},
                {fixed:'right', title: '操作', align:'center',width: 200, toolbar: '#userBar'}

            ]],
            page: true,
            limit: 10//默认显示10条
        });

        /**查询*/
        $(".announcementSearchList_btn").click(function(){
            //监听提交
            form.on('submit(announcementSearchFilter)', function (data) {
                table.reload('announcementTableId',{
                    where: {
                        beginTime:data.field.beginTime,
                        endTime:data.field.endTime
                    },
                    height: 'full-140'
                });

            });

        });

        /**开始日期*/
        laydate.render({
            elem: '#beginTime',
            theme: 'molv'
        });
        /**结束日期*/
        laydate.render({
            elem: '#endTime',
            theme: 'molv'
        });


        /**新增公告*/
        $(".announcementAdd_btn").click(function(){
            var url = "${ctx}/announcement/announcement_add.do";
            common.cmsLayOpen('新增公告',url,'890px','480px');
        });



        /**监听工具条*/
        table.on('tool(announcementTableId)', function(obj){
            var data = obj.data; //获得当前行数据
            var layEvent = obj.event; //获得 lay-event 对应的值

            //公告详情
            if(layEvent === 'announcement_detail') {
                var announcementId = data.announcementId;
                var url =  "${ctx}/announcement/announcement_detail.do?announcementId="+announcementId;
                common.cmsLayOpenTip('公告详情',url,'100%','100%');

             //公告删除
            }else if(layEvent === 'announcement_delete') {
                var announcementId = data.announcementId;
                var url = "${ctx}/announcement/ajax_del_announcement.do";
                var param = {announcementId:announcementId};
                common.ajaxCmsConfirm('系统提示', '确定要删除当前公告吗?',url,param);

            }
        });


    });
</script>
<!-- 公告类型tpl-->
<script type="text/html" id="announcementTypeTpl">

    {{# if(d.announcementType == 1){ }}
    <span class="label label-info ">1-系统公告</span>
    {{# } else if(d.announcementType == 2){ }}
    <span class="label label-info ">2-活动公告</span>
    {{# } else { }}
    {{d.announcementType}}
    {{# }  }}
</script>


<!--工具条 -->
<script type="text/html" id="userBar">
    <div class="layui-btn-group">
        <shiro:hasPermission name="mScICO9G">
            <a class="layui-btn layui-btn-mini layui-btn-normal  announcement_detail" lay-event="announcement_detail"><i class="layui-icon larry-icon larry-chaxun2"></i>详情</a>
        </shiro:hasPermission>
        <shiro:hasPermission name="uBg9TdEr">
            <a class="layui-btn layui-btn-mini layui-btn-danger announcement_delete" lay-event="announcement_delete"><i class="layui-icon larry-icon larry-ttpodicon"></i>删除</a>
        </shiro:hasPermission>
    </div>
</script>



</body>
</html>