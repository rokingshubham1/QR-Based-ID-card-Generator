/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qrcode;

import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import javax.swing.JTextField;
public class DynamicQr {
    public static void main(String[] args) {
        try {
	    DBConnection obj_DBConnection = new DBConnection();
            Connection connection = obj_DBConnection.getConnection();
            String query = "SELECT * FROM userdata;";
            Statement stmt = null;
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
            	DynamicQr.generate_qr(rs.getString("Username"),rs.getString("branch"));
            }
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static void generate_qr(String image_name,String qrCodeData) {
        try {
            String filePath = "C:\\Users\\WIN10\\Desktop\\qrcodes\\"+image_name+".png";
            String charset = "UTF-8"; // or "ISO-8859-1"
            Map < EncodeHintType, ErrorCorrectionLevel > hintMap = new HashMap < EncodeHintType, ErrorCorrectionLevel > ();
            hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
            BitMatrix matrix = new MultiFormatWriter().encode(
                new String(qrCodeData.getBytes(charset), charset),
                BarcodeFormat.QR_CODE, 200, 200, hintMap);
            MatrixToImageWriter.writeToFile(matrix, filePath.substring(filePath
                .lastIndexOf('.') + 1), new File(filePath));
            System.out.println("QR Code image created successfully!");
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    static void generate_qr(JTextField jTextField1) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    static void generate_qr(JTextField jTextField1, JTextField jTextField3) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
