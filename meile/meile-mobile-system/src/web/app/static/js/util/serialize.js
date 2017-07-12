

/**
 * 系列化
 * @param name
 * @param val
 * @returns {String}
 */
function serialize(name , val){
	return "&"+name+"="+val;
}

/**
 * 从系列化字符串中获取指定参数
 * @param serialize
 * @param name
 * @returns
 */
function getSerializeParam(serialize, name){
	var nameValues=serialize.split('&');
	for(var i=0;i<nameValues.length;++i){
		var tname=nameValues[i].split('=')[0];
		if(tname==name){
			var tval=nameValues[i].split('=')[1];
			return tval;
			break;
		}
	}
	return null;
}