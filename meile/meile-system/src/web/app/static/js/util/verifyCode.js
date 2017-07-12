/**
 * 说明:本js需要jquery类库
 */

/**
 * 验证码获得
 */
function verifyCode() {
	var verifyCodeImg = document.getElementById("verifyCodeImg");
	verifyCodeImg.setAttribute("src", SERVE_ROOT
			+ "/verify/verifyCode?" + Math.random());
	verifyCodeImg.setAttribute("title", "点击换一张");
	verifyCodeImg.onclick = function() {// 刷新验证码
		verifyCodeImg.src = SERVE_ROOT + "/verify/verifyCode?"
				+ Math.random(); // 刷新验证码
	}
}
/**
 * 验证码刷新
 */
function refreshVerifyCode() {
	var verifyCodeImg = document.getElementById("verifyCodeImg");
	verifyCodeImg.src = SERVE_ROOT + "/verify/verifyCode?"
			+ Math.random(); // 刷新验证码
}
/**
 * 验证码检验
 */
function checkVerifyCode() {
	var url = SERVE_ROOT + "/verify/checkVerifyCode";
	var data = "&verifyCode=" + document.getElementById("verifyCode").value;
	//
	var result;
	$.ajax({
		type : "POST",
		url : url,
		data : data,
		async : false,
		success : function(msg) {
			if (msg.indexOf("success") != -1) {
				result = true;
			} else {
				result = false;
			}
		}
	});
	return result;
}