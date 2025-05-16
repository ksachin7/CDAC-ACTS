package com.cdac.acts.file.practice;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class BinaryFileOps {

    public static void main(String[] args) {

        Path fileName= Path.of("./src/com/cdac/acts/file/practice/out/BinaryOps.dat");
        System.out.println(fileName.getParent());

        // creating file
        try{
            if(Files.notExists(fileName)){
                Files.createDirectories(fileName.getParent());
                Files.createFile(fileName);
                System.out.println("File created: " + fileName);
            }
        }catch(IOException e){
            e.printStackTrace();
        }

        // Read binary data
        try (FileInputStream fis = new FileInputStream(fileName.toFile())) {
            int byteData;
            while ((byteData = fis.read()) != -1) {
                System.out.print(byteData + " ");  // Raw byte data
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileInputStream fis = new FileInputStream(fileName.toFile())) {

            // 1. Read byte: 'A'
            int a = fis.read();
            System.out.println("Byte A: " + a + " (" + (char) a + ")");

            // 2. Read bytes: 'B', 'C', 'D'
            int b = fis.read();
            int c = fis.read();
            int d = fis.read();
            System.out.println("Bytes: " + b + " " + c + " " + d);

            // 3. Read newline
            fis.read(); // skip newline

            // 4. Read short: 2 bytes
            int s1 = fis.read();
            int s2 = fis.read();
            int shortVal = (s1 << 8) | s2;
            System.out.println("Short: " + shortVal);

            // 5. Read int: 4 bytes
            int i1 = fis.read();
            int i2 = fis.read();
            int i3 = fis.read();
            int i4 = fis.read();
            int intVal = (i1 << 24) | (i2 << 16) | (i3 << 8) | i4;
            System.out.println("Int: " + intVal);

            // 6. Read float: 4 bytes (convert from int bits)
            int f1 = fis.read();
            int f2 = fis.read();
            int f3 = fis.read();
            int f4 = fis.read();
            int floatBits = (f1 << 24) | (f2 << 16) | (f3 << 8) | f4;
            float floatVal = Float.intBitsToFloat(floatBits);
            System.out.println("Float: " + floatVal);

            // 7. Read remaining bytes as String
            StringBuilder sb = new StringBuilder();
            int ch;
            while ((ch = fis.read()) != -1 && ch != '\n') {
                sb.append((char) ch);
            }
            System.out.println("String: " + sb.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Write different types of data to the binary file
        try (FileOutputStream fos = new FileOutputStream(fileName.toFile())) {
            // Writing an integer (4 bytes)
            fos.write(65);  // Write a byte (ASCII 'A')
            fos.write(new byte[]{66, 67, 68});  // Write 'B', 'C', 'D'
            fos.write('\n');  // New line (byte)

            // Writing a short (2 bytes)
            fos.write(new byte[]{0, 100});  // Short value 100 (as bytes)

            // Writing an integer (4 bytes)
            fos.write(new byte[]{0, 0, 0, 123}); // Integer value 123 (as bytes)

            // Writing a float (4 bytes)
            int floatBits = Float.floatToIntBits(3.14f); // Convert float to bits
            fos.write(new byte[]{
                    (byte) (floatBits >>> 24),
                    (byte) (floatBits >>> 16),
                    (byte) (floatBits >>> 8),
                    (byte) (floatBits)
            });

            // Writing a string (length-prefixed)
            String str = "Hello, Binary!";
            fos.write(str.getBytes());  // Write string as bytes
            fos.write('\n');  // Newline after string

        } catch (IOException e) {
            e.printStackTrace();
        }

        // With DataInputStream(Read) & DataOutputStream(Write)
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName.toFile()))) {
            dos.writeByte(65);                  // 'A'
            dos.writeByte(66);                  // 'B'
            dos.writeShort(100);                // short
            dos.writeInt(123);                  // int
            dos.writeFloat(3.14f);              // float
            dos.writeUTF("Hello, Binary!");    // String
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (DataInputStream dis = new DataInputStream(new FileInputStream(fileName.toFile()))) {
            byte a = dis.readByte();
            byte b = dis.readByte();
            short s = dis.readShort();
            int i = dis.readInt();
            float f = dis.readFloat();
            String str = dis.readUTF();

            System.out.println("Byte A: " + a);
            System.out.println("Byte B: " + b);
            System.out.println("Short: " + s);
            System.out.println("Int: " + i);
            System.out.println("Float: " + f);
            System.out.println("String: " + str);
        }catch(IOException e){
            e.printStackTrace();
        }

    }
}
