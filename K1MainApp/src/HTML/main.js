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





