<<<<<<< Updated upstream

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

=======
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>중고차 등록</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <style>
        @import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&display=swap');

        body {
            font-family: 'Noto Sans KR', sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            background-color: #f0f4f8;
            margin: 0;
            padding: 40px 0;
        }

        .container {
            width: 450px;
            height: 650px;
            background: #ffffff;
            padding: 30px;
            border-radius: 15px;
            box-shadow: 0 10px 20px rgba(0, 0, 0, 0.08);
            overflow-y: auto;
            margin-top: 80px;
        }
        h1 {
            text-align: center;
            position: sticky;
            top: 0;
            background: white;
            padding-bottom: 10px;
            z-index: 100;
            border-bottom: 2px solid #f0f0f0;
        }

        label {
            font-weight: 500;
            display: block;
            margin-top: 15px;
            color: #555;
            font-size: 15px;
        }

        input, select {
            width: 100%;
            padding: 10px 12px;
            margin-top: 5px;
            border: 1px solid #ddd;
            border-radius: 8px;
            transition: border-color 0.3s, box-shadow 0.3s;
            font-size: 14px;
        }

        input:focus, select:focus {
            border-color: #ff6b6b;
            box-shadow: 0 0 8px rgba(255, 107, 107, 0.2);
            outline: none;
        }

        .submit-btn {
            width: 100%;
            padding: 12px;
            margin-top: 25px;
            background: linear-gradient(to right, #ff6b6b, #f06595);
            color: white;
            font-size: 16px;
            font-weight: 700;
            cursor: pointer;
            border: none;
            border-radius: 10px;
            box-shadow: 0 5px 10px rgba(255, 107, 107, 0.3);
            transition: transform 0.2s, box-shadow 0.2s;
        }

        .submit-btn:hover {
            transform: translateY(-2px);
            box-shadow: 0 8px 15px rgba(255, 107, 107, 0.35);
        }

        .container::-webkit-scrollbar {
            width: 6px;
        }

        .container::-webkit-scrollbar-track {
            background: transparent;
        }

        .container::-webkit-scrollbar-thumb {
            background-color: #ff6b6b;
            border-radius: 20px;
        }
    </style>
</head>
<body>
<!-- 헤더 포함 -->
<jsp:include page="include/header.jsp"/>



<!-- 사이드바 포함 -->
<jsp:include page="include/sidebar.jsp"/>


<div class="container">
    <h1>중고차 등록</h1>
    <form action="${pageContext.request.contextPath}/admin/cars/register" method="post" enctype="multipart/form-data">
        <label>모델명</label>
        <input name="modelName" type="text" required />

        <label>배기량</label>
        <input name="engineCapacity" type="text" required />

        <label>변속기 </label>
        <input name="fuelType" type="text" required />

        <label>색상</label>
        <input name="Color" type="text" />

        <label>가격</label>
        <input name="carPrice" type="text" required />

        <label>제목</label>
        <input name="title" type="text" required />

        <label>상세 설명</label>
        <input name="description" type="text" required />
        <label>주행거리</label>
        <input name="mileage" type="number" required />
        <label>차대번호</label>
        <input name="vinNumber" type="number" required />
        <label>제시신고번호</label>
        <input name="offerReportNumber" type="number" required />
        <label>연식</label>
        <input name="manufactureYear" type="number" required />

        <label>이전등록비</label>
        <input name="previousRegistrationFee" type="text" required />

        <label>관리비용</label>
        <input name="maintenanceCost" type="text" />

        <label>매물가격</label>
        <input name="itemPrice" type="text" />

        <label>연장보증비</label>
        <input name="extendedWarrantyPrice" type="text" />

        <label>carNum</label>
        <input name="차량번호" type="text" />

        <label>차량 이미지 업로드</label>
        <input type="file" name="imageFiles" accept="image/*" multiple required />

        <label>카테고리 선택</label>
        <select name="largeCateCode" id="largeCate" required>
            <option value="">대분류 선택</option>
            <c:forEach var="large" items="${largeCategories}">
                <option value="${large.cateCode}">${large.cateName}</option>
            </c:forEach>
        </select>

        <select name="mediumCateCode" id="mediumCate" required>
            <option value="">중분류 선택</option>
        </select>

        <select name="smallCateCode" id="smallCate" required>
            <option value="">소분류 선택</option>
        </select>

        <label>판매 상태</label>
        <select name="soldStatus" required>
            <option value="판매준비중">판매준비중</option>
            <option value="판매중">판매중</option>
            <option value="판매완료">판매완료</option>




        </select>

        <button class="submit-btn" type="submit">등록</button>
    </form>
</div>

<script>
    $(document).ready(function () {
        $('#largeCate').change(function () {
            const largeCateCode = $(this).val();
            $('#mediumCate').html('<option value="">중분류 선택</option>');
            $('#smallCate').html('<option value="">소분류 선택</option>');
            if (largeCateCode) {
                $.get('${pageContext.request.contextPath}/admin/cars/categories/medium?parentCode=' + largeCateCode, function (data) {
                    $.each(data, function (index, item) {
                        $('#mediumCate').append('<option value="' + item.cateCode + '">' + item.cateName + '</option>');
                    });
                });
            }
        });

        $('#mediumCate').change(function () {
            const mediumCateCode = $(this).val();
            $('#smallCate').html('<option value="">소분류 선택</option>');
            if (mediumCateCode) {
                $.get('${pageContext.request.contextPath}/admin/cars/categories/small?parentCode=' + mediumCateCode, function (data) {
                    $.each(data, function (index, item) {
                        $('#smallCate').append('<option value="' + item.cateCode + '">' + item.cateName + '</option>');
                    });
                });
            }
        });
    });
</script>
>>>>>>> Stashed changes
</body>
</html>
