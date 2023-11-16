<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Office Management</title>
    </head>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        .body-main {
            display: flex;
            flex-direction: row;
            flex-wrap: wrap;
            /*justify-content: space-around;*/
        }

        .top, .sub-top, .body-top, .body-main, .container4, .container6, .container8, .container10 {
            margin: 20px;
            padding: 15px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        h2, h4, h5, p {
            color: #333;
        }

        .statusContainer h4 {
            color: #d9534f;
        }

        form {
            margin-top: 15px;
        }

        input[type="submit"] {
            background-color: #5cb85c;
            color: white;
            border: none;
            padding: 10px 20px;
            border-radius: 5px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #4cae4c;
        }

        .selectSection, .container1, .container2, .container3, .container5, .container7, .container9, .container11 {
            padding: 10px;
        }

        .container1 {
            max-width: 25vw;
            min-width: 20vw;
        }

        .container3 {
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        select, input[type="text"] {
            padding: 10px;
            margin: 10px 0;
            border: 1px solid #ddd;
            border-radius: 4px;
        }

        hr {
            border-top: 1px solid #eee;
        }

        .flexContainer {
            display: flex;
            flex-direction: row;
        }

        .half {
            width: 45%;
        }
    </style>
    <body>
        <div>
            <div class="top">
                <div class="topic">
                    <h2>Office Management</h2>
                </div>
                <div class="statusContainer">
                    <%--            <div>--%>
                    <%--                <div>--%>
                    <h4>${statusMsg}</h4>
                </div>
                <hr/>
                <div class="selectSection">
                    <form action="office-find" method="get">
                        <label><b>Select By:</b></label>
                        <select name="officeList" id="officeList">
                            <option value="all">ALL</option>
                            <optgroup label="Country">
                                <c:forEach items="${uniqueCountry}" var="country">
                                    <c:if test="${country != null}">
                                        <option value="${country}">${country}</option>
                                    </c:if>
                                </c:forEach>
                            </optgroup>
                            <optgroup label="City">
                                <c:forEach items="${uniqueCity}" var="city">
                                    <c:if test="${city != null}">
                                        <option value="${city}">${city}</option>
                                    </c:if>
                                </c:forEach>
                            </optgroup>
                        </select>
                        <input type="submit" value="FIND">
                    </form>
                </div>

                <div class="body-main">
                    <c:forEach items="${offices}" var="office" varStatus="loop">
                        <div class="container1">
                            <div class="container2">
                                <div class="container3">
                                    <h5>${office.officeCode}</h5>
                                    <p>Country: ${office.country}</p>
                                    <p>City: ${office.city}</p>
                                    <p>Territory: ${office.territory}</p>
                                    <p>Address 1: ${office.addressLine1}</p>
                                    <p>Contact: ${office.phone}</p>
                                    <form action="office-remove" method="post">
                                        <input type="hidden" name="removeOffice" value="${office.officeCode}">
                                        <input type="submit" value="REMOVE">
                                    </form>
                                    <form action="office-update" method="get">
                                        <input type="hidden" name="editOffice" value="${office.officeCode}">
                                        <input type="submit" value="EDIT">
                                    </form>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
                <div class="flexContainer">
                    <div class="half">
                        <div class="container5">
                            <h2>Remove Office By Office Code</h2>
                            <form action="office-remove" method="post">
                                <input type="text" name="officeRemoveCode">
                                <input type="submit" value="REMOVE">
                            </form>
                        </div>
                    </div>
                    <div class="half">
                        <div class="container9">
                            <h2>Add New Office</h2>
                            <form action="office-add" method="get">
                                <input type="hidden" name="insert" value="add">
                                <input type="submit" value="add">
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
