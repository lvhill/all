$(function(){
	topBarMenu();
	topBarLocation();
	topBarSjjd();
	headCart();
	showClassifySort();
	showClassifyDetailContentRoute();
	showClassifyDetailContentListSpan();
	//首页淡入淡出图片轮番
	new Slide($("#fadeSlide"));
	showInfoIco();
	new Slide($('#recommend-list'),'level', 300000);
	new Slide($('#apparel-switch-slide'),'level', 4000);
	new Slide($('#cosmetic-switch-slide'),'level', 4000);
	new Slide($('#makeup-switch-slide'),'level', 4000);
	new Slide($('#makeup-switch-slide-two'),'level', 4000);
	new Slide($('#makeup-switch-slide-three'),'level', 4000);
	new Slide($('#makeup-switch-slide-four'),'level', 4000);
	new Slide($('#makeup-switch-slide-five'),'level', 4000);
	new Slide($('#makeup-switch-slide-six'),'level', 4000);
	new Slide($('#makeup-switch-slide-seven'),'level', 4000);
	new Slide($('#makeup-switch-slide-eight'),'level', 4000);
	new Slide($('#makeup-switch-slide-nine'),'level', 4000);

	bannerTitleSwitch();
});
function topBarMenu(){
	$(".top-bar-menu").each(function(){
		var title = $(this).find(".top-bar-menu-title");
		var titleV = title.find("i");
		var content = $(this).find(".top-bar-menu-content");
		$(this).hover(function(){
			title.css('background-color','#FFFFFF');
			title.css('border-left','1px solid #DDDDDD');
			title.css('border-right','1px solid #DDDDDD');
			titleV.css("background-image","url(./skin/image/v-top-s.gif)");
			content.css('display','block');
		},function(){
			title.css('background-color','#F1F1F1');
			title.css('border-left','1px solid #F1F1F1');
			title.css('border-right','1px solid #F1F1F1');
			titleV.css("background-image","url(./skin/image/v-top-x.gif)");
			content.css('display','none');
		});
	});
}
function topBarLocation(){
	var location = $(".top-bar-location");
	var locationSelect = location.find(".top-bar-menu-title>b");
	var locationLi = location.find(".top-bar-menu-content>li");
	locationLi.each(function(){
		$(this).click(function(){
			$(this).siblings().each(function(){
				var a = $(this).find("a");
				a.css('color','#666666');
				a.css('background-color','#FFFFFF');
				a.hover(function(){
					$(this).css('color','#C81623');
					$(this).css('background-color','#F1F1F1');
				},function(){
					$(this).css('color','#666666');
					$(this).css('background-color','#FFFFFF');
				});
			});
			var a = $(this).find("a");
			a.css('color','#FFFFFF');
			a.css('background-color','#C81623');
			a.hover(function(){	},function(){
				$(this).css('color','#FFFFFF');
				$(this).css('background-color','#C81623');
			});
			locationSelect.text($(this).text());
		});
	});
}
function topBarSjjd(){
	$(".top-bar-sjjd").each(function(){
		var titleB = $(this).find(".top-bar-menu-title>b");
		$(this).hover(function(){
			titleB.css("background-image","url(./skin/image/sj-r.jpg)");
		},function(){
			titleB.css("background-image","url(./skin/image/sj-b.jpg)");
		});
	});
}
function headCart(){
	$(".head-cart").each(function(){
		var title = $(this).find(".head-cart-title");
		var ct = $(this).find(".head-cart-content");
		$(this).hover(function(){
			title.css("background-color","#FFFFFF");
			title.css("border-bottom","0");
			ct.css("display","block");
		},function(){
			title.css("background-color","#F9F9F9");
			title.css("border-bottom","1px solid #DDDDDD");
			ct.css("display","none");
		});
	});
}
function showClassifySort(){
	$(".show-category").each(function(){
		var sort = $(this).find(".show-classify-sort");
		var offsetTop = sort.offset().top;//到达页面顶部的高度
		var sortli = $(sort).find("li");
		var detail = $(this).find(".show-classify-detail");
		var detailli = $(detail).find("li");
		//
		$(sortli).each(function(i){
			var lia = $(this).find("a");
			var deqi = $(detailli).eq(i);
			$(this).hover(function(){
				$(this).css("width","210");
				$(this).css("color","#C81623");
				lia.css("color","#C81623");
				//
				var scrollTop = $(document.body).scrollTop();
				if(scrollTop>offsetTop){
					deqi.css("margin-top",scrollTop-offsetTop-1-465);
					deqi.css("border-top","1px solid #C81623");
				}
				deqi.css("display","block");
			},function(){
				$(this).css("width","209");
				$(this).css("color","#FFFFFF");
				lia.css("color","#FFFFFF");
				deqi.css("display","none");
				deqi.css("margin-top",-465);
				deqi.css("border-top","0");
			});
		});
		//
		$(detailli).each(function(i){
			var seqi = $(sortli).eq(i);
			var lia = $(seqi).find("a");
			$(this).hover(function(){
				var scrollTop = $(document.body).scrollTop();
				if(scrollTop>offsetTop){
					$(this).css("margin-top",scrollTop-offsetTop-1-465);
					$(this).css("border-top","1px solid #C81623");
				}
				$(this).css("display","block");
				seqi.css("width","210");
				seqi.css("background-color","#F7F7F7");
				seqi.css("color","#C81623");
				lia.css("color","#C81623");
			},function(){
				$(this).css("display","none");
				$(this).css("margin-top",-465);
				$(this).css("border-top","0");
				seqi.css("width","209");
				seqi.css("background-color","");
				seqi.css("color","#FFFFFF");
				lia.css("color","#FFFFFF");
			});
		});
	});
}
function showClassifyDetailContentRoute(){
	$(".show-classify-detail-content-route>a").each(function(){
		var i = $(this).find("i");
		$(this).hover(function(){
			$(this).css("background-color","#C81623");
			i.css("background-color","#B1191A");
		},function(){
			$(this).css("background-color","#7A706F");
			i.css("background-color","#58504E");
		});
	});
}
function showClassifyDetailContentListSpan(){
	$(".show-classify-detail-content-list>span>a").each(function(){
		var i = $(this).find("i");
		$(this).hover(function(){
			i.css("background-image","url(./skin/image/v-r-r.gif)");
		},function(){
			i.css("background-image","url(./skin/image/v-r-h.gif)");
		});
	});
}
function showInfoIco() {
	$(".show-info-ico").each(function() {
		var tInterval = null;
		var hInterval = null;
		var title = $(this).find(">p:first-child");
		var titleLi = title.find(">a");
		var hide = $(this).find(".show-info-ico-hide");
		var hideLi = hide.find(">div");
		var isOpened = false;
		var isClosing = false;
		titleLi.mouseover(function() {
			openHide();
		});
		var titleLiSpan = titleLi.find("span");
		titleLi.each(function(){
			var i = titleLi.index(this);
			$(this).mouseover(function(){
				titleLi.css("border-bottom-color","#E8E8E7");
				titleLiSpan.css("border-top-color","#FFFFFF");
				hideLi.hide();
				hideLi.eq(i).show();
				if(isOpened){
					titleLiSpan.eq(i).css("border-top-color","#C81623");
					$(this).css("border-bottom-color","#FFFFFF");
				}
			});
		});
		hideLi.find(">i").click(function(){
			closeHide();
		});
		//点击页面其他地方关闭
		$(document).bind('click', function(e) {
			var e = e || window.event; // 浏览器兼容性
			var elem = e.target || e.srcElement;
			while (elem) { // 循环判断至跟节点，防止点击的是div子元素
				if (elem.className && elem.className == 'show-info-ico') {
					return;
				}
				elem = elem.parentNode;
			}
			closeHide();
		});
		//展开
		function openHide(){
			if(!isClosing){
				isOpened = true;
				clearInterval(tInterval);
				tInterval = setInterval(function() {
					var marginTop = parseInt(title.css("margin-top").replace("px", ""));
					if (marginTop > -42) {
						marginTop--;
						title.css("margin-top", marginTop + "px");
					} else {
						clearInterval(tInterval);
					}
				}, 1);
				//
				clearInterval(hInterval);
				hInterval = setInterval(function() {
					var marginTop = parseInt(hide.css("margin-top").replace("px", ""));
					if (marginTop > -140) {
						marginTop -= 4;
						hide.css("margin-top", marginTop + "px");
					} else {
						clearInterval(hInterval);
					}
				}, 1);
			}
		}
		//关闭
		function closeHide(){
			isOpened = false;
			titleLi.css("border-bottom-color","#E8E8E7");
			titleLiSpan.css("border-top-color","#FFFFFF");
			//
			clearInterval(tInterval);
			isClosing = true;
			tInterval = setInterval(function() {
				var marginTop = parseInt(title.css("margin-top").replace("px", ""));
				if (marginTop < 0) {
					marginTop++;
					title.css("margin-top", marginTop + "px");
				} else {
					clearInterval(tInterval);
					itl = setInterval(function(){
						isClosing = false;
						clearInterval(itl);
					},400);
				}
			}, 1);
			//
			clearInterval(hInterval);
			hInterval = setInterval(function() {
				var marginTop = parseInt(hide.css("margin-top").replace("px", ""));
				if (marginTop < 0) {
					marginTop += 4;
					hide.css("margin-top", marginTop + "px");
				} else {
					clearInterval(hInterval);
				}
			}, 1);
		}
		$(".show-info-ico-hide>div").each(function() {
			var ali = $(this).find(">a");
			var pli = $(this).find(">p");
			ali.each(function() {
				var i = ali.index(this);
				$(this).mouseover(function(){
					ali.removeClass("aselect");
					$(this).addClass("aselect");
					//
					pli.removeClass("pselect");
					pli.eq(i).addClass("pselect");
				});
			});
		});
		$(".show-info-ico-hide .nb_hf").each(function(){
			var map = new Map();
			map.put('10元', '￥9.8-￥11.0');
			map.put('20元', '￥19.6-￥21.0');
			map.put('30元', '￥29.4-￥31.0');
			map.put('50元', '￥49.0-￥50.0');
			map.put('100元', '￥98.0-￥100.0');
			map.put('200元', '￥196.0-￥200.0');
			map.put('300元', '￥294.0-￥300.0');
			map.put('500元', '￥490.0-￥500.0');
			//
			var select = $(this).find(">span>select");
			var b = $(this).find(">span>b");
			b.text(map.get(select.val()));
			select.click(function(){
				b.text(map.get(select.val()));
			});
		});
		$(".show-info-ico-hide .nb_ll").each(function(){
			var map = new Map();
			map.put('50M', '￥7.5-￥10.0');
			map.put('100M', '￥9.95-￥20.0');
			map.put('200M', '￥19.9-￥20.5');
			map.put('300M', '￥29.0-￥29.9');
			map.put('500M', '￥49.0-￥50.0');
			//
			var select = $(this).find(">span>select").eq(1);
			var b = $(this).find(">span>b");
			b.text(map.get(select.val()));
			select.click(function(){
				b.text(map.get(select.val()));
			});
		});
		$(".show-info-ico-hide .huhuang").each(function(){
			$(this).click(function(){
				var pselect = $(this).prevAll("select").eq(0);
				var nselect = $(this).nextAll("select").eq(0);
				var tval = pselect.val();
				pselect.val(nselect.val());
				nselect.val(tval);
			});
		});
		$(".show-info-ico-hide .year").each(function(){
			var yearSelect = $(this);
			var moothSelect = $(this).nextAll(".mooth").eq(0);
			var dateSelect = $(this).nextAll(".date").eq(0);
			var adate = new Date();
			var year = adate.getFullYear();
			yearSelect.append("<option value='"+year+"' selected='selected'>"+year+"</option>");
			yearSelect.append("<option value='"+(year+1)+"'>"+(year+1)+"</option>");
			var mooth = adate.getMonth()+1;
			var i;
			for(i=mooth;i<13;++i){
				if(i==mooth){
					moothSelect.append("<option value='"+i+"' selected='selected'>"+i+"</option>");
				}else{
					moothSelect.append("<option value='"+i+"'>"+i+"</option>");
				}
			}
			var date = adate.getDate();
			var dateMax = getMaxDate(year,mooth);
			for(i=date;i<=dateMax;++i){
				if(i==date){
					dateSelect.append("<option value='"+i+"' selected='selected'>"+i+"</option>");
				}else{
					dateSelect.append("<option value='"+i+"'>"+i+"</option>");
				}
			}
			yearSelect.click(function(){
				var syear = yearSelect.val();
				moothSelect.children().remove();
				dateSelect.children().remove();
				if(syear!=year){
					for(i=1;i<13;++i){
						if(i==1){
							moothSelect.append("<option value='"+i+"' selected='selected'>"+i+"</option>");
						}else{
							moothSelect.append("<option value='"+i+"'>"+i+"</option>");
						}
					}
					for(i=1;i<=31;++i){
						if(i==1){
							dateSelect.append("<option value='"+i+"' selected='selected'>"+i+"</option>");
						}else{
							dateSelect.append("<option value='"+i+"'>"+i+"</option>");
						}
					}
				}else{
					for(i=mooth;i<13;++i){
						if(i==mooth){
							moothSelect.append("<option value='"+i+"' selected='selected'>"+i+"</option>");
						}else{
							moothSelect.append("<option value='"+i+"'>"+i+"</option>");
						}
					}
					dateMax = getMaxDate(year,mooth);
					for(i=date;i<=dateMax;++i){
						if(i==date){
							dateSelect.append("<option value='"+i+"' selected='selected'>"+i+"</option>");
						}else{
							dateSelect.append("<option value='"+i+"'>"+i+"</option>");
						}
					}
				}
			});
			moothSelect.click(function(){
				var syear = yearSelect.val();
				var smooth = moothSelect.val();
				if(syear!=year){
					dateSelect.children().remove();
					dateMax = getMaxDate(syear,smooth);
					for(i=1;i<=dateMax;++i){
						if(i==1){
							dateSelect.append("<option value='"+i+"' selected='selected'>"+i+"</option>");
						}else{
							dateSelect.append("<option value='"+i+"'>"+i+"</option>");
						}
					}
				}
			});
			function getMaxDate(year,mooth){
				var dateMax;
				if(mooth%2==1){
					dateMax = 31;
				}else if(mooth!=2){
					dateMax = 30;
				}else{
					if((year%4==0 && year%100!=0) || year%400==0){
						dateMax = 29;
					}else{
						dateMax = 28;
					}
				}
				return dateMax;
			}
		});
		$(".show-info-ico-hide .nb_gn input").each(function(){
			var i=0;
			$(this).click(function(){
				if(i%2==0){
					$(".show-info-ico-hide .nb_gn .fangcheng_date").css("display","block");
				}else{
					$(".show-info-ico-hide .nb_gn .fangcheng_date").css("display","none");
				}
				++i;
			});
		});
		$(".show-info-ico-hide .nb_gj input").each(function(){
			var i=0;
			$(this).click(function(){
				if(i%2==0){
					$(".show-info-ico-hide .nb_gj .fangcheng_date").css("display","block");
				}else{
					$(".show-info-ico-hide .nb_gj .fangcheng_date").css("display","none");
				}
				++i;
			});
		});
		$(".show-info-ico-hide .nb_dk").each(function(){
			var map = new Map();
			map.put('10元', '￥9.8-￥11.0');
			map.put('20元', '￥19.6-￥21.0');
			map.put('30元', '￥29.4-￥31.0');
			map.put('50元', '￥49.0-￥50.0');
			map.put('100元', '￥98.0-￥100.0');
			map.put('200元', '￥196.0-￥200.0');
			map.put('300元', '￥294.0-￥300.0');
			map.put('500元', '￥490.0-￥500.0');
			//
			var select = $(this).find(">span>.w_select");
			var b = $(this).find(">span>b");
			b.text(map.get(select.val()));
			select.click(function(){
				b.text(map.get(select.val()));
			});
		});
		$(".show-info-ico-hide .nb_qq").each(function(){
			var map = new Map();
			map.put('10元', '￥9.8-￥11.0');
			map.put('20元', '￥19.6-￥21.0');
			map.put('30元', '￥29.4-￥31.0');
			map.put('50元', '￥49.0-￥50.0');
			map.put('100元', '￥98.0-￥100.0');
			map.put('200元', '￥196.0-￥200.0');
			map.put('300元', '￥294.0-￥300.0');
			map.put('500元', '￥490.0-￥500.0');
			//
			var select = $(this).find(">span>.w_select");
			var b = $(this).find(">span>b");
			b.text(map.get(select.val()));
			select.click(function(){
				b.text(map.get(select.val()));
			});
		});
	});
}

function bannerTitleSwitch(){
	$(".banner-title-switch").each(function(){
		var alist = $(this).find(">a");
		var ilist = $(this).find(">i");
		
		var elelist = $(this).parent(".banner-title").parent().find(".banner-ele-switch>*");
		$(alist).each(function(){
			$(this).mouseover(function(){
				alist.removeClass('a_active');
				$(this).addClass('a_active');
				
				var i = $(alist).index(this);
				$(ilist).removeClass('i_active');
				$(ilist).eq(i).addClass('i_active');
				if(i!=0){
					$(ilist).eq(i-1).addClass('i_active');
				}
				
				elelist.removeClass("e_active");
				elelist.eq(i).addClass("e_active");
			});
		});
	});
}



