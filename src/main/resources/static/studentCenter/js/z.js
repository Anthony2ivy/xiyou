$(document).ready(function() {
	$('#myCarousel').on('slid.bs.carousel', function() {
		if($("#myCarousel .carousel-inner div:last-child").hasClass('active')) {
			$('.slide-button.right').css('background-image', 'url(../img/img/rightPage2.png)');
		} else if($("#myCarousel .carousel-inner div:first-child").hasClass('active')) {
			$('.slide-button.left').css('background-image', 'url(../img/img/leftPage2.png)');
		} else {
			$('.slide-button.right').css('background-image', 'url(../img/img/rightPage1.png)');
			$('.slide-button.left').css('background-image', 'url(../img/img/leftPage1.png)');
		}

	});
});