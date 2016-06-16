function xemBaoCaoNam() {
    
    $.get('baocaonam.do?method=getData', {nam: $("select[name='nam']").val()}, function (response) {
        var $dtArray = $(response).find("DOANHTHU").text().replace('[', '').replace(']','').split(', ');
        initChart($("select[name='nam']").val(), $dtArray);
    }, "text");
    
}
