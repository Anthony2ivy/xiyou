var header = angular.module("header", []);
header.controller("header", function($scope) {
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

//
$(document).ready(function() {
	var logowidth = $(".logo").css("width");
	var fontwidth = $(".middleItemsContent-1").css("width");
	var tdwidth = $(".tdButton").css("width"); //每次移动的距离
	$(".pressLine").css("left", logowidth); //设置起始的位置
	$(".pressLine").css("width", fontwidth); //设置宽度
	var posArr = new Array();
	for(var i = 0;i < 3 ;i++) {
		var value = parseInt(logowidth) + parseInt(tdwidth) * i;
		posArr.push(value + "px");//储存对应位置
	}
	$(".tdButton").click(function() {
		var index = $(this).children()[0].className.slice(-1); //获得按动是哪个
		$(".pressLine").animate({
			left:posArr[parseInt(index)-1]
		});
	});
})