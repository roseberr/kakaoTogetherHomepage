function setDisplay(){
    if($('input:radio[id=promotion]').is(':checked')){
    $('#category1').hide();
    $('#category2').hide();


    }else{
    $('#category1').show();
    $('#category2').show();
    }
}

