function search(){
	var keyword=$("#search").val();
	window.location.href = "SearchServlet?keyword="+encodeURI(keyword);
}
