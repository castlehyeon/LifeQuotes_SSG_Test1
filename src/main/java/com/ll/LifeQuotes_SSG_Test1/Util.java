package com.ll.LifeQuotes_SSG_Test1;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Util {
    public static void saveToFile(String path, String body) {//파일 내용 저장
        try (RandomAccessFile stream = new RandomAccessFile(path, "rw");
             FileChannel channel = stream.getChannel()){
            byte[] strBytes = body.getBytes();
            ByteBuffer buffer = ByteBuffer.allocate(strBytes.length);
            buffer.put(strBytes);
            buffer.flip();
            channel.write(buffer);
            //stream.close();
            //channel.close();
            //close없애기!
        } catch (IOException e) {

        }
    }

    public static void mkdir(String path) { //파일을 넣을 디렉토리 추가 mkdirs
        File dir = new File(path);
        dir.mkdirs();
    }

    public static String loadFile(String path) { //파일 내용 불러오기
        try {
            RandomAccessFile reader = new RandomAccessFile(path, "r");
            String body = reader.readLine();
            reader.close();

            return new String(body.getBytes("iso-8859-1"), "utf-8");
        }
        catch ( IOException e ) {
        }

        return "";
    }
}
