/** Add user page manager **/
// set Password filed Action
$(document).ready(function () {

    try {

        $("#user_password_confirm").keyup(function () {

            if ($(this).val() !== $("#user_password").val()) {

                $('#MSG_user_password_confirm').text("NOT EQUALS");
                $(this).addClass(" erorrField ");
                $("#user_password").addClass(" erorrField ");
                //alert("Erorr Pasword Field");
            } else {

                $(this).removeClass(" erorrField ");
                $(this).attr("true", "true");
                $('#MSG_user_password_confirm').text("");

                $("#user_password").removeClass(" erorrField ");
                $("#user_password").attr("true", "true");
                //alert("");
            }

        });
    } catch (e) {
        log(e);
        log("erorrrrr");
    }


});
/******** ADD USER FORM ********/

function btnClick() {
    try {
        var every = [];
        var byname = document.getElementsByName("addUserForm");

        var passFields = {};
        var emailFields = {};
        var selectFields = {};
        var numberFields = {};
        var textFields = {};

        for (var i = 0; i < byname.length; i++) {
            switch (byname[i].type) {
                case "text" :
                    textFields[byname[i].id] = byname[i].value;
                    break;
                case "select-one":
                    selectFields[byname[i].id] = byname[i].value;
                    break;
                case "email" :
                    emailFields[byname[i].id] = byname[i].value;
                    break;
                case "number" :
                    numberFields[byname[i].id] = byname[i].value;
                    break;
                case "password" :
                    passFields[byname[i].id] = byname[i].value;
                    break;
            }
        }



        if (every.every(allTreu)) {
            
        }

        var serverResponce = GetPost("POST", {data: "data", "soso": "rami"}, "addUserFormData");
        log(serverResponce);
        setStatus(serverResponce);

        function allTreu(elemnt, index, array) {
            log(elemnt);
            return elemnt;
        }
    } catch (e) {
        log(e);
        log("erorrrrr");
    }
}

function checkEmailFields(key, value) {

}

/********EXISTING USERS FORM *********/



