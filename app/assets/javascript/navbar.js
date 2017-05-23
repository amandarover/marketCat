$(document).ready(
  function(){
    $("#navbar").append("<nav class=\"navbar navbar-default\">    <div class=\"container-fluid\"><div class=\"navbar-header\"><a class=\"navbar-brand\" href=\"main.html\" text-align=\"center\">MarketCat</a></div>    </div>    <div class=\"container-fluid\"><div class=\"collapse navbar-collapse\" id=\"bs-example-navbar-collapse-1\"><ul class=\"nav navbar-nav navbar-left\"><li><a href=\"../views/products.html\">Produtos</a></li><li><a href=\"#\">Venda</a></li><li><a href=\"#\">Relatório</a></li></ul><ul class=\"nav navbar-nav navbar-right\"><li class=\"dropdown\" id=\"notification\">  <a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\" role=\"button\" aria-haspopup=\"true\" aria-expanded=\"false\">Notificação <span class=\"glyphicon glyphicon-bell\"></span></a>  <ul class=\"dropdown-menu\"><li><a href=\"#\">Alguns produtos irão vencer em <strong>7 dias!</strong><br> Clique aqui para ver quais.</a></li><li role=\"separator\" class=\"divider\"></li><li><a href=\"#\">Um dos produtos está com o <strong>estoque baixo!</strong><br> Clique aqui para ver qual.</a></li>  </ul></li></ul></div>    </div>  </nav>");
  });

function notificationAlert() {
  $('.dropdown-toggle').dropdown()
}
