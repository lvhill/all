/**
 * (1)element : slide div (注意element必须是jquery查询得到的对象,非原生js查询得到的对象)
 * (2)frequency : 图片自动翻转的时间间隔, 默认5000毫秒
 * (3)speed : 图片一次从开始滚动到停止所用时间, 默认500毫秒
 */
function Slide(element,frequency,speed){
	if(element.length > 0){//元素是否存在
		this.element = element;
		this.sWidth = element.width(); //获取焦点图的宽度（显示面积）
		this.len = 0; //轮番图个数
		this.index = 1;
		this.picTimer;
		this.isAnimateFinished = true; //之前的动画是否已经执行完
		this.frequency = frequency;
		this.speed = speed;
		this.slideImg = element.find(".slide-img");
		this.slideSpot = element.find(".slide-spot");
		var _this = this;
		
		_this._init();
		
		//为小按钮添加鼠标滑入事件，以显示相应的内容
		_this.slideSpot.find("li").mouseenter(function() {
			_this.index = _this.slideSpot.find("li").index(this);
			_this._showPics(_this.index);
		}).eq(_this.index).trigger("mouseenter");
	
		//上一页按钮
		_this.element.find(".prev").click(function() {
			_this._prev();
		});
	
		//下一页按钮
		_this.element.find(".next").click(function() {
			_this._next();
		});
	
		//鼠标滑上焦点图时停止自动播放，滑出时开始自动播放
		_this.element.hover(function() {
			clearInterval(_this.picTimer);
			_this.element.find(".slide-arrows").css('display','block');
		},function() {
			_this.picTimer = setInterval(function() {
				_this._next();
			},_this.frequency); //此4000代表自动播放的间隔，单位：毫秒
			_this.element.find(".slide-arrows").css('display','none');
		}).trigger("mouseleave");
	}
}
Slide.prototype = {
	_init : function init(){
		var _this = this;
		if(_this.frequency == null)_this.frequency=5000;
		if(_this.speed == null)_this.speed=500;
		_this._creatEle();
		_this.slideImg.css("width",_this.sWidth * (_this.len));
		_this.slideImg.css("left",-_this.sWidth);
	},
	//动态创建html元素
	_creatEle : function creatEle(){
		var _this = this;
		var fc = _this.slideImg.find('li:first-child');
		var lc = _this.slideImg.find('li:last-child');
		_this.slideImg.append('<li>'+fc.html()+'</li>');
		_this.slideImg.prepend('<li>'+lc.html()+'</li>');
		_this.len = _this.slideImg.find("li").length; //设置轮番图个数
		
		var slide_li="<li style='display: none;'></li>";
		slide_li += "<li class='active'><span></span></li>";
        for(var i= 1;i<_this.len-2;i++){
        	slide_li+="<li><span></span></li>";
        }
        slide_li +="<li style='display: none;'></li>";
        _this.slideSpot.append(slide_li);
        
        var center = (this.sWidth-_this.slideSpot.width())/2;
        _this.slideSpot.css('left',center);
        
	},
	//下一个图片
	_next : function next(){
		if(this.isAnimateFinished){
			var _this = this;
			++ _this.index;
			if(_this.index == _this.len) {_this.index = 0;}
			_this._showPics(_this.index);
		}
	},
	
	//前一个图片
	_prev : function prev(){
		if(this.isAnimateFinished){
			var _this = this;
			-- _this.index;
			if(_this.index == -1) {_this.index = _this.len - 1;}
			_this._showPics(_this.index);
		}
	},
	
	//显示图片函数，根据接收的index值显示相应的内容
	_showPics : function showPics(index) { //普通切换
		if(this.isAnimateFinished){
			this.isAnimateFinished = false;
			var _this = this;
			var nowLeft = -index*_this.sWidth; //根据index值计算ul元素的left值
			
			//通过animate()调整ul元素滚动到计算出的position
			_this.slideImg.stop(true,false).animate({"left":nowLeft},_this.speed,function(){
				switch (index) {
				case 0:
					_this.index = _this.len-2;
					_this.slideImg.css('left',- _this.index*_this.sWidth);
					break;
				case _this.len-1:
					_this.index = 1;
					_this.slideImg.css('left',- _this.index*_this.sWidth);
					break;
				default:
					break;
				}
				_this.isAnimateFinished = true;
			}); 
			switch(index){
				case 0: _this._cssActive(_this.len-2);
				break;
				case _this.len-1: _this._cssActive(1);
				break;
				default: _this._cssActive(index);
				break;
			}
		}
	},
	_cssActive : function cssActive(index){
		var _this = this;
		//为当前的按钮切换到选中的效果
		var li = _this.slideSpot.find("li");
		li.removeClass('active');
		li.eq(index).addClass('active');
	}
}