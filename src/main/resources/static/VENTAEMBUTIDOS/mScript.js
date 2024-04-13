var canvas,preloader,imagenes;
var ancho_video = $(window).width();
    if(ancho_video < 400) {
        imagenes = [ 
            base_url+"VENTAEMBUTIDOS/img/logotipo-alimentos-selectos.png",
            base_url+"VENTAEMBUTIDOS/cabecera_inicio1_c.jpg",
            base_url+"VENTAEMBUTIDOS/cabecera_inicio2_c.jpg",
            base_url+"VENTAEMBUTIDOS/cabecera_inicio3_c.jpg",
//            base_url+"VENTAEMBUTIDOS/producto_jamon_1_c.jpg",
//            base_url+"VENTAEMBUTIDOS/producto_chorizo_2_c.jpg",
//            base_url+"VENTAEMBUTIDOS/producto_jamonada_3_c.jpg",
//            base_url+"VENTAEMBUTIDOS/producto_salchicha_4_c.jpg",
//            base_url+"VENTAEMBUTIDOS/producto_ahumado_5_c.jpg",
//            base_url+"VENTAEMBUTIDOS/producto_empacado_6_c.jpg",
//            base_url+"VENTAEMBUTIDOS/producto_queso_7_c.jpg",
//            base_url+"VENTAEMBUTIDOS/producto_papa_8_c.jpg",
            base_url+"VENTAEMBUTIDOS/producto_crema_9_c.jpg"
            ];
    }
    else {
        imagenes = [
            base_url+"VENTAEMBUTIDOS/img/logotipo-alimentos-selectos.png",
            base_url+"VENTAEMBUTIDOS/cabecera_inicio1_c.jpg",
            base_url+"VENTAEMBUTIDOS/cabecera_inicio2_c.jpg",
            base_url+"VENTAEMBUTIDOS/cabecera_inicio3_c.jpg",
//            base_url+"VENTAEMBUTIDOS/producto_jamon_1_c.jpg",
//            base_url+"VENTAEMBUTIDOS/producto_chorizo_2_c.jpg",
//            base_url+"VENTAEMBUTIDOS/producto_jamonada_3_c.jpg",
//            base_url+"VENTAEMBUTIDOS/producto_salchicha_4_c.jpg",
//            base_url+"VENTAEMBUTIDOS/producto_ahumado_5_c.jpg",
//            base_url+"VENTAEMBUTIDOS/producto_empacado_6_c.jpg",
//            base_url+"VENTAEMBUTIDOS/producto_queso_7_c.jpg",
//            base_url+"VENTAEMBUTIDOS/producto_papa_8_c.jpg",
            base_url+"VENTAEMBUTIDOS/producto_crema_9_c.jpg"
            ];
    }




$(document).on("ready",iniciarApp);
function iniciarApp()
{
	preloader = new PreloadJS();
	preloader.onFileLoad = cargaCompleta;
	preloader.onProgress = progresoCarga;
	prepararCanvas();
	
	

$( "#modal-close").click(function() {
  $( "#delivery_modal").modal('toggle');
});

$('.pop').on('click', function() {

	var captionText = document.getElementById("caption");

	$('.imagepreview').attr('src', $(this).find('img').attr('src'));
	captionText.innerHTML = $(this).find('img').attr('alt');
	$('#imagemodal').modal('show');   
});	

}
function prepararCanvas()
{
	cargar();
}
function cargar()
{
	while(imagenes.length > 0)
	{
		var imagen = imagenes.shift();
		preloader.loadFile(imagen);	
	}
}
function progresoCarga()
{
	var progresoEntero = parseInt(preloader.progress*100);
	$("#porcentaje").text(progresoEntero+"%");
    $(".load_salchicha_blanco").css("width",progresoEntero+"%");
	if(preloader.progress == 1)
	{
		$("#preloader").remove();
		$("#wrapper").fadeIn();
        $('#delivery_modal').modal("show");
	}
}
function cargaCompleta(event)
{
	
}

var inicio = 0;
function aumentar(){
var cantidad = document.getElementById('cantidad').value = ++inicio; //se obtiene el valor del input, y se incrementa en 1 el valor que tenga.
}

function disminuir(){ 
var cantidad = document.getElementById('cantidad').value = --inicio; //se obtiene el valor del input, y se decrementa en 1 el valor que tenga.
}

$(function () {
    $('.add').on('click',function(){
        var $qty=$(this).closest('p').find('.qty');
        var currentVal = parseInt($qty.val());
        if (!isNaN(currentVal)) {
            $qty.val(currentVal + 1);
        }
    });
    $('.minus').on('click',function(){
        var $qty=$(this).closest('p').find('.qty');
        var currentVal = parseInt($qty.val());
        if (!isNaN(currentVal) && currentVal > 0) {
            $qty.val(currentVal - 1);
        }
    });
});