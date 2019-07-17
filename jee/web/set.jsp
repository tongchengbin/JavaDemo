<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%
    Object cur= pageContext.getAttribute("cur");
    System.out.println(cur);
    if(cur == null){
        System.out.println("null=1");
        cur=1;
    }else{
        cur=Integer.parseInt(cur.toString())+1;

    }

    pageContext.setAttribute("cur",cur);
%>
<h1><%=pageContext.getAttribute("cur")%></h1>
<%--<--%>
<h2>${cur}</h2>