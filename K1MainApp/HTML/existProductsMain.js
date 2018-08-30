$(document).ready(function () {
    // get Column Names
    var ColumnsNames = GetPost("GET", {"": ""}, "getExistDataProductsColumns");
    try {
        var parseToJson = JSON.parse(ColumnsNames);

        for (var i = 0; i < parseToJson.length; i++) {
            var initTableHeader = "<th scope='col'>" + parseToJson[i].COLUMN_NAME + "</th>";
            $("#existProductsTableHeader").append(initTableHeader);
        }
        $("#existProductsTableHeader").append("<th scope='col'>OPTIONS</th>");

    } catch (e) {
        alert("ERORR PARSING");
    }

    var ProductsData = GetPost("GET", {"": ""}, "getExistDataProductsData");
    try {
        var parseData = JSON.parse(ProductsData);

        for (var i = 0; i < parseData.length; i++)
        { // model_number	amount	place
            var row = parseData[i];
            var tr = $(`<tr id="rowID_${parseData[i].id}"></tr>`);
            $.each(row, function (key, value) {
                log(key);
                if (key === "place" || key === "model_number" || key === "model") {
                    tr.append(`<th><input id="${key}" itemid="${parseData[i].id}" name="${value}" type="text" value="${value}"/></th>`);
                } else {
                    tr.append(`<th>${value}</th>`);
                }

            });

            var removeBTN = `<button action="delete" itemid="${parseData[i].id}" ><i class="far fa-trash-alt"></i></button>`;
            var editeBTN = `<button action="edit"  itemid="${parseData[i].id}" ><i class="fas fa-edit"></i></button>`;
            tr.append(`<th>${ removeBTN + editeBTN }</th>`);
            $("#existProductsTableBody").append(tr);
        }

    } catch (e) {

    }

    // to change vaoues in DB
    $("input").keydown(function () {
        var itemID = $(this).attr("itemid");
        var inputType = $(this).attr("id");
        alert(itemID + " ---- " + inputType);
    });
    $("button").click(function () {
        var itemID = $(this).attr("itemid");
        var btnAction= $(this).attr("action");
        alert(itemID + " ---- " + btnAction);
    });
});