var footer = angular.module("footer",[]);
footer.controller("footer",function($scope){
	$scope.footerTitle=["友情链接"];
	$scope.footerOne=["学校概况","院系设置","师资队伍","教育教学","科学研究","学生生活","交流合作","招生就业"];
	$scope.footerTwo=["教育捐赠","党群园地","迎新网","人才招聘","公共服务","通知公告","新闻动态","信息公开"];
})