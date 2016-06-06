$(function () {
    // init datetimepicker
    $('#datetimepicker').datetimepicker({
        defaultDate: new Date(),
        format: 'HH:mm DD/MM/YYYY'
    });

    var settings = {
        typeCar: 0, //
        map: ['aaaaaaa', //  'a' is seat, '_' is empty
            '______a',
            'aaaaaaa',
            '______a',
            'aaaaaaa'],
        seatCss: 'icon_seat',
        selectedSeatCss: 'seat_selected',
        selectingSeatCss: 'seat_selecting',
        pathImgSeat: 'resources/images/bed-white.png' // must be png
    };

    initSeats(settings);
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
        if (!$img.hasClass(settings.selectedSeatCss)) {

            var $inputGhe = $('#text_amount_seat');
            var $textTotalPrice = $('#text_total_price_seat');
            var formatTextSeat = $(this).attr('id') + ", ";

            if ($img.hasClass(settings.selectingSeatCss)) {
                $img.removeClass(settings.selectingSeatCss);
                $inputGhe.text($inputGhe.text().replace(formatTextSeat, ""));
                $textTotalPrice.text(parseInt($textTotalPrice.text()) - parseInt($('#text_seat_price').attr("name")));
            } else {
                $img.addClass(settings.selectingSeatCss);
                $inputGhe.text($inputGhe.text() + formatTextSeat);
                $textTotalPrice.text(parseInt($textTotalPrice.text()) + parseInt($('#text_seat_price').attr("name")));
            }
        }
    });
}
// end
