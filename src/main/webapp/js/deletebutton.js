$(document).ready(function() {

    $(document).on('click', '#btnModalShowDelete', function() {
        var selectedNodes = $('#family-tree').jstree(true).get_selected('full', true);
        if (selectedNodes.length === 0) {
            alert("Select Person");
        } else {
            $('#modalDialogDelete').modal('show');
        }
    });

    $(document).on('click', '#btnModalDelete', function() {

        var selectedNodes = $('#family-tree').jstree(true).get_selected('full', true);
        var selectedNode = selectedNodes[0];
        $.ajax({
            type: "POST",
            url: "v1/person/remove",
            data: JSON.stringify({
                id: selectedNode.id
            }),
            dataType: "json",
            contentType: "application/json",
            success: function(result, textStatus, jqXHR) {

                if (result.code === 1) {
                    window.location.reload();
                }
                else {
                    alert("This person has a child");
                     window.location.reload();
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
            