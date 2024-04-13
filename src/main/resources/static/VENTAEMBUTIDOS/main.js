$("#menu").hide();
$(document).ready(function() {
    var ancho_video = $(window).width();
    if(ancho_video < 400) {
        $("#nosotros-video").attr("src",base_url+"assets/img/nosotros/CASA-EUROPA2-mobile.mp4");
    }
    else {
        $("#nosotros-video").attr("src",base_url+"assets/img/nosotros/venta_embutidos_charcuteria_jamones_fiambres_chorizos_morcillas_salchichas_madurados_CASA-EUROPA2.mp4");
    }
    $("#item-menu").click(function(){
        var ancho = $(window).width();
        if(ancho < 768) {
        console.log("1");
        	$(".menu").animate({"right":"-70%"}).fadeOut(10);
        	$(".menu").fadeIn(10).animate({"right":"0px"});
        }
        else {
            $(".menu").fadeIn(500).css({"right":"0px"});
        }
        $(".layer").fadeIn(500);
    })
    
    $(".menu__close").click(function(){
        var ancho = $(window).width();
        if(ancho < 768) {
            $(".menu").animate({"right":"-70%"}).fadeOut(0);
            $(".menu").animate({"right":"0%"}).fadeOut(10);
        }
        else {
            $(".menu").fadeOut(500,function(){
                $(this).css({"right":"-70%"});
                $(".menu").animate({"right":"0%"}).fadeOut(0);
            });
        }
        $(".layer").fadeOut(500);
    })
    
    $(".layer").click(function(){
        var ancho = $(window).width();
        if(ancho < 768) {
            $(".menu").animate({"right":"-70%"}).fadeOut(0);
            $(".menu").animate({"right":"0%"}).fadeOut(10);
        }
        else {
            $(".menu").fadeOut(500,function(){
                $(this).css({"right":"-70%"});
                $(".menu").animate({"right":"0%"}).fadeOut(0);
            });
        }
        $(".layer").fadeOut(500);
    })
    
   /* $(".menu__producto").click(function(){
        $(".menu__producto").toggleClass("menu__height");
    });*/
    $('.menu__producto').hover(
    function(){
        $(".menu__producto").addClass("menu__height");
        $(".menu__options__producto").css("opacity",1);
        
    },
    function(){
        $(".menu__producto").removeClass("menu__height");
        $(".menu__options__producto").css("opacity",0);
    }
    );

    $('.menu__delivery').hover(
    function(){
        $(".menu__delivery").addClass("menu__height_delivery");
        $(".menu__options__delivery").css("opacity",1);
        
    },
    function(){
        $(".menu__delivery").removeClass("menu__height_delivery");
        $(".menu__options__delivery").css("opacity",0);
    }
    );
    
     $("#arrow_down").click(function(){
        var altura = $("#tittle-prod").offset().top;
        if(altura == 140) {
            var suma = 140 + $(".tittle-prod").height();
            $("#options-prod").css("top",suma+"px");
        }
        else {
            $("#options-prod").css("top","60px");
        }
        $("#options-prod").toggleClass("options-prod-height");
     })
    
    $('.content-prod').hover(function(){
      $(this).find('.hover').css({
        "opacity": 1, //O lo que desees
      });
      $(this).find('.rombo').css({
        "opacity": 1, //O lo que desees
      });
    } , function(){
      $(this).find('.hover').css({
        "opacity": 0.2, //O lo que desees
      });
      $(this).find('.rombo').css({
        "opacity": 0, //O lo que desees
      });
    });

$('.button').click(function(){
//   window.location.href= base_url+'';
})
    
$('#nosotros').click(function(){
   window.location.href= base_url+'somos';
})
   
$('#home').click(function(){
   window.location.href= base_url;
});
$('#contacto').click(function(){
   window.location.href= base_url+'contacto';
});
$('#intranet').click(function(){
   window.open('#','_blank');
});
$('#productos').click(function(){
   window.location.href= base_url+'productos';
});

$('#arrow-down').click(function(){
    var body = $("html, body");
    var altura = $(window).height();
        body.stop().animate({scrollTop:altura}, 700, 'swing');
});
    
});


