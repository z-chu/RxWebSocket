package com.dhh.websocket;


import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;

import io.reactivex.rxjava3.functions.Consumer;
import okhttp3.WebSocket;
import okio.ByteString;

/**
 * Created by dhh on 2017/11/1.
 */
@Deprecated
public abstract class WebSocketConsumer implements Consumer<WebSocketInfo> {
    @CallSuper
    @Override
    public void accept(WebSocketInfo webSocketInfo) throws Exception {
        if (webSocketInfo.isOnOpen()) {
            onOpen(webSocketInfo.getWebSocket());
        } else if (webSocketInfo.getString() != null) {
            onMessage(webSocketInfo.getString());
        } else if (webSocketInfo.getByteString() != null) {
            onMessage(webSocketInfo.getByteString());
        }
    }

    public abstract void onOpen(@NonNull WebSocket webSocket);

    public abstract void onMessage(@NonNull String text);

    public abstract void onMessage(@NonNull ByteString bytes);
}
