<%@ page contentType="text/html; charset=UTF-8" %>
<h1>안녕하세요!</h1>
<%
    int num1 = 100;
    int num2 = 200;
    int result = add(num1, num2);

%>

<%!
    int num3 = 300;
    int add(int n1, int n2){
            return n1+n2;
    }
%>

<%=result %>