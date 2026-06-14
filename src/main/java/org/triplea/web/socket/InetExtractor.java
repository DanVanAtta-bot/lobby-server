package org.triplea.web.socket;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Splitter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.util.Map;
import lombok.experimental.UtilityClass;

@UtilityClass
public class InetExtractor {

  @VisibleForTesting
  public static final String IP_ADDRESS_KEY = "jakarta.websocket.endpoint.remoteAddress";

  /**
   * Returns the IP address of the session from the provided 'userSession' map. The value is expected
   * to be an {@link InetSocketAddress} injected by {@link RemoteAddressConfigurator}; it is expected
   * that we will always find one.
   */
  public static InetAddress extract(final Map<String, Object> userSession) {
    final InetSocketAddress remote = (InetSocketAddress) userSession.get(IP_ADDRESS_KEY);
    return remote.getAddress();
  }
}
