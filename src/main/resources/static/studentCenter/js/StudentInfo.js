var StudentInfo = angular.module("StuInfo",[]);
StudentInfo.controller("StuInfo",function($scope){
	$scope.InfoItems = ["姓名","学号","性别","年级","班级","书院","民族","联系电话","照片"];
	$scope.EnglishInfoItems = ["Name","StudentID","Sex","Grade","Class","College","nationality","Phone-Number","Picture"];
	$scope.change=function(){
		$scope.temp=$scope.InfoItems;
		$scope.InfoItems=$scope.EnglishInfoItems;
		$scope.EnglishInfoItems=$scope.temp;
	}
});
