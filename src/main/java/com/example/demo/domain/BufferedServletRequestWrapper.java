package com.example.demo.domain;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import jakarta.servlet.ServletInputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;

public class BufferedServletRequestWrapper extends HttpServletRequestWrapper {

    private byte[] buffer;

    public BufferedServletRequestWrapper(HttpServletRequest request) throws IOException {
        super(request);

        // Request BodyからStreamを取得
        InputStream is = request.getInputStream();

        // Streamをbyte配列に変換し、インスタンス変数に保持
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte buff[] = new byte[1024];
        int read;
        while ((read = is.read(buff)) > 0) {
            baos.write(buff, 0, read);
        }

        this.buffer = baos.toByteArray();
    }

    // Bodyの取得元をこのメソッドに差替え
    @Override
    public ServletInputStream getInputStream() throws IOException {
        // Streamクラスを初期化して返却
        return new BufferedServletInputStream(this.buffer);
    }
}
