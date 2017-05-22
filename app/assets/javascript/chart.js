$(function () {

    // Create the chart
    $('#grafico').highcharts({
      chart: {
            type: 'column'
        },
        title: {
            text: 'Relatório de Vendas'
        },
        xAxis: {
            type: 'category'
        },

        legend: {
            enabled: false
        },

        plotOptions: {
            series: {
                borderWidth: 0,
                dataLabels: {
                    enabled: true,
                }
            }
        },

        series: [{
            name: 'Ano',
            colorByPoint: true,
            data: [{
                name: '2017',
                y: 5,
                drilldown: '2017'
            }]
        }],
        drilldown: {
            series: [{
                id: '2017',
                name: 'Mês',
                data: [{
                    name: 'Janeiro',
                    y: 4,
                    drilldown: 'janeiro'
                },
                {
                    name:'Fevereiro',
                    y:2,
                    drilldown:'fevereiro'
                },
                {
                    name:'Março',
                    y:2,
                    drilldown:'marco'
                },
                {
                    name:'Abril',
                    y:2,
                    drilldown:'abril'
                },
                {
                    name:'Maio',
                    y:2,
                    drilldown:'maio'
                },
                {
                    name:'Junho',
                    y:3,
                    drilldown:'junho'
                },
                {
                    name:'Julho',
                    y:2,
                    drilldown:'julho'
                },
                {
                    name:'Agosto',
                    y:7,
                    drilldown:'agosto'
                },
                {
                    name:'Setembro',
                    y:2,
                    drilldown:'setembro'
                },
                {
                    name:'Outubro',
                    y:2,
                    drilldown:'outubro'
                },
                {
                    name:'Novembro',
                    y:5,
                    drilldown:'novembro'
                },
                {
                    name:'Dezembro',
                    y:3,
                    drilldown:'dezembro'
                }
                ]
            }, {

                id: 'janeiro',
                data: [{name:"1",
                        y:1},
                       {name:"2",
                       y:2},
                       {name:"3",
                        y:1},
                        {name:"4",
                        y:1},
                       {name:"5",
                       y:2},
                       {name:"6",
                        y:1},
                        {name:"7",
                        y:1},
                       {name:"8",
                       y:2},
                       {name:"9",
                        y:1},
                        {name:"10",
                        y:1},
                       {name:"11",
                       y:2},
                       {name:"12",
                        y:1},
                        {name:"13",
                        y:1},
                       {name:"14",
                       y:2},
                       {name:"15",
                        y:1},
                        {name:"16",
                        y:1},
                       {name:"17",
                       y:2},
                       {name:"18",
                        y:1},
                        {name:"19",
                        y:1},
                       {name:"20",
                       y:2},
                       {name:"21",
                        y:1},
                        {name:"22",
                        y:1},
                       {name:"23",
                       y:2},
                       {name:"24",
                        y:1},
                        {name:"25",
                        y:1},
                       {name:"26",
                       y:2},
                       {name:"27",
                        y:1},
                        {name:"28",
                        y:1},
                       {name:"29",
                       y:2},
                       {name:"30",
                        y:1},
                        {name:"31",
                        y:1}
                       ]
            },{

                id: 'fevereiro',
                data: [{name:"1",
                        y:1},
                       {name:"2",
                       y:2},
                       {name:"3",
                        y:1},
                        {name:"4",
                        y:1},
                       {name:"5",
                       y:2},
                       {name:"6",
                        y:1},
                        {name:"7",
                        y:1},
                       {name:"8",
                       y:2},
                       {name:"9",
                        y:1},
                        {name:"10",
                        y:1},
                       {name:"11",
                       y:2},
                       {name:"12",
                        y:1},
                        {name:"13",
                        y:1},
                       {name:"14",
                       y:2},
                       {name:"15",
                        y:1},
                        {name:"16",
                        y:1},
                       {name:"17",
                       y:2},
                       {name:"18",
                        y:1},
                        {name:"19",
                        y:1},
                       {name:"20",
                       y:2},
                       {name:"21",
                        y:1},
                        {name:"22",
                        y:1},
                       {name:"23",
                       y:2},
                       {name:"24",
                        y:1},
                        {name:"25",
                        y:1},
                       {name:"26",
                       y:2},
                       {name:"27",
                        y:1},
                        {name:"28",
                        y:1},
                       {name:"29",
                       y:2}
                    ]
                },{

                id: 'marco',
                data: [{name:"1",
                        y:1},
                       {name:"2",
                       y:2},
                       {name:"3",
                        y:1},
                        {name:"4",
                        y:1},
                       {name:"5",
                       y:2},
                       {name:"6",
                        y:1},
                        {name:"7",
                        y:1},
                       {name:"8",
                       y:2},
                       {name:"9",
                        y:1},
                        {name:"10",
                        y:1},
                       {name:"11",
                       y:2},
                       {name:"12",
                        y:1},
                        {name:"13",
                        y:1},
                       {name:"14",
                       y:2},
                       {name:"15",
                        y:1},
                        {name:"16",
                        y:1},
                       {name:"17",
                       y:2},
                       {name:"18",
                        y:1},
                        {name:"19",
                        y:1},
                       {name:"20",
                       y:2},
                       {name:"21",
                        y:1},
                        {name:"22",
                        y:1},
                       {name:"23",
                       y:2},
                       {name:"24",
                        y:1},
                        {name:"25",
                        y:1},
                       {name:"26",
                       y:2},
                       {name:"27",
                        y:1},
                        {name:"28",
                        y:1},
                       {name:"29",
                       y:2},
                       {name:"30",
                        y:1},
                        {name:"31",
                        y:1}
                       ]
            }
            ]
        }
    })
});