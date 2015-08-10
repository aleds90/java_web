<%@ page import="main.java.com.entity.Fornitore" %>
<% final Fornitore fornitore = (Fornitore) request.getAttribute("fornitore"); %>
<%= fornitore.getNomeFornitore() %>
