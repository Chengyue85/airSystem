$(function () {
    $('#airlinemsg').click(function () {
        var inum = $('#inum').val();
        var ibegin = $('#ibegin').val();
        var iend = $('#iend ').val();
        var ischeduledgo = $('#ischeduledgo').val();
        var tbody = window.document.getElementById("tbody-result");

        $.ajax({
            type: "post",
            dataType: "json",
            contentType: "application/json;charset=utf-8",
            url: "http://localhost:8080/user/queryCheatOrder",
            data: "{\"inum\":\"" + inum
                + "\",\"ibegin\":\"" + ibegin
                + "\",\"iend \":\"" + iend
                + "\",\"ischeduledgo\":\"" + ischeduledgo
                + "\"}",
            success: function (msg) {
                if (msg.et) {
                    var str = "";
                    var data = msg.data;

                    for (i in data) {
                        str += "<tr>" +
                            "<td align='center'>" + data[i].inum + "</td>" +
                            "<td align='center'>" + data[i].icompany + "</td>" +
                            "<td align='center'>" + data[i].ibegin + "</td>" +
                            "<td align='center'>" + data[i].iend + "</td>"+
                            "<td align='center'>" + data[i].imiddle + "</td>" +
                            "<td align='center'>" + data[i].ischeduledgo + "</td>" +
                            "<td align='center'>" + data[i].iactualgo + "</td>" +
                            "<td align='center'>" + data[i].ischeduledarr + "</td>" +
                            "<td align='center'>" + data[i].iactualarr + "</td>" +
                            "<td align='center'>" + data[i].iterminal + "</td>" +
                            "<td align='center'>" + data[i].igate + "</td>" +
                            "<td align='center'>" + data[i].icheck + "</td>" +
                            "<td align='center'>" + data[i].istatus + "</td>" +
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