<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Office Form</title>
    </head>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f4f4f4;
            margin: 20px;
            padding: 20px;
        }

        .container, .row, .col-md-6 {
            margin-bottom: 15px;
        }

        h2 {
            color: #333;
            margin-bottom: 15px;
        }

        .form-group label {
            display: block;
            margin-bottom: 5px;
        }

        .form-control {
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        .btn {
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        .btn-primary {
            background-color: #007bff;
            color: white;
        }

        .btn-secondary {
            background-color: #6c757d;
            color: white;
        }

        .btn:hover {
            opacity: 0.9;
        }

        .text-danger {
            color: #dc3545;
        }

        @media (max-width: 768px) {
            .col-md-6 {
                width: 100%;
            }
        }
    </style>
    <body>
        <div class="container">
            <c:if test="${add != null}">
            <div class="row">
                <h2>Add Office</h2>
            </div>
            <div class="row justify-content-center">
                <div class="col-md-6">
                    <form action="office-add" method="post">
                        <input type="hidden" name="action" value="add">
                        <div class="form-group">
                            <label for="officeCode">Code:</label>
                            <input type="text" id="officeCode" name="officeCode" class="form-control">
                        </div>
                        </c:if>
                        <c:if test="${add == null}">
                        <div class="row">
                            <h2>Edit Office</h2>
                        </div>
                        <div class="row justify-content-center">
                            <div class="col-md-6">
                                <form action="office-update" method="post">
                                    <input type="hidden" name="action" value="update">
                                    </c:if>
                                    <div class="form-row">
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label for="city">City:</label>
                                                <input type="text" id="city" name="city" class="form-control"
                                                       value="${updateOffice != null?updateOffice.city:null}">
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label for="phone">Phone Number:</label>
                                                <input type="text" id="phone" name="phone" class="form-control"
                                                       value="${updateOffice != null?updateOffice.phone:null}">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="addressLine1">Address Line 1:</label>
                                        <input type="text" id="addressLine1" name="addressLine1" class="form-control"
                                               value="${updateOffice != null?updateOffice.addressLine1:null}">
                                    </div>
                                    <div class="form-group">
                                        <label for="addressLine2">Address Line 2:</label>
                                        <input type="text" id="addressLine2" name="addressLine2" class="form-control"
                                               value="${updateOffice != null?updateOffice.addressLine2:null}">
                                    </div>
                                    <div class="form-row">
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label for="state">State:</label>
                                                <input type="text" id="state" name="state" class="form-control"
                                                       value="${updateOffice != null?updateOffice.state:null}">
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label for="country">Country:</label>
                                                <input type="text" id="country" name="country" class="form-control"
                                                       value="${updateOffice != null?updateOffice.country:null}">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-row">
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label for="postalCode">Postal Code:</label>
                                                <input type="text" id="postalCode" name="postalCode"
                                                       class="form-control"
                                                       value="${updateOffice != null?updateOffice.postalCode:null}">
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label for="territory">Territory:</label>
                                                <input type="text" id="territory" name="territory" class="form-control"
                                                       value="${updateOffice != null?updateOffice.territory:null}">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row ">
                                        <button type="submit" class="btn btn-primary">SUBMIT</button>
                                    </div>
                                </form>
                                <h5 class="mt-3 text-danger">${addStatus}</h5>
                            </div>
                        </div>
                </div>
                <div class="row mt-3 text-center">
                    <div class="col-12">
                        <a href="office-management" class="btn btn-secondary">Back</a>
                    </div>
                </div>
            </div>
    </body>

</html>
