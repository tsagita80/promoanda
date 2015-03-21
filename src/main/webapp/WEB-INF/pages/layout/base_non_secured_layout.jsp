<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="t" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title><t:insertAttribute name="title" ignore="true"/></title>

    <link href="resources/css/bootstrap/bootstrap.min.css" rel="stylesheet">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js" async></script>
    <script src="resources/js/bootstrap/bootstrap.min.js" async></script>
</head>

<body>
    <t:insertAttribute name="body"/>
</body>
</html>
