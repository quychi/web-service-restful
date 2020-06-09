<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Đặt hàng</title>
</head>
<body>
	<form action="dathang" method="post">
		<table>
			<tr>
				<td>Tài khoản:</td>
				<td><input type="text" name="usernameTaikhoanMua" value="<%=request.getSession().getAttribute("username")%>" readonly></td>
				<%-- <%System.out.println(request.getSession().getAttribute("username")); %> --%>
			</tr>
			<tr>
				<td>Tên:</td>
				<td><input name="name"></td>
			</tr>

			<tr>
				<td>Tỉnh/Thành phố:</td>
				<td><input type="text" name="thanhpho"></td>
			</tr>
			<tr>
				<td>Quận/huyện:</td>
				<td><input type="text" name="huyen"></td>
			</tr>
			<tr>
				<td>Xã/Phường:</td>
				<td><input type="text" name="xa"></td>
			</tr>
			<tr>
				<td>SĐT:</td>
				<td><input type="text" name="sdt"></td>
			</tr>

		</table>
		<input type="submit" value="Đặt hàng">
	</form>
	
	<fieldset>
	<legend>Thanh toán qua cổng PayPal</legend>
	<form action="https://www.sandbox.paypal.com/cgi-bin/webscr" method="post">

            <!-- Nhập địa chỉ email người nhận tiền (người bán) -->
            <input type="hidden" name="business" value="newsellersandbox@gmail.com">

            <!-- tham số cmd có giá trị _xclick chỉ rõ cho paypal biết là người dùng nhất nút thanh toán -->
            <input type="hidden" name="cmd" value="_xclick">

            <!-- Thông tin mua hàng. -->
            <input type="hidden" name="item_name" value="HoaDonMuaHang">
			<!--Trị giá của giỏ hàng, vì paypal không hỗ trợ tiền việt nên phải đổi ra tiền $-->
            
				
				
				
					<%int tongtien = (int) session.getAttribute("tongtien");%>
    			
				
			Số tiền hóa đơn : <input type="number" name="amount" placeholder="Số tiền vào" value="<%=tongtien*0.000043 %>" readonly>USD	
<!-- ??? -->            <%-- <p  name="amount" >Số tiền hóa đơn : <%=tongtien*0.000043%> USD</p> --%>
			<!--Loại tiền-->
            <input type="hidden" name="currency_code" value="USD">
			<!--Đường link mình cung cấp cho Paypal biết để sau khi xử lí thành công nó sẽ chuyển về theo đường link này-->
            <input type="hidden" name="return" value="http://localhost:8080/WebBanDoAn_R/thanhcong.html">
			<!--Đường link mình cung cấp cho Paypal biết để nếu  xử lí KHÔNG thành công nó sẽ chuyển về theo đường link này-->
            <input type="hidden" name="cancel_return" value="http://localhost:8080/WebBanDoAn_R/loi.html">
            <!-- Nút bấm. -->
           <!--  <input type="submit" src="images/buttonpaypal.png" name="submit" value="Thanh toán qua Paypal">
            src="images/buttonpaypal.png" -->
            <button type="submit" name="submit">
            <img alt="" src="images/buttonpaypal.png">
            </button>
	</form>
</fieldset>
	<div>
		<a href="indexVNPAY.jsp">Thanh toán qua VNPAY</a>
	</div>
</body>
</html>