/**
 * Script Javascript de voyages/roadBook.jsp
 */

/* 
 * *****************************************************************************
 * fonction de selection toutes les checkBox 
 */
$(document).ready(function(){
  // Activate tooltip
  $('[data-toggle="tooltip"]').tooltip();

  // Select/Deselect checkboxes
  var checkbox = $('table tbody input[type="checkbox"]');
  $("#selectAll").click(function(){
    if(this.checked){
      checkbox.each(function(){
        this.checked = true;
      });
    } else{
      checkbox.each(function(){
        this.checked = false;
      });
    }
  });
  checkbox.click(function(){
    if(!this.checked){
      $("#selectAll").prop("checked", false);
    }
  });
});

/*
 *******************************************************************************
 * fonction des boutons supprimer 
 * pour transferer l'id du voyage a la fenetre modal 
 */
$(function(){
  $(".delete").click(function(){
     $('#id').val($(this).data('id'));
    $("#deleteModalVoyages").modal("show");
  });
});