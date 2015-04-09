$(document).ready(function () {
    var $userAccountUsername = $('#userAccount-username'),
            $userAccountPassword = $('#userAccount-password'),
            $userAccountcPassword = $('#userAccount-cpassword'),
            $signupForm = $('#signupForm');

    $signupForm.on('submit', function (event) {
        var userAccountJson = {};
        userAccountJson.username = $userAccountUsername.val();
        userAccountJson.password = $userAccountPassword.val();
        userAccountJson.cpassword = $userAccountcPassword.val();              

        $.ajax({
            url: "/userAccounts",
            data: JSON.stringify(userAccountJson),
            type: "post",
            contentType: 'application/json',
            success: function () {
                $("#container").prepend('<div data-alert class="alert-box success radius">New user was saved!<a href="#" class="close">&times;</a></div>').foundation();
                $signupForm[0].reset();
                $(window).scrollTop(0);                
            },
            error: function (jqXHR, textStatus, errorThrown) {
                var errorFormInfo = $.parseJSON(jqXHR.responseText);
                utils.populateCustomFieldErrors(errorFormInfo);
            }
        });
        event.preventDefault();
    });   
    
    $(document).foundation();
});