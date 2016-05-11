function addNovelToShoppingCar(e){
	e = e || event;
    var target = e.target || e.srcElement,
        href;
    if (target.tagName === 'A') {
        href = target.href;
        var novelID = href.match(/novelID=[\d]*/)[0];
        novelID=novelID.substring(8,novelID.length);
        //jQuery异步请求
        $.get("AddNovelToShoppingCar", {Action:"get",ID:novelID}, function (data, textStatus){

        	//返回的 data 可以是 xmlDoc, jsonObj, html, text, 等等.
        	 // 在这里this指向的是Ajax请求的选项配置信息，请参考下图
        	$("#ShoppingCar").html("购物车:"+data);
        	//alert(textStatus);//请求状态：success，error等等。
        	//当然这里捕捉不到error，因为error的时候根本不会运行该回调函数
        	//alert(this);
        	});
    }
}