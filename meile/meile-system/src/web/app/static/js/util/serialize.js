

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

(function($) {
	$.fn.serializeJson = function() {
		var serializeObj = {};
		var array = this.serializeArray();
		var str = this.serialize();
		$(array).each(
				function() {
					if (serializeObj[this.name]) {
						if ($.isArray(serializeObj[this.name])) {
							serializeObj[this.name].push(this.value);
						} else {
							serializeObj[this.name] = [
									serializeObj[this.name], this.value ];
						}
					} else {
						serializeObj[this.name] = this.value;
					}
				});
		return serializeObj;
	};
})(jQuery);

(function($) {
	$.fn.serializeJsonString = function() {
		var serializeObj = {};
		var array = this.serializeArray();
		var str = this.serialize();
		$(array).each(
				function() {
					if (serializeObj[this.name]) {
						if ($.isArray(serializeObj[this.name])) {
							serializeObj[this.name].push(this.value);
						} else {
							serializeObj[this.name] = [
									serializeObj[this.name], this.value ];
						}
					} else {
						serializeObj[this.name] = this.value;
					}
				});
		return JSON.stringify(serializeObj);
	};
})(jQuery);

(function($) {
	$.fn.serializeRestJson = function(params) {
		var appid = "";
		var appkey = "";
		var channel = "";
		var token = "";
		
		if(params != null){
			if(params.appid != null){
				appid = params.appid;
			}
			if(params.appkey != null){
				appkey = params.appkey;
			}
			if(params.channel != null){
				channel = params.channel;
			}
			if(params.token != null){
				token = params.token;
			}
		}
		var restJson = {
			"appid" : appid,
			"appkey" : appkey,
			"channel" : channel,
			"token" : token,
		};
		var serializeObj = {};
		var array = this.serializeArray();
		var str = this.serialize();
		$(array).each(
				function() {
					if (serializeObj[this.name]) {
						if ($.isArray(serializeObj[this.name])) {
							serializeObj[this.name].push(this.value);
						} else {
							serializeObj[this.name] = [
									serializeObj[this.name], this.value ];
						}
					} else {
						serializeObj[this.name] = this.value;
					}
				});
		restJson["entity"] = serializeObj;
		return restJson;
	};
})(jQuery);

(function($) {
	$.fn.serializeRestJsonString = function(params) {
		var appid = "";
		var appkey = "";
		var channel = "";
		var token = "";
		
		if(params != null){
			if(params.appid != null){
				appid = params.appid;
			}
			if(params.appkey != null){
				appkey = params.appkey;
			}
			if(params.channel != null){
				channel = params.channel;
			}
			if(params.token != null){
				token = params.token;
			}
		}
		var restJson = {
			"appid" : appid,
			"appkey" : appkey,
			"channel" : channel,
			"token" : token,
		};
		var serializeObj = {};
		var array = this.serializeArray();
		var str = this.serialize();
		$(array).each(
				function() {
					if (serializeObj[this.name]) {
						if ($.isArray(serializeObj[this.name])) {
							serializeObj[this.name].push(this.value);
						} else {
							serializeObj[this.name] = [
									serializeObj[this.name], this.value ];
						}
					} else {
						serializeObj[this.name] = this.value;
					}
				});
		restJson["entity"] = serializeObj;
		return JSON.stringify(restJson);
	};
})(jQuery);

