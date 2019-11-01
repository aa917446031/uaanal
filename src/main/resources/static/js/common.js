var formatNum=function(num){
    if(num==undefined){
        return 0;
    }
    var fTmp = parseFloat((num+'').replace(/,/g,''));
    var f=(isNaN(fTmp) ? 0 : fTmp)
    var f=f+'';
    return f.replace(/\d{1,3}(?=(\d{3})+(\.\d*)?$)/g, '$&,');
};