$(function () {
    // init datetimepicker
    $('.datetimepicker').datetimepicker({
        format: 'LT'
    });
    
    //
    $(".editKH").on("dp.change", function () {
        var pars = $(this).val().toString().split(' ');
        var hh = parseInt(pars[0].split(':')[0]) + (pars[1] == 'AM' ? 0 : 12);
        var mm = parseInt(pars[0].split(':')[1]);
        var tgd = parseInt($(this).parent().parent().find('input[type=hidden]').val());
       
        var total = hh * 60 + mm + tgd;
        hh = Math.floor(total / 60);
        mm = total % 60;
        var pmdt = hh % 24 > 12 ? 'PM' : 'AM';
        
        var div_id = $(this).parent().attr('href');
        $(div_id).find('.editKT').val(hh % 24 + ":" + mm + " " + pmdt);
    });
});

function editChuyenDi($this) {
    var id = $($this).attr('href');
    $($this).css('display', 'none');
    $(id).find('input').prop("disabled", false);
    $(id).find('input').css("border", "1px solid");
    $(id).find('.save').css("display", "");
}
function saveEditChuyenDi($this){
    var id = $($this).attr('href');
    $.post('quanlychuyendi.do?method=edit', $(id).parent().serialize(), function (response) {
        var message = $(response).find('MESSAGE').text();
        alert(message);
    }, "text");
    
    $(id).find('.save').css("display", "none");
    $(id).find('.edit').css("display", "");
    $(id).find('input').prop("disabled", true);
    $(id).find('input').css("border", "none");
}

function addChuyenDi(form) {
    $.post($(form).attr('action'), $(form).serialize(), function (response) {
        $(form).find("div[name='message']").html($(response).find('MESSAGE').text());
    }, "text");
    
    return false;
}