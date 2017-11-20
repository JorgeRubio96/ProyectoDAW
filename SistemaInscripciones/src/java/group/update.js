var form, spinnerButton;

$(document).ready(function() {
	form = $('form#editGroup').validate({
		rules: {
			clave: {
				required: true,
				minlength: 4
			},

			materia: {
				required: true,
				minlength: 4
			},

			profesor: {
				required: true,
                                minlength: 4
			},

			horario: {
				required: true
			}
		},

		messages: {
			clave: {
				required: "Porfavor ingrese una clave",
				minlength: "Escriba por lo menos 4 caracteres"
			},

			materia: {
				required: "Porfavor ingrese la materia del grupo",
				minlength: "Escriba por lo menos 4 caracteres"
			},

			profesor: {
				required: "Porfavor ingrese el profesor",
                                minlength: "Escriba por lo menos 4 caracteres"
			},

			horario: {
				required: "Porfavor ingrese el horario"
			}
		}
	});

	$("#horario").formatter({
		'pattern':'{{9999}}-{{99}}-{{99}}'
	});

	setEvents();

});

function setEvents() {
	$('button#cancelbtn').on('click', function() {
        document.location.href = "/groups/listGroups.jsp";
        });

	$('form#editGroup').on('submit', function(event) {
		event.preventDefault();

		var data = {
			clave : $('#clave').val(),
			materia : $('#materia').val(),
			profesor : $('#profesor').val(),
			horario : $('#horario').val()
		};

		if (form.valid()) {
			$.ajax({
				url : document.href,
				type : "POST",
				datatype : "json", 
				headers: { 'X-CSRF-TOKEN': $('meta[name="csrf-token"]').attr('content')},
				data : data
			}).done(function(response){
				document.location.href = "/groups/listGroups.jsp";
			}).fail(function(response){
				
			});
		}
	});
}
