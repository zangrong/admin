
function modalWindow(obj){
	var url = obj.getAttribute("data-url");
	var id = obj.getAttribute("data-id");
	if(id){
        url = url+"?id="+id;
    }
    var modal = $('#modal-window').modal();
    modal
        .find('.modal-content')
        .load(url, function (response, status) {
            if ( status === 'success' || status === 'notmodified') {
                modal.show();
            }
    });
}

