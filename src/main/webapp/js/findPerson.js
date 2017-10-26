$(document).ready(function() {

    $(document).on('click', '#btnModalShowEdit', function() {
        var selectedNodes = $('#family-tree').jstree(true).get_selected('full', true);
        if (selectedNodes.length === 0) {
            alert("Select Person");
            return;
        }
        var selectedNode = selectedNodes[0];
        $.ajax({
            type: "POST",
            url: "v1/person/find",
            data: JSON.stringify({
                id: selectedNode.id
            }),
            dataType: "json",
            contentType: "application/json",
            success: function(result, textStatus, jqXHR) {

                if (result.code === 1) {
                    $("#person_name1").val(result.data.givenName);
                    $("#person_surname1").val(result.data.surname);
                    $("#person_age1").val(result.data.age);
                    $('#modalDialogEdit').modal('show');
                }
                else {
                    alert(result.message);
                }

            },
            error: function(xhr, status, error) {
                alert(xhr)
            },
            complete: function() {
            }
        });



    });

});
            