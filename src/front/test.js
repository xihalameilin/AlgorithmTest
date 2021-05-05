window.onload = function () {
    classifyVueFun();
};

function classifyVueFun() {
    let classifyVue = new Vue({
        el: "#classifyVue",
        data: {

        },
        methods: {
            initialGraph1: function () {
                var formData = new FormData;
                formData.append("examId", 28);
                this.$http.post("/examTestInfoStatistics", formData)
                    .then(function (response) {
                        var responseData = response.data['response'];
                        var xs = []
                        var errorCounts = []
                        for (var i in responseData) {
                            console.log(responseData[i])
                            var questionId = responseData[i]['QuestionId']
                            var testCaseName = responseData[i]['TestCaseName']
                            var examId = responseData[i]['ExamId']
                            xs.push("Question:" + questionId + "\nTestCaseName:" + testCaseName + "\nExamId:" + examId)
                            errorCounts.push(responseData[i]['ErrorCount'])
                        }
                        this.Graph = echarts.init(document.getElementById("graph1"));

                        // 指定图表的配置项和数据
                        var option = {
                            title: {
                                text: ' 错误测试用例汇总',
                                left: 10
                            },
                            toolbox: {
                                feature: {
                                    dataZoom: {
                                        yAxisIndex: false
                                    },
                                    saveAsImage: {
                                        pixelRatio: 2
                                    }
                                }
                            },
                            tooltip: {
                                trigger: 'axis',
                                axisPointer: {
                                    type: 'shadow'
                                }
                            },
                            grid: {
                                bottom: 90
                            },
                            dataZoom: [{
                                type: 'inside'
                            }, {
                                type: 'slider'
                            }],

                            xAxis: {
                                show : false,
                                data: xs,
                                silent: false,
                                splitLine: {
                                    show: false
                                },
                                splitArea: {
                                    show: false
                                },
                                axisLabel : {
                                    formatter: function () {
                                        return "";
                                    }
                                }
                            },
                            yAxis: {
                                splitArea: {
                                    show: false
                                }
                            },
                            series: [{
                                type: 'bar',
                                data: errorCounts,
                                // Set `large` for large data amount
                                large: true
                            }]
                        };

                        // 使用刚指定的配置项和数据显示图表。
                        this.Graph.setOption(option);
                    })
            },

            initialGraph2: function () {
                this.Graph2 = echarts.init(document.getElementById("graph2"));
                this.$http.post("/AllExamInfos")
                    .then(function (response) {
                        var responseData = response.data['response'];
                        var xs = []
                        var logCounts = []
                        var buildTimes = []
                        var testTimes = []
                        for(var i in responseData){
                            var item = responseData[i]
                            xs.push(item['examId'])
                            logCounts.push(item['logNum']/10000)
                            buildTimes.push(item['buildTimes']/1000)
                            testTimes.push(item['testTimes']/1000)
                        }


                    var labelOption = {
                        show: true,
                        position: 'insideBottom',
                        distance: 15,
                        align: 'left',
                        verticalAlign: 'middle',
                        rotate: 90,
                        formatter: '{c}  {name|{a}}',
                        fontSize: 16,
                        rich: {
                            name: {
                                textBorderColor: '#fff'
                            }
                        }
                    };

                    // 指定图表的配置项和数据
                    var option = {
                        title:{
                            text: ' 考试情况汇总',
                            left: 10
                        },
                        color: ['#003355', '#4cabce','#e5323e'],
                        tooltip: {
                            trigger: 'axis',
                            axisPointer: {
                                type: 'shadow'
                            },
                        formatter: function (params, ticket, callback) {
                            var res = params[0].seriesName +' : '+ params[0].value + "w"+
                                '<br/>' + params[1].seriesName + ' : ' + params[1].value+"k"+
                                '<br/>' + params[2].seriesName + ' : ' + params[2].value+"k";

                            setTimeout(function () {
                                callback(ticket, res);
                            }, 20);
                            return 'loading...';
                            }
                        },
                        legend: {
                            data: ['日志条数', '编译次数', '测试次数']
                        },
                        toolbox: {
                            show: true,
                            orient: 'vertical',
                            left: 'right',
                            top: 'center',
                            feature: {
                                mark: {show: true},
                                dataView: {show: true, readOnly: false},
                                magicType: {show: true, type: ['line', 'bar', 'stack', 'tiled']},
                                restore: {show: true},
                                saveAsImage: {show: true}
                            }
                        },
                        xAxis: [
                            {
                                type: 'category',
                                axisTick: {show: false},
                                data: xs,
                                name:'考试编号'
                            }
                        ],
                        yAxis: [
                            {
                                type: 'value'
                            }
                        ],
                        series: [
                            {
                                name: '日志条数',
                                type: 'bar',
                                barGap: 0,
                                label: labelOption,
                                data: logCounts

                            },
                            {
                                name: '编译次数',
                                type: 'bar',
                                label: labelOption,
                                data: buildTimes
                            },
                            {
                                name: '测试次数',
                                type: 'bar',
                                label: labelOption,
                                data: testTimes
                            },
                        ]
                    };

                    // 使用刚指定的配置项和数据显示图表。
                    this.Graph2.setOption(option);
                    })
            },

            initialAllGraphs: function () {
                this.initialGraph1();
                this.initialGraph2()
            }
        },
        mounted: function () {
            //let urlStr = window.location.href; //获取访问地址
            //let urlArr = urlStr.split("/classifyExam/"); //截取字符串，存到数组中
            //this.currentExam = urlArr[1];
            this.initialAllGraphs();
        }


    })
}