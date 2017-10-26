$(document).ready(function() {
    $(document).on('click', '#btnModalSave', function() {
        var name = $("#person_name1").val();
        var surname = $("#person_surname1").val();
        var age = $("#person_age1").val();

        var selectedNodes = $('#family-tree').jstree(true).get_selected('full', true);
        var selectedNode = selectedNodes[0];
        $.ajax({
            type: "POST",
            url: "v1/person/edit",
            data: JSON.stringify({
                surname: surname,
                givenName: name,
                age: age,
                id: selectedNode.id
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
            