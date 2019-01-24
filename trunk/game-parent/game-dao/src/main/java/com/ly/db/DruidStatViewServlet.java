package com.ly.db;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

import com.alibaba.druid.support.http.StatViewServlet;

@WebServlet(urlPatterns="/druid/*",initParams={@WebInitParam(name="allow",value="210.4.119.50,127.0.0.1"),
         @WebInitParam(name="deny",value="0.0.0.0"),
         @WebInitParam(name="loginUsername",value="admin"),
         @WebInitParam(name="loginPassword",value="123456"),
         @WebInitParam(name="resetEnable",value="false")
})
public class DruidStatViewServlet extends StatViewServlet{

	private static final long serialVersionUID = 1L;

}
