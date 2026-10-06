<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Thêm danh mục</title>

    <style>
        body {
            margin: 0;
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
        }

        .container {
            width: 70%;
            margin: 30px auto;
            background: white;
            padding: 25px;
            box-shadow: 0 0 5px #ccc;
        }

        .title {
            background: #f5f5f5;
            border: 1px solid #ddd;
            padding: 15px;
            font-size: 20px;
            margin-bottom: 30px;
        }

        h2 {
            font-weight: normal;
            color: #333;
        }

        .form-group {
            margin-bottom: 25px;
        }

        label {
            display: block;
            font-weight: bold;
            margin-bottom: 8px;
        }

        input[type="text"] {
            width: 100%;
            padding: 12px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }

        input[type="file"] {
            margin-top: 5px;
        }

        .btn {
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            margin-right: 10px;
        }

        .btn-add {
            background-color: #337ab7;
            color: white;
        }

        .btn-reset {
            background-color: #5bc0de;
            color: white;
        }

        .btn-back {
            display: inline-block;
            margin-top: 20px;
            color: #337ab7;
            text-decoration: none;
        }
    </style>
</head>

<body>

<div class="container">

    <div class="title">
        Thêm danh mục
    </div>

    <h2>Danh mục:</h2>

    <form action="${pageContext.request.contextPath}/admin/category/add"
          method="post"
          enctype="multipart/form-data">

        <div class="form-group">

            <label>Tên danh sách:</label>

            <input type="text"
                   name="name"
                   class="form-control"
                   placeholder="Nhập tên danh mục"
                   required>

        </div>

        <div class="form-group">

            <label>Ảnh đại diện:</label>

            <input type="file"
                   name="icon"
                   accept="image/*">

        </div>

        <button type="submit"
                class="btn btn-add">
            Thêm
        </button>

        <button type="reset"
                class="btn btn-reset">
            Hủy
        </button>

    </form>

    <a class="btn-back"
       href="${pageContext.request.contextPath}/admin/category/list">
        ← Quay lại danh sách
    </a>

</div>

</body>
</html>