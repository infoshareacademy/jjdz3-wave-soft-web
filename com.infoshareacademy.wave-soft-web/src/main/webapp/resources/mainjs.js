$('#more').click(function() {
    jQuery(this).html('Zwiń tekst   &#x000AB;');
    if($('#demo').is(':visible')){
        jQuery(this).html('Czytaj dalej &#x000BB;');
    }else{
        jQuery(this).html('Zwiń tekst   &#x000AB;');
    }
    $('#demo').slideToggle('fast');
    return false;
});
