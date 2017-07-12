
/**
 * 后台展示消息
 * @param msg
 */
function showMsg(msg){
	if(!document.getElementById("msg-background")){
		init();
		//
		var msgClose = document.getElementById("msg-close");
		msgClose.onclick=function(){
			var msgBackground=document.getElementById("msg-background");
			var mgNextNode = nextNode(msgBackground);
			msgBackground.style.display="none";
			mgNextNode.style.marginTop="50px";
		}
	}
	document.getElementById("msg-content").innerHTML=msg;
	//
	var msgBackground=document.getElementById("msg-background");
	var mgNextNode = nextNode(msgBackground);
	mgNextNode.style.marginTop="80px";
	msgBackground.style.display="block";
	changeBackColor();
}

function changeBackColor(){
	var msgContent=document.getElementById("msg-content");
	var msgClose=document.getElementById("msg-close");
	var rgbHex = RGBToHex(msgContent.style.backgroundColor);
	if(rgbHex != "#FFFFCC"){
		msgContent.style.backgroundColor = "#FFFFCC";
		msgClose.style.backgroundColor = "#FFFFCC";
	}else{
		msgContent.style.backgroundColor = "#CCEED0";
		msgClose.style.backgroundColor = "#CCEED0";
	}
	
}
/**
 * js将rgb转换为css颜色格式(#ffffff)
 * @param rgb
 * @returns {String}
 */
function RGBToHex(rgb){ 
   var regexp = /[0-9]{0,3}/g;  
   var re = rgb.match(regexp);//利用正则表达式去掉多余的部分，将rgb中的数字提取
   var hexColor = "#"; var hex = ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'];  
   for (var i = 0; i < re.length; i++) {
        var r = null, c = re[i], l = c; 
        var hexAr = [];
        while (c > 16){  
              r = c % 16;  
              c = (c / 16) >> 0; 
              hexAr.push(hex[r]);  
         } hexAr.push(hex[c]);
         if(l < 16&&l != ""){        
             hexAr.push(0)
         }
       hexColor += hexAr.reverse().join(''); 
    }  
   return hexColor;  
}
/**
 * 动态创建消息div
 */
/*
本js动态创建的html如下:
<div id="msg-background" class="msg-background">
	<div id="msg-content" class="msg-content"></div>
	<div id="msg-close" class="msg-close"></div>
</div>
*/
function init(){
	var msgBackground = document.createElement("div");
	msgBackground.id="msg-background";
	msgBackground.className="msg-background";
	//
	var msgContent = document.createElement("div");
	msgContent.id="msg-content";
	msgContent.className="msg-content";
	msgBackground.appendChild(msgContent); 
	//
	var msgClose = document.createElement("div");
	msgClose.id="msg-close";
	msgClose.className="msg-close";
	msgBackground.appendChild(msgClose); 
	//
	msgBackground.style.display="none";
	document.body.insertBefore(msgBackground,document.body.firstChild);
	
}
/**
 * 获取当前节点的下一个兄弟元素节点
 */
function nextNode(elem) {
    do {
        elem = elem.nextSibling;
    } while (elem && elem.nodeType != 1);
    return elem;
}
