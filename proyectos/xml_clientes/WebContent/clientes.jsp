<?xml version="1.0" encoding="utf-8" ?>
<%@page contentType="text/xml" pageEncoding="utf-8"%>
<%@page import="java.util.*,es.curso.clientes.*" %>
<% List<Cliente> clientes = (List<Cliente>)request.getAttribute("clientes"); %>
<clientes>
	<% for (Cliente c: clientes) { %>
		<cliente>
			<nombre><%= c.getNombre().replace("&", "&amp;") %></nombre>
			<nombre><%= c.getPais() %></nombre>
		</cliente>
	<% } %>
</clientes>
