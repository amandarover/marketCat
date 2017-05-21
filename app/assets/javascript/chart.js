// Create the chart

Highcharts.chart('container', {
  chart: {
    type: 'column'
  },
  title: {
    text: 'Relatório de Vendas'
  },
  subtitle: {
    text: 'Clique na coluna para ver os dias'
  },
  xAxis: {
    type: 'category'
  },
  yAxis: {
    title: {
      text: 'Total de Vendas'
    }

  },
  legend: {
    enabled: false
  },
  plotOptions: {
    series: {
      borderWidth: 0,
      dataLabels: {
        enabled: true
      }
    }
  },

  tooltip: {
    headerFormat: '<span style="font-size:11px">{series.name}</span><br>',
    pointFormat: '<span style="color:{point.color}">{point.name}</span>: <b>{point.y:.2f}%</b> of total<br/>'
  },

  series: [{
    name: 'Brands',
    colorByPoint: true,
    data: [{
      name: 'Janeiro',
      y: 56.33,
      drilldown: 'Microsoft Internet Explorer'
    }, {
      name: 'Fevereiro',
      y: 24.03,
      drilldown: 'Chrome'
    }, {
      name: 'Março',
      y: 10.38,
      drilldown: 'Firefox'
    }, {
      name: 'Abril',
      y: 4.77,
      drilldown: 'Safari'
    }, {
      name: 'Maio',
      y: 0.91,
      drilldown: 'Opera'
    }, {
      name: 'Junho',
      y: 0.2,
      drilldown: null
    }, {
      name: 'Julho',
      y: 10.38,
      drilldown: null
    }, {
      name: 'Agosto',
      y: 10.38,
      drilldown: null
    }, {
      name: 'Setembro',
      y: 10.38,
      drilldown: null
    }, {
      name: 'Outubro',
      y: 10.38,
      drilldown: null
    }, {
      name: 'Novembro',
      y: 10.38,
      drilldown: null
    }, {
      name: 'Dezembro',
      y: 10.38,
      drilldown: null
    }]
  }],
  drilldown: {
    series: [{
      name: 'Microsoft Internet Explorer',
      id: 'Microsoft Internet Explorer',
      data: [
        [
          'v11.0',
          24.13
        ],
        [
          'v8.0',
          17.2
        ],
        [
          'v9.0',
          8.11
        ],
        [
          'v10.0',
          5.33
        ],
        [
          'v6.0',
          1.06
        ],
        [
          'v7.0',
          0.5
        ]
      ]
    }, {
      name: 'Chrome',
      id: 'Chrome',
      data: [
        [
          'v40.0',
          5
        ],
        [
          'v41.0',
          4.32
        ],
        [
          'v42.0',
          3.68
        ],
        [
          'v39.0',
          2.96
        ],
        [
          'v36.0',
          2.53
        ],
        [
          'v43.0',
          1.45
        ],
        [
          'v31.0',
          1.24
        ],
        [
          'v35.0',
          0.85
        ],
        [
          'v38.0',
          0.6
        ],
        [
          'v32.0',
          0.55
        ],
        [
          'v37.0',
          0.38
        ],
        [
          'v33.0',
          0.19
        ],
        [
          'v34.0',
          0.14
        ],
        [
          'v30.0',
          0.14
        ]
      ]
    }, {
      name: 'Firefox',
      id: 'Firefox',
      data: [
        [
          'v35',
          2.76
        ],
        [
          'v36',
          2.32
        ],
        [
          'v37',
          2.31
        ],
        [
          'v34',
          1.27
        ],
        [
          'v38',
          1.02
        ],
        [
          'v31',
          0.33
        ],
        [
          'v33',
          0.22
        ],
        [
          'v32',
          0.15
        ]
      ]
    }, {
      name: 'Safari',
      id: 'Safari',
      data: [
        [
          'v8.0',
          2.56
        ],
        [
          'v7.1',
          0.77
        ],
        [
          'v5.1',
          0.42
        ],
        [
          'v5.0',
          0.3
        ],
        [
          'v6.1',
          0.29
        ],
        [
          'v7.0',
          0.26
        ],
        [
          'v6.2',
          0.17
        ]
      ]
    }, {
      name: 'Opera',
      id: 'Opera',
      data: [
        [
          'v12.x',
          0.34
        ],
        [
          'v28',
          0.24
        ],
        [
          'v27',
          0.17
        ],
        [
          'v29',
          0.16
        ]
      ]
    }]
  }
});
