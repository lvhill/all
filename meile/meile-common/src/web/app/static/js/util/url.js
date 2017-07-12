


/**
 * 采用正则表达式获取地址栏指定参数
 * @param name
 * @returns
 */
function getLocationParam(name)
{
     var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
     var r = window.location.search.substr(1).match(reg);
     if(r!=null)return  decodeURI(r[2]); return null;
}



/**
 * 采用正则表达式获取url指定参数
 * @param url
 * @param name
 * @returns
 */
function getUrlParam(url , name)
{
	if(url==null)return null;
	//
    var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
    //
	var search=url.split("?")[1];
	var r = search.match(reg);
	if(r!=null)return  decodeURI(r[2]); return null;
}

/**
 * 给URL添加或者更新参数.
 * <p>如果要添加的参数不存在则新增,否则更新.</p>
 * @param url 要添加参数的url
 * @param name 要添加的参数名
 * @param value 要添加的参数值
 * @return 返回的新url
 */
function addOrUpdateParamToUrl(url, name, value){
	//空值
	if(url==null||url.length==0)return null;
	if(name==null||name.length==0)return url;
	//
	var tmp=url.split('?');
	var startUrl=tmp[0];
	var search=tmp[1];
	//没有参数
	if(search==null||search.length==0){
		startUrl+='?'+name+'='+value;
		return startUrl;
	}
	var nameValues=search.split('&');
	for(var i=0;i<nameValues.length;++i){
		var tname=nameValues[i].split('=')[0];
		if(tname==name)break;
	}
	nameValues[i] = name + '=' + value;
	startUrl+='?'+nameValues[0];
	for(i=1;i<nameValues.length;++i){
		startUrl+='&'+nameValues[i];
	}
	return startUrl;
}



