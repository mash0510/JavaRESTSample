package com.example.demo.domain;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import jakarta.servlet.ReadListener;
import jakarta.servlet.ServletInputStream;

public class BufferedServletInputStream extends ServletInputStream {

    private ByteArrayInputStream inputStream;

    // byte配列で初期化
    public BufferedServletInputStream(byte[] buffer) {
        this.inputStream = new ByteArrayInputStream(buffer);
    }

    @Override
    public int available() throws IOException {
        return inputStream.available();
    }

    @Override
    public int read() throws IOException {
        return inputStream.read();
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        return inputStream.read(b, off, len);
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public boolean isReady() {
        return false;
    }

    @Override
    public void setReadListener(ReadListener listener) {

    }
}