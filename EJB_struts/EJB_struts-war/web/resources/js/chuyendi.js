$(function () {
    // init datetimepicker
   $('.datetimepicker').datetimepicker({
        format: 'LT'
    });
    
    //
     $("#editKH").on("dp.change", function () {
        alert($(this).val());
    });
});

function editChuyenDi($this) {
    var id = $($this).attr('href');
    $(id).find('input').prop("disabled", false);
    $(id).find('input').css("border", "1px solid");
    $(id).find('.save').css("display", "");
}


function traCuuChuyenDi(form) {
    var url = $(form).attr('action') + "&" + $(form).serialize();
    alert(url);
    $(form).attr('action', url);
    alert($(form).attr('action'));
}
