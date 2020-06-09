<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="control.MonAnCtr"%>
<%@page import="model.MonAn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/web.css">
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
	<%
		int id = Integer.parseInt(request.getParameter("id"));
		MonAnCtr monAnCtr = new MonAnCtr();
		MonAn monAn = monAnCtr.getMonAn(id);
		monAn.setId(id);
	%>
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
		<div id="admin">
			<form action="xoamon" method="post">
				<table>
					<tr>
						<td>Id:</td>
						<td><input type="text" name="id" value=<%=id%>></td>
					</tr>
					<tr>
						<td>Tên Món:</td>
						<td><input type="text" name="tenmon"
							value="<%=monAn.getTenMon()%>"></td>
					</tr>
					<tr>
						<td>Mô tả:</td>
						<td><input type="text" name="mota"
							value="<%=monAn.getMoTa()%>"></td>
					</tr>
					<tr>
						<td>Ảnh:</td>
						<td><input type="text" name="anh" value="<%=monAn.getAnh()%>">
						</td>
					</tr>
					<tr>
						<td>Giá niêm yết:</td>
						<td><input type="text" name="gia"
							value="<%=monAn.getGiaNiemYet()%>"></td>
					</tr>
					<tr>
						<td>Trạng thái:</td>
						<td><input type="text" name="trangthai"
							value="<%=monAn.getTrangThai()%>"></td>
					</tr>
					<tr>
						<td>Lượt xem:</td>
						<td><input type="text" name="luotxem"
							value="<%=monAn.getLuotXem()%>"></td>
					</tr>
					<tr>
						<td>Loại:</td>
						<td><input type="text" name="loai"
							value="<%=monAn.getloai()%>"></td>
					</tr>
					<tr>
						<td></td>
						<td><input type="submit" value="Xóa món" /></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<div class="mySlides background col-9 col-s-12">
		<img src="images/pizza_khuyen_mai.jpg">
		<div id="admin">
			<form action="xoamon" method="post">
				<table>
					<tr>
						<td>Id:</td>
						<td><input type="text" name="id" value=<%=id%>></td>
					</tr>
					<tr>
						<td>Tên Món:</td>
						<td><input type="text" name="tenmon"
							value="<%=monAn.getTenMon()%>"></td>
					</tr>
					<tr>
						<td>Mô tả:</td>
						<td><input type="text" name="mota"
							value="<%=monAn.getMoTa()%>"></td>
					</tr>
					<tr>
						<td>Ảnh:</td>
						<td><input type="text" name="anh" value="<%=monAn.getAnh()%>">
						</td>
					</tr>
					<tr>
						<td>Giá niêm yết:</td>
						<td><input type="text" name="gia"
							value="<%=monAn.getGiaNiemYet()%>"></td>
					</tr>
					<tr>
						<td>Trạng thái:</td>
						<td><input type="text" name="trangthai"
							value="<%=monAn.getTrangThai()%>"></td>
					</tr>
					<tr>
						<td>Lượt xem:</td>
						<td><input type="text" name="luotxem"
							value="<%=monAn.getLuotXem()%>"></td>
					</tr>
					<tr>
						<td>Loại:</td>
						<td><input type="text" name="loai"
							value="<%=monAn.getloai()%>"></td>
					</tr>
					<tr>
						<td></td>
						<td><input type="submit" value="Xóa món" /></td>
					</tr>
				</table>
			</form>
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
	</script>
</body>
</html>