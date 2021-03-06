/**
 * 
 */
package com.taobao.fario.server.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.taobao.fario.server.db.HibernateSessionFactory;
import com.taobao.fario.server.service.LocationInfo;
import com.taobao.fario.server.service.ShopInfo;
import com.taobao.fario.server.service.User;
import com.taobao.fario.server.service.UserHistory;

/**
 * @author taichan
 * 
 */
@WebServlet(name = "AddShopServlet", urlPatterns = { "/addshop" })
public class AddShopServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		PrintWriter writer = resp.getWriter();
		req.setCharacterEncoding("GB2312");

		String shopName = new String(req.getParameter("shopname").getBytes(
				"ISO-8859-1"), "GB2312");

		String address = new String(req.getParameter("address").getBytes(
				"ISO-8859-1"), "GB2312");

		String shopurl = new String(req.getParameter("shopurl").getBytes(
				"ISO-8859-1"), "GB2312");
		String telephone = new String(req.getParameter("telephone").getBytes(
				"ISO-8859-1"), "GB2312");

		String fetchfrom = new String(req.getParameter("fetchfrom").getBytes(
				"ISO-8859-1"), "GB2312");

		String category = new String(req.getParameter("category").getBytes(
				"ISO-8859-1"), "GB2312");

		String fetchBy = new String(req.getParameter("fetchBy").getBytes(
				"ISO-8859-1"), "GB2312");

		Double latitude = Double.parseDouble(req.getParameter("latitude"));
		Double longitude = Double.parseDouble(req.getParameter("longitude"));
		Double altitude = Double.parseDouble(req.getParameter("altitude"));

		ShopInfo shop = new ShopInfo(shopName, address, shopurl, telephone,
				fetchfrom, category, fetchBy, latitude, longitude, altitude);

		Session session = HibernateSessionFactory.getSession();
		Transaction beginTransaction = session.beginTransaction();

		Criteria criteria = session.createCriteria(ShopInfo.class);

		criteria.add(org.hibernate.criterion.Expression.eq("shopurl", shopurl));
		List<ShopInfo> shoplist = criteria.list();

		if (shoplist.size() != 0) {
			writer.write("-1 shop exist.");
		} else {
			session.save(shop);
			writer.write("1 shop added.");
			beginTransaction.commit();
		}
		session.close();
		writer.flush();
		writer.close();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest
	 * , javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
