$(document).ready(function () {
    $('#div-pratos2').hide();
    $('#maisPratos').click(function () {
        $('#div-pratos2').show();
        $('#maisPratos').hide();
    })
})

$(function () {
    $('#fone').mask('(00) 0 0000-0000');
})

$(function () {
    $("#avaliacao").checkboxradio();
});