package com.agfa.jenkins.ataf;

import hudson.console.LineTransformationOutputStream;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public class AtafTestAnnotator extends LineTransformationOutputStream {
    private final OutputStream out;
    private final Charset charset;

    private boolean seenEmptyLine;

    public AtafTestAnnotator(OutputStream out, Charset charset) {
        this.out = out;
        this.charset = charset;
    }

    @Override
    protected void eol(byte[] b, int len) throws IOException {
        String line = charset.decode(ByteBuffer.wrap(b, 0, len)).toString();

        // trim off CR/LF from the end
        line = trimEOL(line);

        if (line.contains("<testsuite name=")) {
            new AtafTestNote().encodeTo(out);
        }

        out.write(b,0,len);
    }

    @Override
    public void close() throws IOException {
        super.close();
        out.close();
    }

}
