
(function($){
	function calcHeight(){
		var windowWidth = $(window).innerWidth();
		var videoHeight = Math.ceil(windowWidth/2);

		if(windowWidth < 768){
			$('.videoContainer iframe').attr('height', videoHeight);
		}
		
	}

	$(window).resize(function(){
		calcHeight();
	});

	calcHeight();

	$(document).on('shown.bs.collapse','.panel-group', function (e) {
		$(e.target).prev('.panel-heading').addClass('open');
	});

	$(document).on('hidden.bs.collapse','.panel-group', function (e) {
		$(this).find('.panel-heading').not($(e.target)).removeClass('open');
	});

	$('body').scrollspy({ target: '.scrollspy', offset: 500 });

	$('#scrollspy-steps ul li a[href*=#]').click(function() {
	if (location.pathname.replace(/^\//,'') === this.pathname.replace(/^\//,'') && location.hostname === this.hostname) {
		var $target = $(this.hash);
		$target = $target.length && $target || $('[name=' + this.hash.slice(1) +']');
	
		if ($target.length) {
			var targetOffset = $target.offset().top - 200;
			$('html,body').animate({scrollTop: targetOffset}, 1000);
				return false;
			}
		}
	});

	$('#terms.nav.nav-pills li a').on('click', function(e){
		e.preventDefault();
		var curr_pill = $(this).data('href');

		if ($('#accordion-terms ' + curr_pill).hasClass('in')){
			$('#accordion-terms ' + curr_pill).collapse('hide');
		} else {
			$('#accordion-terms ' + curr_pill).collapse('show');
			if (location.pathname.replace(/^\//,'') === this.pathname.replace(/^\//,'') && location.hostname === this.hostname) {
			var $target = $(this.hash);
			$target = $target.length && $target || $('[name=' + this.hash.slice(1) +']');
		
			if ($target.length) {
				var targetOffset = $target.offset().top - 200;
				$('html,body').animate({scrollTop: targetOffset}, 1000);
					return false;
				}
			}
		}
	});

	var isPaused = false;
	var index = 0;
	var servicesPills = setInterval(function () {

		if(!isPaused) {
            $($('.krew-services .nav-pills > li > a').get(index)).trigger('click');
            index++;

            if(index === 5){
                index = 0;
            }
        } else {
        	isPaused = true;
        }

    }, 5000);

	$('.krew-services .tab-content .tab-pane').hover(function (ev) {
        clearInterval(servicesPills);
    },function (ev) {
        servicesPills = setInterval(function () {

			if(!isPaused) {
	            $($('.krew-services .nav-pills > li > a').get(index)).trigger('click');
	            index++;

	            if(index === 5){
	                index = 0;
	            }
	        } else {
	        	isPaused = true;
	        }

	    }, 5000);
    });
    

})(window.jQuery);
