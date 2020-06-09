<%@page import="java.util.HashMap"%>
<%@page import="control.CartCtr"%>
<%@page import="model.Cart"%>
<%@page import="control.MonAnCtr"%>
<%@page import="model.MonAn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" type="text/css" href="css/web.css">
<title>Trang chủ</title>
</head>
<div id="fb-root"></div>
<script>
	
</script>
<body>
	<%
		int id = Integer.parseInt(request.getParameter("id"));
		MonAnCtr monAnCtr = new MonAnCtr();
		MonAn monAn = monAnCtr.getMonAn(id);
		monAn.setId(id);
	%>
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
	<div class="web">
		<%
			if (request.getSession() == null || request.getSession().getAttribute("username") == null) {
		%>
		<div class="login">
			<p class="text_login" id="login">
				<a href="login.jsp">Đăng nhập</a>
			</p>
			<p class="text_login">/</p>
			<p class="text_login" id="register">
				<a href="register.jsp">Đăng ký</a>
			</p>
		</div>
		<%
			}
		%>
		<div class="gach"></div>
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
		<div class="test RWD col-12 col-s-12" >
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
		<!-- <div class="menu">
			<ul class="col-8 col-s-12">
				<li><a href="index.jsp">Trang chủ</a></li>
				<li><a href="">Khuyến mại</a></li>
				<li><a href="">Liên hệ</a></li>



			</ul>
			<div class="search col-4 col-s-12">
				<form class="search_form" action="timkiem.jsp" method="get">
					<input id="search" type="text" name="search">
					<button type="submit" class="image_submit">Tìm kiếm</button>
				</form>
			</div>
		</div> -->

		<%-- <div id="chitietmon1 col-3 col-s-12">
			<img src="<%=monAn.getAnh()%>">
		</div>

		<div id="chitietmon2 col-9 col-s-12">
			<h2 id="tenmon" class="center"><%=monAn.getTenMon()%></h2>
			<div class="infor_food">
				<p class="text_desc">Mô tả:</p>
				<p id="mo_ta"><%=monAn.getMoTa()%></p>
			</div>
			<div class="infor_food">
				<p class="text_desc">Tình trạng:</p>
				<p id="tinh_trang"><%=monAn.getTrangThai()%></p>
			</div>
			<div class="infor_food">
				<p class="text_desc">Giá:</p>
				<p id="gia"><%=monAn.getGiaNiemYet()%>
					VNĐ
				</p>
			</div>
			<div class="infor_food">
				<p class="text_desc">Lượt xem:</p>
				<p id="luot_xem"><%=monAn.getLuotXem()%>

				</p>
			</div>
			<%
				request.getSession().setAttribute("food", monAn);
			%>
			<div class="button_add_to_cart">
				<form method="post" action="add_to_cart">

					<input type="submit" name="add_to_cart" value="Thêm vào giỏ hàng">
				</form>
			</div>
		</div> --%>

	<table>
		<tr>
			<td><img src="<%=monAn.getAnh()%>"></td>
			<td><h2 id="tenmon" class="center"><%=monAn.getTenMon()%></h2>
			<div class="infor_food">
				<p class="text_desc">Mô tả:</p>
				<p id="mo_ta"><%=monAn.getMoTa()%></p>
			</div>
			<div class="infor_food">
				<p class="text_desc">Tình trạng:</p>
				<p id="tinh_trang"><%=monAn.getTrangThai()%></p>
			</div>
			<div class="infor_food">
				<p class="text_desc">Giá:</p>
				<p id="gia"><%=monAn.getGiaNiemYet()%>
					VNĐ
				</p>
			</div>
			<div class="infor_food">
				<p class="text_desc">Lượt xem:</p>
				<p id="luot_xem"><%=monAn.getLuotXem()%>

				</p>
			</div>
			<%
				request.getSession().setAttribute("food", monAn);
			%>
			<div class="button_add_to_cart">
				<form method="post" action="add_to_cart">

					<input type="submit" name="add_to_cart" value="Thêm vào giỏ hàng">
				</form></td>
		</tr>
	</table>

		</div>
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
				<p>nguyenquychi@gmail.com</p>
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
</body>
</html>