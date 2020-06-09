<%@page import="java.util.regex.Pattern"%>
<%@page import="java.text.Normalizer"%>
<%@page import="model.Cart"%>
<%@page import="java.util.ArrayList"%>
<%@page import="control.MonAnCtr"%>
<%@ page import="model.MonAn" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

 <meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no">
 <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
 <meta name="HandheldFriendly" content="true">

<link rel="stylesheet" type="text/css" href="css/web.css">
<title>Trang chủ</title>
<meta content="text/html">
</head>
<div id="fb-root"></div>
<script type="text/javascript">
	
</script>
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
		<div class="menu">
			<div class="samerowsearch col-7 col-s-12">
			<ul>
				<li><a href="index.jsp">Trang chủ</a></li>
				<li><a href="">Khuyến mại</a></li>
				<li><a href="">Liên hệ</a></li>



			</ul>
			</div>
			<div class="search col-5 col-s-12">
				<form class="search_form" action="timkiem.jsp" method="get">
					<input id="search" type="text" name="search">
					<button type="submit" class="image_submit">Tìm kiếm</button>
				</form>
			</div>
		</div>
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

		<div class="rice">
			<p>Cơm</p>
			<div class="list">
			<%
				if (request.getSession().getAttribute("cart") == null){
					System.out.println("null");
				}
				else{
					System.out.println("not null");
					Cart cart =  (Cart) request.getSession().getAttribute("cart");
					System.out.println(cart.getList().size());
				}
				MonAnCtr monAnCtr = new MonAnCtr();
				ArrayList<MonAn> list = monAnCtr.getListMonAn("Com");
				for (int i = 0; i < 5; i++) {
			%>
				<div class="list_rice">
				<img alt="" src="<%=list.get(i).getAnh()%>">
				<h5><%=list.get(i).getTrangThai()%></h5>

				<h4>
					<a id="id" href="goichitietmon.jsp?id=<%=list.get(i).getId()%>">
						<%=list.get(i).getTenMon()%>
					</a>

				</h4>

				</div>
			
			<%
				}
			%>
			</div>
		</div>
		<p class="show_list_rice">
			<a href="phanloat.jsp?type=Com">Xem thêm >>></a>
		</p>

		<div class="gach"></div>

		<div class="rice">
			<p>Mì miến</p>
			<div class="list">
			<%
				ArrayList<MonAn> listMiMien = monAnCtr.getListMonAn("Mi mien");
				for (int i = 0; i < 5; i++) {
			%>
			
			<div class="list_rice">
				<img alt="" src="<%=listMiMien.get(i).getAnh()%>">
				<h5><%=listMiMien.get(i).getTrangThai()%></h5>
				<h4>
					<a id="id"
						href="goichitietmon.jsp?id=<%=listMiMien.get(i).getId()%>"> <%=listMiMien.get(i).getTenMon()%>
					</a>
				</h4>
			</div>
			<%
				}
			%>
			</div>
		</div>
		<p class="show_list_rice">
			<a href="phanloat.jsp?type=Mi mien">Xem thêm >>></a>
		</p>
		<div class="gach"></div>
		<div class="rice">
			<p>Đồ ăn vặt</p>
			<div class="list">
			<%
				ArrayList<MonAn> listDoAnVat = monAnCtr.getListMonAn("Do an vat");
				for (int i = 0; i < 5; i++) {
			%>
			<div class="list_rice">
				<img alt="" src="<%=listDoAnVat.get(i).getAnh()%>">
				<h5><%=listDoAnVat.get(i).getTrangThai()%></h5>
				<h4>
					<a id="id"
						href="goichitietmon.jsp?id=<%=listDoAnVat.get(i).getId()%>"> <%=listDoAnVat.get(i).getTenMon()%>
					</a>
				</h4>
			</div>
			<%
				}
			%>
			</div>
		</div>
		<p class="show_list_rice">
			<a href="phanloat.jsp?type=Do an vat">Xem thêm >>></a>
		</p>
		<div class="gach"></div>
		<div class="rice">
			<p>Hoa quả</p>
			<div class="list">

			<%
				ArrayList<MonAn> listHoaQua = monAnCtr.getListMonAn("Hoa qua");
				for (int i = 0; i < 5; i++) {
			%>
			<div class="list_rice">
				<img alt="" src="<%=listHoaQua.get(i).getAnh()%>">
				<h5><%=listHoaQua.get(i).getTrangThai()%></h5>
				<h4>
					<a id="id"
						href="goichitietmon.jsp?id=<%=listHoaQua.get(i).getId()%>"> <%=listHoaQua.get(i).getTenMon()%>
					</a>
				</h4>
			</div>
			<%
				}
			%>
			</div>
		</div>



		<p class="show_list_rice">
			<a href="phanloat.jsp?type=Hoa qua">Xem thêm >>></a>
		</p>
		<div class="gach"></div>
		<div class="rice">
			<p>Đồ uống</p>
			<div class="list">
			<%
				ArrayList<MonAn> listDoUong = monAnCtr.getListMonAn("Do uong");
				for (int i = 0; i < 5; i++) {
			%>
			<div class="list_rice">
				<img alt="" src="<%=listDoUong.get(i).getAnh()%>">
				<h5><%=listDoUong.get(i).getTrangThai()%></h5>
				<h4>
					<a id="id"
						href="goichitietmon.jsp?id=<%=listDoUong.get(i).getId()%>"> <%=listDoUong.get(i).getTenMon()%>
					</a>
				</h4>
			</div>

			<%
				}
			%>
			</div>
		</div>
		<p class="show_list_rice">
			<a href="phanloat.jsp?type=Do uong">Xem thêm >>></a>
		</p>


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
	    if (myIndex > x.length) {myIndex = 1}    
	    x[myIndex-1].style.display = "block";  
	    setTimeout(carousel, 1000);    
	}
	</script>
</body>
</html>