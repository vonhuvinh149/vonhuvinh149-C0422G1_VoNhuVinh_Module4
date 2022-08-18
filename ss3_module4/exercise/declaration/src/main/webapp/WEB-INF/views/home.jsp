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
        <h1>KHAI BAO Y TE </h1>
        <form:form action="/create" modelAttribute="medical" method="get">
            <div>
                <label for="exampleInputEmail">Họ và tên</label>
                <form:input path="name" type="text" id="exampleInputEmail"
                            aria-describedby="emailHelp"/>
            </div>
            <div>
                <div>
                    <label for="exampleInputEmail1">Năm sinh</label>
                    <form:select path="age" items="${year}" id="exampleInputEmail1"
                                 aria-describedby="emailHelp"/>
                </div>
                <div>
                    <label for="exampleInputEmail2">Giới tính</label>
                    <form:select path="gender" items="${gender}" id="exampleInputEmail2"
                                 aria-describedby="emailHelp"/>
                </div>
                <div>
                    <label for="exampleInputEmail3" class="form-label">Quốc tịch</label>
                    <form:select path="nation" items="${nation}" id="exampleInputEmail3"
                                 aria-describedby="emailHelp"/>
                </div>
                <div>
                    <label for="example">CCCD/CMND</label>
                    <form:input path="id" type="number" id="example"
                                aria-describedby="emailHelp"/>
                </div>

            </div>
            <div>
                <div>
                    <h5>Thong tin di chuyen</h5>
                    <p><form:radiobutton cssClass="ms-4" path="travel" value="May bay"/> May bay </p>
                    <p><form:radiobutton cssClass="ms-4" path="travel" value="Tau thuyen"/> Tau Thuyen</p>
                    <p><form:radiobutton cssClass="ms-4" path="travel" value="Oto"/> Oto </p>
                    <p><form:radiobutton cssClass="ms-4" path="travel" value="khac"/> khac </p>
                </div>

            </div>
            <div>
                <div>
                    <label for="ex" class="form-label">SO HIEU PHUONG TIEN </label>
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
                            <form:select path="monthEnd" items="${month}" class="form-control"
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
        <div class="col-lg-2">
            <a href="/show"> showlist</a>
        </div>
    </div>
</div>
</body>
</html>