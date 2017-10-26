$(document).ready(function() {

    $(document).on('click', '#btnModalShowAdd', function() {
        var selectedNodes = $('#family-tree').jstree(true).get_selected('full', true);
        if (selectedNodes.length === 0) {
            alert("Select Parent");
        } else {
            $('#modalDialogAddNew').modal('show');
        }
    });

    $(document).on('click', '#btnModalAdd', function() {
        var name = $("#person_name").val();
        var surname = $("#person_surname").val();
        var age = $("#person_age").val();

        if ($.trim(name).length > 0) {
            name = $.trim(name);
        } else {
            alert("Insert value");
            return;
        }
        var selectedNodes = $('#family-tree').jstree(true).get_selected('full', true);
        var selectedNode = selectedNodes[0];
        $.ajax({
            type: "POST",
            url: "v1/person/add",
            data: JSON.stringify({
                surname: surname,
                givenName: name,
                age: age,
                parentId: selectedNode.id
            }),
            dataType: "json",
            contentType: "application/json",
            success: function(result, textStatus, jqXHR) {

                if (result.code === 1) {
                    window.location.reload();
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
            