/**
 * 样式js文件
 */
$(function(){
	hoverRed();
});

function hoverRed(){
	$(".hover-red").each(function(){
		$(this).hover(function(){
			$(this).css("color","#C81623");
			$(this).children().css("color","#C81623");
		},function(){
			$(this).css("color","#666666");
			$(this).children().css("color","#666666");
		});
	});
}
