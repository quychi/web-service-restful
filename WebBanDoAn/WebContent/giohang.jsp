<%@page import="java.util.HashMap"%>
<%@page import="model.MonAn"%>
<%@page import="model.Cart"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=utf-8>
<link rel="stylesheet" type="text/css" href="css/web.css">
<title>Giỏ hàng</title>
</head>
<body>
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
			Cart cart;
			if (request.getSession().getAttribute("cart") != null) {
				System.out.println("Có");
				cart = (Cart) request.getSession().getAttribute("cart");
				System.out.println(cart.getList().size());

			} else {
				System.out.println("Rỗng");
				HashMap<MonAn, Integer> hash = new HashMap<>();
				cart = new Cart(hash);
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
		<div class="list_dat_hang">
			<%
				int tong = 0;
				for (MonAn monAn : cart.getList().keySet()) {
//					System.out.println(monAn.getId());
					tong += monAn.getGiaNiemYet()*cart.getList().get(monAn);
			%>
			<div class="monhang">
				<div class="anh_mon_an">
					<img alt="" src="<%=monAn.getAnh()%>">
				</div>
				<div class="thongtin">
					<h4>
						Tên món:
						<%=monAn.getTenMon()%></h4>
					<h4>
						Số lượng:
						<%=cart.getList().get(monAn)%></h4>
				</div>
				<div class="thanhtien">
					<h4>
						Thành tiền:  
						<%=cart.getList().get(monAn) * monAn.getGiaNiemYet()%>VNĐ
					</h4>

				</div>
			</div>
			<div class="gach"></div>
			<%
				}
			%>
			<div class="tong">
				<h3>
					Tổng Tiền:
					<%=tong%>
					VNĐ
				</h3>
			</div>
			<div class="submit">
				<%
   					 session.setAttribute("tongtien", tong);
					 /* request.getSession().getAttribute("username"); */
       			 %>
				<a type="submit" href="dathang.jsp">Đặt hàng</a>
			</div>
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

</body>
</html>