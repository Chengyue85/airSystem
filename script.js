$(function () {
    $('#airlinemsg').click(function () {
        var inum = $('#inum').val();
        var ibeginplace = $('#ibeginplace').val();
        var iarriveplace = $('#iarriveplace').val();
        var iplangotime = $('#iplangotime').val();
        var tbody = window.document.getElementById("tbody-result");

        $.ajax({
            type: "post",
            dataType: "json",
            contentType: "application/json;charset=utf-8",
            url: "http://localhost:8080/user/queryCheatOrder",
            data: "{\"inum\":\"" + inum
                + "\",\"ibeginplace\":\"" + ibeginplace
                + "\",\"iarriveplace\":\"" + iarriveplace
                + "\",\"iplangotime\":\"" + iplangotime
                + "\"}",
            success: function (msg) {
                if (msg.et) {
                    var str = "";
                    var data = msg.data;

                    for (i in data) {
                        str += "<tr>" +
                            "<td align='center'>" + data[i].inum + "</td>" +
                            "<td align='center'>" + data[i].ibeginplace + "</td>" +
                            "<td align='center'>" + data[i].iarriveplace + "</td>" +
                            "<td align='center'>" + data[i].gpsCity + "</td>"+
                            "<td align='center'>" + data[i].iplangotime + "</td>" +
                            "<td align='center'>" + data[i].iactualgotime + "</td>" +
                            "<td align='center'>" + data[i].iplanarrivetime + "</td>" +
                            "<td align='center'>" + data[i].iactualarrivetime + "</td>" +
                            "<td align='center'>" + data[i].gpsCity + "</td>" +
                            "<td align='center'>" + data[i].cellCity + "</td>" +
                            "<td align='center'>" + data[i].distance + "</td>" +
                            "<td align='center'>" + data[i].distance + "</td>" +
                        "</tr>";
                    }
                    tbody.innerHTML = str;
                }
            },
            error: function () {
                alert("查询失败")
            }
        });
    });
});