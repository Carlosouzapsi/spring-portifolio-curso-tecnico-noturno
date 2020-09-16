const showModalDeletar = function(id){
	$('#produtoid').val(id)	
	$('#deleteModal').modal('show')
}

const deletarProjeto = function(){
	let produtoid = $('#produtoid').val()
	if (produtoid != 0)
		window.location.href = '/projeto/delete/' + produtoid
}
