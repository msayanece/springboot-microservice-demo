package com.sayan.moviecatalog;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("db")
@RefreshScope
public class DBConfig {

	private String connection;
	private String username;
	private String password;
	public DBConfig() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DBConfig(String connection, String username, String password) {
		super();
		this.connection = connection;
		this.username = username;
		this.password = password;
	}
	public String getConnection() {
		return connection;
	}
	public void setConnection(String connection) {
		this.connection = connection;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "DBConfig [connection=" + connection + ", username=" + username + ", password=" + password + "]";
	}
}
