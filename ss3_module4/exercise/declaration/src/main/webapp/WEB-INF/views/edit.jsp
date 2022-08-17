<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: ABC
  Date: 8/17/2022
  Time: 2:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <div>
        <form:form action="/update" modelAttribute="medical" method="post">
            <div>
                <label for="exampleInputEmail">HO VA TEN </label>
                <form:input path="name" type="text" class="form-control" id="exampleInputEmail"
                            aria-describedby="emailHelp"/>
            </div>
            <div>
                <div>
                    <label for="exampleInputEmail1">NAM SINH </label>
                    <form:select path="age" items="${year}" id="exampleInputEmail1"
                                 aria-describedby="emailHelp"/>
                </div>
                <div>
                    <label for="exampleInputEmail2">GIOI TINH </label>
                    <form:select path="gender" items="${gender}" class="form-control" id="exampleInputEmail2"
                                 aria-describedby="emailHelp"/>
                </div>
                <div>
                    <label for="exampleInputEmail3"> QUOC TICH </label>
                    <form:select path="nation" items="${nation}" class="form-control" id="exampleInputEmail3"
                                 aria-describedby="emailHelp"/>
                </div>
                <div>
                    <label for="example" class="form-label">SO CMND (HO CHIEU) </label>
                    <form:input path="id" type="number" id="example"
                                aria-describedby="emailHelp"/>
                </div>
            </div>
            <div>
                <div>
                    <h5>Thong tin di chuyen</h5>
                    <p><form:radiobutton path="travel" value="May bay"/> May bay </p>
                    <form:radiobutton cssClass="ms-4" path="travel" value="Tau thuyen"/>
                    <form:radiobutton cssClass="ms-4" path="travel" value="Oto"/>
                    <form:radiobutton cssClass="ms-4" path="travel" value="khac"/>
                </div>
            </div>
            <div>
                <div>
                    <label for="ex">SO HIEU PHUONG TIEN </label>
                    <form:input path="travelNumber" type="text" id="ex"
                                aria-describedby="emailHelp"/>
                </div>
                <div>
                    <label for="ex1">SO GHE </label>
                    <form:input path="travelSeats" type="text" id="ex1"
                                aria-describedby="emailHelp"/>
                </div>
            </div>
            <div>
                <div>
                    <div>
                        <label>Ngay Khoi hanh </label>
                        <div>
                            <form:select path="dayStart" items="${day}"
                                         aria-describedby="emailHelp"/>
                        </div>
                        <div>
                            <form:select path="monthStart" items="${month}"
                                         id="exampleInputEmail1"
                                         aria-describedby="emailHelp"/>
                        </div>
                        <div>
                            <form:select path="yearStart" items="${year}"
                                         id="exampleInputEmail1"
                                         aria-describedby="emailHelp"/>
                        </div>
                    </div>
                </div>
                <div>
                    <div>
                        <label>Ngay Ket thuc </label>
                        <div>
                            <form:select path="dayEnd" items="${day}"
                                         aria-describedby="emailHelp"/>
                        </div>
                        <div>
                            <form:select path="monthEnd" items="${month}"
                                         id="exampleInputEmail1"
                                         aria-describedby="emailHelp"/>
                        </div>
                        <div>
                            <form:select path="yearEnd" items="${year}"
                                         id="exampleInputEmail1"
                                         aria-describedby="emailHelp"/>
                        </div>
                    </div>
                </div>
            </div>
            <div>
                <label for="exampleInput">Dia diem da di trong vong 14 ngay </label>
                <form:input path="note" type="text" id="exampleInput"
                            aria-describedby="emailHelp"/>
            </div>
            <div>
                <button type="submit"> submit
                </button>
            </div>
        </form:form>
    </div>
</div>
<div>
    <a href="/show"> showlist</a>
</div>
</body>
</html>