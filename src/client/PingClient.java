package client;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import server.PingSessionBeanRemote;

public class PingClient {
	private InitialContext ctx;

	private PingClient() {
		Properties props = new Properties();
		props.put ("java.naming.factory.initial", "weblogic.jndi.WLInitialContextFactory");
		props.put ("java.naming.provider.url", "t3://<host>:<port>");
		ctx = new InitialContext(props);
	}

	public static void main(String[] args) throws NamingException {
		PingClient client = new PingClient();
		client.testPing();
	}

	private void testPing() throws NamingException {
		PingSegssionBeanRemote proxy = (PingSessionBeanRemote) ctx.lookup("java:global/example/example/PingEJB"); 
		System.out.println(proxy.ping("Ping!"));
	}
}
