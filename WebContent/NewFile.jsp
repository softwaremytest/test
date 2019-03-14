<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
   <script>
	    $("#fileUpload").fileinput({
	        language : "zh",//设置语言
	        uploadUrl: "${pageContext.request.contextPath}/fileUpload/UploadServlet",//上传地址
	        uploadAsync: true,//同步还是异步
	        showCaption:false,//是否显示标题
	        showUpload: true,//是否显示上传按钮
	        browseClass: "btn btn-primary", //按钮样式 
	        allowedFileExtensions : ['jpg', 'png','gif','xls'],//接收的文件后缀
	        allowedFileTypes: ['image', 'video', 'flash','excel'],//接收的文件类型['image', 'html', 'text', 'video', 'audio', 'flash','object']
	        maxFileCount: 6,//最大上传文件数限制
	        overwriteInitial: false,
	        maxFileSize: 1000, 
	        msgFilesTooMany: "选择上传的文件数量({n}) 超过允许的最大数值{m}！",
	        previewFileIcon: '<i class="glyphicon glyphicon-file"></i>', 
	        enctype: 'multipart/form-data',
	        /* allowedPreviewTypes: null, */
	        previewFileIconSettings: {
                'docx': '<i class="glyphicon glyphicon-file"></i>',
                'xlsx': '<i class="glyphicon glyphicon-file"></i>',
                'pptx': '<i class="glyphicon glyphicon-file"></i>',
                'jpg': '<i class="glyphicon glyphicon-picture"></i>',
                'pdf': '<i class="glyphicon glyphicon-file"></i>',
                'zip': '<i class="glyphicon glyphicon-file"></i>'
            }
});
	    </script>
<body>
<div class="htmleaf-container">
		<div class="container kv-main">
            <div class="page-header">
            <h2>单张上传 </h2>
            </div> 
            <form enctype="multipart/form-data" id="uploadForm"  method = "post"> 
                <input id="fileUpload" class="file" type="file" name="fileUpload"  multiple  data-show-preview="true">
            </form>
        </div>
	</div>


</body>
</html>