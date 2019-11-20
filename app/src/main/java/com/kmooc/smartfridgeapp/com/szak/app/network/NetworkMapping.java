package com.kmooc.smartfridgeapp.com.szak.app.network;

import java.net.HttpURLConnection;

public interface NetworkMapping {
    ProtocolType PROTOCOL_TYPE = ProtocolType.HTTP;
    String PORTNUMBER = "3000";
    String ADDRESS = "remoteworkstation.ddns.net" + ":" + PORTNUMBER;
}
