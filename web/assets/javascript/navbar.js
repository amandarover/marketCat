$(document).ready(
  function(){
    $("#navbar").append("<nav class=\"navbar navbar-default\">    <div class=\"container-fluid\"><div class=\"navbar-header\"><a class=\"navbar-brand\" href=\"products.jsp\" text-align=\"center\">MarketCat</a></div>    </div>    <div class=\"container-fluid\"><div class=\"collapse navbar-collapse\" id=\"bs-example-navbar-collapse-1\"><ul class=\"nav navbar-nav navbar-left\"><li><a href=\"products.jsp\">Produtos</a></li><li><a href=\"vendas.jsp\">Venda</a></li><li><a href=\"graph.jsp\">Relatório</a></li><li><a href=\"cadastrousuario.jsp\">Cadastro</a></li></ul><ul class=\"nav navbar-nav navbar-right\"><li class=\"dropdown\" id=\"notification\">  <a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\" role=\"button\" aria-haspopup=\"true\" aria-expanded=\"false\">Notificação <span class=\"glyphicon glyphicon-bell\"></span> <span class=\"badge\">2</span></a>  <ul class=\"dropdown-menu\"><li><a href=\"graph.jsp\">Alguns produtos irão vencer em <strong>7 dias!</strong><br> Clique aqui para ver quais.</a></li><li role=\"separator\" class=\"divider\"></li><li><a href=\"products.jsp\">Um dos produtos está com o <strong>estoque baixo!</strong><br> Clique aqui para ver qual.</a></li>  </ul></li><li><a href=\"login.jsp\">Log out</a></li></ul></ul></div>    </div>  </nav>");
  });

function notificationAlert() {
  $('.dropdown-toggle').dropdown()
}
