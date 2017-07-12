/*
 * 首页js文件
 */
/**
 * 顶部搜索处理函数
 */
function topSearch(){
	//顶部搜索范围处理
	var searchRange = document.getElementById("top-search-range");
	var lis=searchRange.getElementsByTagName("li");
	var rangeValue=document.getElementById("top-range-value");
	//
	searchRange.onmouseover=function(){
		for(var i=1;i<lis.length;++i)lis[i].style.display="block"; 
	}
	searchRange.onmouseout=function(){
		for(var i=1;i<lis.length;++i)lis[i].style.display="none"; 
	}
	//
	rangeValue.value=lis[0].innerHTML;
	for(var i=0;i<lis.length;++i){
		lis[i].index=i;
		lis[i].onclick=function(){
			if(this.index!=0){
				var html=lis[0].innerHTML;
				lis[0].innerHTML=this.innerHTML;
				this.innerHTML=html;
				//
				rangeValue.value=lis[0].innerHTML;
			}
		}
	}
	//滚动显示隐藏顶部搜索栏
	$(window).scroll(function(){ 
	    var scrollTop=$(window).scrollTop();
	    var topSearch = document.getElementById("top-search");
	    if(scrollTop>100)topSearch.style.display="block";
	    else topSearch.style.display="none";
	});
	 var scrollTop=$(window).scrollTop();
	 var topSearch = document.getElementById("top-search");
	 if(scrollTop>100)topSearch.style.display="block";
	 else topSearch.style.display="none";
}

/**
 * 头部搜索处理函数
 */
function headSearch(){
	//头部搜索处理函数
	var searchRange = document.getElementById("head-search-range");
	var lis=searchRange.getElementsByTagName("li");
	var rangeValue=document.getElementById("head-range-value");
	//
	rangeValue.value=lis[0].innerHTML;
	for(var i=0;i<lis.length;++i){
		lis[i].onclick=function(){
			for(var j=0;j<lis.length;++j)lis[j].className="noselected";
			//
			this.className="selected";
			rangeValue.value=this.innerHTML;
		}
	}
}
/**
 * 带"标题"的div模拟的下拉框js处理函数
 */
function titleSelect(){
	var titleSelects=document.getElementsByClassName("titleSelect");
	for(var i=0;i<titleSelects.length;++i){
		var titleSelect=titleSelects[i];
		titleSelect.onmouseover=function(){
			var select_title=this.getElementsByClassName("titleSelect-title")[0];
			select_title.style.backgroundColor = "#FFFFFF";
			select_title.style.borderLeftColor = "#EDE6E6";
			select_title.style.borderRightColor = "#EDE6E6";
			//
			var select_content=this.getElementsByClassName("titleSelect-content")[0];
			select_content.style.display="block";
		}
		titleSelect.onmouseout=function(){
			var select_title=this.getElementsByClassName("titleSelect-title")[0];
			select_title.style.backgroundColor = "#F5F5F5";
			select_title.style.borderLeftColor = "#F5F5F5";
			select_title.style.borderRightColor = "#F5F5F5";
			//
			var select_content=this.getElementsByClassName("titleSelect-content")[0];
			select_content.style.display="none";
		}
	}
	
	favoriteTitleImg();
}
/**
 * 收藏夹图标更换
 */
function favoriteTitleImg(){
	var topBarFavorite = document.getElementById("top-bar-favorite");
	var title = topBarFavorite.getElementsByClassName("titleSelect-title")[0];
	var atag=title.getElementsByTagName("a")[0];
	var favoriteTitleImg = topBarFavorite.getElementsByClassName("title-prefixImg")[0];
	
	atag.onmouseover=function(){
		favoriteTitleImg.style.backgroundImage="url(./skin/images/fiveStar-r.gif)";
	}
	atag.onmouseout=function(){
		favoriteTitleImg.style.backgroundImage="url(./skin/images/fiveStar-b.gif)";
	}
	
}
function discoverContentCargobuttom(){
	var cargolist = document.getElementsByClassName("discover-content-cargolist");
	var cargobuttom = document.getElementsByClassName("discover-content-cargobuttom");
	for(var i=0; i<cargolist.length; ++i){
		cargolist[i].index = i;
		cargolist[i].onmouseover = function(){
			cargobuttom[this.index].style.display='block';
		}
		cargolist[i].onmouseout = function(){
			cargobuttom[this.index].style.display='none';
		}
		cargobuttom[i].onmouseover = function(){
			this.style.display='block';
		}
		cargobuttom[i].onmouseout = function(){
			this.style.display='none';
		}
	}
}
function discoverContentGatherlist(){
	var gatherlist = document.getElementsByClassName("discover-content-gatherlist");
	for(var i=0; i<gatherlist.length; ++i){
		var aele = gatherlist[i].getElementsByTagName("a");
		for(var ii=0; ii<aele.length; ++ii){
			aele[ii].onmouseover = function(){
				this.getElementsByTagName("img")[0].style.display='none';
				this.getElementsByTagName("span")[0].style.display='block';
			}
			aele[ii].onmouseout = function(){
				this.getElementsByTagName("img")[0].style.display='block';
				this.getElementsByTagName("span")[0].style.display='none';
			}
		}
	}
}
function discoverContentChange(){
	var change = document.getElementsByClassName("discover-content-change");
	for(var i=0; i<change.length; ++i){
		change[i].onmouseover = function(){
			this.getElementsByTagName("i")[0].style.backgroundImage="url(./skin/images/hsh.png)";
		}
		change[i].onmouseout = function(){
			this.getElementsByTagName("i")[0].style.backgroundImage="url(./skin/images/hsb.png)";
		}
	}
}
function discoverContentShoplist(){
	var shoplist = document.getElementsByClassName("discover-content-shoplist");
	for(var i=0; i<shoplist.length; ++i){
		shoplist[i].onmouseover = function(){
			this.getElementsByTagName("a")[0].style.color="#FF4400";
		}
		shoplist[i].onmouseout = function(){
			this.getElementsByTagName("a")[0].style.color="#605C5C";
		}
	}
}
function trademarkCellBigimg(){
	var bigimg = document.getElementsByClassName("color-red-tag");
	for(var i=0; i<bigimg.length; ++i){
		bigimg[i].onmouseover = function(){
			this.getElementsByClassName("color-red-tag-font")[0].style.color="#FF4400";
		}
		bigimg[i].onmouseout = function(){
			this.getElementsByClassName("color-red-tag-font")[0].style.color="#0F0F0F";
		}
	}
}