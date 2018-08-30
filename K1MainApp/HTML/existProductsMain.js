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
            $.each(row, function (index, value) {
                log(index);
                if (index === "place" || index === "model_number" || index === "model") {
                    tr.append(`<th><input id="${value}" name="${value}" type="text" value="${value}"/></th>`);
                }else{
                    tr.append(`<th>${value}</th>`);
                }
                
            });

            var removeBTN = ``;
            var editeBTN = ``;
            tr.append(`<th></th>`);
            $("#existProductsTableBody").append(tr);
        }

    } catch (e) {

    }
    
    // to change vaoues in DB
    $("input").keydown(function () {
        
    });
});