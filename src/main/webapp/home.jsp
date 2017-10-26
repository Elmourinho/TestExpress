<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Family Tree</title>

        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="thirdparty/jstree/themes/proton/style.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>

        <div class="container">
            <div class="row">
                <h1 class="text-center">Family Tree</h1>

                <div class="col-sm-5 col-sm-offset-4">
                    <div id="family-tree"></div>
                </div>
                <div class="col-sm-5 col-sm-offset-4">
                    <button class="btn btn-primary" id="btnModalShowAdd">Add</button>
                    <button class="btn btn-primary" id="btnModalShowEdit">Edit</button>
                    <button class="btn btn-primary" id="btnModalShowDelete">Delete</button>
                </div>
            </div>
        </div>

        <!-- modal for adding new one -->
        <div class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true" id="modalDialogAddNew">
            <div class="modal-dialog modal-sm">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                        <h4 class="modal-title">Add new</h4>
                    </div>
                    <div class="modal-body">
                        <div class="form-group">
                            <label for="inputNewDictionary">Name</label>
                            <input type="text" class="form-control" id="person_name" placeholder="Insert name">
                        </div>
                        <div class="form-group">
                            <label for="inputNewDictionary">Surname</label>
                            <input type="text" class="form-control" id="person_surname" placeholder="Insert surname">
                        </div>
                        <div class="form-group">
                            <label for="inputNewDictionary">Age</label>
                            <input type="number" class="form-control" id="person_age" placeholder="Insert age">
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        <button type="button" class="btn btn-primary" id="btnModalAdd">Add</button>
                    </div>
                </div>
            </div>
        </div>

        <!-- modal for editing -->
        <div class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true" id="modalDialogEdit">
            <div class="modal-dialog modal-sm">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                        <h4 class="modal-title">Edit</h4>
                    </div>
                    <div class="modal-body">
                        <div class="form-group">
                            <label for="inputNewDictionary">Name</label>
                            <input type="text" class="form-control" id="person_name1" placeholder="Insert name">
                        </div>
                        <div class="form-group">
                            <label for="inputNewDictionary">Surname</label>
                            <input type="text" class="form-control" id="person_surname1" placeholder="Insert surname">
                        </div>
                        <div class="form-group">
                            <label for="inputNewDictionary">Age</label>
                            <input type="number" class="form-control" id="person_age1" placeholder="Insert age">
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        <button type="button" class="btn btn-primary" id="btnModalSave">Save</button>
                    </div>
                </div>
            </div>
        </div>

        <!-- modal for deleting -->
        <div class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true" id="modalDialogDelete">
            <div class="modal-dialog modal-sm">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                        <h4 class="modal-title">Delete</h4>
                    </div>
                    <div class="modal-body">
                        <div class="form-group">
                            <label for="inputNewDictionary">Are you sure you want to delete this person?</label>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        <button type="button" class="btn btn-primary" id="btnModalDelete">Delete</button>
                    </div>
                </div>
            </div>
        </div>

        <script src="js/jquery.min.js"></script> 
        <script src="js/bootstrap.min.js"></script> 
        <script src="thirdparty/jstree/jstree.min.js"></script>


        <script src="js/treemodel.js"></script> 
        <script src="js/addbutton.js"></script> 
        <script src="js/editbutton.js"></script> 
        <script src="js/findPerson.js"></script> 
        <script src="js/deletebutton.js"></script> 
    </body>
</html>
