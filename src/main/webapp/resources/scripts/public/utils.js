var utils = {};

utils.populateCustomFieldErrors = function (errorFormInfo) {
    $.each(errorFormInfo.fieldErrors, function (index, fieldErrorDTO) {
        var errorTag = $("#" + errorFormInfo.objectName + "-" + fieldErrorDTO.fieldName + "-error");
        errorTag.text(fieldErrorDTO.fieldError);
        errorTag.closest('div').addClass("error");

    });
};