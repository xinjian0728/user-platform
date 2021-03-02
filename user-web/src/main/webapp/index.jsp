<head>
<jsp:directive.include
	file="/WEB-INF/jsp/prelude/include-head-meta.jspf" />
<title>My Home Page</title>
</head>
<body>
	<div class="container-lg">
		<!-- Content here -->
		Hello,World 2021
	</div>
	<div class="container">
		<h1 class="h3 mb-3 font-weight-normal">${msg}</h1>
	</div>
	<div class="container-lg">
		<a href="user/toregister">注册</a><br>
		<a href="login-form.jsp">登录</a>
	</div>


</body>
