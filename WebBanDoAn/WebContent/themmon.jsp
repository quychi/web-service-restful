<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="control.MonAnCtr"%>
<%@page import="model.MonAn"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/web.css">
<meta charset="UTF-8">
<title>quan ly mon an</title>
</head>
<body>
<!--  begin navbar-->
 <link rel="stylesheet" type="text/css" href="css/index.css">
  <div class="container">
    <div class="logo-box">
      <a href="/">
        <img src="images/organic-restaurant-logo.png">
      </a>
    </div>
    <nav>
    <ul>
      <li><a href="index.jsp">Trang chủ</a></li>
			<li><a href="">Khuyến mại</a></li>
			<li><a href="">Liên hệ</a></li>
      
      <li><form class="search_form" action="timkiem.jsp" method="get">
					<input id="search" type="text" name="search">
					<button type="submit" class="image_submit">Tìm kiếm</button>
				</form></li>
   </ul>
  </nav>
  </div>
  <!--  end navbar-->
	<div class="header">
		<div class="name_of_web col-10 col-s-12">
			<h1>
				<a href="index.jsp">Fast Food</a>
			</h1>
		</div>
		<div class="cart col-2 col-s-12">
			<div class="cangiuacart">
			<table>
				<tr>
					<td>
						<img src="images/cart.png" href="giohang.jsp">
					</td>
					
					<td>
						<p>
							<a href="giohang.jsp">Giỏ hàng</a>
						</p>
					</td>
				</tr>
			</table>
			</div>
		</div>
	</div>
	<div class="test RWD col-12 col-s-12">
		<div class="transport col-4 col-s-12">
			<div class="icon_transport">
				<img src="images/transport.png" class="imgpro">
			</div>
			<div class="text_transport">
				<div>Miễn phí vận chuyển</div>
				<div class="free_transport">
					<p>Bán kính 5km</p>
				</div>
			</div>
		</div>
		<div class="transport col-4 col-s-12">
			<div class="icon_transport">
				<img src="images/support.png" class="imgpro">
			</div>
			<div class="text_transport">
				<div>Hỗ trợ</div>
				<div id="hotline">
					<p>Hotline: 0972479732</p>
				</div>
			</div>
		</div>
		<div class="transport col-4 col-s-12">
			<div class="icon_transport">
				<img src="images/time.png" class="imgpro">
			</div>
			<div class="text_transport">
				<div>Giờ làm việc</div>
				<div id="">
					<p>Tất cả các ngày trong tuần</p>
				</div>
			</div>
		</div>

	</div>
	<!-- <div class="menu col-12 col-s-12">
		<div class="col-9 col-s-12">
		<ul >
			<li><a href="index.jsp">Trang chủ</a></li>
			<li><a href="">Khuyến mại</a></li>
			<li><a href="">Liên hệ</a></li>



		</ul>
		</div>
		<div class="col-3 col-s-12">
			<form class="search_form" action="timkiem.jsp" method="get">
				<input id="search" type="text" name="search">
				<button type="submit" class="image_submit">Tìm kiếm</button>
			</form>
		</div>
	</div> -->
	<div class="categories col-3 col-s-12">
		<p>Danh mục sản phẩm</p>
		<ul>
			<li><a href="phanloat.jsp?type=Com">Cơm</a></li>
			<div class="gach"></div>
			<li><a href="phanloat.jsp?type=Mi mien">Mì miến</a></li>
			<div class="gach"></div>
			<li><a href="phanloat.jsp?type=Do an vat">Đồ ăn vặt</a></li>
			<div class="gach"></div>
			<li><a href="phanloat.jsp?type=Hoa qua">Hoa quả</a></li>
			<div class="gach"></div>
			<li><a href="phanloat.jsp?type=Do uong">Đồ uống</a></li>
			<div class="gach"></div>
		</ul>
	</div>
	<div class="mySlides background col-9 col-s-12">
		<img src="images/background.png">
	</div>
	<div class="mySlides background col-9 col-s-12">
		<img src="images/pizza_khuyen_mai.jpg">
	</div>
		
		
		
		<div class="col-3 col-s-12">
		</div>
		
		<div id="admin" class="col-9 col-s-12">
			<form action="themmon" method="post">
				<table>
					<tr>
						<td>Id:</td>
						<td><input type="text" id="idFood" name="id" value="">Truong id
							nay tu dong tang trong csdl!<br></td>
					</tr>
					<tr>
						<td>Tên Món:</td>
						<td><input type="text" id="nameFood" name="tenmon" onfocusout="checkParam()" value="">
							<p id="nameFoodEr" class="er-red"></p>
						</td>
					</tr>
					<tr>
						<td>Mô tả:</td>
						<td><input type="text" id="DescriptionFood" name="mota" onfocusout="checkParam()" value="">
							<p id="DescriptionFoodEr" class="er-red"></p>
						</td>
					</tr>
					<tr>
						<td>Ảnh:</td>
						<td><input type="text" id="pictureFood" name="anh" onfocusout="checkParam()" value="">
							<p id="pictureFoodEr" class="er-red"></p>
						</td>
					</tr>
					<tr>
						<td>Giá niêm yết:</td>
						<td><input type="text" id="priceFood" name="gia" onfocusout="checkParam()" value="">
							<p id="priceFoodEr" class="er-red"></p>
						</td>
					</tr>
					<tr>
						<td>Trạng thái:</td>
						<td><input type="text" id="statusFood" name="trangthai" onfocusout="checkParam()" value="">
							<p id="statusFoodEr" class="er-red"></p>
						</td>
					</tr>
					<tr>
						<td>Lượt xem:</td>
						<td><input type="text" id="viewFood" name="luotxem" onfocusout="checkParam()" value="">
							<p id="viewFoodEr" class="er-red"></p>
						</td>
					</tr>
					<tr>
						<td>Loại:</td>
						<td><input type="text" id="typeFood" name="loai" onfocusout="checkParam()" value="">
							<p id="typeFoodEr" class="er-red"></p>
						</td>
					</tr>
					<tr>
						<td></td>
						<td><input type="submit" value="Lưu" /></td>
					</tr>
				</table>
			</form>
	</div>


	<div class="footer">
		<div class="contact col-4 col-s-4">
			<div class="address">
				<img src="images/address.png">
				<p>18 Trần Phú, Hà Đông, Hà Nội</p>
			</div>

			<div class="address">
				<img src="images/phone.png">
				<p>0972479732</p>
			</div>
			<div class="address">
				<img src="images/mail.png">
				<p>nguyenducanhit97@gmail.com</p>
			</div>
		</div>
		<div class="facebook col-4 col-s-8">
			<p style="color: white; font-size: 20px;">Facebook</p>
			<div class="fb-page"
				data-href="https://www.facebook.com/NaCl.muoi.man/"
				data-tabs="timeline" data-width="200" data-height="150"
				data-small-header="false" data-adapt-container-width="true"
				data-hide-cover="false" data-show-facepile="true">
				<blockquote cite="https://www.facebook.com/NaCl.muoi.man/"
					class="fb-xfbml-parse-ignore";></blockquote>
				<iframe
					src="https://www.facebook.com/plugins/page.php?href=https%3A%2F%2Fwww.facebook.com%2FNaCl.muoi.man%2F&tabs&width=180&height=70&small_header=false&adapt_container_width=true&hide_cover=false&show_facepile=true&appId"
					width="200" height="150"></iframe>
			</div>
		</div>
		<div class="map col-4 col-s-12">
			<p style="">Bản đồ</p>
			<div>
				<iframe width="200" height="150" frameborder="0" style="border: 0"
					src="https://www.google.com/maps/embed/v1/place?key=AIzaSyAeuvEcx48pt_bVmzqUlpaSFDwFEi-kttc&q=18 Tráº§n PhÃº, HÃ  Ä�Ã´ng, HÃ  Ná»™i"
					allowfullscreen> </iframe>
			</div>
		</div>

	</div>
	
	
	
			<script src="js/jquery-3.2.1.min.js"></script>
	
	
	
	<script type="text/javascript">
		// Automatic Slideshow - change image every 4 seconds
		var myIndex = 0;
		carousel();

		function carousel() {
			var i;
			var x = document.getElementsByClassName("mySlides");
			for (i = 0; i < x.length; i++) {
				x[i].style.display = "none";
			}
			myIndex++;
			if (myIndex > x.length) {
				myIndex = 1
			}
			x[myIndex - 1].style.display = "block";
			setTimeout(carousel, 3000);
		}
		
		// check tham số.
		
		function checkParam() {

			// chuẩn hóa đầu vào
			var id = document.getElementById("idFood").value.trim();
			var ten = document.getElementById("nameFood").value.trim();
			var mota = document.getElementById("DescriptionFood").value.trim();
			var anh = document.getElementById("pictureFood").value.trim();
			var gianiemyet = document.getElementById("priceFood").value.trim();
			var trangthai = document.getElementById("statusFood").value.trim();
			var luotxem = document.getElementById("viewFood").value.trim();
			var loai = document.getElementById("typeFood").value.trim();

			// name
			if (ten == "") {
				document.getElementById("nameFoodEr").innerHTML = "Chưa nhập tên món ăn";

			} else {
				document.getElementById("nameFoodEr").innerHTML = "";
			}

			if (mota == "") {
				document.getElementById("DescriptionFoodEr").innerHTML = "Chưa nhập mô tả món ăn";

			} else {
				document.getElementById("DescriptionFoodEr").innerHTML = "";
			}


			if (anh == "") {
				document.getElementById("pictureFoodEr").innerHTML = "Chưa nhập đường dẫn ảnh món ăn";

			} else {
				document.getElementById("pictureFoodEr").innerHTML = "";
			}

			if (gianiemyet == "") {
				document.getElementById("priceFoodEr").innerHTML = "Chưa nhập giá niêm yết món ăn";

			} else {
				document.getElementById("priceFoodEr").innerHTML = "";
			}

			if (trangthai == "") {
				document.getElementById("statusFoodEr").innerHTML = "Chưa nhập trạng thái món ăn";

			} else {
				document.getElementById("statusFoodEr").innerHTML = "";
			}

			if (luotxem == "") {
				document.getElementById("viewFoodEr").innerHTML = "Chưa nhập số lượng xem món ăn";

			} else {
				document.getElementById("viewFoodEr").innerHTML = "";
			}

			if (loai == "") {
				document.getElementById("typeFoodEr").innerHTML = "Chưa nhập loại món ăn";

			} else {
				document.getElementById("typeFoodEr").innerHTML = "";
			}
		}
	</script>
</body>
</html>