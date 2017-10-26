$(document).ready(function() {

    $.ajax({
        type: "GET",
        url: "v1/person/familyTree",
        dataType: "json",
        success: function(data, textStatus, jqXHR) {
            $('#family-tree').jstree({
                'core': {
                    'data': data,
                    'themes': {
                        'name': 'proton',
                        'responsive': true
                    }
                }
            }).bind("loaded.jstree", function(event, data) {
                $(this).jstree("open_all");
            });
        },
        error: function(xhr, status, error) {
            bootbox.alert('Xəta baş verdi!');
        },
        complete: function() {
        }
    });
});