<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Welcome</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>

    <nav class="navbar navbar-default navbar-fixed-top" role="navigation">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="/">Krew</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">

                <ul class="nav navbar-nav navbar-right">
                    <li class="dropdown">
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="true">
                            <span class="icon icon-user"></span>&nbsp;&nbsp;${userForm.firstName}<span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <%--<li class="divider"></li>--%>
                            <li><a onclick="document.forms['logoutForm'].submit()"><i class="glyphicon glyphicon-off"></i>&nbsp;&nbsp;Sign out</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>

    <!-- Page Content -->
    <div class="container">

        <div class="row">
            <div class="col-lg-12 text-center">
                <c:if test="${pageContext.request.userPrincipal.name != null}">
                    <form id="logoutForm" method="POST" action="${contextPath}/logout">
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    </form>

                    <h2>Welcome ${userForm.firstName} </h2>

                </c:if>
            </div>
        </div>
        <legend>My Details</legend>

        <div class="row">
            <span class="col-sm-12">
                <a class="btn btn-default pull-right" href="edit" role="button">
                    <span class="glyphicon glyphicon-edit" aria-hidden="true"></span> Edit
                </a>
            </span>
        </div>


        <div class="row">
            <label class="col-sm-4 align-right">First Name</label>
            <span class="col-sm-6">${userForm.firstName}</span>
        </div><br/>

        <div class="row">
            <label class="col-sm-4 align-right">Last Name</label>
            <span class="col-sm-6">${userForm.lastName}</span>
        </div><br/>

        <div class="row">
            <label class="col-sm-4 align-right">Contact</label>
            <span class="col-sm-6">${userForm.contactNo}</span>
        </div><br/>

        <div class="row">
            <label class="col-sm-4 align-right">Email</label>
            <span class="col-sm-6">${userForm.email}</span>
        </div><br/>

    </div>

    <!-- /container -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
