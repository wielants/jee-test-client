package server;

import javax.ejb.Remote;

@Remote
public interface Ping {
	String ping (String s);
}
