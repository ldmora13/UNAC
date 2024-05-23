package com.quiz.Controller;

import java.io.IOException;
import java.io.RandomAccessFile;

public class leerLog {
    private String filePath;

    public leerLog(String filePath) {
        this.filePath = filePath;
    }

    public String usuarioLog() throws IOException {
        try (RandomAccessFile fileHandler = new RandomAccessFile(filePath, "r")) {
            long fileLength = fileHandler.length() - 1;
            StringBuilder sb = new StringBuilder();
            if (fileLength < 0) {
                return null;
            }
            for(long filePointer = fileLength; filePointer != -1; filePointer--){
                fileHandler.seek(filePointer);
                int readByte = fileHandler.readByte();
                if (readByte == 0xD) {
                    if (filePointer == fileLength - 1) {
                        continue;
                    }
                    break;
                }
                sb.append((char) readByte);
            }
            return sb.reverse().toString();
        }
    }
}
