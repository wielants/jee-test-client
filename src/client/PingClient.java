package client;

import java.util.Properties;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import server.Ping;

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
		Ping ping = (Ping) ctx.lookup("java:global/example/example/PingEJB"); 
		System.out.println(ping.ping("Ping!"));
	}
}
