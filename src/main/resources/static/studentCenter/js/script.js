/*这是总的js 存放处*/

// footer
var frontPage = angular.module("frontPage", []);
frontPage.controller("footer", function($scope) {
	$scope.footerTitle = ["友情链接"];
	$scope.footerOne = ["学校概况", "院系设置", "师资队伍", "教育教学", "科学研究", "学生生活", "交流合作", "招生就业"];
	$scope.footerTwo = ["教育捐赠", "党群园地", "迎新网", "人才招聘", "公共服务", "通知公告", "新闻动态", "信息公开"];
});

// header
frontPage.controller("header", function($scope) {
	$scope.headerItems = ["首页", "日常事务", "资源下载"];
	$scope.headerSrc = ["headerItems-function.svg", "headerItems-notification.svg", "headerProfile.svg"];
	$scope.clicked1 = true;
	$scope.clicked2 = false;
	$scope.clicked3 = false;
	$scope.headerItemsClicked1 = function() {
		$scope.clicked1 = true;
		$scope.clicked2 = false;
		$scope.clicked3 = false;
	}
	$scope.headerItemsClicked2 = function() {
		$scope.clicked1 = false;
		$scope.clicked2 = true;
		$scope.clicked3 = false;
	}
	$scope.headerItemsClicked3 = function() {
		$scope.clicked1 = false;
		$scope.clicked2 = false;
		$scope.clicked3 = true;
	}
});
//login
var login = angular.module("login", []);
login.controller("login", function($scope) {

});

//home page
var person = angular.module("person", []);
person.controller("navLeft", function($scope) {
	//	$scope.navItems = ["搜索", "签证", "毕业", "贷款", "日常", "国际", "测试", "更多"];
	$scope.navItems = ["搜索", "提醒", "事务", "日常", "更多"];
	//	$scope.navIcons = ["img/navLeft/navLeft-ss.svg", "img/navLeft/navLeft-qz.svg", "img/navLeft/navLeft-by.svg", "img/navLeft/navLeft-dk.svg", "img/navLeft/navLeft-rc.svg", "img/navLeft/navLeft-gj.svg", "img/navLeft/navLeft-gd.svg", "img/navLeft/navLeft-bq.svg"];
	//	$scope.navIcons = ["img/navLeft/navLeft-ss.svg","img/navLeft/navLeft-tx-tx.svg","img/navLeft/navLeft-grsw.svg","img/navLeft/navLeft-rc.svg","img/navLeft/navLeft-gd.svg"];
	$scope.navIcons = ["ion-ios-search", "ion-ios-bell-outline", "ion-ios-copy-outline", "ion-ios-calendar-outline", "ion-ios-more-outline"]
	$scope.sign = "标签";
	$scope.signIcons = "ion-ios-pricetag-outline";
	$scope.subs = ["主页", "提醒", "设置", "标签", "帮助", "文章", "退出"];
	$scope.subIcons = ["ion-ios-home-outline", "ion-ios-lightbulb-outline", "ion-ios-gear-outline", "ion-ios-pricetag-outline", "ion-ios-help-outline", "ion-ios-book-outline", "ion-log-out"];
	$scope.subsubs = ["asda", "adf", "asdc", "wd", "dskjf", "lkmkn", "ow"];
	$scope.test = [
		["sjdhge", "iux", "ebc", "uehr", "chs", "kcjn", "xjs"],
		["asda", "adf", "asdc", "wd", "dskjf", "lkmkn", "ow"]
	]; //这里放三级菜单的东西

	//左边导航栏动态改变宽度
	$(document).ready(function() {
		//设置高度函数
		function setHeight(x, y, z) {
			var items = $(x).children().length; //个数
			var height = $(x).css("height"); //导航栏高度
			var perHeight = parseFloat(parseInt(height) / (parseInt(items) * parseFloat(z)));
			perHeight += "px";
			$(y).css("height", perHeight); //设置高度
		}
		//设置位置的函数
		function setPos(x, y, z) {
			$(x).animate({
				"left": y,
				"top": z
			}, "3500");
		}
		var trianglePosLeft = $(".navLeft").css("width");
		trianglePosLeft = parseFloat(trianglePosLeft) + 1;
		trianglePosLeft += "px";
		var trianglePosTop = $(".personIcons").css("padding-top");
		trianglePosTop = (parseFloat(trianglePosTop) + parseFloat($(".personIcons").css("width"))) / 4;
		trianglePosTop += "px";
		var hideDivLeft = parseFloat(trianglePosLeft) + parseFloat($(".triangle").css("border-right"));
		hideDivLeft += "px";
		//点击头像后出现
		$(".personIcons").click(function() {
			//先检查是否已经出现了
			var checkPos = $(".hideDiv").css("left");
			if(parseInt(checkPos) > 0) {
				setPos(".triangle", 0, 0);
				setPos(".hideDiv", "-500px", 0);
			} else {
				setPos(".triangle", trianglePosLeft, trianglePosTop);
				setPos(".hideDiv", hideDivLeft, 0);
			}

		});
		//将鼠标悬浮二级菜单上
		$(".subItems").mouseover(function() {
			var hideSubDiv = parseFloat($(".hideDiv").css("left")) + parseFloat($(".hideDiv").css("width")) + 2;
			hideSubDiv += "px";
			var index = $(this).attr("mark"); //获得这是第几个
			//得到这是第几个按键
			$scope.subsubs = $scope.test[parseInt(index)];
			$(this).css({
				"background-color": "#2E190B",
				"color": "white"
			}); //把这行颜色变色
			//先判断是否有三级菜单这东西
			if($scope.subsubs != null) {
				var topPos = parseInt(index) * parseFloat($(".subItems").css("height")) + parseFloat($(".hideDiv").css("padding-top")) / 3;
				topPos += "px";
				$(".hideSubDive").css({
					"left": hideSubDiv,
					"top": topPos
				});
				$scope.$apply(); //强行刷新
				$(".subSubItems").eq(0).css({
					"background-color": "#2E190B",
					"color": "white"
				}); //三级菜单第一行变色
			} else {
				$(".hideSubDive").css({
					"left": "-500px",
					"top": "0"
				});
			}
		});
		//离开二级菜单
		$(".subItems").mouseout(function() {
				$(this).css({
					"background-color": "white",
					"color": "#3E2311"
				});
				//悬浮在三级菜单
				$(".subSubItems").mouseover(function() {
					$(".subSubItems").eq(0).css({
						"background-color": "white",
						"color": "#3E2311"
					});
					$(this).css({
						"background-color": "#2E190B",
						"color": "white"
					}); //把这行颜色变色
				});
				//离开三级菜单
				$(".subSubItems").mouseout(function() {
					$(this).css({
						"background-color": "white",
						"color": "#3E2311"
					});
				})
			})
			//点击空白地方消失
		$("body").click(function() {
			$(".hideDiv").css({
				"left": "-500px",
				"top": "0"
			});
			$(".triangle").css({
				"left": "0",
				"top": "0"
			})
			$(".hideSubDive").css({
				"left": "-500px",
				"top": "0"
			});
		})
		setHeight(".navList", ".navItems", 1.55);
		setHeight(".hideDiv", ".subItems", 1.1);
		setHeight(".hideSubDive", ".subSubItems", 0.97);
	});
});
//内容 controller
person.controller("content", function($scope) {
	$scope.subtitles = ["全部会话", "系统消息"];
	$scope.name = ["张文轩", "邱柏森", "王林", "周兴友"];
	$scope.touxiang = ["img/test.svg", "img/test.svg", "img/test.svg", "img/test.svg"];
	$scope.textTitle = ["该吃药了", "拿钱啦", "DDL 快到啦", "药不能停啊"];
	$scope.texts = ["利用磁层上不同方向的磁化区域表示信息,容量大,非破坏性读出,长期保存信息,速度慢,外存", "利用光斑的有无/晶相等变化表示信息,容量很大, 非破坏性读出,长期保存信息,速度慢,外存", "访问时读/写部件按顺序查找目标地址,访问时间与数据的存储位置有关", "按地址访问存储器中的任一单元,访问时间与存储单 元的地址无"];
	$scope.dates = ["16/2/4", "16/3/5", "16/7/2", "16/4/2"];
});

//导师
person.controller("tutor", function($scope) {
	$scope.stepName = ["导师一览", "导师选择", "结果反馈"];
	$scope.stepNumber = ["1", "2", "3"];
	$scope.teacherIndex = ["A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"];
	$scope.selected = ["陈十一", "张贤科", "骆宗伟", "张进", "王婷", "姚新"];
	$scope.department = ["公共基础", "未知"];

	$(document).ready(function() {
		//判断现在是在第几步
		var step = new Array();
		step = $(".teacher-nav").next().attr("class");
		alert(step);
		debugger;
		var indexs = parseInt(step[9]) - 1;
		var stepNumber = ".stepNumber-" + indexs;
		var stepLine = ".stepLine-" + indexs;
		$(stepLine).css("background-color", "#2E190B");
		$(stepNumber).css("background-color", "#2E190B");

		$(".index").click(function() {
			var offset = parseInt($(".tutor").css("height")) + 50;
			var pos = $(this).attr("mark");
			$("html,body").scrollTop($("#" + pos).offset().top - offset);
		});

		$(".list").hide();
		var judge = 0;
		$(".selectChart").click(function() {
			if(judge == 0) {
				$(".list").fadeIn("slow");
				judge = 1;
			} else {
				$(".list").fadeOut("slow");
				judge = 0;
			}
		});

		//添加购物车的动画
		$(".first").click(function() {
			//先得到原先的位置
			var orignalTop = $(".selectChart").offset().top;
			var orignalLeft = $(".selectChart").offset().left;
			//点击的位置
			var top = $(this).offset().top;
			var left = $(this).offset().left;
			//
			$(".selectChart").css({
				"left": left,
				"top": top
			});
			$(".selectChart").animate({
				"left": left,
				"top": top
			});
		});
	});

})

//个人事物
person.controller("affair", function($scope) {
	$scope.affairNum = 12;
	$scope.affairs = ["全部可办理事务", "正在办理的事务", "以后可能添加的事务"];
	$scope.daily = ["学生报道注册", "在校证明	", "培养方案", "借用教室", "社会实践", "请假", "饭卡遗失", "补办学生证", "成绩证明", "奖学金申请"];
	$scope.count = $scope.daily.length;
	$scope.getInclude = function() {
		if($scope.x == 1) {
			return "affair/affairs-2.html";
		} else if($scope.x == 2) {
			return "affair/affairs-3.html";
		} else {
			return "affair/affairs-1.html";
		}
	}
	$scope.colorChange = function() {
		for(var i = 0; i < 3; i++) {
			var child = $(".navAffairDetails").children().eq(i);
			var check = child.hasClass("colorChange");
			if(check) {
				child.removeClass("colorChange");
			}
		}
		var mark = $(event.target).attr("mark");
		$scope.x = mark;
		$(event.target).toggleClass("colorChange");
	}
	$(document).ready(function() {

		$("body").css("background-color", "white");
		$(".affairs-0").addClass("colorChange");
		//		$(".affairs-0").css("color","red");

		function removeZero(x, y) {
			if(parseInt(x) >= 10) {
				$(y).find(".zero").remove();
			}
		}
		for(var i = 0; i < $scope.count; i++) {
			var nodes = $(".dailyTd").eq(i);
			removeZero(nodes.attr("mark"), nodes);
		}

	});

});

//帮助中心
person.controller("help", function($scope) {
	$scope.getContent = function() {
		if($scope.x == 1) {
			return "help/helpContact.html";
		} else {
			return "help/helpQuestions.html";
		}
	}
	$scope.colorPress = function($event) {
		for(var i = 0; i < 2; i++) {
			var child = $(".navSwitch").children().eq(i);
			var check = child.hasClass("pressColor");
			if(check) {
				child.removeClass("pressColor");
			}
		}
		$(event.target).toggleClass("pressColor");
		$scope.x = $(event.target).attr("mark");
	}
	$scope.questions = ["常见问题1", "常见问题2", "常见问题3"];
});

function jump(url) {
	window.location.href=url;
}