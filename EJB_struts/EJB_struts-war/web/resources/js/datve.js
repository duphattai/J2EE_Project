$(function () {
    // init datetimepicker
    $('#datetimepicker').datetimepicker({
        defaultDate: new Date(),
        format: 'HH:mm DD/MM/YYYY'
    });
});


function initSeats(settings) {

    // init draw seat chart
    function findNumberOfSeat(row, col, array) {
        var temp = 0;
        var rowMap = array.length;
        var colMap = array[0].length;

        for (var c = 0; c < colMap; c++) {
            for (var r = 0; r < rowMap; r++) {
                if (row == r && c == col)
                    return temp;
                temp = array[r][c] != '_' ? temp + 1 : temp;
            }
        }

        return temp;
    }

    // setup booked seat (payment, not payment)
    function initBookedSeat(bookedSeats, cssBookedSeat){
        for(var i in bookedSeats){
            var id = "#" + bookedSeats[i].toString().replace(' ','');
            $(id).children(":first").addClass(cssBookedSeat);
        }
    }

    // draw seat chart
    if (settings.typeCar == 0) {
        var map = settings.map;
        var html = "";

        for (var temp = 0; temp < 2; temp++) {
            var name = temp == 0 ? "A" : "B";

            html += "<tr><td><table class=\"table car_chart\">";
            for (var row = 0; row < map.length; row++) {

                html += "<tr>";
                for (var col = 0; col < map[row].length; col++) {

                    var nameSeat = (findNumberOfSeat(row, col, map) + 1) + name;

                    if (map[row][col] != '_') {
                        html += "<td><a href=\"#\" id=\"" + nameSeat + "\" class=\"link_icon_seat\">";
                        html += "<img class=\"" + settings.seatCss + "\" src=\"" + settings.pathImgSeat + "\"/>";
                        html += "<div class=\"text_icon_seat\">Ghế số: " + nameSeat + "</div>";
                        html += "</a></td>";
                    } else {
                        html += "<td></td>";
                    }
                }
                html += "</tr>";
            }
            html += "</table></td></tr>";
        }

        $('#placeSeat').html(html);
    }

    // setup event select on seat
    $("a.link_icon_seat").click(function () {
        var $img = $(this).children(":first");
        if (!$img.hasClass(settings.bookedSeatPaymentCss) && 
                !$img.hasClass(settings.bookedSeatNotPaymentCss)) {

            var $inputGhe = $('#text_amount_seat');
            var $textTotalPrice = $('#text_total_price_seat');
            var formatTextSeat = $(this).attr('id') + ", ";

            if ($img.hasClass(settings.selectingSeatCss)) {
                $img.removeClass(settings.selectingSeatCss);
                $inputGhe.text($inputGhe.text().replace(formatTextSeat, ""));
                $textTotalPrice.text(parseInt($textTotalPrice.text()) - parseInt($('#lapve_giave').attr("name")));
            } else {
                $img.addClass(settings.selectingSeatCss);
                $inputGhe.text($inputGhe.text() + formatTextSeat);
                $textTotalPrice.text(parseInt($textTotalPrice.text()) + parseInt($('#lapve_giave').attr("name")));
            }
        }
    });
    
    // init bookedseats
    initBookedSeat(settings.bookedSeatPayment, settings.bookedSeatPaymentCss);
    initBookedSeat(settings.bookedSeatNotPayment, settings.bookedSeatNotPaymentCss);
}
// end

function timKiemChuyenDi() {
    $.post('vexe.do?method=tracuuchuyendi', $("#searchChuyenDi").serialize(), function (response) {
        $('#placeSearchChuyenDi').html(response);
    }, "text");
}
                    
function initFormLapVe(tuyen, khoihanh, gia, machuyendi){
    $('#lapve_tuyendi').text(tuyen);
    $('#lapve_khoihanh').text(khoihanh);
    $('#lapve_giave').attr('name', gia);
    $('#lapve_giave').text(gia);
    $('#lapve_machuyendi').val(machuyendi);

    $.get('vexe.do?method=thongtinchuyendi', { idchuyendi: machuyendi}, function (response) {

        var strArray1 = $(response).find('BookedPayment').text();
        var strArray2 = $(response).find('BookedNotPayment').text();
        
        var settings = {
            typeCar: 0, //
            map: ['aaaaaaa', //  'a' is seat, '_' is empty
                '______a',
                'aaaaaaa',
                '______a',
                'aaaaaaa'],
            seatCss: 'icon_seat',
            bookedSeatNotPayment: strArray2.replace('[','').replace(']','').split(','),
            bookedSeatPayment: strArray1.replace('[','').replace(']','').split(','),
            bookedSeatNotPaymentCss: 'seat_bookedSeatNotPayment',
            bookedSeatPaymentCss: 'seat_bookedSeatPayment',
            selectingSeatCss: 'seat_selecting',
            pathImgSeat: 'resources/images/bed-white.png' // must be png
        };
        initSeats(settings);
        
    }, "xml");
    
    
}


 function lapPhieuDatCho(form){
    
    $("#formPhieuDatCho").submit(function(e) {
        alert('ok');
        e.preventDefault();
        
        validateVeXeForm(this);
    });
    /*
        $.post('vexe/lapphieu.do?method=taoPhieuDatCho', $("#formPhieuDatCho").serialize(), function (response) {
            alert('ok');
        }, "text");
        */  
}
