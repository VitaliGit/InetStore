$(document).ready(function(){
	$("#search-form").submit(function (event){
		add();
	})
})

function add(){
	var search={}
	search["title"]=$('#title').val();
	search["author"]=$('#author').val();
	search["available"]=$('#available').val();
	search["genre"]=$('#genre').val();
	search["discount"]=$('#discount').val();
	search["price"]=$('#price').val();
	search["ageGroup"]=$('#ageGroup').val();
	$("#btn").prop("disabled", true);
$.ajax({
	type: "GET",
	contentType: "application/json",
	url: "/rest_api/book",
	data: JSON.stringify(search),
	dataType: 'json',
	cache: false,
	timeout: 2000,
	success: function(data) {
		var json = "<h4>Ajax</h4><pre>" + JSON.parse(data, null, 4) + "</pre>";
		$("#feedback").html(json);
		console.log("SUCCESS : ", data);
        $("#btn").prop("disabled", false);
	},
	error: function (e){
		var json = "<h4>Ajax Response</h4><pre>"
            + e.responseText + "</pre>";
        $('#feedback').html(json);

        console.log("ERROR : ", e);
        $("#btn").prop("disabled", false);

	}
});

}