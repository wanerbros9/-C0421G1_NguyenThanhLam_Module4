<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Health Declaration</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>

<center><h4>MEDICAL DECLARATION FORM</h4></center>
<center><h5>THIS IS IMPORTANT DOCUMENT, YOUR INFORMATION IS VITAL TO ALLOW HEALTH AUTHORITIES CONTACT YOU TO PREVENT
    COMMUNICABLE DISEASES</h5></center>
<center><p class="text-danger">Warning: Declaring false information is a violation of Vietnamese law and may be subject
    to criminal handling
</p></center>
<h5 class="text-danger">
    <c:if test="${msg!=null}">
        ${msg}
    </c:if>
</h5>
<div class="container-fluid col-lg-12">
    <form:form modelAttribute="health" action="create" method="post">
        <div class="col-lg-12">
            <label for="inputName" class="form-label">Full name</label>
            <form:input path="name" class="form-control" id="inputName"/>
        </div>
        <div class="row">
            <div class="col-lg-4">
                <label for="inputYearBirth" class="form-label">Year of birth</label>
                <form:input path="yearBirth" class="form-control" id="inputYearBirth"/>
            </div>
            <div class="col-lg-4">
                <label for="inputGender" class="form-label">Gender</label>
                <form:select path="gender" cssClass="form-control" id="inputGender">
                    <form:option value="0">Select</form:option>
                    <form:option value="1">Male</form:option>
                    <form:option value="2">Female</form:option>
                </form:select>
            </div>
            <div class="col-lg-4">
                <label for="inputNationality" class="form-label">Nationality</label>
                <form:select path="nationality" class="form-control" id="inputNationality">
                    <form:option value="Viet Nam"></form:option>
                    <form:option value="America"></form:option>
                    <form:option value="Italia"></form:option>
                </form:select>
            </div>
        </div>
        <div class="col-lg-12">
            <label for="inputCitizenId" class="form-label">Passport number or other legal document </label>
            <form:input path="citizenId" class="form-control" id="inputCitizenId"/>
        </div>
        <div class="col-lg-12">
            <label class="form-label">Travel information</label>
            <br>
            <form:radiobutton path="travelInformation" value="Plane" label="Plane"/>
            <form:radiobutton path="travelInformation" value="Ship" label="Ship"/>
            <form:radiobutton path="travelInformation" value="Car" label="Car"/>
            <form:radiobutton path="travelInformation" value="Other" label="Other"/>
        </div>
        <div class="row">
            <div class="col-lg-6">
                <label for="vehicleNumber" class="form-label">Transportation no</label>
                <form:input path="vehicleNumber" class="form-control" id="vehicleNumber"/>
            </div>
            <div class="col-lg-6">
                <label for="seatNumber" class="form-label">Seat no</label>
                <form:input path="seatNumber" class="form-control" id="seatNumber"/>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-6">
                <label for="departureDate" class="form-label">Departure date</label>
                <form:input path="departureDate" class="form-control" id="departureDate"/>
            </div>
            <div class="col-lg-6">
                <label for="arriveDate" class="form-label">Arrive date</label>
                <form:input path="arriveDate" class="form-control" id="arriveDate"/>
            </div>
        </div>
        <div class="col-lg-12">
            <label for="stayCity" class="form-label">In the past 14 days, which province/ region/ city?</label>
            <form:input path="stayCity" class="form-control" id="stayCity"/>
        </div>
        <div class="row">
            <div class="col-lg-4">
                <label for="homeCity" class="form-label">City</label>
                <form:select path="homeCity" class="form-control" id="homeCity">
                    <form:option value="Đà Nẵng">Đà Nẵng</form:option>
                    <form:option value="Hà Nội">Hà Nội</form:option>
                    <form:option value="Nha Trang">Nha Trang</form:option>
                </form:select>
            </div>
            <div class="col-lg-4">
                <label for="homeDistrict" class="form-label">District</label>
                <form:select path="homeDistrict" cssClass="form-control" id="homeDistrict">
                    <form:option value="Hải Châu">Hải Châu</form:option>
                    <form:option value="Thanh Khê">Thanh Khê</form:option>
                    <form:option value="Cẩm Lệ">Cẩm Lệ</form:option>
                </form:select>
            </div>
            <div class="col-lg-4">
                <label for="homeWard" class="form-label">Ward</label>
                <form:select path="homeWard" class="form-control" id="homeWard">
                    <form:option value="Bình Hiên"></form:option>
                    <form:option value="Thọ Quang"></form:option>
                    <form:option value="Thạc Gián"></form:option>
                </form:select>
            </div>
        </div>
        <div class="col-lg-12">
            <label for="homeAddress" class="form-label">Address</label>
            <form:input path="homeAddress" class="form-control" id="homeAddress"/>
        </div>
        <div class="row">
            <div class="col-lg-6">
                <label for="phoneNumber" class="form-label">Phone number</label>
                <form:input path="phoneNumber" class="form-control" id="phoneNumber"/>
            </div>
            <div class="col-lg-6">
                <label for="email" class="form-label">Email</label>
                <form:input path="email" class="form-control" id="email"/>
            </div>
        </div>
        <%--        <div class="col-lg-12">--%>
        <%--            <label for="symptom" class="form-label">If you have any of the followings at present or during the past 14--%>
        <%--                days (until the date of entry/exit/transit)?</label>--%>
        <%--&lt;%&ndash;            <form:checkboxes path="symptom" items="${symptomList}" cssClass="form-label" id="symptom"/>&ndash;%&gt;--%>
        <%--            <form:checkboxes path="symptom" items="${symptomList}"/>--%>
        <%--        </div>--%>
        <%--        <div class="col-lg-12">--%>
        <%--            <label for="exposure" class="form-label">History of exposure: During the last 14 days, did you</label>--%>
        <%--            <form:checkboxes path="exposure" items="${exposureList}" cssClass="form-label" id="exposure"/>--%>
        <%--        </div>--%>
        <center>
            <div class="col-lg-12">The data you provide is completely confidential and only serves for the prevention of
                epidemics, under the management of the Vietnam National Steering Committee for COVID-19 Epidemic
                Prevention
                and Control. When you press "Submit", you understand and agree with the above statement.
            </div>
        </center>
        <center>
            <div class="col-lg-12">
                <button type="submit" class="btn btn-success" value="Submit">Submit</button>
            </div>
        </center>
    </form:form>
</div>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
        integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
        integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
        crossorigin="anonymous"></script>
</body>
</html>
