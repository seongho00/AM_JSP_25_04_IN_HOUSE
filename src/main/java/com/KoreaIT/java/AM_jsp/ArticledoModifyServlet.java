package com.KoreaIT.java.AM_jsp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.KoreaIT.java.AM_jsp.DBUtil;
import com.KoreaIT.java.AM_jsp.SecSql;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/article/doModify")
public class ArticledoModifyServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		String url = "jdbc:mysql://127.0.0.1:3306/AM_JSP_25_04?useUnicode=true&characterEncoding=utf8&autoReconnect=true&serverTimezone=Asia/Seoul";
		String user = "";
		String password = "";

		Connection conn = null;

		try {
			conn = DriverManager.getConnection(url, "root", "");
			response.getWriter().append("연결 성공!");

			SecSql sql = new SecSql();

			String title = request.getParameter("title");
			int id = Integer.parseInt(request.getParameter("id"));
			String body = request.getParameter("body");

			sql.append("UPDATE article ");
			sql.append("SET regDate = NOW(),");
			sql.append("title = ?,", title);
			sql.append("`body` = ?", body);
			sql.append("WHERE id = ?;", id);

			DBUtil.update(conn, sql);

			response.getWriter().append(String.format("<script>location.replace('list');</script>"));

		} catch (SQLException e) {
			System.out.println("에러 1 : " + e);
		} finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}