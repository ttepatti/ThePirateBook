/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.util.Zip4jConstants;

/**
 *
 * @author Deliquescence <Deliquescence1@gmail.com>
 */
public class base64Functions {

    /**
     * The size to split into. ie, the facebook messenger character limit
     */
    public static final int SPLIT_SIZE = 20000;

//    /**
//     * Class with all the base64 code to make things work
//     */
//    public static void main(String[] args) throws FileNotFoundException, IOException, ZipException {
//
//        //Example Usages
//        //Example 1a: Encode one file into files of base 64
//        encodeAndSplit.intoFiles(new File("memes.jpg"));
//        //Example 1b: Decode file parts into one file
//        unSplitAndDecode.filesIntoFile("memesDecoded.jpg");
//
//        //Example 2a: Zip one file and encode into files of base 64
//        encodeAndSplit.intoFiles(createZip(new File("memes.jpg"), "memes.zip").getFile());
//        //Example 2b: Decode file parts into file
//        unSplitAndDecode.filesIntoFile("memes decoded.zip");
//
//        //Example 3a: Encode one file into bytes[][]
//        byte[][] data = encodeAndSplit.fileIntoBytePieces(new File("memes.jpg"));
//        //Example 3b: Change bytes[][] into string[]
//        String[] textualData = util.convertBytePiecesToStrings(data);
//        //Example 3c: Decode bytes[][] into file
//        unSplitAndDecode.bytePeicesIntoFile(data, "memesDecoded.jpg");
//    }
    /**
     * Create a zip out of multiple files
     *
     * @param files The ArrayList of files to zip
     * @param name the name of the zip file created (with extension)
     *
     * @return The ZipFile created
     *
     * @throws ZipException
     */
    public static ZipFile createZip(ArrayList<File> files, String name) throws ZipException {
        ZipFile zipFile = new ZipFile(name);

        // Initiate Zip Parameters which define various properties such
        // as compression method, etc.
        ZipParameters parameters = new ZipParameters();

        // set compression method to store compression
        parameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);

        // Set the compression level. This value has to be in between 0 to 9
        parameters.setCompressionLevel(8);

        zipFile.createZipFile(files, parameters);
        return zipFile;
    }

    /**
     * Create a zip file from a single file
     *
     * @param file The file to zip
     * @param name the name of the zip file created (with extension)
     *
     * @return The ZipFile created
     *
     * @throws ZipException
     */
    public static ZipFile createZip(File file, String name) throws ZipException {
        ArrayList<File> files = new ArrayList<>();
        files.add(file);

        return createZip(files, name);
    }

    /**
     * Take an input file and return a byte[] representation of its data encoded in base64
     *
     * @param encodeFile The file to turn into base64
     *
     * @return a byte array of base64 data
     *
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static byte[] base64encode(File encodeFile) throws FileNotFoundException, IOException {
        //Input stream for file to encode
        FileInputStream fis = new FileInputStream(encodeFile);
        //byte array that the input file will be converted to
        byte[] mybytes = new byte[(int) encodeFile.length()];
        //convert to bytes
        fis.read(mybytes);

        return base64encode(mybytes);
    }

    /**
     * Encode a byte array to base64
     *
     * @param encodeBytes the array to encode
     *
     * @return the encoded array
     */
    public static byte[] base64encode(byte[] encodeBytes) {
        return Base64.encode(encodeBytes).getBytes();
    }

    /**
     * Turn a byte array of base64 into a decoded byte array
     *
     * @param decodeBytes the byte[]s to decode
     *
     * @return the decoded byte[]s
     */
    public static byte[] base64decode(byte[] decodeBytes) {
        String decodeString = new String(decodeBytes);
        return Base64.decode(decodeString);
    }

    /**
     * Turn a string of base 64 into a byte[] of data
     *
     * @param decodeString The string of base64
     *
     * @return the decoded string
     */
    public static byte[] base64decode(String decodeString) {
        return Base64.decode(decodeString);
    }

    public static class util {

        /**
         * Write a byte array to a file. Pretty simple stuff, really
         *
         * @param data The byte array to write
         * @param name The name of the file to make
         *
         * @throws FileNotFoundException
         * @throws IOException
         */
        public static void writeBytesToFile(byte[] data, String name) throws FileNotFoundException, IOException {
            FileOutputStream fos = new FileOutputStream(name);
            fos.write(data);
        }

        /**
         * Convert an array of byte arrays into a string array, which is more useful
         *
         * @param data the array of byte arrays
         *
         * @return string array of the data
         */
        public static byte[][] convertStringArrayIntoBytePieces(String[] data) {
            int pieceLength = data[0].length();
            byte[][] bytes = new byte[data.length][pieceLength];

            for (int i = 0; i < bytes.length; i++) {
                bytes[i] = data[i].getBytes();
            }
            return bytes;
        }

        /**
         * convert back from string array into bytes array
         *
         * @param data string array of the data
         *
         * @return array of byte arrays
         */
        public static String[] convertBytePiecesToStrings(byte[][] data) {
            String[] strings = new String[data.length];
            for (int i = 0; i < strings.length; i++) {
                strings[i] = new String(data[i]);
            }
            return strings;
        }
    }

    public static class encodeAndSplit {

        /**
         * Take a file input and split it into base64 chunks of {@link SPLIT_SIZE}, then create text files of each split.
         * The files have naming scheme "base64_%N%.txt"
         *
         * @param file The file to encode and split
         *
         * @throws IOException
         */
        public static void intoFiles(File file) throws IOException {
            byte[][] splits = fileIntoBytePieces(file);

            int i = 0;
            for (byte[] split : splits) {
                File outFile = new File("base64_" + i + ".txt"); //Each block is put into a text file
                outFile.createNewFile(); //Make it exist
                FileOutputStream fos = new FileOutputStream(outFile);

                fos.write(split);//encode to base64 and put it in the file
                i++;
            }
        }

        /**
         *
         * Take a file input and split it into base64 chunks of {@link SPLIT_SIZE}. Returns an array of byte arrays.
         *
         * @param file The file to encode and split
         *
         * @return Array with split base64 bytes
         *
         * @throws IOException
         */
        public static byte[][] fileIntoBytePieces(File file) throws IOException {
            byte[] encoded = base64encode(file);//Get base64
            byte[][] splitBytes = new byte[(encoded.length / SPLIT_SIZE) + 1][20000];

            //spliting
            for (int i = 0; i < encoded.length / SPLIT_SIZE; i++) { //Run for each block of base64 that is 20000 chars long
                splitBytes[i] = Arrays.copyOfRange(encoded, i * SPLIT_SIZE, (1 + i) * SPLIT_SIZE);
            }
            //The end file needs special treatment because its not SPLIT_LENGTH long
            int i = (encoded.length / SPLIT_SIZE);

            splitBytes[i] = Arrays.copyOfRange(encoded, (i * SPLIT_SIZE), (i * SPLIT_SIZE) + (encoded.length - (i * SPLIT_SIZE)));
            return splitBytes;
        }

        /**
         * Take a file and split it into strings of base64 chunks of {@link SPLIT_SIZE}
         *
         * @param file The flie to encode and split
         *
         * @return string array of base64
         *
         * @throws IOException
         */
        public static String[] intoStrings(File file) throws IOException {
            return util.convertBytePiecesToStrings(fileIntoBytePieces(file));
        }
    }

    public static class unSplitAndDecode {

        /**
         * Using base64 encoded files of "base64_%N%.txt", create a file with useable data
         *
         * @param name the name of the file to output
         *
         * @throws IOException
         */
        public static void filesIntoFile(String name) throws IOException {
            util.writeBytesToFile(filesIntoBytes(), name);
        }

        /**
         * Using base64 encoded files of "base64_%N%.txt", create a string of useable data
         *
         * @return String with decoded data
         *
         * @throws IOException
         */
        public static String filesIntoString() throws IOException {
            return new String(filesIntoBytes());
        }

        /**
         * Using base64 encoded files of "base64_%N%.txt", create a byte array of useable data
         *
         * @return the decoded data
         *
         * @throws IOException
         */
        public static byte[] filesIntoBytes() throws IOException {
            ArrayList<File> parts = new ArrayList<>();//ArrayList for the splits

            int j = 0;
            while (true) {
                //get each file
                File part = new File("base64_" + j + ".txt");
                if (part.exists()) {//to figure out how many parts there are
                    parts.add(part);
                    j++;
                } else {
                    break;//stop adding
                }
            }

            ByteArrayOutputStream outStream = new ByteArrayOutputStream();

            //init scanner that will scan each part
            Scanner scan = null;
            for (File part : parts) {
                scan = new Scanner(part);//set scanner to each part
                outStream.write(base64decode(scan.next().getBytes()));//decode part and add to file
            }

            return outStream.toByteArray();
        }

        /**
         * Decode a byte[][] of base 64 into a file of data
         *
         * @param data The encoded and split up bytes of base64
         * @param name The output file name, with extension
         *
         * @throws FileNotFoundException
         * @throws IOException
         */
        public static void bytePeicesIntoFile(byte[][] data, String name) throws FileNotFoundException, IOException {
            util.writeBytesToFile(bytePiecesIntoBytes(data), name);
        }

        /**
         * Decode a byte[][] of base 64 into a string of useable data
         *
         * @param data they byte pieces array of base64
         *
         * @return data string
         */
        public static String bytePiecesIntoString(byte[][] data) {
            String out = "";
            for (String s : util.convertBytePiecesToStrings(data)) {
                out += s;
            }
            return out;
        }

        /**
         * Decode a byte[][] of base 64 into a byte[] of useable data
         *
         * @param data The encoded and split up bytes of base64
         *
         * @return the decoded data
         *
         * @throws IOException
         */
        public static byte[] bytePiecesIntoBytes(byte[][] data) throws IOException {
            ByteArrayOutputStream outStream = new ByteArrayOutputStream();

            for (byte[] split : data) {
                outStream.write(base64decode(split));//Decode part and add to file
            }

            return outStream.toByteArray();
        }

    }
}
