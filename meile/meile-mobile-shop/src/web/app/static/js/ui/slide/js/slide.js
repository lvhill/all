/**
 * html元素动态切换, 需要 jquery 支持
 * (1) element: 要动态切换的元素, 为jquery对象, 不支持原生 js 对象
 * (2) slideType: 动态切换的类型, 有 fade、level 和 vertical 三种切换类型, 分别表示 淡入淡出切换、水平滑动切换 和 垂直滚动切换, 默认淡入淡出切换
 * (3) frequency: 自动切换的频率(毫秒/次), 接受 null、'' 和 纯数字输入, 默认是 4000
 * (4) speed: 切换的速度, 完成一次切换需要的时间, 单位毫秒. 接受 null、'' 和 纯数字输入, 默认是 500
 * 
 * 示例：
 * 
 * <div id="example" class="slide" style="width: 400px; height: 250px;">
 *     <ul class="slide-list">
 *         <li><img src="/1.jpg"/></li>
 *         <li><img src="/2.jpg"/></li>
 *         <li><img src="/3.jpg"/></li>
 *         <li><img src="/4.jpg"/></li>
 *         <li><img src="/5.jpg"/></li>
 *         <li><img src="/6.jpg"/></li>
 *     </ul>
 *     <p class="slide-prev"></p>
 *     <p class="slide-next"></p>
 * 	<div class="slide-dot">
 * 		<p>
 * 			<b>1</b>
 * 			<b>2</b>
 * 			<b>3</b>
 * 			<b>4</b>
 * 			<b>5</b>
 * 			<b>6</b>
 * 		</p>
 * 	</div>
 * </div>
 * 
 * 默认切换方式:
 * 		new Slide($("#example"));
 * 淡入淡出切换:
 * 		new Slide($("#example"), 'fade');
 * 		或者
 * 		new Slide($("#example"), 'f');
 * 水平滑动切换:
 * 		new Slide($("#example"), 'level');
 * 		或者
 * 		new Slide($("#example"), 'l');
 * 垂直滚动切换:
 * 		new Slide($("#example"), 'vertical');
 * 		或者
 * 		new Slide($("#example"), 'v');
 * 
 */
function Slide(element, slideType, frequency, speed) {
	this.slide = element;
	this.sum = this.slide.find('.slide-list>li').length;
	this.index = 0;
	this.interval = null;
	this.isAnimateFinished = true;
	this.slideType = slideType;
	this.frequency = frequency;
	this.speed = speed;
	
	if(this.frequency==null || this.frequency=='' || isNaN(this.frequency)){
		this.frequency = 4000;
	}
	if(this.speed==null || this.speed=='' || isNaN(this.speed)){
		this.speed = 500;
	}
	//
	switch(this.slideType){
	case 'level':
	case 'l':
		this.slideType = 'level';
		this.level();
		break;
	case 'vertical':
	case 'v':
		this.slideType = 'vertical';
		this.vertical();
		break;
	default: 
		this.slideType = 'fade';
		this.fade();
		break;
	}
	
}
Slide.prototype = {
	/**
	 * 根据slde的高度和宽度动态调整其他元素的高度,宽度和位置等css样式
	 */
	cssAdjust: function(){
		var width = this.slide.width();
		var height = this.slide.height();
		this.slide.find(".slide-list li").width(width);
		this.slide.find(".slide-list li").height(height);
		//设置小圆点水平居中
		var bw = this.slide.find(".slide-dot b").width();
		var bm;
		var ml = this.slide.find(".slide-dot b").css("margin-left");
		if(ml!=null&&ml!=""){
			bm = parseInt(ml.replace("px",""))
		}
		var pw = (bw+bm)*this.sum+bm;
		if(this.slideType == 'level' || this.slideType == 'vertical' ){
			pw = (bw+bm)*(this.sum - 2)+bm;
		}
		this.slide.find(".slide-dot p").width(pw);
		//设置左右切换按钮垂直居中
		var bh = this.slide.find(".slide-prev").height();
		var top = Math.ceil((height-bh)/2);//向上取整,有小数就整数部分加1
		this.slide.find(".slide-prev").css("top",top);
		this.slide.find(".slide-next").css("top",top);
	},
	/**
	 * 图片淡入淡出轮番
	 */
	fade: function(){
		var _this = this;
		init();
		
		/*
		 * 初始化
		 */
		function init(){
			_this.slide.addClass("fadeSlide");
			_this.cssAdjust();//css调整
			
			// 页面加载隐藏所有的li 除了第一个
			_this.slide.find('.slide-list li:gt(0)').hide();
			_this.slide.find('.slide-dot>p>b').first().addClass('slide-dot-select');
			
			// 左边箭头点击时切换
			_this.slide.find('.slide-prev').click(function() {
				prev();
			});

			// 右边箭头点击时切换
			_this.slide.find('.slide-next').click(function() {
				next()
			});

			// 鼠标移动到幻灯片上时,停止播放和显示左右切换按钮
			_this.slide.mouseover(function() {
				_this.slide.find('.slide-prev').show();
				_this.slide.find('.slide-next').show();
				clearInterval(_this.interval);
			});

			// 鼠标离开幻灯片上时, 开启定时播放和隐藏左右切换按钮
			_this.slide.mouseout(function() {
				_this.slide.find('.slide-prev').hide();
				_this.slide.find('.slide-next').hide();
				autoPlay();
			});
			
			// 底下小图标点击切换
			_this.slide.find('.slide-dot b').mouseover(function() {
				var i = _this.slide.find('.slide-dot b').index(this)
				show(i);
			});
			
			// 开始自动播放
			autoPlay();
		}
		/*
		 * 自动播放
		 */
		function autoPlay() {
			_this.interval = setInterval(function() {
				next();
			}, _this.frequency);
		}
		/*
		 * 第i个li元素淡入淡出
		 */
		function show(i){
			_this.slide.find('.slide-dot b').eq(i).addClass('slide-dot-select').siblings('b').removeClass('slide-dot-select');
			_this.slide.find('.slide-list li').eq(i).fadeIn(_this.speed).siblings('li').fadeOut(_this.speed);
			_this.index = i;
		}
		/*
		 * 上一个li元素淡入淡出
		 */
		function prev(){
			if (_this.index == 0) {
				_this.index = _this.sum
			}
			// 大图切换
			_this.slide.find('.slide-list li').eq(_this.index - 1).fadeIn(_this.speed).siblings('li').fadeOut(_this.speed);
			// 小图切换
			_this.slide.find('.slide-dot b').eq(_this.index - 1).addClass('slide-dot-select').siblings('b').removeClass('slide-dot-select');
			_this.index--;
		}
		/*
		 * 下一个li元素淡入淡出
		 */
		function next() {
			if (_this.index == _this.sum - 1) {
				_this.index = -1
			}
			// 大图切换
			_this.slide.find('.slide-list li').eq(_this.index + 1).fadeIn(_this.speed).siblings('li').fadeOut(_this.speed);
			// 小图切换
			_this.slide.find('.slide-dot b').eq(_this.index + 1).addClass('slide-dot-select').siblings('b').removeClass('slide-dot-select');
			_this.index++;
		}
	},
	/**
	 * 水平滑动
	 */
	level: function(){
		var _this = this;
		init();
		/*
		 * 初始化
		 */
		function init(){
			_this.slide.addClass("levelSlide");
			creatEle();
			_this.cssAdjust();//css调整
			
			// 鼠标移动到幻灯片上时,停止播放和显示左右切换按钮
			_this.slide.mouseover(function() {
				_this.slide.find('.slide-prev').show();
				_this.slide.find('.slide-next').show();
				clearInterval(_this.interval);
			});

			// 鼠标离开幻灯片上时, 开启定时播放和隐藏左右切换按钮
			_this.slide.mouseout(function() {
				_this.slide.find('.slide-prev').hide();
				_this.slide.find('.slide-next').hide();
				autoPlay();
			});
			
			// 底下小图标点击切换
			_this.slide.find('.slide-dot b').mouseover(function() {
				_this.index = _this.slide.find('.slide-dot b').index(this)
				show(_this.index);
			});
			
			//左切换按钮
			_this.slide.find('.slide-prev').click(function() {
				prev();
			});
		
			//右切换按钮
			_this.slide.find('.slide-next').click(function() {
				next();
			});
			
			//
			autoPlay();
		}
		/*
		 * 动态创建html元素
		 */
		function creatEle(){
			var slideList = _this.slide.find('.slide-list');
			var fc = slideList.find('li:first-child');
			var lc = slideList.find('li:last-child');
			slideList.append('<li>'+fc.html()+'</li>');
			slideList.prepend('<li>'+lc.html()+'</li>');
			//
			var slideDotP = _this.slide.find(".slide-dot>p");
			var dot="<b style='display: none;'></b>";
			slideDotP.prepend(dot);
			slideDotP.append(dot);
			//调整css
			_this.sum = slideList.find("li").length; //设置总个数
			slideList.width(_this.slide.width()*_this.sum);
			//
			_this.index = 1;
			slideList.css('left',- _this.slide.width());
			_this.slide.find('.slide-dot>p>b').eq(1).addClass('slide-dot-select');
		}
		function autoPlay(){
			_this.interval = setInterval(function() {
				next();
			},_this.frequency); //此4000代表自动播放的间隔，单位：毫秒
		}
		/*
		 * 滑动显示下一个li元素
		 */
		function next(){
			if(_this.isAnimateFinished){
				++ _this.index;
				if(_this.index == _this.sum) {_this.index = 0;}
				show(_this.index);
			}
		}
		/*
		 * 滑动显示上一个li元素
		 */
		function prev(){
			if(_this.isAnimateFinished){
				-- _this.index;
				if(_this.index == -1) {_this.index = _this.sum - 1;}
				show(_this.index);
			}
		}
		/*
		 * 滑动显示第index个li元素
		 */
		function show(index) { //普通切换
			if(_this.isAnimateFinished){
				_this.isAnimateFinished = false;
				var width = _this.slide.width();
				var nowLeft = - index * width; //根据index值计算ul元素的left值
				var slideList = _this.slide.find(".slide-list");
				
				//通过animate()调整ul元素滚动到计算出的position
				slideList.stop(true,false).animate({"left":nowLeft},_this.speed,function(){
					switch (index) {
					case 0:
						_this.index = _this.sum-2;
						slideList.css('left',- _this.index * width);
						break;
					case _this.sum-1:
						_this.index = 1;
						slideList.css('left',- _this.index * width);
						break;
					default:
						break;
					}
					_this.isAnimateFinished = true;
				}); 
				switch(index){
					case 0: 
						_this.slide.find('.slide-dot b').eq(_this.sum-2).addClass('slide-dot-select').siblings('b').removeClass('slide-dot-select');
					break;
					case _this.sum-1:
						_this.slide.find('.slide-dot b').eq(1).addClass('slide-dot-select').siblings('b').removeClass('slide-dot-select');
					break;
					default: _this.slide.find('.slide-dot b').eq(index).addClass('slide-dot-select').siblings('b').removeClass('slide-dot-select');
					break;
				}
			}
		}
	},
	/**
	 * 垂直滑动
	 */
	vertical: function(){
		var _this = this;
		init();
		/*
		 * 初始化
		 */
		function init(){
			_this.slide.addClass("verticalSlide");
			creatEle();
			_this.cssAdjust();//css调整
			
			// 鼠标移动到幻灯片上时,停止播放和显示左右切换按钮
			_this.slide.mouseover(function() {
				_this.slide.find('.slide-prev').show();
				_this.slide.find('.slide-next').show();
				clearInterval(_this.interval);
			});

			// 鼠标离开幻灯片上时, 开启定时播放和隐藏左右切换按钮
			_this.slide.mouseout(function() {
				_this.slide.find('.slide-prev').hide();
				_this.slide.find('.slide-next').hide();
				autoPlay();
			});
			
			// 底下小图标点击切换
			_this.slide.find('.slide-dot b').mouseover(function() {
				_this.index = _this.slide.find('.slide-dot b').index(this)
				show(_this.index);
			});
			
			//左切换按钮
			_this.slide.find('.slide-prev').click(function() {
				prev();
			});
		
			//右切换按钮
			_this.slide.find('.slide-next').click(function() {
				next();
			});
			
			//
			autoPlay();
		}
		/*
		 * 动态创建html元素
		 */
		function creatEle(){
			var slideList = _this.slide.find('.slide-list');
			var fc = slideList.find('li:first-child');
			var lc = slideList.find('li:last-child');
			slideList.append('<li>'+fc.html()+'</li>');
			slideList.prepend('<li>'+lc.html()+'</li>');
			//
			var slideDotP = _this.slide.find(".slide-dot>p");
			var dot="<b style='display: none;'></b>";
			slideDotP.prepend(dot);
			slideDotP.append(dot);
			//调整css
			_this.sum = slideList.find("li").length; //设置总个数
			//
			_this.index = 1;
			slideList.css('top',- _this.slide.height()*(_this.sum - 1 - _this.index));
			_this.slide.find('.slide-dot>p>b').eq(1).addClass('slide-dot-select');
		}
		function autoPlay(){
			_this.interval = setInterval(function() {
				next();
			},_this.frequency); //此4000代表自动播放的间隔，单位：毫秒
		}
		/*
		 * 滑动显示下一个li元素
		 */
		function next(){
			if(_this.isAnimateFinished){
				++ _this.index;
				if(_this.index == _this.sum) {_this.index = 0;}
				show(_this.index);
			}
		}
		/*
		 * 滑动显示上一个li元素
		 */
		function prev(){
			if(_this.isAnimateFinished){
				-- _this.index;
				if(_this.index == -1) {_this.index = _this.sum - 2;}
				show(_this.index);
			}
		}
		/*
		 * 滑动显示第index个li元素
		 */
		function show(index) { //普通切换
			if(_this.isAnimateFinished){
				_this.isAnimateFinished = false;
				var height = _this.slide.height();
				var nowTop = - (_this.sum - 1 - index) * height; //根据index值计算ul元素的top值
				var slideList = _this.slide.find(".slide-list");
				
				//通过animate()调整ul元素滚动到计算出的position
				slideList.stop(true,false).animate({"top":nowTop},_this.speed,function(){
					switch (index) {
					case 0:
						_this.index = _this.sum-2;
						slideList.css('top',- height);
						break;
					case _this.sum-1:
						_this.index = 1;
						slideList.css('top',- (_this.sum - 1 - _this.index) * height);
						break;
					default:
						break;
					}
					_this.isAnimateFinished = true;
				}); 
				switch(index){
					case 0: 
						_this.slide.find('.slide-dot b').eq(_this.sum-2).addClass('slide-dot-select').siblings('b').removeClass('slide-dot-select');
					break;
					case _this.sum-1:
						_this.slide.find('.slide-dot b').eq(1).addClass('slide-dot-select').siblings('b').removeClass('slide-dot-select');
					break;
					default: _this.slide.find('.slide-dot b').eq(index).addClass('slide-dot-select').siblings('b').removeClass('slide-dot-select');
					break;
				}
			}
		}
	},
	
	
}