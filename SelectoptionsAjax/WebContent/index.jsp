<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="js/jquery-3.3.1.js"></script>
<script src="js/bootstrap-3.3.7.js" defer></script>
<script src="js/bootstrap-select.js"></script>
<link rel="stylesheet" href="css/bootstrap-select.css"/>
<link rel="stylesheet" href="css/bootstrap-3.3.7.css">
<style>
div.dropdown-menu.open{
  max-height: 314px !important;
  overflow: hidden;
}
ul.dropdown-menu.inner{
  max-height: 260px !important;
  overflow-y: auto;
}

</style>
<script>
$(document).ready(function(){
var years;
$.ajax({
  url:'SelectController',
  type:'GET',
  data:{
  },
  success:function(response){
  var years=JSON.parse(response);

$.each(years,function(index,value){
$("#mySelect").append('<option value='+value+'>'+value+'</option>')
})
$('.selectpicker').selectpicker('refresh');
  },
  error:(function(response){
  })
})


/* var cars=["BMW","Audi","wolks Wagan","Marutisuzki","Honda city","Ciaz"];
var bikes=["pulser","Hona cdss","","Honda Hornet","Bullet"];
var truck=["Ashok layland","Eicher","aswf","wkl"]; */

$('#mySelect').change(function(){ 
    var value = $(this).val();
     
 $.ajax({
 url:'SelectController',
 type:'POST',
 data:{'state':value},
 success:function(response){
 var options=JSON.parse(response);
bindoptions(options)
$('.selectpicker').selectpicker('refresh');
 },
 error:function(response){
 }
 
 })
});

    function bindoptions(names){
      $("#mySelect2").empty();
    $.each(names,function(index,value){
    $("#mySelect2").append('<option value='+value+'>'+value+'</option>');
    });
 
    }

})
</script>
</head>
<body>
<div class="container">
<div class="row">
<div class="row" style="margin-top: 185px;">
<div class="col-sm-6" style="margin-left: 332px;">
<select id="mySelect"  class="selectpicker">
</select>
<select id="mySelect2" class="selectpicker">
</select>
</div>
</div>
</div>
</body>
</html>