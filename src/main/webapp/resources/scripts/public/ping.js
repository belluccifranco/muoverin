$(document).ready(function () {

    function pingServer() {
        $.ajax({
            complete: function (e, xhr, settings) {
                setTimeout(pingServer, 240000); //4min
                if (e.status === 403) {
                    window.location.replace("/login");
                }
            }
        });
    }

    pingServer();
});